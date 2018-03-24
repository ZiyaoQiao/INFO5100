package WorkRequest;

import Enterprise.Enterprise;
import Organization.Organization;
import Person.Goods;
import Person.GoodsList;
import Person.UserAccount;

import java.util.ArrayList;
import java.util.Date;

public abstract class WorkRequest {
    GoodsList goodsList;
    UserAccount sender;
    UserAccount receiver;
    
    Organization fromOrganization;
    Organization toOrganization;
    Enterprise fromEnterprise;
    Enterprise toEnterprise;

    Date requestDate;
    Date resolveDate;
    
  
    String Message;
    //1 waiting, 2 finished, -1 error 
    //1 waiting, 2 received, 3 sent for delivery
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
        goodsList = new GoodsList();
        sender = null;
        receiver = null;
        fromEnterprise = null;
        toEnterprise = null;
        requestDate = new Date();
        resolveDate = null;
        this.type = type;
    }

    public Organization getFromOrganization() {
        return fromOrganization;
    }

    public void setFromOrganization(Organization fromOrganization) {
        this.fromOrganization = fromOrganization;
    }
    
    public Organization getToOrganization(){
        return toOrganization;
    }
    
    public void setToOrganization(Organization toOrganization){
        this.toOrganization = toOrganization;
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

    public GoodsList getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(GoodsList goodsList) {
        this.goodsList = goodsList;
    }

    public String toString(){
        return type.value;
    }
    
}
