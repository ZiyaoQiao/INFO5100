package Business;

import MarketFrame.Market;
import MarketFrame.MarketList;
import MarketFrame.PriceRangeTuple;
import MarketFrame.ProductOffer;
import OrderFrame.*;
import SupplierFrame.Product;
import SupplierFrame.Supplier;
import SupplierFrame.SupplierList;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.*;

public class Business {
    ArrayList<SalesPerson> salesPeople;
    ArrayList<Customer> customerArrayList;
    OrderList orderList;
    MarketList marketList;
    SupplierList supplierList;
    Admin adminAccount;

    public Business(){
        salesPeople = new ArrayList<>();
        marketList = new MarketList();
        orderList = new OrderList();
        marketList = new MarketList();
        supplierList = new SupplierList();
        adminAccount = new Admin();
    }

    public boolean adminLogin(String account, String password){
        if(account.equals(adminAccount.getID()) && password.equals(adminAccount.getPassword()))
            return true;
        else
            return false;
    }

    public SalesPerson salesPersonLogin(String account, String password){
        for(SalesPerson i: salesPeople){
            if(i.getAccount().equals(account) && i.getPassword().equals(password)){
                return i;
            }
        }
        return null;
    }

    public Customer searchCustomer(String firstName, String lastName){
        for(Customer i: customerArrayList){
            if(i.getLastName().equals(lastName) && i.getFirstName().equals(firstName)){
                return i;
            }
        }
        return null;
    }


    public boolean isExistCustomer(String firstName, String lastName){
        for(Customer i: customerArrayList){
            if(i.getFirstName().equals(firstName)&&i.getLastName().equals(lastName)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Product> allProduct(){
        ArrayList<Product> productList = new ArrayList<>();
        for(Supplier supplier:supplierList.getSupplierArrayList()){
            for(Product product: supplier.getProductList().getProductArrayList()){
                productList.add(product);
            }
        }
        return productList;
    }

    public void setMarketOffer(Market market, ArrayList<ProductOffer> productOffers){
        for(ProductOffer i: productOffers){
            market.getMarketOffer().getProductOfferArrayList().add(i);
        }
    }

    public void setMarketOffer(Market market, ArrayList<Product> products, ArrayList<PriceRangeTuple> priceRangeTuples){
        for(int i = 0; i<products.size();i++){
            ProductOffer tmp = market.newProductOffer();
            tmp.setProduct(products.get(i));
            tmp.setPriceRange(priceRangeTuples.get(i));
        }
    }

    public ProductOffer searchMarketProductOffer(Market market, ProductOffer productOffer){
        for(ProductOffer i: market.getMarketOffer().getProductOfferArrayList()){
            if(i.equals(productOffer)){
                return i;
            }
        }
        return null;
    }

    public void addSalesPerson(SalesPerson person){
        salesPeople.add(person);
    }

    public void addMarket(Market market){
        marketList.addMarket(market);
    }

    public void addSupplier(Supplier supply){
        supplierList.addSupplier(supply);
    }


    public void addCustomer(Customer customer){
        customerArrayList.add(customer);
    }

    public ArrayList<SalesPerson> getSalesPeople() {
        return salesPeople;
    }

    public ArrayList<Customer> getCustomerArrayList() {
        return customerArrayList;
    }

    public MarketList getMarketList() {
        return marketList;
    }

    public SupplierList getSupplierList() {
        return supplierList;
    }

    public OrderList getOrderList() {
        return orderList;
    }


    public double totalRevenue(){
        double result = 0;
        for(Order i:orderList.getOrderArrayList()){
            for(OrderItem item:i.getOrderItemArrayList()){
                result += item.getNumber()*item.getPrice();
            }
        }
        return result;
    }

    public double totalRevenuePerMarket(Market market){
        double result = 0;
        for(Customer i:market.getCustomerArrayList()){
            for(Order j:i.getOrderList().getOrderArrayList()){
                for(OrderItem item:j.getOrderItemArrayList()){
                    result += item.getNumber()*item.getPrice();
                }
            }
        }
        return result;
    }

    public double gapPerMarket(Market market){
        double result = 0;
        market.generateMap();
        for(Customer i: market.getCustomerArrayList()){
            for(Order j : i.getOrderList().getOrderArrayList()){
                for(OrderItem item: j.getOrderItemArrayList()){
                    result = item.getNumber()*item.getPrice() - market.getProductOfferMap().get(item.getProduct()).getPriceRange().getTargetPrice()*item.getNumber();
                }
            }
        }
        return result;
    }

    public ArrayList<SalesPerson> top10SalesPersonByMarket(Market market){
        class Sales implements Comparable<Sales> {
            SalesPerson salesPerson;
            double total;

            @Override
            public int compareTo(Sales o) {
                if(this.total == o.total)
                    return 0;
                else if(this.total>o.total)
                    return -1;
                else
                    return 1;
            }
        }
        ArrayList<Sales> sale = new ArrayList<>();
        ArrayList<SalesPerson> result = new ArrayList<>();
        for(SalesPerson person : salesPeople){
            Sales tmp = new Sales();
            tmp.salesPerson = person;
            double total = 0;
            for(Order order: person.getOrderList().getOrderArrayList()){
                for(OrderItem item : order.getOrderItemArrayList()){
                    total += item.getPrice()*item.getNumber();
                }
            }
            tmp.total = total;
            sale.add(tmp);
        }
        Collections.sort(sale);
        for(int i = 0; i <10; i++){
            result.add(sale.get(i).salesPerson);
        }
        return result;
    }

    public ArrayList<Double> gapSelectedSalesPerson(ArrayList<SalesPerson> sales, Market market){
        double result = 0;
        ArrayList<Double> re = new ArrayList<>();
        market.generateMap();
        for(SalesPerson i : sales){
            for(Order j : i.getOrderList().getOrderArrayList()){
                for(OrderItem item:j.getOrderItemArrayList()){
                    result = item.getNumber()*item.getPrice() - market.getProductOfferMap().get(item.getProduct()).getPriceRange().getTargetPrice()*item.getNumber();
                }
            }
            re.add(result);
            result = 0;
        }
        return re;
    }

    public ArrayList<SalesPerson> aboveTargetSales(){
        ArrayList<SalesPerson> result = new ArrayList<>();
        for(SalesPerson person : salesPeople){
            double total = 0;
            for(Order order:person.getOrderList().getOrderArrayList()){
                for(OrderItem item: order.getOrderItemArrayList()){
                    total += item.getPrice()*item.getNumber();
                }
            }
            if(total > person.getTarget()){
                result.add(person);
            }
        }
        return result;
    }

    public ArrayList<SalesPerson> belowTargetSales(){
        ArrayList<SalesPerson> result = new ArrayList<>();
        for(SalesPerson person : salesPeople){
            double total = 0;
            for(Order order:person.getOrderList().getOrderArrayList()){
                for(OrderItem item: order.getOrderItemArrayList()){
                    total += item.getPrice()*item.getNumber();
                }
            }
            if(total < person.getTarget()){
                result.add(person);
            }
        }
        return result;
    }

    public ArrayList<Double> gapSelectedSalesPerson(ArrayList<SalesPerson> sales){
        double result = 0;
        ArrayList<Double> re = new ArrayList<>();
        for(SalesPerson i : sales){
            for(Order j : i.getOrderList().getOrderArrayList()){
                Market market = j.getCustomer().getMarket();
                market.generateMap();
                for(OrderItem item:j.getOrderItemArrayList()){
                    result += item.getNumber()*item.getPrice() - market.getProductOfferMap().get(item.getProduct()).getPriceRange().getTargetPrice()*item.getNumber();
                }
            }
            re.add(result);
            result = 0;
        }
        return re;
    }

    public ArrayList<Product> top3ProductsSoldAboveTarget(){
        class topProduct implements Comparable<topProduct>{
            Product product;
            int number;
            boolean status;

            public topProduct(){
                product = new Product();
                number = 0;
                status = true;
            }
            @Override
            public int compareTo(topProduct o) {
                if (this.number == o.number)
                    return 0;
                else if (this.number > o.number)
                    return -1;
                else
                    return 1;
            }
        }


        ArrayList<topProduct> top = new ArrayList<>();
        ArrayList<Product> result = new ArrayList<>();

        Map<Product,topProduct> productMap = new HashMap<>();


        for(Market market: marketList.getMarketArrayList()) {
            for (Customer customer : market.getCustomerArrayList()) {
                for (Order order : customer.getOrderList().getOrderArrayList()) {
                    for (OrderItem item : order.getOrderItemArrayList()) {
                        topProduct tmp = new topProduct();
                        if(productMap.get(item.getProduct())==null) {
                            tmp.product = item.getProduct();
                            tmp.number = item.getNumber();
                            productMap.put(item.getProduct(),tmp);
                        }
                        if (item.getPrice() < market.getTargetPrice(item.getProduct())) {
                            tmp = productMap.get(item.getProduct());
                            tmp.status = false;
                        } else{
                            tmp = productMap.get(item.getProduct());
                            tmp.number += item.getNumber();
                        }
                    }
                }
            }
        }

        for(Map.Entry<Product,topProduct> entry : productMap.entrySet()){
            if(entry.getValue().status == true){
                top.add(entry.getValue());
            }
        }
        Collections.sort(top);
        for(int i = 0; i <3; i++){
            result.add(top.get(i).product);
        }
        return result;
    }

    public ArrayList<Double> gapSelectedProduct(ArrayList<Product> products){
        double result = 0;
        ArrayList<Double> re = new ArrayList<>();
        for(Product product:products){
            for(Market market: marketList.getMarketArrayList()){
        for(Customer cus : market.getCustomerArrayList()){
            for(Order order : cus.getOrderList().getOrderArrayList()){
                for(OrderItem item:order.getOrderItemArrayList()){
                    if(item.getProduct() == product){
                        result += item.getNumber()*item.getPrice() - market.getProductOfferMap().get(item.getProduct()).getPriceRange().getTargetPrice()*item.getNumber();
                    }
                }
            }
        }
    }
        re.add(result);
        result = 0;
    }
        return re;
}


    public double totalGap(){
        class topProduct implements Comparable<topProduct>{
            Product product;
            double profit;

            public topProduct(){
                product = new Product();
                profit = 0;
            }
            @Override
            public int compareTo(topProduct o) {
                if (this.profit == o.profit)
                    return 0;
                else if (this.profit > o.profit)
                    return -1;
                else
                    return 1;
            }
        }
        double total = 0;
        Map<Product,topProduct> productMap = new HashMap<>();


        for(Market market: marketList.getMarketArrayList()) {
            for (Customer customer : market.getCustomerArrayList()) {
                for (Order order : customer.getOrderList().getOrderArrayList()) {
                    for (OrderItem item : order.getOrderItemArrayList()) {
                        topProduct tmp = new topProduct();
                        if(productMap.get(item.getProduct())==null) {
                            tmp.product = item.getProduct();
                            tmp.profit = item.getNumber()*item.getPrice() - market.getTargetPrice(item.getProduct())*item.getNumber();
                            productMap.put(item.getProduct(),tmp);
                        }else {
                            tmp = productMap.get(item.getProduct());
                            tmp.profit += item.getNumber()*item.getPrice() - market.getTargetPrice(item.getProduct())*item.getNumber();
                        }
                    }
                }
            }
        }

        for(Map.Entry<Product,topProduct> entry : productMap.entrySet()){
            total += entry.getValue().profit;
        }
        return total;
    }
}
