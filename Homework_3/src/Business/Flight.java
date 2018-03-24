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
public class Flight {
    ArrayList<Seat> seatList;
    private String leaveTime;
    private String arriveTime;
    private String leavePort;
    private String arrivePort;
    private String ID;

    public Flight(){
        seatList = new ArrayList<>();

    }

    public ArrayList<Seat> getSeatList() {
        return seatList;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getLeavePort() {
        return leavePort;
    }

    public void setLeavePort(String leavePort) {
        this.leavePort = leavePort;
    }

    public String getArrivePort() {
        return arrivePort;
    }

    public void setArrivePort(String arrivePort) {
        this.arrivePort = arrivePort;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Seat AddSeat(){
        Seat seat = new Seat();
        this.seatList.add(seat);
        return seat;
    }

    public void setSeatList(String list){
        Seat seat = this.AddSeat();
        String split[] = list.split(" ");
/*
        seat.setCol(Integer.parseInt(split[0]));
        seat.setRow(Integer.parseInt(split[1]));
*/
        seat.setPrice(Double.parseDouble(split[1]));
        seat.setAvailable(true);
        seat.setId(split[0]);
    }
}
