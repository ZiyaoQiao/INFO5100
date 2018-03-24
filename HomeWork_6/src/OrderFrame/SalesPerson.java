package OrderFrame;

import MarketFrame.Market;

public class SalesPerson {
    OrderList orderList;

    String firstName;
    String lastName;
    int target;
    String account;
    String password;

    public SalesPerson(){
        orderList = new OrderList();
        firstName = "";
        lastName = "";
        target = 0;
        account = "";
        password = "";
    }

    public OrderList getOrderList() {
        return orderList;
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

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double compensation(){
        //Order order = orderList.orderArrayList.get(orderList.orderArrayList.size()-1);
        double totalSales = 0;
        double totalTarget = 0;
        double compensation = 0;
        for(Order order : orderList.getOrderArrayList()) {
            for (OrderItem item : order.getOrderItemArrayList()) {
                totalSales += item.getNumber() * item.getPrice();
                Market market = order.getCustomer().getMarket();
                totalTarget += market.getTargetPrice(item.getProduct()) * item.getNumber();
            }
        }
        if(totalSales > target*1.5 && totalSales > totalTarget*0.8) {
            compensation = (totalSales - totalTarget) / totalTarget;
            if(compensation < 0)
                compensation = 0;
        }
        else if(totalSales < target){
            if(totalSales < totalTarget)
                compensation = (totalSales - totalTarget)/totalTarget -0.2;
            else if(totalSales > totalTarget && totalSales <totalSales*1.2){
                compensation = 0;
            }
            else
                compensation = (totalSales - totalTarget)/totalTarget;
        }
        else{
            compensation = (totalSales - totalTarget)/totalTarget;
        }
        return compensation;
    }

}
