package WorkRequest;

import Enterprise.Enterprise;

public class ComplainWorkRequest extends WorkRequest{
    Enterprise complainEnterprise;
    String response;
    //service type, -1 means not at service
    int complainCatalog;

    public ComplainWorkRequest(){
        super(Type.Complain);
        complainEnterprise = null;
        complainCatalog = -1;
    }

    public Enterprise getComplainEnterprise() {
        return complainEnterprise;
    }

    public void setComplainEnterprise(Enterprise complainEnterprise) {
        this.complainEnterprise = complainEnterprise;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String reponse) {
        this.response = reponse;
    }

    public int getComplainCatalog() {
        return complainCatalog;
    }

    public void setComplainCatalog(int complainCatalog) {
        this.complainCatalog = complainCatalog;
    }
    

    
    
}
