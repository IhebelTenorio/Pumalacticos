// Archivo: src/PUMABANK/iteratorComposite/Portafolios.java
package PUMABANK.iteratorComposite;

import PUMABANK.decorator.ICuenta;
import PUMABANK.strategy.IEstrategiaInteres;
import java.util.ArrayList;
import java.util.Collection; // Importar List
import java.util.Iterator;
import java.util.List;

/**
 * Representa un Portafolios (Nodo Composite en el patrón Composite).
 * Contiene una colección de ICuenta (que pueden ser Cuentas 'hoja' u otros Portafolios 'rama').
 * Implementa ICuenta para ser tratado uniformemente y delega la mayoría de operaciones a sus hijos.
 * Implementa Iterable para permitir recorrer sus hijos con un Iterator.
 *
 * @author PUMALACTICOS (Modificado y Refinado por Modelado)
 */
public class Portafolios implements Iterable<ICuenta>, ICuenta {
    // Lista para guardar los componentes hijos (Cuentas u otros Portafolios)
    private List<ICuenta> cuentas; // Buena práctica: Usar la interfaz List para declarar
    // Identificador único para este portafolios
    private String numeroDeCuenta;

    /**
     * Constructor del Portafolios.
     * @param numeroDeCuenta Identificador único para el portafolios.
     * @param c Colección inicial de ICuenta (hijos) para añadir.
     */
    public Portafolios(String numeroDeCuenta, Collection<ICuenta> c) {
        // Usar ArrayList como implementación concreta
        this.cuentas = new ArrayList<>();
        // Añadir todos los elementos de la colección inicial
        if (c != null) {
             this.cuentas.addAll(c);
        }
        this.numeroDeCuenta = numeroDeCuenta;
        System.out.println("[COMPOSITE] Portafolios '" + numeroDeCuenta + "' creado con " + (c != null ? c.size() : 0) + " elementos iniciales.");
    }

    /**
     * Proporciona un iterador personalizado para recorrer las cuentas contenidas.
     * @return Un IteradorCuentas sobre los hijos.
     */
    @Override
    public Iterator<ICuenta> iterator() { // Especificar el tipo genérico <ICuenta>
        // Usa la clase IteradorCuentas que ya existe
        return new IteradorCuentas(cuentas);
    }

    // --- Implementación de Métodos de ICuenta (Delegación a Hijos) ---

    /**
     * Intenta retirar un monto, dividiéndolo equitativamente entre las cuentas hijas.
     * Si una cuenta hija falla (ej. fondos insuficientes), esa parte no se retira.
     * Nota: No maneja excepciones de los hijos de forma agregada por simplicidad.
     * @param monto Monto total a retirar del portafolios.
     */
    @Override
    public void retirar(double monto) {
        if (cuentas.isEmpty()) {
            System.err.println("### ERROR: Portafolios " + numeroDeCuenta + " está vacío. No se puede retirar. ###");
            // Podríamos lanzar una excepción aquí si fuera necesario
            return;
        }
        // Calcula cuánto retirar de cada cuenta hija
        double montoPorCuenta = monto / cuentas.size();
        System.out.println("[PORTAFOLIOS " + numeroDeCuenta + "] Intentando retirar $" + String.format("%.2f", montoPorCuenta) +
                           " de cada una de las " + cuentas.size() + " cuentas (Total: $" + monto +")...");
        // Itera sobre los hijos y delega la operación
        for (ICuenta cuenta : cuentas) {
            try {
                // Llama al retirar de cada hijo
                cuenta.retirar(montoPorCuenta);
            } catch (Exception e) {
                // Informa si un retiro individual falla, pero continúa con los demás
                System.err.println("   -> Falló retiro en " + cuenta.getNumeroDeCuenta() + ": " + e.getMessage());
            }
        }
    }

    /**
     * Deposita un monto, dividiéndolo equitativamente entre las cuentas hijas.
     * @param monto Monto total a depositar en el portafolios.
     */
    @Override
    public void depositar(double monto) {
        if (cuentas.isEmpty()) {
             System.err.println("### ERROR: Portafolios " + numeroDeCuenta + " está vacío. No se puede depositar. ###");
            return;
        }
        double montoPorCuenta = monto / cuentas.size();
        System.out.println("[PORTAFOLIOS " + numeroDeCuenta + "] Depositando $" + String.format("%.2f", montoPorCuenta) +
                           " en cada una de las " + cuentas.size() + " cuentas (Total: $" + monto +")...");
        for (ICuenta cuenta : cuentas) {
             try {
                cuenta.depositar(montoPorCuenta);
             } catch (Exception e) {
                System.err.println("   -> Falló depósito en " + cuenta.getNumeroDeCuenta() + ": " + e.getMessage());
             }
        }
    }

    /**
     * Calcula y devuelve el saldo total del portafolios sumando los saldos de las cuentas hijas.
     * @return El saldo consolidado del portafolios.
     */
    @Override
    public double getSaldo() {
        double saldoTotal = 0;
        for (ICuenta cuenta : cuentas) {
            try {
                 saldoTotal += cuenta.getSaldo(); // Suma los saldos de los hijos
            } catch (Exception e) {
                 System.err.println("   -> No se pudo obtener saldo de " + cuenta.getNumeroDeCuenta() + ": " + e.getMessage());
            }
        }
        return saldoTotal;
    }

    /**
     * Intenta cerrar el portafolios. Por seguridad, solo lo permite si está vacío.
     */
    @Override
    public void cerrarCuenta() {
        if (cuentas.isEmpty()) {
            System.out.println("[PORTAFOLIOS " + numeroDeCuenta + "] Portafolios vacío. (Simulando cierre/eliminación...)");
            // Aquí iría la lógica para eliminar el portafolios del sistema si fuera necesario
        } else {
            // Lanza una excepción para indicar que no se puede cerrar
             throw new UnsupportedOperationException("No se puede cerrar el Portafolios '" + numeroDeCuenta +
                                                    "'. Contiene " + cuentas.size() + " elementos. Ciérrelos/quíitelos individualmente primero.");
        }
    }

    /**
     * Aplica el cálculo de intereses a cada una de las cuentas contenidas en el portafolios.
     */
    @Override
    public void aplicarInteres() {
        System.out.println("[PORTAFOLIOS " + numeroDeCuenta + "] Aplicando intereses a elementos contenidos...");
        for (ICuenta cuenta : cuentas) {
            try {
                 cuenta.aplicarInteres(); // Delega la aplicación de interés a cada hijo
            } catch (Exception e) {
                 System.err.println("   -> Error aplicando interés en " + cuenta.getNumeroDeCuenta() + ": " + e.getMessage());
            }
        }
    }

    /**
     * Establece la misma estrategia de interés a todas las cuentas contenidas en el portafolios.
     * @param nuevaEstrategia La estrategia de interés a aplicar globalmente.
     */
    @Override
    public void setEstrategiaInteres(IEstrategiaInteres nuevaEstrategia) {
        System.out.println("[PORTAFOLIOS " + numeroDeCuenta + "] Estableciendo estrategia '" + nuevaEstrategia.getClass().getSimpleName() +
                           "' a todos los elementos contenidos...");
        for (ICuenta cuenta : cuentas) {
             try {
                cuenta.setEstrategiaInteres(nuevaEstrategia); // Delega el cambio de estrategia a cada hijo
             } catch (Exception e) {
                 System.err.println("   -> Error estableciendo estrategia en " + cuenta.getNumeroDeCuenta() + ": " + e.getMessage());
             }
        }
    }

    /**
     * Obtiene el número identificador de este portafolios.
     * @return El número del portafolios.
     */
    @Override
    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    /**
     * Determina el nombre del cliente asociado. Si todas las cuentas hijas pertenecen
     * al mismo cliente, devuelve ese nombre. Si hay diferentes clientes, devuelve "Varios Propietarios".
     * @return El nombre del cliente o "Varios Propietarios".
     */
    @Override
    public String getNombreCliente() {
        if (cuentas.isEmpty()) {
            return "Portafolios Vacío";
        }
        // Tomamos el nombre del primer elemento como referencia
        String primerNombre = cuentas.get(0).getNombreCliente();
        // Comparamos con los nombres de los demás elementos
        for (int i = 1; i < cuentas.size(); i++) {
            if (!cuentas.get(i).getNombreCliente().equals(primerNombre)) {
                return "Varios Propietarios"; // Si encontramos uno diferente, son varios
            }
        }
        return primerNombre; // Si todos son iguales, devolvemos ese nombre
    }

    /**
     * Genera una descripción textual del portafolios.
     * @return Una cadena describiendo el portafolios.
     */
    @Override
    public String getDescripcion() {
        return "Portafolios '" + numeroDeCuenta + "' (" + getNombreCliente() + ") con " + cuentas.size() + " elementos";
    }

    /**
     * Implementación del método update para el ciclo mensual del banco.
     * Delega la llamada a update() a cada cuenta o sub-portafolios contenido.
     */
    @Override
    public void update() {
        System.out.println("[PORTAFOLIOS " + numeroDeCuenta + "] Iniciando update mensual para elementos contenidos...");
        for (ICuenta cuenta : cuentas) {
            try {
                cuenta.update(); // Llama al update de cada hijo
            } catch (Exception e) {
                 System.err.println("   -> Error durante update en " + cuenta.getNumeroDeCuenta() + ": " + e.getMessage());
            }
        }
         System.out.println("[PORTAFOLIOS " + numeroDeCuenta + "] Update mensual completado para elementos contenidos.");
    }

    // --- Métodos específicos para gestionar la composición (Añadir/Quitar hijos) ---
    // Estos métodos NO están en la interfaz ICuenta, son propios del Composite.

    /**
     * Añade una ICuenta (Cuenta o Portafolios) a este portafolios.
     * @param cuenta El componente a añadir.
     */
    public void agregarCuenta(ICuenta cuenta) {
        if (cuenta != null) {
            this.cuentas.add(cuenta);
            System.out.println("[PORTAFOLIOS " + numeroDeCuenta + "] Elemento añadido: " + cuenta.getNumeroDeCuenta());
        } else {
             System.err.println("[PORTAFOLIOS " + numeroDeCuenta + "] Intento de añadir elemento nulo ignorado.");
        }
    }

    /**
     * Quita una ICuenta de este portafolios.
     * @param cuenta El componente a quitar.
     * @return true si se quitó exitosamente, false si no se encontró.
     */
    public boolean quitarCuenta(ICuenta cuenta) {
        if (cuenta == null) return false;
        boolean removido = this.cuentas.remove(cuenta);
        if (removido) {
             System.out.println("[PORTAFOLIOS " + numeroDeCuenta + "] Elemento quitado: " + cuenta.getNumeroDeCuenta());
        } else {
             System.err.println("[PORTAFOLIOS " + numeroDeCuenta + "] No se pudo quitar '" + cuenta.getNumeroDeCuenta() + "' (¿no estaba en este portafolios?).");
        }
        return removido;
    }
}