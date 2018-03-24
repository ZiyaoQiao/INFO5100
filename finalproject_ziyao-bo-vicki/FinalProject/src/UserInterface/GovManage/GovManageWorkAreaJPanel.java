/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.GovManage;

import EcoSystem.EcoSystem;
import Enterprise.CharityEnterprise;
import Enterprise.Enterprise;
import Network.Network;
import WorkRequest.TransportWorkRequest;
import WorkRequest.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author caobo
 */
public class GovManageWorkAreaJPanel extends javax.swing.JPanel {
    
    
    JPanel userProcessContainer; 
    EcoSystem business;
    Network network;
    /**
     * Creates new form GovManageWorkAreaJPanel
     */
    public GovManageWorkAreaJPanel(JPanel userProcessContainer,EcoSystem business, Network network) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.business=business;
        
        this.network = network;
        populate();
    }
    
    public void populate(){
        DefaultTableModel model = (DefaultTableModel)tblProduct.getModel();
        model.setRowCount(0);
        for(Enterprise ent: network.getEnterpriseDirectory().getEnterpriseList()){
            if(ent instanceof CharityEnterprise){
                double price = 0;
                int number = 0;
                for(WorkRequest request: ent.getWorkQueue().getWorkRequestList()){
                    if(request instanceof TransportWorkRequest){
                        if(((TransportWorkRequest) request).getPrice() == -1){
                            price += 0;
                        }
                        price += 0;
                        number ++;
                    }
                }
                Object[] row = new Object[3];
                row[0] = ent;
                row[1] = number;
                row[2] = price;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Charity", "WorkRequestNumber", "Money Spent"
            }
        ));
        jScrollPane1.setViewportView(tblProduct);

        add(jScrollPane1);
        jScrollPane1.setBounds(213, 50, 640, 350);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(70, 480, 75, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Admin/6783831-cute-backgrounds.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1200, 800);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProduct;
    // End of variables declaration//GEN-END:variables
}
