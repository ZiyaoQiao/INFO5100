/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CharityManage;

import EcoSystem.EcoSystem;
import Enterprise.CharityEnterprise;
import Enterprise.Enterprise;
import Person.Goods;
import Person.GoodsList;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JOptionPane;
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
public class ManageCharityInvJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageCharityInvJPanel
     */
    JPanel userProcessContainer;
    EcoSystem system;
    Enterprise enterprise;
    
    public ManageCharityInvJPanel(JPanel userProcessContainer, Enterprise enterprise,EcoSystem business) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.system=business;
        this.enterprise=enterprise;
        populateTable();
        populateChart();
        
    }
    
    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel) tblInv.getModel();
        
        dtm.setRowCount(0);
        
            for(GoodsList goodlist:((CharityEnterprise)enterprise).getGoodsList()){
                for(Goods goods:goodlist.getGoodsList()){
                    Object[] row = new Object[5];
                    row[0] = goods;
                    row[1] = goods.getNum();
                    row[2] = goods.getEstimatedPrice();
                    row[3] = goods.getSize();
                    row[4] = goods.getCondition();
                    dtm.addRow(row);
                }
            }
        
    }
    
    public void populateChart(){
        CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart("List Inventory", "Name", "Quantity", dataset, PlotOrientation.VERTICAL, true, false, false);
        
        CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象  
        CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表  
        ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状  

        
        ChartPanel frame = new ChartPanel(chart);
        ChartPanel.add(frame, BorderLayout.CENTER);
        ChartPanel.validate();
        
    }
    
    private CategoryDataset getDataSet(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        if(enterprise instanceof CharityEnterprise){
            for(GoodsList goodlist:((CharityEnterprise)enterprise).getGoodsList()){
                for(Goods goods:goodlist.getGoodsList()){
                    dataset.addValue(goods.getNum(), goods.getName(), goods.getName());
                }
            }
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

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInv = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnSendLeague = new javax.swing.JButton();
        btnBack1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ChartPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setLayout(null);

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(770, 370, 77, 29);

        tblInv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Num", "Estimated Price", "Size", "Condition"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblInv);
        if (tblInv.getColumnModel().getColumnCount() > 0) {
            tblInv.getColumnModel().getColumn(0).setResizable(false);
            tblInv.getColumnModel().getColumn(1).setResizable(false);
            tblInv.getColumnModel().getColumn(2).setResizable(false);
            tblInv.getColumnModel().getColumn(3).setResizable(false);
            tblInv.getColumnModel().getColumn(4).setResizable(false);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(230, 90, 610, 272);

        btnUpdate.setText("View or update Good info");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate);
        btnUpdate.setBounds(530, 500, 180, 40);

        btnSendLeague.setText("Send to league for free");
        btnSendLeague.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendLeagueActionPerformed(evt);
            }
        });
        add(btnSendLeague);
        btnSendLeague.setBounds(530, 550, 180, 40);

        btnBack1.setText("Back");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });
        add(btnBack1);
        btnBack1.setBounds(40, 550, 90, 40);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        jLabel2.setText("Goods List Inventory");
        add(jLabel2);
        jLabel2.setBounds(230, 40, 260, 30);

        ChartPanel.setLayout(new java.awt.BorderLayout());
        add(ChartPanel);
        ChartPanel.setBounds(230, 370, 290, 220);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Admin/6783831-cute-backgrounds.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        add(jLabel3);
        jLabel3.setBounds(0, 0, 1200, 800);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = tblInv.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a row from table first to update details!","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else{
            Goods goods = (Goods) tblInv.getValueAt(selectedRow, 0);
            
            UpdateJPanel updateJPanel = new UpdateJPanel(userProcessContainer , system , goods);
            userProcessContainer.add("updateJPanel", updateJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        
                
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSendLeagueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendLeagueActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblInv.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a row from table first to send the good!","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else{
            Goods goods = (Goods) tblInv.getValueAt(selectedRow, 0);
            
            if(enterprise instanceof CharityEnterprise){
                for(GoodsList goodlist:((CharityEnterprise)enterprise).getGoodsList()){
                    for(Goods g:goodlist.getGoodsList()){
                        if(g==goods){
                            goodlist.getGoodsList().remove(g);
                            populateTable();
                        }
                    }
                }
            }
            
        }
        
    }//GEN-LAST:event_btnSendLeagueActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        populateTable();
        populateChart();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChartPanel;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnSendLeague;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInv;
    // End of variables declaration//GEN-END:variables
}
