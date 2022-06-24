package RMI;

import java.rmi.Naming;
/**
 *
 * @author Luis Jumbo
 */
public class Servidor {

    public Servidor() {
        try {
            System.out.println("Servidor corriendo");
            InterfaceRmi objetoD = new ImplementacionRmi();
            Naming.rebind("rmi://localhost/oyente", objetoD);
        } catch (Exception e) {
        }
    }
   
    public static void main(String[] args) {
        new Servidor();    
    }
}
