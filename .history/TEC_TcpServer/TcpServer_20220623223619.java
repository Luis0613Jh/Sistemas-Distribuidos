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

    private static ServerSocket server;
    private static String host = "127.0.0.1";
    private static int port = 5000;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        server = new ServerSocket(port);
        int contador = 1000;
        while (true) {
            System.out.println("SERVIDOR ACTIVO");
            Socket socket = server.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String mensaje = String.valueOf(ois.readObject());
            System.out.println("Mensaje recibido: " + mensaje);

            System.out.println("Enviando respuesta al cliente");
            Socket socketEnviar = new Socket(host, port);
            ObjectOutputStream oos = new ObjectOutputStream(socketEnviar.getOutputStream());
            oos.writeObject("Mensaje [" + contador + "] desde el servidor");
            contador++;
            oos.close();
            ois.close();
            socket.close();
            System.out.println("Finalizando petición");
        }
    }
}
