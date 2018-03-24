package WorkRequest;

import java.time.LocalTime;
import java.util.Date;

public class TransportWorkRequest extends WorkRequest {
    double distance;
    double price;
    Date time;
    SendWorkRequest linkRequest;
    
    
    //1 charity to delivery, 2 delivery to donee, 3 finished;
    int transportType;

    public SendWorkRequest getLinkRequest() {
        return linkRequest;
    }

    public void setLinkRequest(SendWorkRequest linkRequest) {
        this.linkRequest = linkRequest;
    }
    
    public double getDistance() {
        return distance;
    }

    public int getTransportType() {
        return transportType;
    }

    public void setTransportType(int transportType) {
        this.transportType = transportType;
    }


    
    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    
    public TransportWorkRequest(){
        super(Type.Transport);
        linkRequest = new SendWorkRequest();
        distance = -1;
        price = -1;
        time = null;
    }
}
