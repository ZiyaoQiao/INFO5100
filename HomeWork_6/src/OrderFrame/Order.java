package OrderFrame;

import java.util.ArrayList;

public class Order {
    ArrayList<OrderItem> orderItemArrayList;
    Customer customer;

    public Order(){
        orderItemArrayList = new ArrayList<>();
        customer = new Customer();
    }

    public OrderItem newOrder(){
        OrderItem orderItem = new OrderItem();
        orderItemArrayList.add(orderItem);
        return orderItem;
    }
    public void addOrder(OrderItem orderItem){
        orderItemArrayList.add(orderItem);
    }

    public ArrayList<OrderItem> getOrderItemArrayList() {
        return orderItemArrayList;
    }

    public Customer getCustomer() {
        return customer;
    }
}
