package Organization;

import Role.Role;
import Role.GovComplainRole;
import java.util.ArrayList;

public class GovComplainOrganization extends Organization{
    public GovComplainOrganization(){
        super(Type.GovernmentComplain.getValue());
    }

    public ArrayList<Role> getSupportedRole(){
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new GovComplainRole());
        return roles;
    }
}
