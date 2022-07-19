import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Luis Jumbo
 * @Curso 6to "A"
 * @Fecha 07/06/2022
 */
public class UdpServer {

    public static void main(String[] args) throws Exception {
        
        
        DatagramSocket serverSocket = new DatagramSocket(9876);
        DatagramSocket clientSocket = new DatagramSocket();
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
//            RECIBIR MENSAJE DEL CLIENTE
            System.out.println("SERVIDOR ACTIVO");
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            System.out.println(">> Mensaje recivido: " + sentence);
            
            //            ENVIAR MENSAJE AL CLIENTE
            InetAddress IPAdress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAdress, port);
            serverSocket.send(sendPacket);
            System.out.println("Mensaje enviado");
        }
    }

}
