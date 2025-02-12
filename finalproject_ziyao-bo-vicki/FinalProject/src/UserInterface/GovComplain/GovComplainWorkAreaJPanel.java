/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.GovComplain;

import EcoSystem.EcoSystem;
import Enterprise.Enterprise;
import Network.Network;
import Organization.Organization;
import Person.UserAccount;
import WorkRequest.ComplainWorkRequest;
import WorkRequest.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author caobo
 */
public class GovComplainWorkAreaJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer; 
    EcoSystem system;
    UserAccount account;
    Enterprise enterprise;
    Network network;
    Organization organization;
    /**
     * Creates new form GovComplainWorkAreaJPanel
     */
    public GovComplainWorkAreaJPanel(JPanel userProcessContainer,UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem system) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.system=system;
        this.network = network;
        this.enterprise = enterprise;
        this.account = account;
        this.organization = organization;
        
        populate();
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
        btnComplain = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnViewMessage = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(null);

        btnComplain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Message", "Sender", "Status", "Complain Enterprise"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(btnComplain);

        add(jScrollPane1);
        jScrollPane1.setBounds(329, 91, 620, 290);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        jLabel1.setText("Handle Complain");
        add(jLabel1);
        jLabel1.setBounds(329, 29, 300, 22);

        btnViewMessage.setText("View Message Detail");
        btnViewMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewMessageActionPerformed(evt);
            }
        });
        add(btnViewMessage);
        btnViewMessage.setBounds(780, 400, 172, 29);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Admin/6783831-cute-backgrounds.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2);
        jLabel2.setBounds(0, -10, 1210, 820);
    }// </editor-fold>//GEN-END:initComponents
    public void populate(){
        DefaultTableModel model = (DefaultTableModel) btnComplain.getModel();

        model.setRowCount(0);
        for(WorkRequest request:enterprise.getWorkQueue().getWorkRequestList()){
            if(request instanceof ComplainWorkRequest){
                ComplainWorkRequest tmp = (ComplainWorkRequest)request;
                Object[] row = new Object[4];
                row[0] = tmp;
                row[1] = tmp.getSender();
                row[2] = tmp.getStatus();
                row[3] = tmp.getComplainEnterprise();
                model.addRow(row);
            }
        }
    }
    private void btnViewMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewMessageActionPerformed
        // TODO add your handling code here:
        int select = btnComplain.getSelectedRow();
        if(select < 0){
            JOptionPane.showMessageDialog(null, "please select a row");
        }else{
            ComplainWorkRequest request = (ComplainWorkRequest)btnComplain.getValueAt(select, 0);
            ViewMessageJPanel viewMessageJPanel = new ViewMessageJPanel(userProcessContainer, request, account, system);
            userProcessContainer.add("viewMessageJPanel", viewMessageJPanel);

            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnViewMessageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable btnComplain;
    private javax.swing.JButton btnViewMessage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
