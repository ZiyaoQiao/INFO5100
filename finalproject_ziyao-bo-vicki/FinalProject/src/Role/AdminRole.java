package Role;

import Person.UserAccount;
import Organization.Organization;
import Enterprise.Enterprise;
import EcoSystem.EcoSystem;
import Network.Network;
import UserInterface.Admin.AdminWorkAreaJPanel;
import javax.swing.*;

public class AdminRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new AdminWorkAreaJPanel(userProcessContainer, enterprise, network, business);
    }

}
