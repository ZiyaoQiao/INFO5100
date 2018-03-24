package MarketFrame;

import OrderFrame.Customer;
import OrderFrame.Order;
import OrderFrame.OrderItem;
import OrderFrame.OrderList;
import SupplierFrame.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Market {
    MarketOffer marketOffer;
    String marketName;
    ArrayList<Customer> customerArrayList;
    Map<Product,ProductOffer> productOfferMap;
    public Market(){
        customerArrayList = new ArrayList<>();
        productOfferMap = new HashMap<>();
        marketName = "";
        marketOffer = new MarketOffer();
    }

    public MarketOffer getMarketOffer() {
        return marketOffer;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public ArrayList<Customer> getCustomerArrayList() {
        return customerArrayList;
    }

    public Map<Product, ProductOffer> getProductOfferMap() {
        return productOfferMap;
    }

    public ProductOffer newProductOffer(){
        ProductOffer productOffer = new ProductOffer();
        marketOffer.getProductOfferArrayList().add(productOffer);
        return productOffer;
    }

    public double getTargetPrice(Product product){
        for(ProductOffer po : marketOffer.getProductOfferArrayList()){
            if(po.getProduct().getProductID() == product.getProductID())
                return po.getPriceRange().getTargetPrice();
        }
        return -1;
    }

    public void generateMap(){
        productOfferMap = new HashMap<>();
        for(ProductOffer i: marketOffer.getProductOfferArrayList()){
            productOfferMap.put(i.getProduct(),i);
        }
    }

}
