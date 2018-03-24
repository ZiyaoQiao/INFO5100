package SupplierFrame;

public class Supplier {
    ProductList productList;
    String supplierName;
    public Supplier(){
        productList = new ProductList();
        supplierName = "";
    }

    public ProductList getProductList() {
        return productList;
    }

    public void setProductList(ProductList productList) {
        this.productList = productList;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void addProduct(Product product){
        productList.addProduct(product);
    }

    public Product newProduct(){
        Product product = productList.newProduct();
        return product;
    }

}
