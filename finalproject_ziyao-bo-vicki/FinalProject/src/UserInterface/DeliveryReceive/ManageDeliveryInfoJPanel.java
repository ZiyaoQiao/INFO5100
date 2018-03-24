/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DeliveryReceive;

import Person.Goods;
import WorkRequest.TransportWorkRequest;
import WorkRequest.WorkRequest;
import java.awt.CardLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.runtime.RewriteException;
import oracle.jrockit.jfr.events.Bits;

/**
 *
 * @author yanfei
 */
public class ManageDeliveryInfoJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageDeliveryInfoJPanel
     */
    JPanel userProcessContainer;
    WorkRequest workRequest;
    
    public ManageDeliveryInfoJPanel(JPanel userProcessContainer ,WorkRequest workRequest) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.workRequest = workRequest;
        fromLocation.setText(workRequest.getFromOrganization().getLocation());
        toLocation.setText(workRequest.getToOrganization().getLocation());
        setFromLocation();
        setToLocation();
        calcualteDistance();
        calculatePrice();
        populateComboBox();
    }
    
    private void populateComboBox(){
        
        yearCombo.removeAllItems();
        monthCombo.removeAllItems();
        dayCombo.removeAllItems();
        
        int year = 2017;
        while(year < 2020){
            yearCombo.addItem(String.valueOf(year));
            year++;
        }
        
        int month = 1;
        while(month < 13){
            monthCombo.addItem(String.valueOf(month));
            month++;
        }
        
        int day = 1;
        while(day < 32){
            dayCombo.addItem(String.valueOf(day));
            day++;
        }
        
        
        
    
    
    }
    
    private void setFromLocation(){
         String from = workRequest.getFromOrganization().getLocation();
//         String to = workRequest.getToEnterprise().getLocation();
        switch (from) {
            case "NYC":
                workRequest.getFromOrganization().setXY(100, 200);
                break;
            case "Boston":
                workRequest.getFromOrganization().setXY(200, 300);
                break;
            case "Maryland":
                workRequest.getFromOrganization().setXY(300, 300);
                break;
            case "New Jersy":
                workRequest.getFromOrganization().setXY(400, 300);
                break;
            case "Chicago":
                workRequest.getFromOrganization().setXY(300, 900);
                break;
            case "Philadelphia":    
                workRequest.getFromOrganization().setXY(500, 900);
                break;
            case "Washington":
                workRequest.getFromOrganization().setXY(500, 700);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Location Not Found","Warning",JOptionPane.WARNING_MESSAGE);                
                break;
        } 
    }
    
    private void setToLocation(){
        String to = workRequest.getToOrganization().getLocation();
            switch (to) {
            case "NYC":
                workRequest.getToOrganization().setXY(100, 300);
                break;
            case "Boston":
                workRequest.getToOrganization().setXY(200, 300);
                break;
            case "Maryland":
                workRequest.getToOrganization().setXY(300, 300);
                break;
            case "New Jersy":
                workRequest.getToOrganization().setXY(400, 300);
                break;
            case "Chicago":
                workRequest.getToOrganization().setXY(300, 900);
                break;
            case "Philadelphia":
                workRequest.getToOrganization().setXY(500, 900);
                break;
            case "Washington":
                workRequest.getToOrganization().setXY(500, 700);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Location Not Found","Warning",JOptionPane.WARNING_MESSAGE);
                break;
        } 
    }
    double distance;
    double price;
    
    public double calcualteDistance(){
        double fromX = workRequest.getFromOrganization().getX();
        double fromY = workRequest.getFromOrganization().getY();
        
        double toX = workRequest.getToOrganization().getX();
        double toY = workRequest.getToOrganization().getY();
        if(fromX == 0 || fromY == 0 || toX == 0|| toY == 0){
            distance = 0;
            System.out.println(distance);
            distanceTxt.setText("Location Not On Map. Price as Default Rate");
        }
        else{
        distance = Math.sqrt((fromX - toX)*(fromX - toX) + (fromY - toY)*(fromY - toY));
        System.out.println(distance);
        if(workRequest instanceof TransportWorkRequest){
                ((TransportWorkRequest)workRequest).setDistance(distance);
            }
        distanceTxt.setText(String.valueOf(distance));
        }
        return distance;
    }
    
    public void calculatePrice(){
        double sizeSum = 0;
        double weightSum = 0;
        for(Goods goods : workRequest.getGoodsList().getGoodsList()){
            sizeSum += goods.getSize()*goods.getNum();
            weightSum += goods.getWeight()*goods.getNum();
        }
        
        if(distance == 0){
            if(sizeSum/6000 > weightSum){
                price = sizeSum/6000;
            }
            else{
                price = weightSum*2;
            }
        }
        else if(distance <= 100){
            if(sizeSum/6000 > weightSum){
                price = sizeSum/6000;
            }
            else{
                price = weightSum;
            }
        }
        else if(distance > 100 && distance <= 500){
            if(sizeSum/6000 > weightSum){
                price = sizeSum/6000*1.5;
            }
            else{
                price = weightSum*1.5;
            }
        }
        else{
            if(sizeSum/6000 > weightSum){
                price = sizeSum/6000*2;
            }
            else{
                price = weightSum*2;
            }
        }
        if(workRequest instanceof TransportWorkRequest){
                ((TransportWorkRequest)workRequest).setPrice(price);
            }
        priceTxt.setText(String.valueOf(price));
    }
    
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fromLocation = new javax.swing.JLabel();
        toLocation = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        distanceTxt = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        priceTxt = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        yearCombo = new javax.swing.JComboBox<>();
        monthCombo = new javax.swing.JComboBox<>();
        dayCombo = new javax.swing.JComboBox<>();
        btnSend = new javax.swing.JButton();
        yearTxt = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("From Location");
        add(jLabel1);
        jLabel1.setBounds(396, 82, 104, 16);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("To Location");
        add(jLabel2);
        jLabel2.setBounds(396, 116, 92, 16);

        fromLocation.setText("fromLocation");
        add(fromLocation);
        fromLocation.setBounds(675, 82, 100, 16);

        toLocation.setText("toLocation");
        add(toLocation);
        toLocation.setBounds(675, 116, 100, 16);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("Calculated Distance");
        add(jLabel3);
        jLabel3.setBounds(396, 150, 133, 16);

        distanceTxt.setText("distanceTxt");
        add(distanceTxt);
        distanceTxt.setBounds(675, 150, 100, 16);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("Estimated Price");
        add(jLabel4);
        jLabel4.setBounds(396, 184, 125, 16);

        priceTxt.setText("priceTxt");
        add(priceTxt);
        priceTxt.setBounds(675, 184, 100, 20);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText("Estimated Delivery Date");
        add(jLabel5);
        jLabel5.setBounds(396, 283, 162, 16);

        yearCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(yearCombo);
        yearCombo.setBounds(679, 317, 96, 27);

        monthCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(monthCombo);
        monthCombo.setBounds(679, 350, 96, 27);

        dayCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(dayCombo);
        dayCombo.setBounds(679, 383, 96, 27);

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        add(btnSend);
        btnSend.setBounds(700, 485, 75, 29);

        yearTxt.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        yearTxt.setText("Year");
        add(yearTxt);
        yearTxt.setBounds(396, 321, 31, 16);

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setText("Month");
        add(jLabel6);
        jLabel6.setBounds(396, 354, 43, 16);

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel7.setText("Day");
        add(jLabel7);
        jLabel7.setBounds(396, 387, 26, 16);

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 3, 24)); // NOI18N
        jLabel8.setText("Shipping Information");
        add(jLabel8);
        jLabel8.setBounds(294, 22, 264, 30);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(70, 485, 75, 29);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Admin/6783831-cute-backgrounds.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        add(jLabel9);
        jLabel9.setBounds(0, 0, 1200, 800);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        String year = (String)yearCombo.getSelectedItem();
        String month = (String) monthCombo.getSelectedItem();
        String day = (String) dayCombo.getSelectedItem();
        
        String date = day + "-" + month + "-" + year;
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date deliveryDate = dateFormat.parse(date);
            if(workRequest instanceof TransportWorkRequest){
                ((TransportWorkRequest)workRequest).setTime(deliveryDate);
                ((TransportWorkRequest)workRequest).setTransportType(2);
                JOptionPane.showMessageDialog(null, "Sent!");
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        

    }//GEN-LAST:event_btnSendActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSend;
    private javax.swing.JComboBox<String> dayCombo;
    private javax.swing.JLabel distanceTxt;
    private javax.swing.JLabel fromLocation;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JComboBox<String> monthCombo;
    private javax.swing.JLabel priceTxt;
    private javax.swing.JLabel toLocation;
    private javax.swing.JComboBox<String> yearCombo;
    private javax.swing.JLabel yearTxt;
    // End of variables declaration//GEN-END:variables
}
