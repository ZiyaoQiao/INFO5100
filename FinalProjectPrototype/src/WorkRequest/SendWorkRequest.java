package WorkRequest;

public class SendWorkRequest extends WorkRequest {
    //-1 not at service, 1 request, 0 send
    int request;

    public  SendWorkRequest(){
        super(Type.Send);
        request = -1;
    }

}
