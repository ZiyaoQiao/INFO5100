/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CharitySend;

import EcoSystem.EcoSystem;
import Enterprise.Enterprise;
import Network.Network;
import Person.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author caobo
 */
public class CharitySendWorkAreaJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    EcoSystem system;
    Enterprise enterprise;
    Network network;
    UserAccount account;
    /**
     * Creates new form CharitySendWorkAreaJPanel
     */
    public CharitySendWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Network network, EcoSystem business) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        system=business;
        this.enterprise=enterprise;
        this.network = network;
        this.account = account;
        valueLabel.setText(enterprise.getName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMngReceiveComfirm = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(null);

        btnMngReceiveComfirm.setText("Manage Send Request");
        btnMngReceiveComfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMngReceiveComfirmActionPerformed(evt);
            }
        });
        add(btnMngReceiveComfirm);
        btnMngReceiveComfirm.setBounds(457, 173, 250, 29);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("My Work Area -Charity Send Role");
        add(jLabel1);
        jLabel1.setBounds(357, 59, 396, 29);

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel);
        enterpriseLabel.setBounds(357, 106, 120, 30);

        valueLabel.setText("<value>");
        add(valueLabel);
        valueLabel.setBounds(483, 115, 130, 16);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/CharityManage/redcross log.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        add(jLabel3);
        jLabel3.setBounds(460, 220, 240, 150);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Admin/6783831-cute-backgrounds.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2);
        jLabel2.setBounds(0, 0, 1200, 800);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMngReceiveComfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMngReceiveComfirmActionPerformed
        // TODO add your handling code here:
        ManageSendJPanel manageSendJPanel = new ManageSendJPanel(userProcessContainer,account,enterprise,network, system);
        userProcessContainer.add("manageSendJPanel", manageSendJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnMngReceiveComfirmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMngReceiveComfirm;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
