/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Admin;


import EcoSystem.EcoSystem;
import Enterprise.Enterprise;
import Network.Network;
import Organization.Organization;
import Person.Person;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class ManageEmployeeJPanel extends javax.swing.JPanel {

    private EcoSystem system;
    private JPanel userProcessContainer;
    Enterprise enterprise;
    Network network;
    Organization organ;
    
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageEmployeeJPanel(JPanel userProcessContainer,Enterprise enterprise, Network network, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.enterprise = enterprise;
        this.network = network;
        populateOrganizationComboBox();
        populateOrganizationEmpComboBox();
        UpdateBtn.setEnabled(false);
    }
    
    public void populateOrganizationComboBox(){
        organizationJComboBox.removeAllItems();
        for(Organization org:enterprise.getOrganizationDirectory().getOrganizationList()){
            organizationJComboBox.addItem(org);
        }
    }
    
    public void populateOrganizationEmpComboBox(){
        organizationEmpJComboBox.removeAllItems();
        for(Organization org:enterprise.getOrganizationDirectory().getOrganizationList()){
            organizationEmpJComboBox.addItem(org);
        }
    }

    private void populateTable(Organization organization){
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        
        model.setRowCount(0);
        
        for (Person employee : organization.getEmployeeDirectory().getPersonList()){
            Object[] row = new Object[2];
            row[0] = employee.getID();
            row[1] = employee;
            model.addRow(row);
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
        organizationJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        organizationEmpJComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        EditBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

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
        jScrollPane1.setBounds(179, 74, 580, 170);

        addJButton.setText("Create Employee");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton);
        addJButton.setBounds(610, 523, 148, 29);

        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });
        add(organizationJComboBox);
        organizationJComboBox.setBounds(284, 34, 240, 27);

        jLabel1.setText("Organization");
        add(jLabel1);
        jLabel1.setBounds(185, 38, 81, 16);

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton);
        backJButton.setBounds(37, 523, 97, 29);

        jLabel2.setText("Name");
        add(jLabel2);
        jLabel2.setBounds(179, 306, 36, 16);
        add(nameJTextField);
        nameJTextField.setBounds(278, 301, 240, 26);

        organizationEmpJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationEmpJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationEmpJComboBoxActionPerformed(evt);
            }
        });
        add(organizationEmpJComboBox);
        organizationEmpJComboBox.setBounds(278, 262, 250, 27);

        jLabel3.setText("Organization");
        add(jLabel3);
        jLabel3.setBounds(179, 266, 81, 16);

        EditBtn.setText("Edit");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });
        add(EditBtn);
        EditBtn.setBounds(584, 33, 75, 29);

        UpdateBtn.setText("Update");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });
        add(UpdateBtn);
        UpdateBtn.setBounds(610, 488, 148, 29);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Admin/6783831-cute-backgrounds.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        add(jLabel4);
        jLabel4.setBounds(0, 0, 1210, 800);
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        Organization organization = (Organization) organizationEmpJComboBox.getSelectedItem();
        String name = nameJTextField.getText();
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "please input name");
        }else{
            
                boolean personNotExist = true;
                for(Person p:organization.getEmployeeDirectory().getPersonList()){
                    if(p.getName().equals(name)){
                        personNotExist = false;
                    }
                }
                
                if(personNotExist){
                    organization.getEmployeeDirectory().createAndAddPerson(name);
                    populateOrganizationComboBox();
                    nameJTextField.setText("");
                    JOptionPane.showMessageDialog(null, "Create Success!");
                }else{
                    JOptionPane.showMessageDialog(null, "The name of person has been existed!");
                }
        
            
        }
    }//GEN-LAST:event_addJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null){
            populateTable(organization);
        }
        organ=organization;
    }//GEN-LAST:event_organizationJComboBoxActionPerformed
        Person selectedPerson;
    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        // TODO add your handling code here:
        int selected = organizationJTable.getSelectedRow();
        if(selected < 0){
            JOptionPane.showMessageDialog(null, "please select a row");
        }else{
            UpdateBtn.setEnabled(true);
            addJButton.setEnabled(false);
            selectedPerson = (Person)organizationJTable.getValueAt(selected, 1);
            organizationEmpJComboBox.setSelectedItem(organizationJComboBox.getSelectedItem());
            organizationEmpJComboBox.setEnabled(false);
            nameJTextField.setText(selectedPerson.getName());
            
            UpdateBtn.setEnabled(true);
        }
    }//GEN-LAST:event_EditBtnActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        // TODO add your handling code here:
        String name = nameJTextField.getText();
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "not complete");
        }else{
            boolean personNotExist = true;
            for(Person p:organ.getEmployeeDirectory().getPersonList()){
                if(p.getName().equals(name)){
                    personNotExist = false;
                }
            }
            
            if(personNotExist){
                selectedPerson.setName(name);
                UpdateBtn.setEnabled(false);
                addJButton.setEnabled(true);
                nameJTextField.setText("");
                JOptionPane.showMessageDialog(null, "update success");
            }else{
                JOptionPane.showMessageDialog(null, "The name has been existed!");
            }
            
        }
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void organizationEmpJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationEmpJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_organizationEmpJComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditBtn;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizationEmpJComboBox;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    // End of variables declaration//GEN-END:variables
}
