package MarketFrame;

import java.util.ArrayList;

public class MarketList {
    ArrayList<Market> marketArrayList;

    public MarketList(){
        marketArrayList = new ArrayList<>();
    }
    public Market newMarket(){
        Market market = new Market();
        marketArrayList.add(market);
        return market;
    }
    public void addMarket(Market market){
        marketArrayList.add(market);
    }
    public ArrayList<Market> getMarketArrayList() {
        return marketArrayList;
    }
}
