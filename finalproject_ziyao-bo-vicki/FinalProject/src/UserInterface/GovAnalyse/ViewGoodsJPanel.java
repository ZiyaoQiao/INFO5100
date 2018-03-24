/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.GovAnalyse;

import EcoSystem.EcoSystem;
import Enterprise.CharityEnterprise;
import Enterprise.Enterprise;
import Network.Network;
import Organization.Organization;
import Person.Goods;
import Person.UserAccount;
import WorkRequest.ComplainWorkRequest;
import WorkRequest.SendWorkRequest;
import WorkRequest.WorkRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
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
 * @author qiaoz
 */
public class ViewGoodsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewGoodsJPanel
     */
    public ViewGoodsJPanel() {
        initComponents();
    }
    JPanel userProcessContainer; 
    EcoSystem system;
    UserAccount account;
    Enterprise enterprise;
    Network network;
    Organization organization;
    /**
     * Creates new form ViewCompliantRateJPanel
     */
public ViewGoodsJPanel(JPanel userProcessContainer,UserAccount account, Organization organization, Enterprise enterprise, Network network,EcoSystem system) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.system=system;
        this.network = network;
        this.enterprise = enterprise;
        this.account = account;
        this.organization = organization;
        populateChart();
    }

   public void populateChart(){
        CategoryDataset dataset = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D("Top 10 Donated Goods", "Goods Name", "Number", dataset, PlotOrientation.VERTICAL,true,false,false);
       
        ChartPanel frame = new ChartPanel(chart);
        Donate.add(frame, BorderLayout.CENTER);
        Donate.validate();
        
        CategoryDataset dataset2 = getDataSet2();
        JFreeChart chart2 = ChartFactory.createBarChart3D("Top 10 Requested Goods", "Goods Name", "Number", dataset2, PlotOrientation.VERTICAL,true,false,false);
   
        ChartPanel frame2 = new ChartPanel(chart2);
        Request.add(frame2, BorderLayout.CENTER);
        Request.validate();
    }
    
    private CategoryDataset getDataSet(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        HashMap<String, Integer> map = new HashMap<>();
        for(Enterprise ent: network.getEnterpriseDirectory().getEnterpriseList()){
            if(ent instanceof CharityEnterprise){
                for(WorkRequest request: ent.getWorkQueue().getWorkRequestList()){
                    if(request instanceof SendWorkRequest){
                        if(((SendWorkRequest) request).getRequest() == 1){
                            for(Goods goods: request.getGoodsList().getGoodsList()){
                                if(map.containsKey(goods.getName()))
                                    map.put(goods.getName(), map.get(goods.getName())+goods.getNum());
                                else
                                    map.put(goods.getName(), goods.getNum());
                            }
                        }
                    }
                }
            }
        }
        int i = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(i == 10)
                break;
            dataset.addValue(entry.getValue(), "Goods Number", entry.getKey());
            i++;
        }
        return dataset;
    }
    
    private CategoryDataset getDataSet2(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        HashMap<String, Integer> map = new HashMap<>();
        for(Enterprise ent: network.getEnterpriseDirectory().getEnterpriseList()){
            if(ent instanceof CharityEnterprise){
                for(WorkRequest request: ent.getWorkQueue().getWorkRequestList()){
                    if(request instanceof SendWorkRequest){
                        if(((SendWorkRequest) request).getRequest() == 2){
                            for(Goods goods: request.getGoodsList().getGoodsList()){
                                if(map.containsKey(goods.getName()))
                                    map.put(goods.getName(), map.get(goods.getName())+goods.getNum());
                                else
                                    map.put(goods.getName(), goods.getNum());
                            }
                        }
                    }
                }
            }
        }
        int i = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(i == 10)
                break;
            dataset.addValue(entry.getValue(), "Goods Number", entry.getKey());
            i++;
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

        jButton1 = new javax.swing.JButton();
        Request = new javax.swing.JPanel();
        Donate = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(90, 558, 75, 29);

        Request.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        Request.setLayout(new java.awt.BorderLayout());
        add(Request);
        Request.setBounds(648, 228, 303, 359);

        Donate.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        Donate.setLayout(new java.awt.BorderLayout());
        add(Donate);
        Donate.setBounds(231, 228, 272, 359);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Admin/6783831-cute-backgrounds.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1200, 800);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Donate;
    private javax.swing.JPanel Request;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
