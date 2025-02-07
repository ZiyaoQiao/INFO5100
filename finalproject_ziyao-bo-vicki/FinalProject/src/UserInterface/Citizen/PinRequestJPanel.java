/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Citizen;

import Person.Goods;
import Person.UserAccount;
import WorkRequest.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author qiaoz
 */
public class PinRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PinRequestJPanel
     */
    UserAccount account;
    public PinRequestJPanel(UserAccount account) {
        initComponents();
        this.account = account;
        populateRequest();
    }
    
    public void populateRequest(){
        DefaultTableModel model = (DefaultTableModel)RequestTable.getModel();
        model.setRowCount(0);
        for(WorkRequest request: account.getPinWorkQueue().getWorkRequestList()){
            Object[] row = new Object[24];
            row[0] = request;
            row[1] = request.getRequestDate();
            row[2] = request.getStatus();
            row[3] = request.getSender();
            model.addRow(row);
        }
    }
    public void populateDetail(WorkRequest request){
        DefaultTableModel model = (DefaultTableModel)DetailTable.getModel();
        model.setRowCount(0);
        if(request != null){
            for(Goods goods : request.getGoodsList().getGoodsList()){
                Object[] row = new Object[2];
                row[0] = goods;
                row[1] = goods.getNum();
                model.addRow(row);
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
        RequestTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        DetailTable = new javax.swing.JTable();
        DetailBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(null);

        RequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request", "Date", "Status", "Person"
            }
        ));
        jScrollPane1.setViewportView(RequestTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(213, 85, 568, 118);

        DetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Goods", "Number"
            }
        ));
        jScrollPane2.setViewportView(DetailTable);

        add(jScrollPane2);
        jScrollPane2.setBounds(210, 280, 568, 292);

        DetailBtn.setText("Detail");
        DetailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetailBtnActionPerformed(evt);
            }
        });
        add(DetailBtn);
        DetailBtn.setBounds(649, 221, 132, 29);

        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });
        add(DeleteBtn);
        DeleteBtn.setBounds(210, 220, 121, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Admin/6783831-cute-backgrounds.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1200, 800);
    }// </editor-fold>//GEN-END:initComponents

    private void DetailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetailBtnActionPerformed
        // TODO add your handling code here:
        int selected = RequestTable.getSelectedRow();
        if(selected < 0){
            JOptionPane.showMessageDialog(null, "please select!");
        }else{
            WorkRequest request = (WorkRequest)RequestTable.getValueAt(selected, 0);
            populateDetail(request);
        }
    }//GEN-LAST:event_DetailBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        // TODO add your handling code here:
        int selected = RequestTable.getSelectedRow();
        if(selected < 0){
            JOptionPane.showMessageDialog(null, "please select!");
        }else{
            WorkRequest request = (WorkRequest)RequestTable.getValueAt(selected, 0);
            account.getPinWorkQueue().getWorkRequestList().remove(request);
            JOptionPane.showMessageDialog(null, "delete success");
            populateRequest();
            populateDetail(null);
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton DetailBtn;
    private javax.swing.JTable DetailTable;
    private javax.swing.JTable RequestTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
