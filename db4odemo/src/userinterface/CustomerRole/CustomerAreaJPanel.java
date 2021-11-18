/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import Business.Customer.Customer;
import Business.EcoSystem;
import Business.Order.Order;
import Business.Restaurant.Restaurant;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.RestaurantAdminRole.ManageMenu;

/**
 *
 * @author zhuzixuan
 */
public class CustomerAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    EcoSystem system;
    private UserAccount account;
    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public CustomerAreaJPanel(JPanel userProcessContainer, UserAccount account,EcoSystem system) {
        initComponents();
        
        this.account=account;
        this.userProcessContainer = userProcessContainer;
        this.system=system;
        valueLabel.setText("Welcome"+account.getName());
        populateTable();
        pastTblPopulate();
        
    }
    
    public void populateTable(){
         DefaultTableModel model = (DefaultTableModel) restaurentTable.getModel();
        
        model.setRowCount(0);
         
       
                Object[] row = new Object[3];
                //System.out.println();
                for(Restaurant restro:system.getRestaurantDirectory().getRestaurantList()){
                     row[0] = restro;
                     //System.out.println(restro.getAdminUName());
                     row[1] = restro.getAddress();
                     row[2] = restro.getNumber();
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
        restaurentTable = new javax.swing.JTable();
        requestTestJButton = new javax.swing.JButton();
        refreshTestJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        valueLabel1 = new javax.swing.JLabel();
        valueLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pastTbl = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        restaurentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Address", "Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(restaurentTable);
        if (restaurentTable.getColumnModel().getColumnCount() > 0) {
            restaurentTable.getColumnModel().getColumn(0).setResizable(false);
            restaurentTable.getColumnModel().getColumn(1).setResizable(false);
            restaurentTable.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, -1, 97));

        requestTestJButton.setText("Choose one Restaurant");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });
        add(requestTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, -1));

        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });
        add(refreshTestJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, -1, -1));

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("Customer:");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 127, 30));

        valueLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 250, 26));

        valueLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        valueLabel1.setText("Available Restaurants");
        add(valueLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 210, 26));

        valueLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        valueLabel2.setText("Order History");
        add(valueLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 158, 26));

        pastTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order ID", "Restaurant Name", "Total Price", "Status"
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
        jScrollPane2.setViewportView(pastTbl);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, -1, 100));
    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed
        int selectedRow = restaurentTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null,"Please select a row from the table to view details","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else{
           Restaurant restaurant = (Restaurant)restaurentTable.getValueAt(selectedRow, 0);
            
            
              MenuPanel manageMenu=new MenuPanel(userProcessContainer,account,system,restaurant);
             userProcessContainer.add("Manage Restaurents",manageMenu);
            CardLayout layout=(CardLayout)userProcessContainer.getLayout();
                layout.next(userProcessContainer);
        }
        
        
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

        pastTblPopulate();
        
    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable pastTbl;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JTable restaurentTable;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JLabel valueLabel1;
    private javax.swing.JLabel valueLabel2;
    // End of variables declaration//GEN-END:variables

    private void pastTblPopulate() {
        DefaultTableModel model = (DefaultTableModel) pastTbl.getModel();
        
        model.setRowCount(0);
         
       
          for (Customer cust:system.getCustomerDirectory().getCustList()) {
           
            if (cust.getUserName().equals(account.getUsername())) {
               // System.out.println(restro.getOrderList());
               for(Order menu:cust.getOrderList()){
                Object[] row = new Object[4];
                row[0] = menu;
                row[1] = menu.getRestaurentName();
               
                row[2] = menu.getCost();
                row[3] = menu.getStatus();
                model.addRow(row);
               }
                
            }
            
        }
        
        
    }
}
