package Enterprise;

import Role.Role;

import java.util.ArrayList;

public class DeliveryEnterprise extends Enterprise{
    ArrayList<Integer> priceList;

    public DeliveryEnterprise(String name){
        super(name, Enterprise.EnterpriseType.Delivery);
        priceList = new ArrayList<>();
    }

    public ArrayList<Role> getSupportedRole(){
        return null;
    }
}
