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
public class Airliner {
    String name;
    FlightSchedule flightSchedule;
    private ArrayList<Airplane> airplane;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airplane AddAirplane(){
        Airplane airplane = new Airplane();
        this.airplane.add(airplane);
        return airplane;
    }
    
    public Airliner(){
        flightSchedule = new FlightSchedule();
        airplane = new ArrayList<>();
    }

    public void textHandleAirplane(String read){
        String splitArray[] = read.split(";");
        int con = 1;
        for(Airplane i: this.airplane) {
            if(i.getID()!=null && i.getID().equals(splitArray[0])){
                i.textHandle(splitArray[2]);
                con = 0;
            }
        }
        if(con == 1){
            Airplane airplane = this.AddAirplane();
            airplane.setID(splitArray[0]);
            airplane.setModel(splitArray[1]);
            airplane.textHandle(splitArray[2]);
        }
    }

    public FlightSchedule getFlightSchedule() {
        return flightSchedule;
    }

    public ArrayList<Airplane> getAirplane() {
        return airplane;
    }

    public void read(String txt){
        try{
            FileInputStream fis = new FileInputStream(txt);

            InputStreamReader isr = new InputStreamReader(fis, "Unicode");

            BufferedReader br = new BufferedReader(isr);

            String read;
            while((read = br.readLine())!=null){
                textHandleAirplane(read);
            }
            br.close();
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        for(Airplane i:airplane){
            ArrayList<Flight> tmp = i.getFlight();
            for(Flight j: tmp){
                flightSchedule.getFlightSchedule().add(j);
            }
        }
    }
    
}
