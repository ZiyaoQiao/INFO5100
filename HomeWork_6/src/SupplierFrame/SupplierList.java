package SupplierFrame;

import java.util.ArrayList;

public class SupplierList {
    ArrayList<Supplier> supplierArrayList;

    public SupplierList(){
        supplierArrayList = new ArrayList<>();
    }

    public ArrayList<Supplier> getSupplierArrayList() {
        return supplierArrayList;
    }

    public Supplier newSupplier(){
        Supplier supplier = new Supplier();
        supplierArrayList.add(supplier);
        return supplier;
    }
    public void addSupplier(Supplier supplier){
        supplierArrayList.add(supplier);
    }
}
