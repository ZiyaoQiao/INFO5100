package WorkRequest;

import Enterprise.Enterprise;

public class ComplainWorkRequest extends WorkRequest{
    Enterprise complainEnterprise;

    //service type, -1 means not at service
    int complainCatalog;

    public ComplainWorkRequest(){
        super(Type.Complain);
        complainEnterprise = null;
        complainCatalog = -1;
    }
}
