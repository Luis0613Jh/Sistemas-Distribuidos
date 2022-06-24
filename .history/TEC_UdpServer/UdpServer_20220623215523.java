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
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        
        DatagramSocket serverSocket = new DatagramSocket(9876);
        DatagramSocket clientSocket = new DatagramSocket();
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
//            RECIBIR MENSAJE DEL CLIENTE
            System.out.println("SERVIDOR ACTIVO");
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
//            serverSocket.close();
            System.out.println(">> Mensaje recivido: " + sentence);
            
            //            ENVIAR MENSAJE AL CLIENTE
            System.out.println("Enviar datos al cliente desde el servidor");
            InetAddress IPAdress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String capitalizedSentence = sentence.toUpperCase();
            //String sentenceSend = inFromUser.readLine();
            sendData = capitalizedSentence.getBytes();
            System.out.println("Data: " + sendData);
            
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAdress, port);
            serverSocket.send(sendPacket);
            //            clientSocket.close();
            // System.out.println("SERVIDOR DESACTIVADO");
            System.out.println("Mensaje enviado");
        }
    }

}
