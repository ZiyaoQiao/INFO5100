package SupplierFrame;
import java.util.ArrayList;

public class ProductList {
    ArrayList<Product> productArrayList;

    public ProductList(){
        productArrayList = new ArrayList<>();
    }


    public Product newProduct(){
        Product product = new Product();
        productArrayList.add(product);
        return product;
    }
    public void addProduct(Product product){
        productArrayList.add(product);
    }
    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }
}
