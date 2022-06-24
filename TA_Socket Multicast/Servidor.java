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

    private static MulticastSocket serverSocket;
    private static int port = 33333;
    public static void main(String[] args) throws SocketException, IOException {
        serverSocket = new MulticastSocket(port);
        byte[] receiveData = new byte[1024];
        serverSocket.joinGroup(InetAddress.getByName("230.0.0.1"));

        System.out.println("===============SERVER ACTIVO===============");
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            System.out.println("Mensaje recibido con éxito en el servidor:");
            System.out.println(sentence);
        }
    }
}
