package WorkRequest;

import Organization.Organization;

public class ManageWorkRequest extends WorkRequest {
    Organization fromOrganization;
    Organization toOrganization;

    public ManageWorkRequest(){
        super(Type.Manage);
        fromOrganization = null;
        toOrganization = null;
    }
}
