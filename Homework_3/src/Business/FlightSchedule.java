/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author qiaoz
 */
public class FlightSchedule {
    private ArrayList<Flight> flightSchedule;

    public ArrayList<Flight> getFlightSchedule() {
        return flightSchedule;
    }

    public FlightSchedule(){
        flightSchedule = new ArrayList<>();
    }

    public void Copy(FlightSchedule schedule){
        for(Flight i:schedule.getFlightSchedule()){
            this.flightSchedule.add(i);
        }
    }
}
