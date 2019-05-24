package advance.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OrderService extends Remote {

    String getOrder(int id) throws RemoteException;
}
