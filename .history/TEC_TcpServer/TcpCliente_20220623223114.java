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
public class TcpCliente {

    private static String host = "127.0.0.1";
    private static ServerSocket server;
    private static int port = 5000;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        server = new ServerSocket(port);
        for (int i = 0; i < 10; i++) {
            System.out.println("CLIENTE ACTIVO");
            Socket socket = new Socket(host, port);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Mensaje [" + i + "]");

            Socket socketRecibir = server.accept();
            ObjectInputStream ois = new ObjectInputStream(socketRecibir.getInputStream());
            String mensaje = String.valueOf(ois.readObject());
            System.out.println("Mensaje recibido desde el servidor: " + mensaje);
            oos.close();
            ois.close();
            socket.close();
        }
    }

}
