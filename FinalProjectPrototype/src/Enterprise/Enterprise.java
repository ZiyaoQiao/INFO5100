package Enterprise;

import Organization.Organization;
import Organization.OrganizationDirectory;

public abstract class Enterprise extends Organization {

    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;

    public Enterprise(String name, EnterpriseType type){
        super(name);
        this.enterpriseType = type;
        organizationDirectory = new OrganizationDirectory();
    }
    public enum EnterpriseType{
        Charity("Charity Enterprise"), Citizen("Citizen Enterprise"), Delivery("Delivery Enterprise"), Government("Government Enterprise");

        private String value;
        private EnterpriseType(String value){
            this.value = value;
        }
        public String getValue(){
            return value;
        }
        public String toString(){
            return value;
        }
    }

    public EnterpriseType getEnterpriseType(){
        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
}
