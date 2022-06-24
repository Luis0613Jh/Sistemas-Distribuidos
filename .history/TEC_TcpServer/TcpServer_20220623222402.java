import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Luis Jumbo
 * @Curso 6to "A"
 * @Fecha 06/06/2022
 */
public class TcpServer {

    private static String host = "127.0.0.1";
    private static ServerSocket server;
    private static int port = 5000;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        server = new ServerSocket(port);
        while (true) {
            System.out.println("Esperando la petición del cliente");
            Socket socket = server.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String mensaje = String.valueOf(ois.readObject());
            System.out.println("Mensaje recibido : "+mensaje);

            System.out.println("Enviando respuesta al cliente");
            Socket socketEnviar = new Socket();
            ObjectOutputStream oos = new ObjectOutputStream(socketEnviar.getOutputStream());
            oos.writeObject("Mi primera vez en el servidor :3");

            oos.close();
            ois.close();
            socket.close();
            System.out.println("Finalizando petición");
        }
//        server.close();
    }

}
