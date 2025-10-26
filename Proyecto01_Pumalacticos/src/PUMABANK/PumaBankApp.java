package PUMABANK;

// Importamos 
import PUMABANK.decorator.*;
import PUMABANK.proxy.CuentaProxy;
import PUMABANK.strategy.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Aplicación principal interactiva de PumaBank.
 * Uso de los patrones State, Strategy, Decorator y Proxy.
 *
 * @author MPumalacticos
 */
public class PumaBankApp {
    private static int mes = 1;
    private static Scanner scanner = new Scanner(System.in);
    // TODO hashmap de usuarios
    //      los usuarios tinenen cuentas!

    public static void main(String[] args) {
         
        // estrategia
        IEstrategiaInteres mensual = new EstrategiaInteresMensual();
        
        // cuenta base (Componente Concreto)
        ICuenta cuentaBase = new Cuenta("PUMALACTICO 001", "Cliente Interactivo", 5000, mensual);

        // Decoramos (opcional)
        ICuenta cuentaDecorada = new RecompensasDecorator(new SeguroAntifraudeDecorator(cuentaBase));

        //Creamos el Proxy, "envolviendo" al objeto real (decorado)
        // El NIP "1234" está quemado aquí por simplicidad.
        CuentaProxy miCuentaProxy = new CuentaProxy(cuentaDecorada, "1234");

        // la variable que usaremos es 'miCuentaProxy'

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("\n PUMABANK CAJERO FELINO INTERACTIVO ");
            System.out.println("Cliente: " + miCuentaProxy.getNombreCliente());
            System.out.println("Cuenta: " + miCuentaProxy.getNumeroDeCuenta());
            System.out.println("Servicios: " + miCuentaProxy.getDescripcion());
            System.out.println("----------------------------------------------");
            System.out.println("1. Iniciar Sesión (Ingresar NIP)");
            System.out.println("2. Consultar Saldo");
            System.out.println("3. Depositar");
            System.out.println("4. Retirar");
            System.out.println("5. Aplicar Intereses");
            System.out.println("6. Cerrar Sesión");
            System.out.println("7. Ir al siguiente mes");
            System.out.println("0. Salir del Cajero");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese su NIP de 4 dígitos: ");
                        String nip = scanner.nextLine();
                        miCuentaProxy.login(nip);
                        break;
                    case 2:
                        // getSaldo() ahora puede lanzar una excepción si no hay login
                        double saldo = miCuentaProxy.getSaldo();
                        System.out.println("SALDO ACTUAL: $" + saldo);
                        break;
                    case 3:
                        System.out.print("Ingrese monto a depositar: ");
                        double deposito = Double.parseDouble(scanner.nextLine());
                        miCuentaProxy.depositar(deposito);
                        break;
                    case 4:
                        System.out.print("Ingrese monto a retirar: ");
                        double retiro = Double.parseDouble(scanner.nextLine());
                        miCuentaProxy.retirar(retiro);
                        break;
                    case 5:
                        miCuentaProxy.aplicarInteres();
                        break;
                    case 6:
                        miCuentaProxy.logout();
                        break;
                    case 7:
                        mes++;
                        updateUsers();
                        break;
                    case 0:
                        System.out.println("Adiosss...");
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            } catch (Exception e) {
                 // Aquí atrapamos las excepciones de seguridad del Proxy
                 System.err.println("\n*** ERROR DE OPERACIÓN: " + e.getMessage() + " ***");
            }
        }
        scanner.close();
    }

    // TODO
    private static void updateUsers(){
        // para cada usuario, a cada uno ejecutarle .update()
    }
}