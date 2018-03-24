package Person;

import java.util.ArrayList;

public class PersonDirectory {
    ArrayList<Person> personList;

    public PersonDirectory(){
        personList = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList(){
        return personList;
    }
    public Person createAndAddPerson(String name){
        Person person = new Person(name);
        personList.add(person);
        return person;
    }
    public Person createAndAddPerson(){
        Person person = new Person();
        personList.add(person);
        return person;
    }
}
