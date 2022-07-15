import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
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
public class Client {

    private static String host = "127.0.0.1";
    private static int port = 9876;
    public static void main(String[] args) throws SocketException, IOException {

        Socket socket = new Socket(host, port);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner input = new Scanner(socket.getInputStream());
        long tiempoInicial;
        long tiempoServidor;
        long tiempoFinal;
        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss:SS");

        // ENVIAR MENSAJE AL SERVIDOR
        System.out.println("CLIENTE ACTIVO");
        tiempoInicial = System.currentTimeMillis();
        out.println("Solicitar timepo del servidor");
        String tiempoServidorString = input.nextLine();
        tiempoFinal = System.currentTimeMillis();
        tiempoServidor = Long.parseLong(tiempoServidorString);
        
        long tiempoCalculado = tiempoServidor + ((tiempoFinal - tiempoInicial) / 2);
        System.out.println("Tiempo Inicial (T1): " + formatoHora.format(new Date(tiempoInicial)));
        System.out.println("Tiempo Final (T0): " + formatoHora.format(new Date(tiempoFinal)));
        System.out.println("Tiempo Servidor (CS): " + formatoHora.format(new Date(tiempoServidor)));
        System.out.println("Tiempo Calculado (C): " + formatoHora.format(new Date(tiempoCalculado)));
        System.out.println("=========================================================================================================");
        System.out.println("\t\t\t\tSINCRONIZACIÓN DE RELOJ");
        System.out.println();
        if(tiempoFinal < tiempoCalculado) {
            System.out.println("Tiempo del Cliente Actual: " + formatoHora.format(new Date(tiempoFinal)));
            System.out.println("Tiempo Calculado (C): " + formatoHora.format(new Date(tiempoCalculado)));
            System.out.println("Se debe realizar una actualización ya que el tiempo del cliente es menor que el tiempo calculado");
            System.out.println("El tiempo actual del cliente es: " + formatoHora.format(new Date(tiempoCalculado)));
        } else {
            long diferenciaTiempo = tiempoFinal - tiempoCalculado;
            System.out.println("Tiempo del Cliente Actual: " + formatoHora.format(new Date(tiempoFinal)));
            System.out.println("Tiempo Calculado (C): " + formatoHora.format(new Date(tiempoCalculado)));
            System.out.println("Se debe realizar un retardo de: " + diferenciaTiempo + " ms, ya que el tiempo del cliente es mayor que el tiempo calculado");
            System.out.println("El tiempo actual del cliente va a ser: " + formatoHora.format(new Date(tiempoFinal)) + " por " + diferenciaTiempo + " ms");
            
        }
        System.out.println("=========================================================================================================");
    }
}
