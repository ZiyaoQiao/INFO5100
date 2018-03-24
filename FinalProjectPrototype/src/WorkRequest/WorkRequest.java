package WorkRequest;

import Enterprise.Enterprise;
import Person.Goods;
import Person.UserAccount;

import java.util.ArrayList;
import java.util.Date;

public abstract class WorkRequest {
    ArrayList<Goods> goodsList;
    UserAccount sender;
    UserAccount receiver;

    Enterprise fromEnterprise;
    Enterprise toEnterprise;

    Date requestDate;
    Date resolveDate;
    String Message;
    int status;
    Type type;

    public enum Type{
        Complain("Complain WorkRequest"),
        Manage("Manage WorkRequest"),
        Send("Send WorkRequest"),
        Transport("Transport WorkRequest");

        String value;
        private Type(String value){
            this.value = value;
        }
        public String getValue(){
            return value;
        }
        public String toString(){
            return value;
        }
    }

    public WorkRequest(Type type){
        goodsList = new ArrayList<>();
        sender = null;
        receiver = null;
        fromEnterprise = null;
        toEnterprise = null;
        requestDate = new Date();
        resolveDate = null;
        this.type = type;
    }

    public ArrayList<Goods> getGoodsList() {
        return goodsList;
    }

    public UserAccount getSender() {
        return sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public Enterprise getFromEnterprise() {
        return fromEnterprise;
    }

    public Enterprise getToEnterprise() {
        return toEnterprise;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public String getMessage() {
        return Message;
    }

    public int getStatus() {
        return status;
    }

    public WorkRequest.Type getType() {
        return type;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public void setFromEnterprise(Enterprise fromEnterprise) {
        this.fromEnterprise = fromEnterprise;
    }

    public void setToEnterprise(Enterprise toEnterprise) {
        this.toEnterprise = toEnterprise;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
