package Organization;

import Role.Role;
import Role.CharityReceiveRole;
import java.util.ArrayList;

public class CharityReceiveOrganization extends Organization{
    public CharityReceiveOrganization(){
        super(Type.CharityReceive.getValue());
    }
    public CharityReceiveOrganization(String location){
        super(Type.CharityReceive.getValue(), location);
    }
    public ArrayList<Role> getSupportedRole(){
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CharityReceiveRole());
        return roles;
    }
}
