import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Luis Jumbo
 * @Curso 6to "A"
 * @Fecha 23/06/2022
 */
public class ImplementationRMI extends UnicastRemoteObject implements InterfazRMI{
    public ImplementationRMI() throws RemoteException{
        super();
    }

    public double depositar(double cantidadTransaccion, double cantidadEnCuenta) throws RemoteException{
        cantidadEnCuenta += cantidadTransaccion;
        return cantidadEnCuenta;
    }
    
    public double retirar(double cantidadTransaccion, double cantidadEnCuenta) throws RemoteException{
        cantidadEnCuenta -= cantidadTransaccion;
        return cantidadEnCuenta;
    }
}
