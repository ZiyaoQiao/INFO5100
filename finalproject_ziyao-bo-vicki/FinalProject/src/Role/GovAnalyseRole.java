package Role;
import Person.UserAccount;
import Organization.Organization;
import Enterprise.Enterprise;
import EcoSystem.EcoSystem;
import Network.Network;
import UserInterface.GovAnalyse.GovAnalyseWorkAreaJPanel;
import javax.swing.*;
public class GovAnalyseRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network,  EcoSystem business) {
        return new GovAnalyseWorkAreaJPanel(userProcessContainer,account, organization, enterprise, network, business);
    }

}
