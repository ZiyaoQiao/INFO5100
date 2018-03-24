package EcoSystem;

import Person.Person;
import Person.UserAccount;
import Role.SysAdminRole;

public class ConfigureSystem {
    public static EcoSystem configure(){

        EcoSystem system = EcoSystem.getInstance();

        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees
        //create user account


        Person person = system.getEmployeeDirectory().createAndAddPerson("RRH");

        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", person, new SysAdminRole());

        return system;
    }
}
