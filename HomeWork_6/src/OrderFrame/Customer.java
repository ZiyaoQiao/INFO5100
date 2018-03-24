package OrderFrame;

import Business.Business;
import MarketFrame.Market;
import MarketFrame.ProductOffer;
import SupplierFrame.Product;
import SupplierFrame.Supplier;

import java.util.ArrayList;

public class Customer {
    OrderList orderList;
    Market market;
    String firstName;
    String lastName;

    public Customer(){
        orderList = new OrderList();
        market = new Market();
        firstName = "";
        lastName = "";
    }

    public OrderList getOrderList() {
        return orderList;
    }

    public Market getMarket() {
        return market;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<ProductOffer> getAllProduct(){
        ArrayList<ProductOffer> productList = new ArrayList<>();
        for(ProductOffer i : market.getMarketOffer().getProductOfferArrayList()){
            productList.add(i);
        }
        return productList;
    }

    public ArrayList<ProductOffer> getSelectedSupplierProduct(Supplier supplier){
        ArrayList<ProductOffer> productList = new ArrayList<>();
        for(ProductOffer i: market.getMarketOffer().getProductOfferArrayList()){
            for(Product j : supplier.getProductList().getProductArrayList()){
                if(i.getProduct() == j){
                    productList.add(i);
                }
            }
        }
        return productList;
    }

    public double totalPrice(ArrayList<OrderItem> orderList){
        double total = 0;
        for(OrderItem i:orderList){
            total+=i.getPrice()*i.getNumber();
        }
        return total;
    }

    public void addOrder(ArrayList<OrderItem> orderItems, SalesPerson salesPerson, Business business){
        Order order = new Order();
        for(OrderItem i:orderItems){
            order.getOrderItemArrayList().add(i);
        }
        order.customer = this;
        salesPerson.getOrderList().getOrderArrayList().add(order);
        business.getOrderList().getOrderArrayList().add(order);
    }

}
