package RMI;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
/**
 *
 * @author Luis Jumbo
 */
public class ImplementacionRmi extends UnicastRemoteObject implements InterfaceRmi{

    public ImplementacionRmi() throws RemoteException{
        super();
    }

    @Override
    public String saludar(String nombre) throws RemoteException {
        return "Hola " + nombre;
    }

}
