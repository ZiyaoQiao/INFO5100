package Role;
import Person.UserAccount;
import Organization.Organization;
import Enterprise.Enterprise;
import EcoSystem.EcoSystem;
import Network.Network;
import UserInterface.DeliverySend.DeliverySendWorkAreaJPanel;
import javax.swing.*;
public class DeliverySendRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,  Network network, EcoSystem business) {
        return new DeliverySendWorkAreaJPanel(userProcessContainer, account, enterprise,network,business);
    }

}
