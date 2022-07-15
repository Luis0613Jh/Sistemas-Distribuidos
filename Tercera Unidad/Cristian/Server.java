import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Luis Jumbo
 * @Curso 6to "A"
 * @Fecha 15/07/2022
 */
public class Server {

    private static int port = 9876;
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        long tiempoServidor;
        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss:SSS");

        while (true) {
//            RECIBIR MENSAJE DEL CLIENTE
            System.out.println("SERVIDOR ACTIVO");
            Socket socketCliente = serverSocket.accept();
            PrintWriter out = new PrintWriter(socketCliente.getOutputStream(), true);
            Scanner input = new Scanner(socketCliente.getInputStream());
            String entrada = input.nextLine();
            tiempoServidor = System.currentTimeMillis();
            out.println(tiempoServidor);
            System.out.println("Mensaje: " + entrada);
            System.out.println("Tiempo desde el servidor: " + formatoHora.format(new Date(tiempoServidor)));
            System.out.println("Mensaje enviado");
        }
    }

}
