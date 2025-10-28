// Archivo: src/PUMABANK/PumaBankApp.java
package PUMABANK;

import PUMABANK.iteratorComposite.Registro;
import PUMABANK.proxy.CuentaProxy;
import java.util.Scanner;

/**
 * Aplicación principal interactiva de PumaBank.
 * Demuestra el uso de los patrones State, Strategy, Decorator, Proxy, Observer, Composite, Iterator.
 * Incluye manejo de sesión, simulación de tiempo y generación de logs.
 *
 * @author PUMALACTICOS (Modificado y Refinado por Modelado)
 */
public class PumaBankApp {
    // Variables de estado de la aplicación
    private int mesActual = 1; // Contador para la simulación de tiempo
    private Scanner scanner;   // Para leer la entrada del usuario
    private Registro registro; // Contiene todas las cuentas y portafolios
    private CuentaProxy proxyActivo = null; // Guarda la sesión activa (null si no hay)

    // Constructor: Inicializa las variables
    public PumaBankApp() {
        this.scanner = new Scanner(System.in);
        // El Registro crea las cuentas de ejemplo al inicializarse
        this.registro = new Registro();
    }

    // Punto de entrada principal de la aplicación
    public static void main(String[] args) {
        PumaBankApp app = new PumaBankApp();
        app.iniciar(); // Lanza el menú principal
    }

    /**
     * Inicia y gestiona el bucle principal del menú interactivo.
     */
    public void iniciar() {
        int opcion = -1;
        // El bucle continúa hasta que el usuario elija la opción 0 (Salir)
        while (opcion != 0) {
            mostrarMenuPrincipal(); // Muestra las opciones disponibles

            try {
                System.out.print("Seleccione una opción: ");
                // Lee la opción del usuario
                opcion = Integer.parseInt(scanner.nextLine());

                // Validación: Si no hay sesión, solo permite iniciar sesión, avanzar mes o salir.
                if (proxyActivo == null && (opcion >= 3 && opcion <= 6 || opcion == 8)) {
                    System.err.println("ERROR: Debe iniciar sesión primero (Opción 1).");
                    opcion = -1; // Forza a mostrar el menú de nuevo
                    continue; // Salta al siguiente ciclo del while
                }
                 // Validación: Si SÍ hay sesión, no permite la opción 1.
                 if (proxyActivo != null && opcion == 1) {
                    System.err.println("ERROR: Ya hay una sesión activa. Cierre sesión (Opción 6) para cambiar de cuenta.");
                    opcion = -1;
                    continue;
                 }


                // Procesa la opción válida
                procesarOpcionPrincipal(opcion);

            } catch (NumberFormatException e) {
                System.err.println("ERROR: Entrada inválida. Por favor, ingrese solo números.");
                opcion = -1; // Asegura que el bucle continúe
            } catch (Exception e) { // Captura general para otros errores (ej. del Proxy o Estados)
                System.err.println("\nERROR INESPERADO: " + e.getMessage());
                // e.printStackTrace(); // Descomentar para ver el stack trace completo si es necesario
                opcion = -1;
            }
        } // Fin while

        System.out.println("\n Vuelve pronto a PumaBank Cajero Felino... ¡Gracias por su preferencia!");
        scanner.close(); // Cierra el scanner al salir
    }

    /**
     * Muestra el menú principal, adaptándose si hay o no una sesión activa.
     */
    private void mostrarMenuPrincipal() {
        System.out.println("\n        PUMABANK (Mes Simulado: " + mesActual + ")              ");
        // Si hay una sesión activa, muestra la información de la cuenta/portafolios
        if (proxyActivo != null) {
            System.out.println(">> Sesión Activa <<");
            System.out.println("   Cliente:     " + proxyActivo.getNombreCliente());
            System.out.println("   Cuenta/Port: " + proxyActivo.getNumeroDeCuenta());
            System.out.println("   Servicios:   " + proxyActivo.getDescripcion());

            System.out.println("--------------------------------------------------");
            // Opciones disponibles CON sesión activa
            System.out.println("3. Consultar Saldo (Requiere NIP)");
            System.out.println("4. Depositar (Requiere NIP)");
            System.out.println("5. Retirar (Requiere NIP)");
            System.out.println("6. Cerrar Sesión");
            System.out.println("7. Máquina del Tiempo (+1 Mes)");
            System.out.println("8. Generar Resumen TXT del Mes Actual"); // Opción para el TXT
            System.out.println("0. Apagar Cajero");
        } else {
            // Si NO hay sesión activa
            System.out.println(">> Sin Sesión Activa <<");
            System.out.println("--------------------------------------------------");
            // Opciones disponibles SIN sesión activa
            System.out.println("1. Iniciar Sesión (Ingresar Cuenta/Portafolios y NIP)");
            System.out.println("7. Máquina del Tiempo (+1 Mes)");
            System.out.println("0. Apagar Cajero");
        }
        System.out.println("                            ");
    }

    /**
     * Dirige la ejecución a la función correspondiente según la opción elegida.
     * @param opcion La opción numérica seleccionada por el usuario.
     */
    private void procesarOpcionPrincipal(int opcion) {
        switch (opcion) {
            case 1: // Iniciar Sesión (Solo si proxyActivo es null)
                iniciarSesion();
                break;
            case 3: // Consultar Saldo
                consultarSaldo();
                break;
            case 4: // Depositar
                realizarDeposito();
                break;
            case 5: // Retirar
                realizarRetiro();
                break;
            case 6: // Cerrar Sesión
                cerrarSesion();
                break;
            case 7: // Máquina del Tiempo
                avanzarMes();
                break;
            case 8: // Generar TXT Manualmente
                 generarResumenManual();
                 break;
            case 0: // Apagar
                // La salida se gestiona en el bucle principal
                break;
            default:
                System.err.println("ERROR: Opción no válida. Intente de nuevo.");
                break;
        }
    }

    /**
     * Gestiona el proceso de inicio de sesión: pide cuenta/portafolios y NIP.
     */
    private void iniciarSesion() {
        System.out.println("\n    Iniciar Sesión    ");
        System.out.print("Ingrese el número de la Cuenta o Portafolios: ");
        String numeroCuentaSeleccionada = scanner.nextLine();

        // Busca la cuenta/portafolios en el registro
        CuentaProxy proxySeleccionado = registro.get(numeroCuentaSeleccionada);

        if (proxySeleccionado != null) {
            System.out.println("Cuenta/Portafolios encontrado: " + proxySeleccionado.getNumeroDeCuenta() + " ("+ proxySeleccionado.getNombreCliente() +")");
            System.out.print("Ingrese su NIP de 4 dígitos: ");
            String nipIngresado = scanner.nextLine();

            // Intenta autenticar usando el método login del Proxy
            if (proxySeleccionado.login(nipIngresado)) {
                // Éxito: Guarda el proxy como la sesión activa
                proxyActivo = proxySeleccionado;
                System.out.println("--> Acceso concedido. Sesión iniciada para " + proxyActivo.getNombreCliente() + ".");
            } else {
                // Fallo: Informa al usuario
                System.err.println("ERROR: NIP incorrecto. No se pudo iniciar sesión.");
                proxyActivo = null; // Asegura que no quede sesión activa
            }
        } else {
            System.err.println("ERROR: Cuenta o Portafolios con número '" + numeroCuentaSeleccionada + "' no encontrado.");
        }
    }

     /**
     * Simula el paso de un mes: aplica procesos bancarios y guarda logs automáticamente.
     */
    private void avanzarMes() {
        System.out.println("\n    Máquina del Tiempo    ");
        System.out.println("Simulando cierre del mes " + mesActual + " y avance al mes " + (mesActual + 1) + "...");

        // Llama a update() en TODAS las cuentas/portafolios registrados.
        //    Este método (en Cuenta y Portafolios) se encarga de:
        //    - Incrementar la antigüedad (simularPasoDeMes)
        //    - Aplicar intereses según la estrategia
        System.out.println("[BANCO] Aplicando procesos de fin de mes (intereses, etc.)...");
        registro.update(); // El método update en Registro itera sobre todos

        // Guarda AUTOMÁTICAMENTE los logs TXT del mes que acaba de terminar.
        System.out.println("[BANCO] Generando resúmenes mensuales TXT...");
        registro.guardarLogsDelMes(mesActual);

        // ncrementa el contador del mes actual para la simulación.
        mesActual++;

        System.out.println("\n--> ¡El tiempo avanzó! Ahora estamos en el mes simulado " + mesActual + ".");
        System.out.println("    Se aplicaron intereses/cargos y se guardaron los resúmenes TXT del mes anterior.");

        // Si había una sesión activa, el NIP sigue siendo válido,
        // pero es bueno recordar al usuario que está en un nuevo mes.
        if (proxyActivo != null) {
            System.out.println("    (Sesión de " + proxyActivo.getNombreCliente() + " sigue activa)");
        }
    }

     /**
     * Permite al usuario generar el log TXT del mes actual bajo demanda.
     */
     private void generarResumenManual() {
        System.out.println("\n Generar Resumen TXT (Mes " + mesActual + ") ---|");
        // Llama directamente al método en registro, pasándole el mes actual
        registro.guardarLogsDelMes(mesActual);
        System.out.println("--> Resumen TXT para el mes " + mesActual + " generado (o actualizado si ya existía).");
     }


    /**
     * Intenta consultar y mostrar el saldo de la cuenta activa.
     * Requiere que el usuario esté autenticado (NIP válido).
     */
    private void consultarSaldo() {
         System.out.println("\n    Consultar Saldo    ");
         try {
             // El método getSaldo() del Proxy ya incluye la verificación de NIP
             double saldo = proxyActivo.getSaldo();
             System.out.println("--> SALDO ACTUAL: $" + String.format("%.2f", saldo));
         } catch (Exception e) {
             // Captura la excepción si verificarAcceso() falla dentro del Proxy
             System.err.println("   ERROR al consultar saldo: " + e.getMessage() + " ");
         }
    }

    /**
     * Gestiona el proceso de depósito en la cuenta activa.
     * Requiere NIP y maneja errores de entrada.
     */
    private void realizarDeposito() {
        System.out.println("\n    Depositar    ");
        try {
            System.out.print("Ingrese monto a depositar: $");
            double monto = Double.parseDouble(scanner.nextLine());
            // Validación básica del monto
            if (monto <= 0) {
                System.err.println("    ERROR: El monto a depositar debe ser mayor que cero.    ");
                return;
            }
            // Llama al método depositar del Proxy (que verifica NIP y delega)
            proxyActivo.depositar(monto);
            // La notificación de éxito o error la maneja el Estado/Cuenta y se verá por la consola
            System.out.println("--> Depósito procesado. Verifique el saldo para confirmar.");
        } catch (NumberFormatException e) {
            System.err.println("    ERROR: Monto inválido. Ingrese solo números.    ");
        } catch (Exception e) {
            // Captura errores del Proxy (NIP) o del Estado (ej. cuenta cerrada)
            System.err.println("    ERROR durante el depósito: " + e.getMessage() + "    ");
        }
    }

    /**
     * Gestiona el proceso de retiro de la cuenta activa.
     * Requiere NIP y maneja errores de entrada y de negocio (ej. fondos insuficientes).
     */
    private void realizarRetiro() {
        System.out.println("\n    Retirar    ");
         try {
            System.out.print("Ingrese monto a retirar: $");
            double monto = Double.parseDouble(scanner.nextLine());
            // Validación básica del monto
             if (monto <= 0) {
                System.err.println("    ERROR: El monto a retirar debe ser mayor que cero.    ");
                return;
            }
            // Llama al método retirar del Proxy (que verifica NIP y delega)
            proxyActivo.retirar(monto);
            // La notificación de éxito, error (fondos insuficientes, sobregiro, congelada) la maneja el Estado/Cuenta.
            System.out.println("--> Retiro procesado. Verifique el saldo para confirmar.");
        } catch (NumberFormatException e) {
            System.err.println("    ERROR: Monto inválido. Ingrese solo números.    ");
        } catch (Exception e) {
            // Captura errores del Proxy (NIP) o del Estado (fondos, congelada, etc.)
            System.err.println("    ERROR durante el retiro: " + e.getMessage() + "    ");
        }
    }

    /**
     * Cierra la sesión activa actual, invalidando el NIP ingresado.
     */
    private void cerrarSesion() {
        if (proxyActivo != null) {
            proxyActivo.logout(); // Llama al logout del proxy para invalidar NIP
            proxyActivo = null;   // Elimina la referencia, terminando la sesión
            System.out.println("\n--> Sesión cerrada correctamente. ¡Vuelva pronto!");
        } else {
            // Esto no debería pasar si la validación del menú funciona, pero por si acaso.
            System.out.println("No hay ninguna sesión activa para cerrar.");
        }
    }
} 