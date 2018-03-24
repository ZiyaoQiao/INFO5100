package Role;

import Person.UserAccount;
import Organization.Organization;
import Enterprise.Enterprise;
import EcoSystem.EcoSystem;
import javax.swing.*;

public abstract class Role {
    public enum RoleType{
        Admin("Admin Role"),
        CharityManage("CharityManage Role"),
        CharityReceive("CharityRecieve Role"),
        CharitySend("CharitySend Role"),
        DeliverySend("DeliverySend Role"),
        DeliveryReceive("DeliveryReceive Role"),
        GovernmentAnalyse("GovernmentAnalyse Role"),
        GovernmentComplain("GovernmentComplain Role"),
        GovernmentManage("GorvernmentManage Role"),
        Group("Group Role");

        private String value;
        private RoleType(String value){
            this.value = value;
        }
        public String getValue(){
            return value;
        }
        public String toString(){
            return value;
        }
    }

    public abstract JPanel createWorkArea(JPanel userProcessContainer,
                                          UserAccount account,
                                          Organization organization,
                                          Enterprise enterprise,
                                          EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }


}
