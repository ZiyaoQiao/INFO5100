package Enterprise;

import Role.Role;

import java.util.ArrayList;

public class CitizenEnterprise extends Enterprise{

    public CitizenEnterprise(String name){
        super(name, EnterpriseType.Citizen);
    }

    public ArrayList<Role> getSupportedRole(){
        return null;
    }
}
