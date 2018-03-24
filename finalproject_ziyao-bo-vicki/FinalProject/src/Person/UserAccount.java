package Person;

import Enterprise.Enterprise;
import Network.Network;
import Organization.Organization;
import Role.Role;
import WorkRequest.WorkQueue;

public class UserAccount {
    private String username;
    private String password;
    private Person person;
    private Role role;
    private WorkQueue workQueue;
    private Enterprise enterprise;
    private Organization organization;
    private Network network;
    private WorkQueue pinWorkQueue;
    
    private int donateIndex;
    private int requestIndex;
    
    public UserAccount(){
        workQueue = new WorkQueue();
        person = null;
        role = null;
        enterprise = null;
        organization = null;
        pinWorkQueue = new WorkQueue();
        donateIndex = 0;
        requestIndex = 0;
    }
    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
        workQueue = new WorkQueue();
        pinWorkQueue = new WorkQueue();
        person = null;
        role = null;
        enterprise = null;
        organization = null;
    }

    public WorkQueue getPinWorkQueue() {
        return pinWorkQueue;
    }

    public void setPinWorkQueue(WorkQueue pinWorkQueue) {
        this.pinWorkQueue = pinWorkQueue;
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Person getPerson() {
        return person;
    }

    public Role getRole() {
        return role;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String toString(){
        return username;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public Organization getOrganization() {
        return organization;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public int getDonateIndex() {
        return donateIndex;
    }

    public void setDonateIndex(int donateIndex) {
        this.donateIndex = donateIndex;
    }

    public int getRequestIndex() {
        return requestIndex;
    }

    public void setRequestIndex(int requestIndex) {
        this.requestIndex = requestIndex;
    }
    
    
    
}
