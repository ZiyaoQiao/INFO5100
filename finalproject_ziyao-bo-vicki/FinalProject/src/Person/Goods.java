package Person;

public class Goods {
    String name;
    int num;
    double condition = 0;
    double estimatedPrice = 0;
    double size = 0;
    double x = 0;
    double y = 0;
    double z = 0;
    double weight = 0;
    String picLink = null;

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }
    
    
    private Goods linkGoods;

    public Goods getLinkGoods() {
        return linkGoods;
    }

    public void setLinkGoods(Goods linkGoods) {
        this.linkGoods = linkGoods;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    
    
    
    public Goods(){

    }

    public Goods(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getCondition() {
        return condition;
    }

    public void setCondition(double condition) {
        this.condition = condition;
    }

    public double getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(double estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }


     @Override
    public String toString(){
        return name;
    }
}
