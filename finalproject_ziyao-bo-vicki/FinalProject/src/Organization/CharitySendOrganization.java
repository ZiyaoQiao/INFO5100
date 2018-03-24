package Organization;

import Role.Role;
import Role.CharitySendRole;
import java.util.ArrayList;

public class CharitySendOrganization extends Organization{
    public CharitySendOrganization(){
        super(Type.CharitySend.getValue());
    }
    public CharitySendOrganization(String location){
        super(Type.CharitySend.getValue(), location);
    }
    public ArrayList<Role> getSupportedRole(){
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CharitySendRole());
        return roles;
    }
}
