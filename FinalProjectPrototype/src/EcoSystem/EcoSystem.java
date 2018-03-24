package EcoSystem;

import Network.Network;
import Organization.Organization;
import Person.UserAccount;
import Person.UserAccountDirectory;
import Role.Role;

import java.util.ArrayList;

public class EcoSystem extends Organization{
    private static EcoSystem business;
    UserAccountDirectory userAccountDirectory;
    private ArrayList<Network> networkList;

    private EcoSystem() {
        super(null);
        this.networkList = new ArrayList<Network>();
        this.userAccountDirectory = new UserAccountDirectory();
    }

    public static EcoSystem getInstance(){
        if(business == null)
            business = new EcoSystem();
        return business;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public Network createAndAddNetwork(){
        Network net = new Network();
        networkList.add(net);
        return net;
    }

    public UserAccount createAndAddAccount(){
        UserAccount account = new UserAccount();
        userAccountDirectory.getUserAccountList().add(account);
        return account;
    }
}
