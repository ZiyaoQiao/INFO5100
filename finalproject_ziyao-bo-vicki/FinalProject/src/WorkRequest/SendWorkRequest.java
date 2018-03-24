package WorkRequest;

public class SendWorkRequest extends WorkRequest {
    //-1 not at service, 1 send goods to charity, 2 request goods from charity
    int request;
    //1 rejected
    int rejected;
    
    public  SendWorkRequest(){
        super(Type.Send);
        request = -1;
    }

    public int getRequest() {
        return request;
    }

    public void setRequest(int request) {
        this.request = request;
    }

    public int getRejected() {
        return rejected;
    }

    public void setRejected(int rejected) {
        this.rejected = rejected;
    }

    
}
