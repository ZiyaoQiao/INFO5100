package Role;
import Person.UserAccount;
import Organization.Organization;
import Enterprise.Enterprise;
import EcoSystem.EcoSystem;
import Network.Network;
import UserInterface.GovManage.GovManageWorkAreaJPanel;
import javax.swing.*;
public class GovManageRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network,  EcoSystem business) {
        return new GovManageWorkAreaJPanel(userProcessContainer, business, network);
    }

}
