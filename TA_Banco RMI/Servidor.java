import java.rmi.Naming;

/**
 * @author Luis Jumbo
 * @Curso 6to "A"
 * @Fecha 23/06/2022
 */
public class Servidor {
    public Servidor(){
        try {
            System.out.println("ESTAMOS EN EL SERVIDOR");
            InterfazRMI objetD = new ImplementationRMI();
            Naming.rebind("rmi://localhost/banco", objetD);
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
    public static void main(String [] args){
        new Servidor();
    }
}
