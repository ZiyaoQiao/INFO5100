package Enterprise;

import Person.Goods;
import Person.GoodsList;
import Role.CharityManageRole;
import Role.Role;
import Role.CharityReceiveRole;
import Role.CharitySendRole;
import WorkRequest.WorkQueue;

import java.util.ArrayList;

public class CharityEnterprise extends Enterprise{
    ArrayList<GoodsList> goodsList;
    double money;
    WorkQueue transactionList;
    WorkQueue receiveList;
    WorkQueue sendList;

    public ArrayList<GoodsList> getGoodsList() {
        return goodsList;
    }

    public double getMoney() {
        return money;
    }

    public WorkQueue getTransactionList() {
        return transactionList;
    }

    public WorkQueue getReceiveList() {
        return receiveList;
    }

    public WorkQueue getSendList() {
        return sendList;
    }

    public void setGoodsList(ArrayList<GoodsList> goodsList) {
        this.goodsList = goodsList;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setTransactionList(WorkQueue transactionList) {
        this.transactionList = transactionList;
    }

    public void setReceiveList(WorkQueue receiveList) {
        this.receiveList = receiveList;
    }

    public void setSendList(WorkQueue sendList) {
        this.sendList = sendList;
    }

    
    public CharityEnterprise(String name){
        super(name, Enterprise.EnterpriseType.Charity);
        goodsList = new ArrayList<>();
        transactionList = new WorkQueue();
        receiveList = new WorkQueue();
        sendList = new WorkQueue();
    }

    public ArrayList<Role> getSupportedRole(){
        return null;
    }
}
