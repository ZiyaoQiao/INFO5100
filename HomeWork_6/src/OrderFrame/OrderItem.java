package OrderFrame;

import SupplierFrame.Product;

public class OrderItem {
    Product product;
    double price;
    int number;

    public OrderItem(){
        product = new Product();
        price = 0;
        number = 0;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
