package Organization;

import Role.Role;
import Role.CitizenRole;
import java.util.ArrayList;

public class GroupOrganization extends Organization{
    public GroupOrganization(){
        super(Type.Group.getValue());
    }

    public ArrayList<Role> getSupportedRole(){
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CitizenRole());
        return roles;
    }

}
