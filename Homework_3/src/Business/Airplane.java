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
public class Airplane {
    ArrayList<Flight> flight;
    String Model;
    String ID;

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ArrayList<Flight> getFlight() {
        return flight;
    }

    public Flight AddFlight(){
        Flight flight = new Flight();
        this.flight.add(flight);
        return flight;
    }

    public void read(String txt){
        try{
            FileInputStream fis = new FileInputStream(txt);

            InputStreamReader isr = new InputStreamReader(fis, "Unicode");

            BufferedReader br = new BufferedReader(isr);

            String read;
            while((read = br.readLine())!=null){
                textHandle(read);
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

    public void textHandle(String read){
        Flight flight = this.AddFlight();
            String splitArray[] = read.split(",");
            flight.setLeavePort(splitArray[0]);
            flight.setArrivePort(splitArray[1]);
            flight.setLeaveTime(splitArray[2]);
            flight.setArriveTime(splitArray[3]);
            flight.setID(splitArray[4]);
            for(int i = 5;i<splitArray.length;i++){
                flight.setSeatList(splitArray[i]);
        }
    }


    public Airplane(){
        flight = new ArrayList<>();
    }
}
