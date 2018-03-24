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
public class MasterTravelSchedule {
    ArrayList<FlightSchedule> travelSchedule;

    public ArrayList<FlightSchedule> getTravelSchedule() {
        return travelSchedule;
    }

    public FlightSchedule AddFlightSchedule(){
        FlightSchedule schedule = new FlightSchedule();
        travelSchedule.add(schedule);
        return schedule;
    }

    public MasterTravelSchedule(){
        travelSchedule = new ArrayList<>();
    }
}
