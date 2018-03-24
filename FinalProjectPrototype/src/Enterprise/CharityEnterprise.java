package Enterprise;

import Person.Goods;
import Role.CharityManageRole;
import Role.Role;
import Role.CharityReceiveRole;
import Role.CharitySendRole;
import WorkRequest.WorkQueue;

import java.util.ArrayList;

public class CharityEnterprise extends Enterprise{
    ArrayList<Goods> goodsList;
    double money;
    WorkQueue transactionList;
    WorkQueue receiveList;

    public ArrayList<Goods> getGoodsList() {
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

    public CharityEnterprise(String name){
        super(name, Enterprise.EnterpriseType.Charity);
        goodsList = new ArrayList<>();
        transactionList = new WorkQueue();
        receiveList = new WorkQueue();
    }

    public ArrayList<Role> getSupportedRole(){
        return null;
    }
}
