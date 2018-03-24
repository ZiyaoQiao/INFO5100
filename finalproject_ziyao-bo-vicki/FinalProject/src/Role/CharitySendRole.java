package Role;
import Person.UserAccount;
import Organization.Organization;
import Enterprise.Enterprise;
import EcoSystem.EcoSystem;
import Network.Network;
import UserInterface.CharitySend.CharitySendWorkAreaJPanel;
import javax.swing.*;
public class CharitySendRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network,  EcoSystem business) {
        return new CharitySendWorkAreaJPanel(userProcessContainer,account, enterprise, network,business);
    }

}
