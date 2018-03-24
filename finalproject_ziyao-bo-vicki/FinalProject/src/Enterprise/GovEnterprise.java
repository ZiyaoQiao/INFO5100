package Enterprise;

import Role.Role;
import WorkRequest.WorkQueue;

import java.util.ArrayList;

public class GovEnterprise extends Enterprise{
    WorkQueue completedComplainList;

    public GovEnterprise(String name){
        super(name, EnterpriseType.Government);
        completedComplainList = new WorkQueue();
    }

    public ArrayList<Role> getSupportedRole(){
        return null;
    }
}
