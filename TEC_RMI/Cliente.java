package RMI;
import java.rmi.Naming;
/**
 *
 * @author luis0
 */
public class Cliente {
    public static void main(String[] args) {
        try {
            System.out.println("Cliente corriendo");
            InterfaceRmi interfaz = (InterfaceRmi)Naming.lookup("rmi://localhost/saludo");
            interfaz.saludar("Luis");
        } catch (Exception e) {
        }
    }
}
