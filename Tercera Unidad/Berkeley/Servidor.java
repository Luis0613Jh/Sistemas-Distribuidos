import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/**
 * @author Luis Jumbo
 * @Curso 6to "A"
 * @Fecha 23/06/2022
 */
public class Servidor {

    private static MulticastSocket clienteSocket;
    private static int port = 5876;

    public static void main(String[] args) throws SocketException, IOException {

        clienteSocket = new MulticastSocket();
        byte[] sendData = new byte[1024];
        int tiempoActual = 20;
        String sentence;

        System.out.println("===============SERVIDOR ACTIVO===============");
        // ENVIAR EL TIEMPO A TODOS LOS CLIENTES
        sentence = tiempoActual + "";
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("230.0.0.1"),
                port);
        clienteSocket.send(sendPacket);
        System.out.println("Mensaje enviado con éxito al cliente:");
        System.out.println(sentence);
    }
}
