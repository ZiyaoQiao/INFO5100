package Organization;

import Organization.Organization.Type;
import java.util.ArrayList;

public class OrganizationDirectory {    
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type, String location){
        Organization organization = null;
        if (type.getValue().equals(Type.Admin.getValue())){
            organization = new AdminOrganization(location);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.CharityManage.getValue())){
            organization = new CharityManageOrganization(location);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.CharityReceive.getValue())){
            organization = new CharityReceiveOrganization(location);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.CharitySend.getValue())){
            organization = new CharitySendOrganization(location);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.DeliveryReceive.getValue())){
            organization = new DeliveryReceiveOrganization(location);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.DeliverySend.getValue())){
            organization = new DeliverySendOrganization(location);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.GovernmentAnalyse.getValue())){
            organization = new GovAnalyseOrganization(location);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.GovernmentComplain.getValue())){
            organization = new GovComplainOrganization(location);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.GovernmentManage.getValue())){
            organization = new GovManageOrganization(location);
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Group.getValue())){
            organization = new GroupOrganization(location);
            organizationList.add(organization);
        }        
        return organization;
    }
}
