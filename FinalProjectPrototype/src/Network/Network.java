package Network;

import Enterprise.EnterpriseDirectory;
import Person.Person;
import Person.UserAccountDirectory;

import java.util.ArrayList;

public class Network {
    private EnterpriseDirectory enterpriseDirectory;
    private String name;
    ArrayList<Person> citizenList;

    public Network(){
        enterpriseDirectory = new EnterpriseDirectory();
        citizenList = new ArrayList<Person>();
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Person> getCitizenList() {
        return citizenList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return name;
    }
}

