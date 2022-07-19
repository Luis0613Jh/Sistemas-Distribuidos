import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfazRMI extends Remote{
    public String saludar(String msj)throws RemoteException;
    
}
