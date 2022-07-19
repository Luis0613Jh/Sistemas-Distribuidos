import java.rmi.Naming;
import java.io.*;
import java.util.Scanner;

public class Cliente{
    public static void main(String [] args){
        try {
            InterfazRMI interfaz = (InterfazRMI)Naming.lookup("rmi://localhost/saludo");
            System.out.println("como te llamas");
            Scanner sc = new Scanner(new InputStreamReader(System.in));
            System.out.println(interfaz.saludar(sc.next()));
        } catch (Exception e) {
            System.out.println(""+e);
        }
    }
}
