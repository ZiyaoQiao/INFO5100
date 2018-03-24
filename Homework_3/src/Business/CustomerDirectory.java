/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author qiaoz
 */
public class CustomerDirectory {
    ArrayList<Person> customerDirectory;


    public CustomerDirectory(){
        customerDirectory = new ArrayList<>();
    }

    public Person AddPerson(){
        Person person = new Person();
        customerDirectory.add(person);
        return person;
    }

    public ArrayList<Person> getCustomerDirectory() {
        return customerDirectory;
    }
}
