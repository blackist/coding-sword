package advance.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        ZkQuiz.register(args[0], args[1]);

        OrderService orderService = (OrderService) UnicastRemoteObject.exportObject(
                new OrderServiceImpl(), 0);
        Registry registry = LocateRegistry.createRegistry(Integer.parseInt(args[1]));
        String rmi = "rmi://" + args[0] + ":" + args[1] + "/";
        try {
            Context naming = new InitialContext();
            naming.rebind(rmi + "orderService", orderService);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("服务启动了");
    }
}
