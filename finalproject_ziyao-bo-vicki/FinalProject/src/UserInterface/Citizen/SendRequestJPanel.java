/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Citizen;

import EcoSystem.EcoSystem;
import Enterprise.CharityEnterprise;
import Enterprise.Enterprise;
import Network.Network;
import Person.Goods;
import Person.GoodsList;
import Person.UserAccount;
import WorkRequest.SendWorkRequest;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yanfei
 */
public class SendRequestJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer; 
    EcoSystem system;
    UserAccount account;
    Enterprise enterprise;
    Network network;
    GoodsList goodsList;
    Goods goods;
    /**
     * Creates new form SendRequestJPanel
     */
    public SendRequestJPanel(JPanel userProcessContainer,UserAccount account, Enterprise enterprise, Network network, EcoSystem system) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.system=system;
        this.network = network;
        this.enterprise = enterprise;
        this.account = account;
        goodsList = new GoodsList();
        populateComboBox();
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
        tblDonationOrder = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnSendRequest = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtItemName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        DeleteBtn = new javax.swing.JButton();
        PinnedBtn = new javax.swing.JButton();
        txtQuantity = new javax.swing.JFormattedTextField();
        CharityComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();

        setLayout(null);

        tblDonationOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Items", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(tblDonationOrder);

        add(jScrollPane1);
        jScrollPane1.setBounds(316, 203, 470, 159);

        btnAdd.setText("Add to Order");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        add(btnAdd);
        btnAdd.setBounds(660, 130, 125, 29);

        btnSendRequest.setText("Send Request for Donation");
        btnSendRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendRequestActionPerformed(evt);
            }
        });
        add(btnSendRequest);
        btnSendRequest.setBounds(570, 390, 220, 29);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(60, 390, 75, 29);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        jLabel1.setText("Request Items");
        add(jLabel1);
        jLabel1.setBounds(316, 41, 134, 31);

        jLabel2.setText("Item Name");
        add(jLabel2);
        jLabel2.setBounds(316, 103, 68, 16);
        add(txtItemName);
        txtItemName.setBounds(446, 98, 192, 26);

        jLabel3.setText("Quantity");
        add(jLabel3);
        jLabel3.setBounds(316, 141, 68, 16);

        jLabel4.setText("Send Request for certain goods for donation");
        add(jLabel4);
        jLabel4.setBounds(320, 440, 278, 16);

        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });
        add(DeleteBtn);
        DeleteBtn.setBounds(490, 390, 84, 29);

        PinnedBtn.setText("Pinned");
        PinnedBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PinnedBtnActionPerformed(evt);
            }
        });
        add(PinnedBtn);
        PinnedBtn.setBounds(790, 30, 86, 29);
        add(txtQuantity);
        txtQuantity.setBounds(446, 136, 192, 26);

        CharityComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(CharityComboBox);
        CharityComboBox.setBounds(310, 390, 171, 27);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Admin/6783831-cute-backgrounds.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        add(jLabel5);
        jLabel5.setBounds(0, 0, 1200, 800);
    }// </editor-fold>//GEN-END:initComponents
    public void display(){
        DefaultTableModel model = (DefaultTableModel)tblDonationOrder.getModel();
        
        model.setRowCount(0);        
        for(Goods goods: goodsList.getGoodsList()){
            Object[] row = new Object[2];
            row[0] = goods;
            row[1] = goods.getNum();
            model.addRow(row);
        }
        
    }
    
    public void populateComboBox(){
        CharityComboBox.removeAllItems();
        for(Enterprise ent:network.getEnterpriseDirectory().getEnterpriseList()){
            if(ent instanceof CharityEnterprise){
                CharityComboBox.addItem(ent);
            }
        }
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String name = txtItemName.getText();
        String quantity = txtQuantity.getText();
        if(name.equals("")||quantity.equals("")){
            JOptionPane.showMessageDialog(null, "please input");
        }else{
            
            boolean numInvalid = false;
            int num = -1;
            try{
                num = Integer.parseInt(quantity);
            }catch (Exception e){
                numInvalid = true;
            }
            
            if(num<1||numInvalid){
                JOptionPane.showMessageDialog(null,"wrong number!");
            }else{
                Goods goods = new Goods(name);
                goods.setNum(num);
                goods.setLinkGoods(null);
                goodsList.getGoodsList().add(goods);
                txtItemName.setText("");
                txtQuantity.setText("");
                JOptionPane.showMessageDialog(null, "Request Sent!");
                display();
            }
        }
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSendRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendRequestActionPerformed
        // TODO add your handling code here:
        
        if(goodsList.getGoodsList().size()==0){
            JOptionPane.showMessageDialog(null, "No goods");
        }else{
            Enterprise ent = (Enterprise)CharityComboBox.getSelectedItem();
            SendWorkRequest request = new SendWorkRequest();
            request.setFromEnterprise(enterprise);
            request.setRequest(2);
            request.setRequestDate(new Date());
            request.setSender(account);
            request.setStatus(1);
            request.setToEnterprise(ent);
            request.setGoodsList(goodsList);
            request.setFromOrganization(account.getOrganization());
            
            ent.getWorkQueue().getWorkRequestList().add(request);
            account.getWorkQueue().getWorkRequestList().add(request);
            
            goodsList = new GoodsList();
            display();
        }
    }//GEN-LAST:event_btnSendRequestActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        // TODO add your handling code here:
        int selected = tblDonationOrder.getSelectedRow();
        if(selected < 0){
            JOptionPane.showMessageDialog(null, "Please select a row to delete");
        }else{
            Goods gd = (Goods)tblDonationOrder.getValueAt(selected, 0);
            goodsList.getGoodsList().remove(gd);
            display();
            JOptionPane.showMessageDialog(null, "Remove Successfully");
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void PinnedBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PinnedBtnActionPerformed
        // TODO add your handling code here:
        JPanel jp = new JPanel();
        JFrame jf = new JFrame();
        jf.setVisible(true);
        jf.setSize(new Dimension(800,600));
        JPanel tmp = new PinRequestJPanel(account);

        JButton close = new JButton("close");
        tmp.add(close);

        jf.setContentPane(tmp);
    }//GEN-LAST:event_PinnedBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CharityComboBox;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton PinnedBtn;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSendRequest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDonationOrder;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JFormattedTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
