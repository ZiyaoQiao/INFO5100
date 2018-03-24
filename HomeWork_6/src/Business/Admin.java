package Business;

public class Admin {
    String ID;
    String password;
    public Admin(){
        ID = "";
        password = "";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
