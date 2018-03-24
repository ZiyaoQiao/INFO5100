package Role;
import Person.UserAccount;
import Organization.Organization;
import Enterprise.Enterprise;
import EcoSystem.EcoSystem;
import Network.Network;
import UserInterface.Citizen.CitizenWorkAreaJPanel;
import javax.swing.*;
public class CitizenRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,  Network network, EcoSystem business) {
        return new CitizenWorkAreaJPanel(userProcessContainer, account, enterprise, network, business);
    }

}
