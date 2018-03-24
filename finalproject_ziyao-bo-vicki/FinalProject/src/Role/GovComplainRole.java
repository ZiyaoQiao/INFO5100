package Role;
import Person.UserAccount;
import Organization.Organization;
import Enterprise.Enterprise;
import EcoSystem.EcoSystem;
import Network.Network;
import UserInterface.GovComplain.GovComplainWorkAreaJPanel;
import javax.swing.*;
public class GovComplainRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,  Network network, EcoSystem business) {
        return new GovComplainWorkAreaJPanel(userProcessContainer,account, organization, enterprise,network, business);
    }

}
