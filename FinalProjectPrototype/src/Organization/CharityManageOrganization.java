package Organization;

import Role.Role;
import Role.CharityManageRole;
import java.util.ArrayList;

public class CharityManageOrganization extends Organization {
    public CharityManageOrganization(){
        super(Organization.Type.CharityManage.getValue());
    }

    public ArrayList<Role> getSupportedRole(){
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CharityManageRole());
        return roles;
    }
}
