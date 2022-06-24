packageimport java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Luis Jumbo
 * @Curso 6to "A"
 * @Fecha 06/06/2022
 */
public class UdpClient {

    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket clientSocket = new DatagramSocket();
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket serverSocket = new DatagramSocket(9877);

        InetAddress IPAdress = InetAddress.getByName("127.0.0.1");
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while (true) {
//            ENVIAR MENSAJE AL SERVIDOR
            System.out.println("Enviar datos al servidor desde el cliente");
            String sentence = inFromUser.readLine();
            sendData = sentence.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAdress, 9876);
            clientSocket.send(sendPacket);
//            clientSocket.close();

            System.out.println("MESSASGE ENVIADO");

//            RECIBIR MENSAJE DEL SERVIDOR
            System.out.println("Servidor activo en el lado del cliente");
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentenceRecive = new String(receivePacket.getData());
//            serverSocket.close();
            System.out.println("========================= Mensaje recivido: " + sentenceRecive);
            System.out.println("Servidor desactivado en el lado del cliente");
        }
    }
}
