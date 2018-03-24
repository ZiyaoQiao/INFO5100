package SupplierFrame;

public class Product {
    String productName;
    String productID;

    public Product(){
        productID = "";
        productName = "";
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    @Override
    public String toString(){
        return productName;
    }


    public int partition(a,lo,high){
        int i = lo;
        int j = high+1;
        while(true){

            while(a[++i] < a[lo]){
                if(i == high)
                    break;
            }

            while(a[lo] < a[--j]){
                if(j == lo)
                    break;
            }

            if(i >= j)
                break;

            swap(a,i,j);
        }
        swap(a,lo,j);
        return j;
    }

    public void sort(a,lo,high){
        if(high <= lo)
            return;
        int j = partition(a,lo,high);
        sort(a,lo,j-1);
        sort(a,j+1,high);
    }
}
