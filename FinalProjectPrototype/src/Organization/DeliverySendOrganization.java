package Organization;

import Role.Role;
import Role.DeliverySendRole;
import java.util.ArrayList;

public class DeliverySendOrganization extends Organization{
    public DeliverySendOrganization(){
        super(Type.DeliverySend.getValue());
    }

    public ArrayList<Role> getSupportedRole(){
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DeliverySendRole());
        return roles;
    }
}
