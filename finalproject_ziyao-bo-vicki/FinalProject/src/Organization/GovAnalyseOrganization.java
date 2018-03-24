package Organization;

import Role.Role;
import Role.GovAnalyseRole;
import java.util.ArrayList;

public class GovAnalyseOrganization extends Organization{
    public GovAnalyseOrganization(){
        super(Type.GovernmentAnalyse.getValue());
    }
    public GovAnalyseOrganization(String location){
        super(Type.GovernmentAnalyse.getValue(), location);
    }

    public ArrayList<Role> getSupportedRole(){
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new GovAnalyseRole());
        return roles;
    }
}
