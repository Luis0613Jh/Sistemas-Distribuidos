import java.io.BufferedReader;
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

        InetAddress IPAdress = InetAddress.getByName("127.0.0.1");
        
        while (true) {
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

//            ENVIAR MENSAJE AL SERVIDOR
            System.out.println("CLIENTE ACTIVO");
            String sentence = inFromUser.readLine();
            sendData = sentence.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAdress, 9876);
            clientSocket.send(sendPacket);

            System.out.println("Mensaje enviado");

//            RECIBIR MENSAJE DEL SERVIDOR
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String sentenceRecive = new String(receivePacket.getData());
            System.out.println(">> Mensaje recivido: " + sentenceRecive);
            System.out.println("CLIENTE DESACTIVADO");
            clientSocket.close();
        }
    }
}
