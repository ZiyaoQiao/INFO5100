package Network;

import Enterprise.EnterpriseDirectory;
import Person.Person;
import Person.PersonDirectory;
import Person.UserAccountDirectory;

import java.util.ArrayList;

public class Network {
    private EnterpriseDirectory enterpriseDirectory;
    private String name;
    PersonDirectory citizenList;

    public Network(){
        enterpriseDirectory = new EnterpriseDirectory();
        citizenList = new PersonDirectory();
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public String getName() {
        return name;
    }

    public PersonDirectory getCitizenList() {
        return citizenList;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return name;
    }
    
}

