package advance.rmi;

public class OrderServiceImpl implements OrderService {
    @Override
    public String getOrder(int id) {
        System.out.println("订单" + id);
        return "订单" + id;
    }
}
