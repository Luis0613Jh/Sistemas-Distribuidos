import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author Luis Jumbo
 * @Curso 6to "A"
 * @Fecha 23/06/2022
 */
public class Cliente {

    private static MulticastSocket serverSocket;
    private static int port = 5876;

    public static void main(String[] args) throws SocketException, IOException {
        serverSocket = new MulticastSocket(port);
        byte[] receiveData = new byte[1024];
        serverSocket.joinGroup(InetAddress.getByName("230.0.0.1"));

        // RECIBIR TIEMPO DEL SERVIDOR
        System.out.println("===============CLIENTE ACTIVO===============");
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);
        // String sentence = new String(receivePacket.getData(), StandardCharsets.UTF_8);
        byte[] byteRecibido = receivePacket.getData();
        System.out.println(byteRecibido);
        int tiempoServidorINT = Integer.parseInt(byteRecibido[0]);
        int tiempoServidor = ByteBuffer.wrap(byteRecibido).getInt();
        // String cadena = sentence + "";
        System.out.print("Tiempo recibido del servidor: ");
        System.out.println(tiempoServidor);
        System.out.print("Tiempo recibido del servidor INT: ");
        System.out.println(tiempoServidorINT);

        // ENVIAR D AL SERVIDOR
        
    }
}