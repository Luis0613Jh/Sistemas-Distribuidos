
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Jean Agreda
 */
public class Cliente {

    private static String host = "127.0.0.1";
    private static int port = 5000;

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        int cont = 0;
        while (cont < 5000) {
            cont = cont + 1;

            System.out.println("iniciando el socket para comunicarnos ");
            
            Socket socket = new Socket(host, port);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            String msj = " MVP "+ cont;
            oos.writeObject(msj);

           
            System.out.println("MSJ: " + msj);
            // ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //String mensaje = String.valueOf(ois.readObject());
            //oos.close();
            // socket.close();

        }

    }

}
