package PUMABANK;

// Importamos 
import PUMABANK.decorator.*;
import PUMABANK.iteratorComposite.Registro;
import PUMABANK.proxy.CuentaProxy;
import PUMABANK.strategy.*;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Aplicación principal interactiva de PumaBank.
 * Uso de los patrones State, Strategy, Decorator y Proxy.
 *1
 * @author MPumalacticos
 */
public class PumaBankApp {
    private static int mes = 1;
    private static Scanner scanner = new Scanner(System.in);
    private static Registro proxys = new Registro();
    private static CuentaProxy proxyActivo = null;

    public static void main(String[] args) {

        int opcion = -1;
        while (opcion != 0) {
            if(proxyActivo != null){
                // si no hay cuenta activa, no desplegamos la informacion
                System.out.println("Cliente: " + proxyActivo.getNombreCliente());
                System.out.println("Cuenta: " + proxyActivo.getNumeroDeCuenta());
                System.out.println("Servicios: " + proxyActivo.getDescripcion());
            }
            System.out.println("\n PUMABANK CAJERO FELINO INTERACTIVO ");
            System.out.println("----------------------------------------------");
            System.out.println("1. Iniciar Cuenta o Portafolios");
            System.out.println("2. Maquina del tiempo (avanzar un mes al futuro)");
            if(proxyActivo != null){
                // Si no hay cuenta activa no desplegamos esto tampoco
                System.out.println("3. Consultar Saldo");
                System.out.println("4. Depositar");
                System.out.println("5. Retirar");
                System.out.println("6. Cerrar Sesión");
            }
            System.out.println("0. Salir del Cajero (apagar)");
            System.out.print("Seleccione una opción: ");
            try{
                opcion = Integer.parseInt(scanner.nextLine());
                // si no hay cuenta activa, las opciones 3-6 quedan deshabilitadas
                if(proxyActivo == null && opcion > 2){
                    opcion = -1;
                }
            }catch(NumberFormatException e){
                System.out.println("Error: Ingrese un número válido.");
            }
            switch (opcion) {
                case 0: // apagar
                    System.out.println("Adiosss...");
                    break;
                case 1: // iniciar sesion
                    // Otro submenu para iniciar sesion y eso
                    System.out.println("Ingrese el nombre de la cuenta");
                        try {
                            proxyActivo = proxys.get(scanner.nextLine());
                            System.out.println("Seleccionada: " + proxyActivo.getNombreCliente());
                            System.out.print("Ingrese su NIP de 4 dígitos: ");
                            if(!proxyActivo.login(scanner.nextLine())){
                                // si llegamos aqui, el proxy NO autentificó al usuario con el nip
                                proxyActivo = null;
                            }

                        } catch (Exception e) {
                            System.out.print("Cuenta no válida");
                        }


                
                    break;
                case 2: // maquina del tiempo
                    mes++;
                    update();
                    System.out.println("El tiempo avanzó un mes!");
                case 3: // consultar saldo
                    if(proxyActivo==null){break;}
                    double saldo = proxyActivo.getSaldo();
                    System.out.println("SALDO ACTUAL: $" + saldo);
                    break;
                case 4: // depositar
                    if(proxyActivo==null){break;}
                    System.out.print("Ingrese monto a depositar: ");
                    double deposito = Double.parseDouble(scanner.nextLine());
                    proxyActivo.depositar(deposito);
                    break;
                case 5: // retirar
                    if(proxyActivo==null){break;}
                    System.out.print("Ingrese monto a retirar: ");
                    double retiro = Double.parseDouble(scanner.nextLine());
                    proxyActivo.retirar(retiro);
                    break;
                case 6: // cerrar sesion 
                    if(proxyActivo==null){break;}
                    proxyActivo = null;
                    System.out.println("Vuelve pronto!");
                    break;
                default: // xd
                    System.err.println("Opción no válida");
                    break;
            }
            
        }

        scanner.close();
    }

    private static void update(){
        // sabes que el iterator está bien hecho porque funciona el foreach jaja
        for (ICuenta proxy : proxys) {
            proxy.update();
        }
  
    }

}