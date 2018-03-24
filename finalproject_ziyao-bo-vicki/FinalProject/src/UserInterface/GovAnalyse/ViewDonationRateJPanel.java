/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.GovAnalyse;

import EcoSystem.EcoSystem;
import Enterprise.CharityEnterprise;
import Enterprise.DeliveryEnterprise;
import Enterprise.Enterprise;
import Network.Network;
import Organization.Organization;
import Person.Goods;
import Person.UserAccount;
import WorkRequest.ComplainWorkRequest;
import WorkRequest.SendWorkRequest;
import WorkRequest.TransportWorkRequest;
import WorkRequest.WorkRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author yanfei
 */
public class ViewDonationRateJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer; 
    EcoSystem system;
    UserAccount account;
    Enterprise enterprise;
    Network network;
    Organization organization;
    /**
     * Creates new form ViewCompliantRateJPanel
     */
    public ViewDonationRateJPanel(JPanel userProcessContainer,UserAccount account, Organization organization, Enterprise enterprise, Network network,EcoSystem system) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.system=system;
        this.network = network;
        this.enterprise = enterprise;
        this.account = account;
        this.organization = organization;
        populateCombo();
        populateChart1();
    }
    /**
     * Creates new form GovAnalyseWorkAreaJPanel
     */
    public void populateCombo(){
        jComboBox1.removeAllItems();
        for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
            jComboBox1.addItem(enterprise);
        }
    }
    
    public void populateTable(){
        Enterprise enterprise = (Enterprise)jComboBox1.getSelectedItem();
        DefaultTableModel model = (DefaultTableModel)DonateTable.getModel();
        model.setRowCount(0);
        
        for(WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()){
            if(request instanceof SendWorkRequest){
                if(request.getStatus() == 2){
                    Object[] row = new Object[2];
                    row[0] = request;
                    row[1] = request.getRequestDate();
                    model.addRow(row);
                }
            }
        }
    }
    
    public void populateChart1(){
        CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D("Total Resolve Request", "Charity Name", "Number", dataset, PlotOrientation.VERTICAL,true,false,false);
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        ValueAxis rangeAxis = plot.getRangeAxis();
        
        ChartPanel frame = new ChartPanel(chart);
        ChartPanel.add(frame, BorderLayout.CENTER);
        ChartPanel.validate();
    }
    
    private CategoryDataset getDataSet(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        class Tuple{
            int total;
            int finished;
        }
        
        HashMap<Enterprise, Tuple> map = new HashMap<Enterprise, Tuple>();
        for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
            if(enterprise instanceof CharityEnterprise){
                if(!map.containsKey(enterprise)){
                    Tuple tuple = new Tuple();
                    tuple.total = 0;
                    tuple.finished = 0;
                    map.put(enterprise, tuple);
                }
                for(WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()){
                    if(request instanceof SendWorkRequest){
                        if(request.getStatus() == 2){
                            Tuple t = map.get(enterprise);
                            t.total++;
                            t.finished++;
                        }else{
                            Tuple t = map.get(enterprise);
                            t.total++;
                        }
                    }
                }
            }
        }
       
        for(Map.Entry<Enterprise, Tuple> entry : map.entrySet()){
            dataset.addValue(entry.getValue().total, "Total Request", entry.getKey().toString());
            dataset.addValue(entry.getValue().finished, "Finished Request", entry.getKey().toString());
        }
        
        //dataset.addValue(100, "11", "qwe");
        
        return dataset;
    }
    
    
        public void populateChart2(){
        CategoryDataset dataset = getDataSet2();
        JFreeChart chart = ChartFactory.createBarChart3D("Total Goods", "Charity Name", "Number", dataset, PlotOrientation.VERTICAL,true,false,false);
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        ValueAxis rangeAxis = plot.getRangeAxis();
        
        ChartPanel frame = new ChartPanel(chart);
        ChartPanel.add(frame, BorderLayout.CENTER);
        ChartPanel.validate();
    }
    
    private CategoryDataset getDataSet2(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        HashMap<Enterprise, Integer> map = new HashMap<Enterprise, Integer>();
        for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
            if(enterprise instanceof CharityEnterprise){
                if(!map.containsKey(enterprise)){
                   int number = 0;
                    map.put(enterprise, number);
                }
                for(WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()){
                    if(request instanceof SendWorkRequest){
                        if(request.getStatus() == 2){
                            int t = map.get(enterprise);
                            for(Goods goods: request.getGoodsList().getGoodsList()){
                                t += goods.getNum();
                            }
                            map.put(enterprise, t);
                        }
                    }
                }
            }
        }
       
        for(Map.Entry<Enterprise, Integer> entry : map.entrySet()){
            dataset.addValue(entry.getValue(), "Total Received Goods", entry.getKey().toString());
        }
        return dataset;
    }
    
    
    public void populateChart3(){
        CategoryDataset dataset = getDataSet3();
        JFreeChart chart = ChartFactory.createBarChart3D("Delevered Goods & Benefited Person", "Charity Name", "Number", dataset, PlotOrientation.VERTICAL,true,false,false);
        CategoryPlot plot = chart.getCategoryPlot();
        
        ChartPanel frame = new ChartPanel(chart);
        ChartPanel.add(frame, BorderLayout.CENTER);
        ChartPanel.validate();
    }
    
    private CategoryDataset getDataSet3(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        HashMap<UserAccount, Integer> map = new HashMap<>();
        for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
            if(enterprise instanceof CharityEnterprise){
                for(WorkRequest request: enterprise.getWorkQueue().getWorkRequestList()){
                    if(request instanceof SendWorkRequest){
                        if(request.getStatus() == 2 && ((SendWorkRequest) request).getRequest() == 2 && ((SendWorkRequest) request).getRejected() != 1){
                            int number = 0;
                            for(Goods goods:request.getGoodsList().getGoodsList()){
                                number += goods.getNum();
                            }
                            Integer x = map.get(request.getSender());
                            if(x == null)
                                x = 0;
                            map.put(request.getSender(), x + number);
                        }
                    }
                }
            }
        }
       
        for(Map.Entry<UserAccount, Integer> entry : map.entrySet()){
            dataset.addValue(entry.getValue(), "Received Goods", entry.getKey().toString());
        }
        return dataset;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        btnBack = new javax.swing.JButton();
        ChartPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DonateTable = new javax.swing.JTable();
        Chart1 = new javax.swing.JButton();
        Chart3 = new javax.swing.JButton();
        Chart2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1);
        jComboBox1.setBounds(284, 52, 180, 27);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(64, 474, 75, 29);

        ChartPanel.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Some Chart& Graph");
        ChartPanel.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        add(ChartPanel);
        ChartPanel.setBounds(284, 205, 569, 263);

        DonateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request", "Date"
            }
        ));
        jScrollPane2.setViewportView(DonateTable);

        add(jScrollPane2);
        jScrollPane2.setBounds(284, 85, 569, 82);

        Chart1.setText("Chart1");
        Chart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chart1ActionPerformed(evt);
            }
        });
        add(Chart1);
        Chart1.setBounds(284, 474, 86, 29);

        Chart3.setText("Chart3");
        Chart3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chart3ActionPerformed(evt);
            }
        });
        add(Chart3);
        Chart3.setBounds(767, 474, 86, 29);

        Chart2.setText("Chart2");
        Chart2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Chart2ActionPerformed(evt);
            }
        });
        add(Chart2);
        Chart2.setBounds(507, 474, 86, 29);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Admin/6783831-cute-backgrounds.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        add(jLabel3);
        jLabel3.setBounds(0, 0, 1200, 800);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void Chart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Chart1ActionPerformed
        // TODO add your handling code here:
        populateChart1();
        Chart1.setEnabled(false);
        Chart3.setEnabled(true);
        Chart2.setEnabled(true);
    }//GEN-LAST:event_Chart1ActionPerformed

    private void Chart3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Chart3ActionPerformed
        // TODO add your handling code here:
        populateChart3();
        Chart1.setEnabled(true);
        Chart3.setEnabled(false);
        Chart2.setEnabled(true);
    }//GEN-LAST:event_Chart3ActionPerformed

    private void Chart2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Chart2ActionPerformed
        // TODO add your handling code here:
        populateChart2();
        Chart1.setEnabled(true);
        Chart3.setEnabled(true);
        Chart2.setEnabled(false);
    }//GEN-LAST:event_Chart2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedItem() != null)
            populateTable();
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Chart1;
    private javax.swing.JButton Chart2;
    private javax.swing.JButton Chart3;
    private javax.swing.JPanel ChartPanel;
    private javax.swing.JTable DonateTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
