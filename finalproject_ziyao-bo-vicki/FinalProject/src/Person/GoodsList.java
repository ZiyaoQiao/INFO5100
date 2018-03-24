/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

import java.util.ArrayList;

/**
 *
 * @author qiaoz
 */
public class GoodsList {
    ArrayList<Goods> goodsList;

    public ArrayList<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(ArrayList<Goods> goodsList) {
        this.goodsList = goodsList;
    }
    
    public GoodsList(){
        goodsList = new ArrayList<Goods>();
    }
    
    public String toString(){
        return "GoodsList of size " + goodsList.size();
    }
}
