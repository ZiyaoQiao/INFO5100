package Role;
import Person.UserAccount;
import Organization.Organization;
import Enterprise.Enterprise;
import EcoSystem.EcoSystem;
import Network.Network;
import UserInterface.CharityReceive.CharityReceiveWorkAreaJPanel;
import javax.swing.*;

public class CharityReceiveRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network,  EcoSystem business) {
        return new CharityReceiveWorkAreaJPanel(userProcessContainer, enterprise,business);
    }

}
