package WorkRequest;

public class TransportWorkRequest extends WorkRequest {
    int distance;
    int price;
    int time;

    public TransportWorkRequest(){
        super(Type.Transport);
        distance = -1;
        price = -1;
        time = -1;
    }
}
