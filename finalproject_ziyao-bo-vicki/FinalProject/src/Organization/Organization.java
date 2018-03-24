package Organization;

import Person.PersonDirectory;
import Person.UserAccountDirectory;
import WorkRequest.WorkQueue;
import Role.Role;

import java.util.ArrayList;
import sun.net.www.content.audio.x_aiff;


public abstract class Organization {
    private String name;
    private String displayName;
    private WorkQueue workQueue;
    private PersonDirectory employeeDirectory;
    private String location;
    private UserAccountDirectory userAccountDirectory;
    private String ID;
    private double  x;
    private double y;

    public enum Type{
        Admin("Admin Organization"),
        CharityManage("CharityManage Organization"),
        CharityReceive("CharityRecieve Organization"),
        CharitySend("CharitySend Organization"),
        DeliverySend("DeliverySend Organization"),
        DeliveryReceive("DeliveryReceive Organization"),
        GovernmentAnalyse("GovernmentAnalyse Organization"),
        GovernmentComplain("GovernmentComplain Organization"),
        GovernmentManage("GorvernmentManage Organization"),
        Group("Group Organization");

        private String value;
        private Type(String value){
            this.value = value;
        }
        public String getValue(){
            return value;
        }
        public String toString(){
            return value;
        }
    }

    public Organization(String name){
        this.name = name;
 //       this.displayName = name;
        workQueue = new WorkQueue();
        employeeDirectory = new PersonDirectory();
        userAccountDirectory = new UserAccountDirectory();

    }
    public Organization(String name, String location){
        this.name = name;
//        this.displayName = name;
        workQueue = new WorkQueue();
        employeeDirectory = new PersonDirectory();
        userAccountDirectory = new UserAccountDirectory();
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public PersonDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public String getLocation() {
        return location;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public String getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public abstract ArrayList<Role> getSupportedRole();

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setXY(double x, double y){
        this.x = x;
        this.y = y;
    }

    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    @Override
    public String toString(){
        return displayName;
    }
}
