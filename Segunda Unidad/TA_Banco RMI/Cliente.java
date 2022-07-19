import java.rmi.Naming;
import java.io.*;
import java.util.Scanner;

/**
 * @author Luis Jumbo
 * @Curso 6to "A"
 * @Fecha 23/06/2022
 */
public class Cliente{
    
    public static void main(String [] args){
        boolean salir = false;
        String nombre = "Luis Jumbo";
        double cantidadTransaccion;
        double cantidadEnCuenta = 500;
        Scanner cantidad;
        Scanner opcion;
        try {
            InterfazRMI interfaz = (InterfazRMI)Naming.lookup("rmi://localhost/banco");
            System.out.println("Bienvenido " + nombre);
            do {
                System.out.println("Actualmente posee [" + cantidadEnCuenta + "] en su cuenta bancaria.");
                System.out.println("¿Qué desea hacer?");
                System.out.println("1. Depositar");
                System.out.println("2. Retirar");
                System.out.println("3. Salir");
                opcion = new Scanner(new InputStreamReader(System.in));
                switch (opcion.next()) {
                    case "1":
                        System.out.println("Ingrese la cantidad a depositar: ");
                        cantidad = new Scanner(new InputStreamReader(System.in));
                        cantidadTransaccion = Double.parseDouble(cantidad.next());
                        while (cantidadTransaccion <= 0) {
                            System.out.println("El valor de depósito no puede ser menor o igual a 0, ingrese otra cantidad: ");
                            cantidad = new Scanner(new InputStreamReader(System.in));
                            cantidadTransaccion = Double.parseDouble(cantidad.next());
                        }
                        cantidadEnCuenta = interfaz.depositar(cantidadTransaccion, cantidadEnCuenta);
                        System.out.println("Depósito realizado con éxito, el saldo en su cuenta es de: " + cantidadEnCuenta);
                        System.out.println();
                        System.out.println();
                        break;
                    case "2":
                        System.out.println("Retiro");
                        System.out.println("Ingrese la cantidad a retirar: ");
                        cantidad = new Scanner(new InputStreamReader(System.in));
                        cantidadTransaccion = Double.parseDouble(cantidad.next());
                        while (cantidadTransaccion <= 0 || cantidadTransaccion > cantidadEnCuenta) {
                            System.out.println("El valor de retiro no puede ser menor o igual a 0, ni tampoco superior a la cantidad que posee en la cuenta, ingrese otra cantidad: ");
                            cantidad = new Scanner(new InputStreamReader(System.in));
                            cantidadTransaccion = Double.parseDouble(cantidad.next());
                        }
                        cantidadEnCuenta = interfaz.retirar(cantidadTransaccion, cantidadEnCuenta);
                        System.out.println("Retiro realizado con éxito, el saldo en su cuenta es de: " + cantidadEnCuenta);
                        System.out.println();
                        System.out.println();
                        break;
                    case "3":
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida, intente nuevamente por favor");
                        break;
                }
            } while (!salir);
        } catch (Exception e) {
            System.out.println(""+e);
        }
    }
}
