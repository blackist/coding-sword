package advance.rmi;

import javax.naming.Context;
import javax.naming.InitialContext;

public class Client {


    public static void main(String[] args) {
        try {
            OrderService service = null;
            String rmi = "rmi://" + args[0] + ":" + args[1] + "/";
            System.out.println("Service From: " + rmi);
            Context context = new InitialContext();
            service = (OrderService) context.lookup(rmi + "orderService");
            System.out.println(service.getOrder(10));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
