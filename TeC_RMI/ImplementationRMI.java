import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class ImplementationRMI extends UnicastRemoteObject implements InterfazRMI{
    public ImplementationRMI() throws RemoteException{
        super();
    }

    public String saludar(String nombre) throws RemoteException{
        return "hola"+nombre;
    }
}
