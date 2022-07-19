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
public class Cliente {

    private static MulticastSocket clienteSocket;
    private static int port = 33333;
    public static void main(String[] args) throws SocketException, IOException {

        clienteSocket = new MulticastSocket();
        clienteSocket.
        byte[] sendData = new byte[1024];
        int contador = 0;
        String sentence;

        System.out.println("===============CLIENTE ACTIVO===============");
        while (true) {
            sentence = contador + "";
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("230.0.0.1"), port);
            clienteSocket.send(sendPacket);
            System.out.println("Mensaje enviado con éxito desde el cliente:");
            System.out.println(sentence);
            contador++;
        }
    }
}