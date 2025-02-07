/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Admin;

import EcoSystem.EcoSystem;
import Enterprise.CharityEnterprise;
import Enterprise.CitizenEnterprise;
import Enterprise.DeliveryEnterprise;
import Enterprise.Enterprise;
import Enterprise.GovEnterprise;
import Organization.CharityManageOrganization;
import Organization.CharityReceiveOrganization;
import Organization.CharitySendOrganization;
import Organization.Organization;
import Organization.Organization.Type;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Network.Network;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
/**
 *
 * @author raunak
 */
public class ManageOrganizationJPanel extends javax.swing.JPanel {

    EcoSystem system;
    private JPanel userProcessContainer;
    Enterprise enterprise;
    Network network;
    
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageOrganizationJPanel(JPanel userProcessContainer,Enterprise enterprise, Network network, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.network = network;
        this.enterprise = enterprise;
        populateTable();
        populateCombo();
        //googlemap();
    }
//
//    public void googlemap(){
//        Browser browser = new Browser();
//        BrowserView view = new BrowserView(browser);
//
//        JFrame frame = new JFrame("JxBrowser Google Maps");
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.add(view, BorderLayout.CENTER);
//        frame.setSize(700, 500);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//
//        browser.loadURL("http://www.google.com/maps");
//    }
//    
    
    private void populateCombo(){
        organizationJComboBox.removeAllItems();
        if(enterprise instanceof CharityEnterprise){
            organizationJComboBox.addItem(Organization.Type.CharityManage);
            organizationJComboBox.addItem(Organization.Type.CharityReceive);
            organizationJComboBox.addItem(Organization.Type.CharitySend);
        }else if(enterprise instanceof CitizenEnterprise){
            organizationJComboBox.addItem(Organization.Type.Group);
        }else if(enterprise instanceof DeliveryEnterprise){
            organizationJComboBox.addItem(Organization.Type.DeliveryReceive);
            organizationJComboBox.addItem(Organization.Type.DeliverySend);
        }else if(enterprise instanceof GovEnterprise){
            organizationJComboBox.addItem(Organization.Type.GovernmentAnalyse);
            organizationJComboBox.addItem(Organization.Type.GovernmentComplain);
            organizationJComboBox.addItem(Organization.Type.GovernmentManage);
        }
    }

    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        model.setRowCount(0);
        int i = 1;
        for(Organization org: enterprise.getOrganizationDirectory().getOrganizationList()){
            Object[] row = new Object[2];
            row[0] = i++;
            row[1] = org;
            model.addRow(row);
        }
    }
    /**
     * This method is called from within the constructor t o initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        locationJText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setLayout(null);

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationJTable);
        if (organizationJTable.getColumnModel().getColumnCount() > 0) {
            organizationJTable.getColumnModel().getColumn(0).setResizable(false);
            organizationJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(210, 60, 580, 156);

        addJButton.setText("Add Organization");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton);
        addJButton.setBounds(626, 523, 154, 29);

        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(organizationJComboBox);
        organizationJComboBox.setBounds(360, 280, 173, 27);

        jLabel1.setText("Organization Type ");
        add(jLabel1);
        jLabel1.setBounds(210, 290, 143, 10);

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton);
        backJButton.setBounds(22, 523, 97, 29);
        add(locationJText);
        locationJText.setBounds(360, 230, 173, 26);

        jLabel2.setText("Organization Location:");
        add(jLabel2);
        jLabel2.setBounds(210, 240, 143, 16);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Admin/6783831-cute-backgrounds.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        add(jLabel3);
        jLabel3.setBounds(10, 0, 1190, 800);
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        Type type = (Type)organizationJComboBox.getSelectedItem();
        String location = locationJText.getText();
        if(location.equals("")){
            JOptionPane.showMessageDialog(null, "Please assign a location");
        }else{
            int i = 1;
            for(Organization org:enterprise.getOrganizationDirectory().getOrganizationList()){
                if(org.getName().equals(type.getValue()))
                    i++;
            }
            String name = type.getValue() + "_" + i;
            Organization organization = enterprise.getOrganizationDirectory().createOrganization(type, location);
            organization.setDisplayName(name);
            locationJText.setText("");
            populateTable();
            JOptionPane.showMessageDialog(null, "Create Success!");
        }
    }//GEN-LAST:event_addJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField locationJText;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    // End of variables declaration//GEN-END:variables
}
