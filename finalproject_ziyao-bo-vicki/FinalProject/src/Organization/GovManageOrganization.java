package Organization;

import Role.Role;
import Role.GovManageRole;
import java.util.ArrayList;

public class GovManageOrganization extends Organization{
    public GovManageOrganization(){
        super(Type.GovernmentManage.getValue());
    }
    public GovManageOrganization(String location){
        super(Type.GovernmentManage.getValue(), location);
    }
    public ArrayList<Role> getSupportedRole(){
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new GovManageRole());
        return roles;
    }
}
