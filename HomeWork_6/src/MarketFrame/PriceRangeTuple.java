package MarketFrame;

public class PriceRangeTuple {
    double floorPrice;
    double ceilingPrice;
    double targetPrice;

    public PriceRangeTuple(){
        floorPrice = 0;
        ceilingPrice = 0;
        targetPrice = 0;
    }

    public double getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(double floorPrice) {
        this.floorPrice = floorPrice;
    }

    public double getCeilingPrice() {
        return ceilingPrice;
    }

    public void setCeilingPrice(double ceilingPrice) {
        this.ceilingPrice = ceilingPrice;
    }

    public double getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(double targetPrice) {
        this.targetPrice = targetPrice;
    }
}
