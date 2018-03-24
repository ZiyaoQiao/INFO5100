/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author qiaoz
 */
public class TravelAgency {
    ArrayList<Airliner> airliner;
    MasterTravelSchedule travelSchedule;
    CustomerDirectory customerDirectory;
    
    public TravelAgency(){
        airliner = new ArrayList<>();
        travelSchedule = new MasterTravelSchedule();
        customerDirectory = new CustomerDirectory();
        readAirliner();
        readCustomerDirectory();
        readTravelSchedule();
    }
    
    public void readAirliner(){
        try{
            FileInputStream fis = new FileInputStream("./src/Airliner.txt");
            InputStreamReader isr = new InputStreamReader(fis, "Unicode");
            BufferedReader br = new BufferedReader(isr);

            String read;
            while((read = br.readLine())!=null){
                textHandleAirliner(read);
            }
            br.close();
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    
    public void readCustomerDirectory(){
            try {
                FileInputStream fis = new FileInputStream("./src/CustomerDirectory.txt");
                InputStreamReader isr = new InputStreamReader(fis, "Unicode");
                BufferedReader br = new BufferedReader(isr);

                String read;
                while ((read = br.readLine()) != null) {
                    textHandleCustomer(read);
                }
                br.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void textHandleCustomer(String read){
        Person person = customerDirectory.AddPerson();
        String split[] = read.split(";");
        person.setFirstName(split[0]);
        person.setLastName(split[1]);
        person.setFlightID(split[2]);
        person.setSeat(this.searchSeat(split[3],person));
    }

    public Seat searchSeat(String id, Person person){
        for(Airliner i:airliner){
            for(Airplane j: i.getAirplane()){
                for(Flight k:j.getFlight()){
                    if(person.getFlightID().equals(k.getID())) {
                        for (Seat l : k.getSeatList()) {
                            if (id.equals(l.getId())) {
                                l.setAvailable(false);
                                l.person = person;
                                return l;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public void readTravelSchedule(){
        for(Airliner i:airliner){
            FlightSchedule schedule = travelSchedule.AddFlightSchedule();
            schedule.Copy(i.getFlightSchedule());
        }
    }
    
    public void textHandleAirliner(String str){
        Airliner airliner = this.addAirliner();
        String splitArray[] = str.split(";");
        airliner.setName(splitArray[0]);
        airliner.read(splitArray[1]);
    }
    
    
    public ArrayList<Airliner> getAirliner() {
        return airliner;
    }

    public void setAirliner(ArrayList<Airliner> airliner) {
        this.airliner = airliner;
    }

    
    public Airliner addAirliner(){
        Airliner Airliner = new Airliner();
        airliner.add(Airliner);
        return Airliner;
    }
    
    public void deleteAirliner(Airliner V){
        airliner.remove(V);
        System.out.println("remove");
    }
   public void totalRevenue(){
       double total = 0;
       for(Airliner i:airliner){
           for(Airplane j: i.getAirplane()){
               for(Flight k:j.flight){
                   for(Seat l: k.seatList){
                       if(l.available == false)
                           total+=l.getPrice();
                   }
               }
           }
       }
       System.out.println("Total Revenue:"+total);
    }
    

    
    public void perAirlinerRevenue(){
        for(Airliner i:airliner){
            System.out.println("Airliner Name:"+i.getName());
            double total = 0;
            for(Airplane j: i.getAirplane()){
                for(Flight k:j.flight){
                    for(Seat l: k.seatList){
                        if(l.available == false)
                            total+=l.getPrice();
                    }
                }
            }
            System.out.println("Total Airliner Revenue:"+total);
            System.out.println("--------------------------------");
        }
    }

    public void perPlaneRevenue(){
        for(Airliner i:airliner){
            for(Airplane j: i.getAirplane()){
                System.out.println("Airplane ID:"+j.getID());
                double total = 0;
                for(Flight k:j.flight){
                    for(Seat l: k.seatList){
                        if(l.available == false)
                            total+=l.getPrice();
                    }
                }
                System.out.println("Total Plane Revenue:"+total);

                System.out.println("--------------------------------");
            }
        }
    }

    public static void main(String[] args){
        TravelAgency travelagency = new TravelAgency();
        travelagency.totalRevenue();
        System.out.println("**************************************************************************");
        travelagency.perAirlinerRevenue();
        System.out.println("**************************************************************************");
        travelagency.perPlaneRevenue();;
    }
}
