import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Luis Jumbo
 * @Curso 6to "A"
 * @Fecha 23/06/2022
 */
public interface InterfazRMI extends Remote{
    public double depositar(double cantidadTransaccion, double cantidadEnCuenta)throws RemoteException;
    public double retirar(double cantidadTransaccion, double cantidadEnCuenta)throws RemoteException;    
}
