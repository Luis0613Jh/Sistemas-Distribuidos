
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author Jean Agreda
 */
public class Servidor {
    
        private static ServerSocket server;
        private static int port = 5000;


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        server = new ServerSocket(port);
        
        while (true) {    
            System.out.println("server en linea");
            Socket socket= server.accept();
            
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String mensaje = String.valueOf(ois.readObject());
            System.out.println("Mensaje Cliente : "+mensaje);
            ois.close();
            socket.close();
            //server.close();
        }
    
        
    }
    
    

    
    
}
