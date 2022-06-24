package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Luis Jumbo
 */
public interface InterfaceRmi extends Remote{
    public String saludar (String nombre) throws RemoteException;
}
