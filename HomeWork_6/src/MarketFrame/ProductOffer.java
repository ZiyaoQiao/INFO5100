package MarketFrame;

import SupplierFrame.Product;

public class ProductOffer {
    Product product;
    PriceRangeTuple priceRange;

    public ProductOffer(){
        product = new Product();
        priceRange = new PriceRangeTuple();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PriceRangeTuple getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(PriceRangeTuple priceRange) {
        this.priceRange = priceRange;
    }

    @Override
    public String toString(){
        return product.getProductName();
    }
}
