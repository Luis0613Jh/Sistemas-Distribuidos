import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Luis Jumbo
 * @Curso 6to "A"
 * @Fecha 14/07/2022
 */
public class TcpCliente {

    private static String host = "127.0.0.1";
    private static ServerSocket server;
    private static int port = 5000;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        server = new ServerSocket(port);
        int tiempoInicial = 0;
        int tiempoFinal = 0;
        int tiempoActualizado = 0;
        System.out.println("CLIENTE ACTIVO");
        Socket socketEnviar = new Socket(host, port);
        ObjectOutputStream oos = new ObjectOutputStream(socketEnviar.getOutputStream());
        long tiempoActual = System.currentTimeMillis();
        oos.writeObject("Solicitar tiempo al servidor");
        System.out.println("Mensaje enviado al servidor");

        
        Socket socketRecibir = server.accept();
        ObjectInputStream ois = new ObjectInputStream(socketRecibir.getInputStream());
        String mensaje = String.valueOf(ois.readObject());
        System.out.println("Tiempo recibido desde el servidor: " + mensaje);
        ois.close();
        oos.close();
        server.close();
    }
}
