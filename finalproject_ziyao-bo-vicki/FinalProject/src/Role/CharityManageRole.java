package Role;
import Person.UserAccount;
import Organization.Organization;
import Enterprise.Enterprise;
import EcoSystem.EcoSystem;
import Network.Network;
import UserInterface.CharityManage.CharityManageWorkAreaJPanel;
import javax.swing.*;
public class CharityManageRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,  Network network, EcoSystem business) {
        return new CharityManageWorkAreaJPanel(userProcessContainer,enterprise, business);
    }

}
