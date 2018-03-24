package Organization;

import Role.Role;
import Role.CharitySendRole;
import java.util.ArrayList;

public class CharitySendOrganization extends Organization{
    public CharitySendOrganization(){
        super(Type.CharitySend.getValue());
    }

    public ArrayList<Role> getSupportedRole(){
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CharitySendRole());
        return roles;
    }
}
