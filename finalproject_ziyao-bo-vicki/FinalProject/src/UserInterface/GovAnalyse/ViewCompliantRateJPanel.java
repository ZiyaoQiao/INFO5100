/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.GovAnalyse;

import EcoSystem.EcoSystem;
import Enterprise.Enterprise;
import Network.Network;
import Organization.Organization;
import Person.UserAccount;
import WorkRequest.ComplainWorkRequest;
import WorkRequest.WorkRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.ArrayList;
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
public class ViewCompliantRateJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer; 
    EcoSystem system;
    UserAccount account;
    Enterprise enterprise;
    Network network;
    Organization organization;
    /**
     * Creates new form ViewCompliantRateJPanel
     */
    public ViewCompliantRateJPanel(JPanel userProcessContainer,UserAccount account, Organization organization, Enterprise enterprise, Network network,EcoSystem system) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.system=system;
        this.network = network;
        this.enterprise = enterprise;
        this.account = account;
        this.organization = organization;
        populateCombo();
        populateChart1();
        PreviousBtn.setEnabled(false);
    }
    
    public void populateCombo(){
        jComboBox1.removeAllItems();
        HashSet<Enterprise> ent = new HashSet<Enterprise>();
        for(WorkRequest request:enterprise.getWorkQueue().getWorkRequestList()){
            if(request instanceof ComplainWorkRequest){
                ent.add(((ComplainWorkRequest) request).getComplainEnterprise());
            }
        }
        for(Enterprise enterprise : ent){
            jComboBox1.addItem(enterprise);
        }
    }
    
    public void populateTable(){
        Enterprise enterprise = (Enterprise)jComboBox1.getSelectedItem();
        DefaultTableModel model = (DefaultTableModel)ComplainTable.getModel();
        model.setRowCount(0);
        for(WorkRequest request : this.enterprise.getWorkQueue().getWorkRequestList()){
            if(request instanceof ComplainWorkRequest){
                if(((ComplainWorkRequest) request).getComplainEnterprise() == enterprise){
                    Object[] row = new Object[2];
                    row[0] = request;
                    row[1] = ((ComplainWorkRequest) request).getResponse();
                    model.addRow(row);
                }
            }
        }
    }
    
    public void populateChart1(){
        CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D("Complain Finished Rate", "Enterprise Name", "Number", dataset, PlotOrientation.VERTICAL,true,false,false);
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        ValueAxis rangeAxis = plot.getRangeAxis();
        
        ChartPanel frame = new ChartPanel(chart);
        ChartPanel.add(frame, BorderLayout.CENTER);
        ChartPanel.validate();
    }
    public void populateChart2(){
        CategoryDataset dataset = getDataSet2();
        JFreeChart chart = ChartFactory.createBarChart3D("Complain Number Per Enterprise", "Enterprise Name", "Number", dataset, PlotOrientation.VERTICAL,true,false,false);
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
        for(WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()){
            if(request instanceof ComplainWorkRequest){
                if(map.containsKey(((ComplainWorkRequest) request).getComplainEnterprise())){
                    Tuple t = map.get(((ComplainWorkRequest) request).getComplainEnterprise());
                    if(request.getStatus() == 2){
                        t.total++;
                        t.finished++;
                    }else{
                        t.total++;
                    }
                    map.put(((ComplainWorkRequest) request).getComplainEnterprise(), t);
                }else{
                    Tuple t = new Tuple();
                    t.total = 1;
                    t.finished = 1;
                    map.put(((ComplainWorkRequest) request).getComplainEnterprise(), t);
                }
            }
        }
        for(Map.Entry<Enterprise, Tuple> entry : map.entrySet()){
            dataset.addValue((double)entry.getValue().finished / entry.getValue().total, "Comlain Finished Rate", entry.getKey().toString());
        }
        
        //dataset.addValue(100, "11", "qwe");
        
        return dataset;
    }
    private CategoryDataset getDataSet2(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        HashMap<Enterprise, Integer> map = new HashMap<>();
        for(WorkRequest request : enterprise.getWorkQueue().getWorkRequestList()){
            if(request instanceof ComplainWorkRequest){
                if(map.containsKey(((ComplainWorkRequest) request).getComplainEnterprise())){
                    int t = map.get(((ComplainWorkRequest) request).getComplainEnterprise());
                    t++;
                    map.put(((ComplainWorkRequest) request).getComplainEnterprise(), t);
                }else{
                    map.put(((ComplainWorkRequest) request).getComplainEnterprise(), 1);
                }
            }
        }
        for(Map.Entry<Enterprise, Integer> entry : map.entrySet()){
            dataset.addValue(entry.getValue(), "Complain Number", entry.getKey().toString());
        }
        
        //dataset.addValue(100, "11", "qwe");
        
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

        btnBack = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ComplainTable = new javax.swing.JTable();
        ChartPanel = new javax.swing.JPanel();
        NextBtn = new javax.swing.JButton();
        PreviousBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setLayout(null);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(65, 519, 75, 29);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1);
        jComboBox1.setBounds(380, 40, 160, 30);

        jLabel2.setText("Some Chart& Graph");
        add(jLabel2);
        jLabel2.setBounds(380, 190, 464, 16);

        ComplainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Complain", "Response"
            }
        ));
        jScrollPane1.setViewportView(ComplainTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(380, 70, 439, 103);

        ChartPanel.setLayout(new java.awt.BorderLayout());
        add(ChartPanel);
        ChartPanel.setBounds(380, 220, 580, 288);

        NextBtn.setText("Next Chart");
        NextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextBtnActionPerformed(evt);
            }
        });
        add(NextBtn);
        NextBtn.setBounds(860, 530, 112, 29);

        PreviousBtn.setText("Previous Chart");
        PreviousBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousBtnActionPerformed(evt);
            }
        });
        add(PreviousBtn);
        PreviousBtn.setBounds(370, 530, 135, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Admin/6783831-cute-backgrounds.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1200, 800);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 435, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );

        add(jPanel1);
        jPanel1.setBounds(360, 220, 435, 288);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedItem() != null){
            populateTable();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void NextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextBtnActionPerformed
        // TODO add your handling code here:
        populateChart2();
        PreviousBtn.setEnabled(true);
        NextBtn.setEnabled(false);
    }//GEN-LAST:event_NextBtnActionPerformed

    private void PreviousBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousBtnActionPerformed
        // TODO add your handling code here:
        populateChart1();
        PreviousBtn.setEnabled(false);
        NextBtn.setEnabled(true);
    }//GEN-LAST:event_PreviousBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChartPanel;
    private javax.swing.JTable ComplainTable;
    private javax.swing.JButton NextBtn;
    private javax.swing.JButton PreviousBtn;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
