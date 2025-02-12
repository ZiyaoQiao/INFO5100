/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.GovComplain;

import EcoSystem.EcoSystem;
import Person.UserAccount;
import WorkRequest.ComplainWorkRequest;
import WorkRequest.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author yanfei
 */
public class ViewMessageJPanel extends javax.swing.JPanel {
    JPanel userProcessContainer; 
    EcoSystem system;
    ComplainWorkRequest request;
    UserAccount account;
    /**
     * Creates new form GovComplainWorkAreaJPanel
     */
    public ViewMessageJPanel(JPanel userProcessContainer,ComplainWorkRequest request, UserAccount account,EcoSystem system) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.system=system;
        this.request = request;
        this.account = account;
        txtComplain.setText(request.getMessage());
        txtComplain.setEditable(false);
        ComplainEnterprise.setText(request.getComplainEnterprise().toString());
        if(request.getResponse() != null){
            txtReply.setText(request.getResponse());
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
        txtComplain = new javax.swing.JTextArea();
        btnBack = new javax.swing.JButton();
        btnReply = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtReply = new javax.swing.JTextArea();
        ComplainEnterprise = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(null);

        txtComplain.setColumns(20);
        txtComplain.setRows(5);
        jScrollPane1.setViewportView(txtComplain);

        add(jScrollPane1);
        jScrollPane1.setBounds(334, 103, 457, 149);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(69, 481, 75, 29);

        btnReply.setText("Send Reply");
        btnReply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplyActionPerformed(evt);
            }
        });
        add(btnReply);
        btnReply.setBounds(679, 481, 112, 29);

        jLabel1.setText("Complain Message Detail");
        add(jLabel1);
        jLabel1.setBounds(334, 64, 159, 16);

        jLabel2.setText("Your Reply");
        add(jLabel2);
        jLabel2.setBounds(340, 264, 67, 16);

        txtReply.setColumns(20);
        txtReply.setRows(5);
        jScrollPane2.setViewportView(txtReply);

        add(jScrollPane2);
        jScrollPane2.setBounds(334, 292, 457, 183);
        add(ComplainEnterprise);
        ComplainEnterprise.setBounds(633, 59, 158, 26);

        jLabel3.setText("Complain Enterprise:");
        add(jLabel3);
        jLabel3.setBounds(633, 37, 131, 16);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Admin/6783831-cute-backgrounds.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        add(jLabel4);
        jLabel4.setBounds(0, 0, 1210, 800);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnReplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReplyActionPerformed
        String message = txtReply.getText();
        if(message.equals("")){
            JOptionPane.showMessageDialog(null, "please say something");
        }else{
            request.setResponse(message);
            txtReply.setEditable(false);
            request.setResolveDate(new Date());
            request.setStatus(2);
            JOptionPane.showMessageDialog(null, "Replied!");
        }
    }//GEN-LAST:event_btnReplyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ComplainEnterprise;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnReply;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtComplain;
    private javax.swing.JTextArea txtReply;
    // End of variables declaration//GEN-END:variables
}
