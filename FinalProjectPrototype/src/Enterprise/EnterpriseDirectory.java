package Enterprise;

import java.util.ArrayList;

public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory(){
        enterpriseList = new ArrayList<>();
    }
    public ArrayList<Enterprise> getEnterpriseList(){
        return enterpriseList;
    }
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type){
        Enterprise enterprise = null;
        if(type == Enterprise.EnterpriseType.Charity){
            enterprise = new CharityEnterprise(name);
            enterpriseList.add(enterprise);
        }else if(type == Enterprise.EnterpriseType.Citizen){
            enterprise = new CitizenEnterprise(name);
            enterpriseList.add(enterprise);
        }else if(type == Enterprise.EnterpriseType.Delivery){
            enterprise = new DeliveryEnterprise(name);
            enterpriseList.add(enterprise);
        }else if(type == Enterprise.EnterpriseType.Government){
            enterprise = new GovEnterprise(name);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }

}
