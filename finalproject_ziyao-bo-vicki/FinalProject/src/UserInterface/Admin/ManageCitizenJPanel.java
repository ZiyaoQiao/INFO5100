/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author qiaoz
 */
public class ManageCitizenJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageCitizenJPanel
     */
    private EcoSystem system;
    private JPanel userProcessContainer;
    Enterprise enterprise;
    Network network;
    Organization organ;
    
    public ManageCitizenJPanel(JPanel userProcessContainer,Enterprise enterprise, Network network, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.enterprise = enterprise;
        this.network = network;
        populateOrganizationComboBox();
        populateOrganizationEmpComboBox();
        populateGenderComboBox();
        UpdateBtn.setEnabled(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        organizationEmpJComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        GenderComboBox = new javax.swing.JComboBox<>();
        IncomeTxt = new javax.swing.JFormattedTextField();
        FoodCostTxt = new javax.swing.JFormattedTextField();
        EditBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setLayout(null);

        jLabel2.setText("Name");
        add(jLabel2);
        jLabel2.setBounds(190, 260, 36, 16);
        add(nameJTextField);
        nameJTextField.setBounds(374, 255, 180, 26);

        organizationEmpJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(organizationEmpJComboBox);
        organizationEmpJComboBox.setBounds(370, 220, 190, 27);

        jLabel3.setText("Organization");
        add(jLabel3);
        jLabel3.setBounds(190, 220, 81, 16);

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

        add(jScrollPane1);
        jScrollPane1.setBounds(160, 70, 570, 140);

        addJButton.setText("Create Employee");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton);
        addJButton.setBounds(580, 490, 148, 29);

        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });
        add(organizationJComboBox);
        organizationJComboBox.setBounds(260, 30, 200, 27);

        jLabel1.setText("Organization");
        add(jLabel1);
        jLabel1.setBounds(170, 30, 81, 20);

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton);
        backJButton.setBounds(40, 490, 97, 29);

        jLabel4.setText("Gender");
        add(jLabel4);
        jLabel4.setBounds(190, 300, 44, 16);

        jLabel5.setText("Annual Income");
        add(jLabel5);
        jLabel5.setBounds(190, 350, 94, 16);

        jLabel6.setText("Average Food Cost");
        add(jLabel6);
        jLabel6.setBounds(190, 390, 118, 16);

        GenderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(GenderComboBox);
        GenderComboBox.setBounds(370, 300, 190, 27);
        add(IncomeTxt);
        IncomeTxt.setBounds(374, 344, 180, 26);
        add(FoodCostTxt);
        FoodCostTxt.setBounds(374, 388, 180, 26);

        EditBtn.setText("Edit");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });
        add(EditBtn);
        EditBtn.setBounds(570, 30, 75, 29);

        UpdateBtn.setText("Update");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });
        add(UpdateBtn);
        UpdateBtn.setBounds(580, 450, 148, 29);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Admin/6783831-cute-backgrounds.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        add(jLabel7);
        jLabel7.setBounds(0, 0, 1200, 800);
    }// </editor-fold>//GEN-END:initComponents
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
    
    public void populateGenderComboBox(){
        GenderComboBox.removeAllItems();
        GenderComboBox.addItem("Male");
        GenderComboBox.addItem("Female");
        GenderComboBox.addItem("Hidden");
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
    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        Organization organization = (Organization) organizationEmpJComboBox.getSelectedItem();
        String gender = (String)GenderComboBox.getSelectedItem();
        int g = 0;
        if(gender.equals("Male")){
            g = 1;
        }else if(gender.equals("Female")){
            g = -1;
        }else{
            g = 0;
        }
        String name = nameJTextField.getText();
        
        boolean personNotExist = true;
        for(Person p:organization.getEmployeeDirectory().getPersonList()){
            if(p.getName().equals(name)){
                personNotExist = false;
            }
        }
        
        if(personNotExist){
            String income = IncomeTxt.getText();
            String food = FoodCostTxt.getText();
            if(name.equals("")||income.equals("")||food.equals("")){
                JOptionPane.showMessageDialog(null, "incomplete information");
            }else{
                Person person = organization.getEmployeeDirectory().createAndAddPerson(name);
                person.setGender(g);
                person.setFoodSpend(Double.parseDouble(food));
                person.setIncome(Double.parseDouble(income));
                person.setEngelsCoefficient(person.getFoodSpend()/person.getIncome());
                populateOrganizationComboBox();
            
                nameJTextField.setText("");
                IncomeTxt.setText("");
                FoodCostTxt.setText("");
                JOptionPane.showMessageDialog(null, "Create Success!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "The name of person has been existed!");
        }
        
    }//GEN-LAST:event_addJButtonActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null){
            populateTable(organization);
            organ=organization;
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed
    
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
            GenderComboBox.setSelectedItem(selectedPerson.getGender());
            GenderComboBox.setEnabled(false);
            IncomeTxt.setText(String.valueOf(selectedPerson.getIncome()));
            FoodCostTxt.setText(String.valueOf(selectedPerson.getFoodSpend()));
            UpdateBtn.setEnabled(true);
        }
    }//GEN-LAST:event_EditBtnActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        // TODO add your handling code here:
        String name = nameJTextField.getText();
        String Income = IncomeTxt.getText();
        String FoodCost = FoodCostTxt.getText();
        if(name.equals("")||Income.equals("")||FoodCost.equals("")){
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
                selectedPerson.setIncome(Double.parseDouble(Income));
                selectedPerson.setFoodSpend(Double.parseDouble(FoodCost));
                selectedPerson.setEngelsCoefficient(selectedPerson.getFoodSpend()/selectedPerson.getIncome());
                UpdateBtn.setEnabled(false);
                addJButton.setEnabled(true);
            
                nameJTextField.setText("");
                IncomeTxt.setText("");
                FoodCostTxt.setText("");
                JOptionPane.showMessageDialog(null, "Update Success!");
                UpdateBtn.setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null, "The name has been existed!");
            }
            
            
        }
    }//GEN-LAST:event_UpdateBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditBtn;
    private javax.swing.JFormattedTextField FoodCostTxt;
    private javax.swing.JComboBox<String> GenderComboBox;
    private javax.swing.JFormattedTextField IncomeTxt;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JComboBox organizationEmpJComboBox;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    // End of variables declaration//GEN-END:variables
}
