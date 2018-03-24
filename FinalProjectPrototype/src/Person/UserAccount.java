package Person;

import Role.Role;
import WorkRequest.WorkQueue;

public class UserAccount {
    private String username;
    private String password;
    private Person person;
    private Role role;
    private WorkQueue workQueue;

    public UserAccount(){
        workQueue = new WorkQueue();
        person = null;
        role = null;
    }
    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
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
}
