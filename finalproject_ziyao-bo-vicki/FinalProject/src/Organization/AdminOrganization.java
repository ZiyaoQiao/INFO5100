package Organization;

import Role.Role;
import Role.AdminRole;
import java.util.ArrayList;

public class AdminOrganization extends Organization{

    public AdminOrganization(){
        super(Type.Admin.getValue());
    }
    public AdminOrganization(String location){
        super(Type.Admin.getValue(),location);
    }

    public ArrayList<Role> getSupportedRole(){
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AdminRole());
        return roles;
    }
}
