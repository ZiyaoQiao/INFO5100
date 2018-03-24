package MarketFrame;

import java.util.ArrayList;

public class MarketOffer {
    ArrayList<ProductOffer> productOfferArrayList;

    public MarketOffer(){
        productOfferArrayList = new ArrayList<>();
    }

    public ArrayList<ProductOffer> getProductOfferArrayList() {
        return productOfferArrayList;
    }
}
