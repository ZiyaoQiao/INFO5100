package OrderFrame;

import java.util.ArrayList;

public class OrderList {
    ArrayList<Order> orderArrayList;

    public OrderList(){
        orderArrayList = new ArrayList<>();
    }

    public ArrayList<Order> getOrderArrayList() {
        return orderArrayList;
    }

    public Order newOrder(){
        Order order = new Order();
        orderArrayList.add(order);
        return order;
    }
    public void addOrder(Order order){
        orderArrayList.add(order);
    }
}
