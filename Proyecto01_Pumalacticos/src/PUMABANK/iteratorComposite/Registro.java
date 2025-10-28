// Archivo: src/PUMABANK/iteratorComposite/Registro.java
package PUMABANK.iteratorComposite;

import PUMABANK.Cuenta;
import PUMABANK.decorator.*;
import PUMABANK.observer.*;
import PUMABANK.proxy.CuentaProxy;
import PUMABANK.strategy.*; // Necesario para iterar sobre el Map de loggers
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator; // Importar todo observer
import java.util.Map;

/**
 * Clase que simula la base de datos de cuentas (proxys).
 * Se encarga de crear las cuentas de ejemplo, adjuntarles observadores,
 * decorarlas, protegerlas con un Proxy y almacenarlas.
 * También gestiona los loggers TXT para la generación de resúmenes.
 * Implementa Iterable para permitir recorrer todas las cuentas/portafolios.
 *
 * @author PUMALACTICOS (Modificado y Finalizado por Modelado)
 */
public class Registro implements Iterable<ICuenta> {

    // Almacena los proxies (CuentaProxy) accesibles por número de cuenta/portafolios
    private HashMap<String, CuentaProxy> proxys;

    // Almacena los loggers (GeneradorResumenTXT) asociados a cada cuenta/portafolios
    private HashMap<String, GeneradorResumenTXT> loggers;

    /**
     * Constructor: Inicializa los HashMaps y llama a generar las cuentas de ejemplo.
     */
    public Registro() {
        this.proxys = new HashMap<>(); // Esencial inicializar aquí
        this.loggers = new HashMap<>(); // Esencial inicializar aquí
        generarCuentasEjemplo(); // Poblar con datos de prueba
    }

    /**
     * Obtiene el Proxy de una cuenta o portafolios por su número identificador.
     * @param numero El número de la cuenta o portafolios a buscar.
     * @return El CuentaProxy asociado, o null si no se encuentra.
     */
    public CuentaProxy get(String numero) {
        return proxys.get(numero);
    }

    /**
     * Permite iterar sobre todos los Proxies (tratados como ICuenta) en el registro.
     * Útil para operaciones globales como el update mensual.
     * @return Un iterador sobre la colección de Proxies.
     */
    @Override
    public Iterator<ICuenta> iterator() {
        // Creamos una lista temporal con los valores (proxies) del HashMap
        // y le pasamos esa lista a nuestro IteradorCuentas personalizado.
        return new IteradorCuentas(new ArrayList<>(proxys.values()));
    }

    /**
     * Método centralizado para crear las cuentas y portafolios de ejemplo.
     * Aquí se instancia Cuenta, se adjuntan Observadores, se aplican Decoradores
     * y finalmente se envuelve todo en un CuentaProxy antes de guardarlo.
     */
    private void generarCuentasEjemplo() {
        System.out.println("[REGISTRO] Creando cuentas y portafolios de ejemplo...");

        // CUENTA 1: PUMALACTICO 001
        try {
            IEstrategiaInteres mensual1 = new EstrategiaInteresMensual();
            Cuenta cuentaBase1 = new Cuenta("PUMALACTICO 001", "Cliente 1", 5000, mensual1);
            // Adjuntar Observadores
            GeneradorResumenTXT logger1 = new GeneradorResumenTXT(cuentaBase1.getNumeroDeCuenta());
            cuentaBase1.adjuntar(new NotificadorEmail());
            cuentaBase1.adjuntar(logger1);
            // Decorar
            ICuenta cuentaDecorada1 = new RecompensasDecorator(new SeguroAntifraudeDecorator(cuentaBase1));
            // Proteger con Proxy
            CuentaProxy proxy1 = new CuentaProxy(cuentaDecorada1, "1234"); // NIP: 1234
            // Guardar
            this.proxys.put(proxy1.getNumeroDeCuenta(), proxy1);
            this.loggers.put(proxy1.getNumeroDeCuenta(), logger1);
        } catch (Exception e) { System.err.println("Error creando PUMALACTICO 001: " + e.getMessage());}

        // CUENTA 2: SUPER_NOVA 002 
         try {
            IEstrategiaInteres anual2 = new EstrategiaInteresAnual();
            Cuenta cuentaBase2 = new Cuenta("SUPER_NOVA 002", "Cliente 1", 150000, anual2);
            GeneradorResumenTXT logger2 = new GeneradorResumenTXT(cuentaBase2.getNumeroDeCuenta());
            cuentaBase2.adjuntar(new NotificadorEmail());
            cuentaBase2.adjuntar(new AlertaPremium()); // Servicio premium
            cuentaBase2.adjuntar(logger2);
            ICuenta cuentaDecorada2 = new RecompensasDecorator(cuentaBase2); // Solo Recompensas
            CuentaProxy proxy2 = new CuentaProxy(cuentaDecorada2, "2468"); // NIP: 2468
            this.proxys.put(proxy2.getNumeroDeCuenta(), proxy2);
            this.loggers.put(proxy2.getNumeroDeCuenta(), logger2);
        } catch (Exception e) { System.err.println("Error creando SUPER_NOVA 002: " + e.getMessage());}

        // CUENTA 3: GALAXIA_M31 003
         try {
            IEstrategiaInteres mensual3 = new EstrategiaInteresMensual();
            Cuenta cuentaBase3 = new Cuenta("GALAXIA_M31 003", "Cliente 2", 500, mensual3);
            GeneradorResumenTXT logger3 = new GeneradorResumenTXT(cuentaBase3.getNumeroDeCuenta());
            cuentaBase3.adjuntar(new NotificadorEmail());
            cuentaBase3.adjuntar(logger3);
            ICuenta cuentaDecorada3 = new SeguroAntifraudeDecorator(cuentaBase3); // Solo Seguro
            CuentaProxy proxy3 = new CuentaProxy(cuentaDecorada3, "1357"); // NIP: 1357
            this.proxys.put(proxy3.getNumeroDeCuenta(), proxy3);
            this.loggers.put(proxy3.getNumeroDeCuenta(), logger3);
        } catch (Exception e) { System.err.println("Error creando GALAXIA_M31 003: " + e.getMessage());}


        // CUENTA 4: ANDROMEDA 004
        try {
            IEstrategiaInteres premium4 = new EstrategiaInteresPremium();
            Cuenta cuentaBase4 = new Cuenta("ANDROMEDA 004", "Cliente 2", 75000, premium4);
            GeneradorResumenTXT logger4 = new GeneradorResumenTXT(cuentaBase4.getNumeroDeCuenta());
            cuentaBase4.adjuntar(new NotificadorEmail());
            cuentaBase4.adjuntar(new AlertaPremium());
            cuentaBase4.adjuntar(logger4);
            // Sin Decoradores
            CuentaProxy proxy4 = new CuentaProxy(cuentaBase4, "0000"); // NIP: 0000
            this.proxys.put(proxy4.getNumeroDeCuenta(), proxy4);
            this.loggers.put(proxy4.getNumeroDeCuenta(), logger4);
        } catch (Exception e) { System.err.println("Error creando ANDROMEDA 004: " + e.getMessage());}

        // CUENTA 5: NEBULA_DE_ORION 005
        try {
            IEstrategiaInteres mensual5 = new EstrategiaInteresMensual();
            Cuenta cuentaBase5 = new Cuenta("NEBULA_DE_ORION 005", "Cliente 3", 2500, mensual5);
            GeneradorResumenTXT logger5 = new GeneradorResumenTXT(cuentaBase5.getNumeroDeCuenta());
            cuentaBase5.adjuntar(new NotificadorEmail());
            cuentaBase5.adjuntar(logger5);
            ICuenta cuentaDecorada5 = new RecompensasDecorator(new SeguroAntifraudeDecorator(cuentaBase5)); // Ambos
            CuentaProxy proxy5 = new CuentaProxy(cuentaDecorada5, "9999"); // NIP: 9999
            this.proxys.put(proxy5.getNumeroDeCuenta(), proxy5);
            this.loggers.put(proxy5.getNumeroDeCuenta(), logger5);
        } catch (Exception e) { System.err.println("Error creando NEBULA_DE_ORION 005: " + e.getMessage());}


        //  PORTAFOLIO 1 (Cliente 1: Cuentas 001 y 002) 
        try {
            // Es importante obtener las referencias a las *cuentas ya creadas y decoradas*
            // si queremos que los observadores adjuntos a ellas sigan funcionando.
            ICuenta c1 = this.proxys.get("PUMALACTICO 001").getCuentaReal(); // Obtener la cuenta real del proxy
            ICuenta c2 = this.proxys.get("SUPER_NOVA 002").getCuentaReal();
            if (c1 != null && c2 != null) {
                ArrayList<ICuenta> cuentasPort1 = new ArrayList<>();
                cuentasPort1.add(c1);
                cuentasPort1.add(c2);
                Portafolios port1 = new Portafolios("PORT_C1", cuentasPort1);
                 // Opcional: Adjuntar observadores directamente al portafolios si queremos eventos agregados
                 GeneradorResumenTXT loggerP1 = new GeneradorResumenTXT(port1.getNumeroDeCuenta());
                 // port1.adjuntar(new NotificadorEmail()); // Si quisiéramos notificar operaciones del portafolios
                 // port1.adjuntar(loggerP1);
                CuentaProxy port1Proxy = new CuentaProxy(port1, "7777"); // NIP: 7777
                this.proxys.put(port1Proxy.getNumeroDeCuenta(), port1Proxy);
                 if (loggerP1 != null) { // Guardar el logger si lo creamos para el portafolios
                    this.loggers.put(port1Proxy.getNumeroDeCuenta(), loggerP1);
                 }
            } else { System.err.println("Error creando PORT_C1: Cuentas base no encontradas."); }
        } catch (Exception e) { System.err.println("Error creando PORT_C1: " + e.getMessage());}


        // PORTAFOLIO 2 (Cliente 2: Cuentas 003 y 004)
         try {
            ICuenta c3 = this.proxys.get("GALAXIA_M31 003").getCuentaReal();
            ICuenta c4 = this.proxys.get("ANDROMEDA 004").getCuentaReal();
             if (c3 != null && c4 != null) {
                ArrayList<ICuenta> cuentasPort2 = new ArrayList<>();
                cuentasPort2.add(c3);
                cuentasPort2.add(c4);
                Portafolios port2 = new Portafolios("PORT_C2", cuentasPort2);
                GeneradorResumenTXT loggerP2 = new GeneradorResumenTXT(port2.getNumeroDeCuenta());
                 // port2.adjuntar(loggerP2);
                CuentaProxy port2Proxy = new CuentaProxy(port2, "8888"); // NIP: 8888
                this.proxys.put(port2Proxy.getNumeroDeCuenta(), port2Proxy);
                 if (loggerP2 != null) {
                    this.loggers.put(port2Proxy.getNumeroDeCuenta(), loggerP2);
                 }
            } else { System.err.println("Error creando PORT_C2: Cuentas base no encontradas."); }
        } catch (Exception e) { System.err.println("Error creando PORT_C2: " + e.getMessage());}

        System.out.println("[REGISTRO] Creación de cuentas de ejemplo finalizada.");
    }

    /**
     * Itera sobre todas las cuentas y portafolios (a través de sus proxies)
     * y les aplica el proceso de fin de mes llamando a su método update().
     * El método update() en Cuenta/Portafolios se encarga de simularPasoDeMes y aplicarInteres.
     */
    public void update() {
        System.out.println("\n[BANCO] Iniciando proceso de fin de mes para todas las cuentas...");
        if (proxys.isEmpty()) {
            System.out.println("[BANCO] No hay cuentas registradas para actualizar.");
            return;
        }
        // Usamos el iterador que implementa Registro (sobre los proxies)
        for (ICuenta proxy : this) {
            try {
                // Llamamos a update() en el Proxy, que debe delegar a la cuenta real/decorada/portafolios
                proxy.update();
            } catch (Exception e) {
                // Capturamos cualquier excepción durante el update
                System.err.println("   -> [ERROR BANCO] Error al actualizar " + proxy.getNumeroDeCuenta() + ": " + e.getMessage());
            }
        }
        System.out.println("[BANCO] Proceso de fin de mes completado.");
    }


    /**
     * Itera sobre todos los loggers de TXT registrados (tanto de cuentas como de portafolios)
     * y les ordena guardar el resumen del mes especificado en sus archivos correspondientes.
     * @param mes El número del mes (1, 2, ...) que se está cerrando.
     */
    public void guardarLogsDelMes(int mes) {
        System.out.println("\n[BANCO] Guardando logs de fin de mes " + mes + "...");
        if (loggers.isEmpty()) {
            System.out.println("[BANCO] No hay loggers de TXT registrados.");
            return;
        }
        // Iteramos sobre las entradas (clave=numeroCuenta, valor=logger) del HashMap
        for (Map.Entry<String, GeneradorResumenTXT> entry : loggers.entrySet()) {
            GeneradorResumenTXT logger = entry.getValue();
            if (logger != null) {
                // Llama al método del logger para que escriba su archivo
                logger.guardarLogMensual(mes);
            } else {
                // Esto no debería ocurrir si la inicialización es correcta
                System.err.println("   -> [ADVERTENCIA BANCO] Logger nulo encontrado para ID: " + entry.getKey());
            }
        }
        System.out.println("[BANCO] Guardado de logs finalizado.");
    }

     // Método auxiliar para obtener la cuenta real desde el proxy (si se necesita fuera del Registro)
     // Podría ser útil si necesitamos acceder a métodos específicos de Cuenta que no están en ICuenta
     public ICuenta getCuentaReal(String numeroCuenta) {
        CuentaProxy proxy = proxys.get(numeroCuenta);
        return (proxy != null) ? proxy.getCuentaReal() : null;
     }

}
