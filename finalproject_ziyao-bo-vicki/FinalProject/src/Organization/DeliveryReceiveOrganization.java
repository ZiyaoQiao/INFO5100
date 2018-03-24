package Organization;

import Role.Role;
import Role.DeliveryReceiveRole;
import java.util.ArrayList;

public class DeliveryReceiveOrganization extends Organization{
    public DeliveryReceiveOrganization(){
        super(Type.DeliveryReceive.getValue());
    }
    public DeliveryReceiveOrganization(String location){
        super(Type.DeliveryReceive.getValue(), location);
    }
    public ArrayList<Role> getSupportedRole(){
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DeliveryReceiveRole());
        return roles;
    }
}
