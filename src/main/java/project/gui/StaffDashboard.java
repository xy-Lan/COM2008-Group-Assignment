/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project.gui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 *
 * @author linyu
 */
public class StaffDashboard extends javax.swing.JFrame {

    /**
     * Creates new form Default
     */
    public StaffDashboard() {
        initComponents();
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnMyDetails = new javax.swing.JButton();
        btnRecentOrders = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        btnUser = new javax.swing.JButton();
        btnManager = new javax.swing.JButton();
        btnPendingOrders = new javax.swing.JButton();
        btnListCustomers1 = new javax.swing.JButton();
        btnAddProduct1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAddProduct3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jPopupMenu1.setPreferredSize(new java.awt.Dimension(20, 50));

        jMenuItem1.setText("jMenuItem1");
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Category");
        setPreferredSize(new java.awt.Dimension(1000, 800));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 800));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 800));

        btnMyDetails.setBackground(new java.awt.Color(0, 102, 0));
        btnMyDetails.setForeground(new java.awt.Color(204, 204, 204));
        btnMyDetails.setText("My Details");
        btnMyDetails.setBorder(null);
        btnMyDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyDetailsActionPerformed(evt);
            }
        });

        btnRecentOrders.setBackground(new java.awt.Color(0, 102, 0));
        btnRecentOrders.setForeground(new java.awt.Color(204, 204, 204));
        btnRecentOrders.setText("Recent Orders");
        btnRecentOrders.setBorder(null);
        btnRecentOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecentOrdersActionPerformed(evt);
            }
        });

        btnLogOut.setBackground(new java.awt.Color(0, 102, 0));
        btnLogOut.setForeground(new java.awt.Color(204, 204, 204));
        btnLogOut.setText("Log out");
        btnLogOut.setBorder(null);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMyDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnRecentOrders))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnMyDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecentOrders)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 667, Short.MAX_VALUE)
                .addComponent(btnLogOut)
                .addGap(61, 61, 61))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 250, 800);

        jPanel3.setBackground(new java.awt.Color(0, 102, 0));

        title.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Dashboard");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(title)
                .addContainerGap(588, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(title)
                .addGap(19, 19, 19))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(250, 120, 750, 70);

        btnUser.setBackground(new java.awt.Color(0, 102, 0));
        btnUser.setForeground(new java.awt.Color(204, 204, 204));
        btnUser.setText("User interface");
        btnUser.setBorder(null);
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        jPanel1.add(btnUser);
        btnUser.setBounds(840, 10, 130, 16);

        btnManager.setBackground(new java.awt.Color(0, 102, 0));
        btnManager.setForeground(new java.awt.Color(204, 204, 204));
        btnManager.setText("Manager interface");
        btnManager.setBorder(null);
        btnManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagerActionPerformed(evt);
            }
        });
        jPanel1.add(btnManager);
        btnManager.setBounds(840, 50, 150, 16);

        btnPendingOrders.setBackground(new java.awt.Color(0, 102, 0));
        btnPendingOrders.setForeground(new java.awt.Color(255, 255, 255));
        btnPendingOrders.setText("Pending orders");
        btnPendingOrders.setBorder(null);
        btnPendingOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPendingOrdersActionPerformed(evt);
            }
        });
        jPanel1.add(btnPendingOrders);
        btnPendingOrders.setBounds(760, 200, 140, 32);

        btnListCustomers1.setBackground(new java.awt.Color(0, 102, 0));
        btnListCustomers1.setForeground(new java.awt.Color(255, 255, 255));
        btnListCustomers1.setText("Customer List");
        btnListCustomers1.setBorder(null);
        btnListCustomers1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListCustomers1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnListCustomers1);
        btnListCustomers1.setBounds(600, 200, 140, 32);

        btnAddProduct1.setBackground(new java.awt.Color(0, 102, 0));
        btnAddProduct1.setForeground(new java.awt.Color(255, 255, 255));
        btnAddProduct1.setText("Add Products");
        btnAddProduct1.setActionCommand("bruh");
        btnAddProduct1.setBorder(null);
        btnAddProduct1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProduct1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddProduct1);
        btnAddProduct1.setBounds(440, 200, 140, 32);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(300, 280, 660, 500);

        btnAddProduct3.setBackground(new java.awt.Color(0, 102, 0));
        btnAddProduct3.setForeground(new java.awt.Color(255, 255, 255));
        btnAddProduct3.setText("Inventory View");
        btnAddProduct3.setBorder(null);
        btnAddProduct3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProduct3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddProduct3);
        btnAddProduct3.setBounds(280, 200, 140, 32);

        jLabel1.setText("Change Price:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(300, 250, 80, 16);

        jTextField1.setText("Product ID");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(380, 250, 100, 22);
        jPanel1.add(jSpinner1);
        jSpinner1.setBounds(490, 250, 64, 22);

        jButton1.setText("Confirm");
        jPanel1.add(jButton1);
        jButton1.setBounds(570, 250, 110, 23);

        jButton2.setBackground(new java.awt.Color(0, 102, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("New Product");
        jPanel1.add(jButton2);
        jButton2.setBounds(760, 247, 140, 30);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProduct(evt);
            }
        });

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1000, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadData() {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        model.setRowCount(0);
        model.setColumnCount(0);
    
        // Add column headers
        model.addColumn("Product Code");
        model.addColumn("Product Brand");
        model.addColumn("Product Name");
        model.addColumn("Product Price");
        model.addColumn("Quantity");
    
        // Use try-with-resources to automatically close resources
        try (
            Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team015", "team015", "eSh7Shahk");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT product.product_code, product.brand_name, product.product_name, product.retail_price, inventory.quantity FROM product JOIN inventory ON product.product_code = inventory.product_code")
        ) {
            // Add rows to the model
            while (rs.next()) {
                Object[] row = new Object[5];
                row[0] = rs.getString("product_code");
                row[1] = rs.getString("brand_name");
                row[2] = rs.getString("product_name");
                row[3] = rs.getDouble("retail_price");
                row[4] = rs.getInt("quantity");
                model.addRow(row);
            }
    
            // Set the model to the existing JTable
            jTable1.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception (log or show an error message)
        }
    }
    

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        // log out
        Default DefaultFrame = new Default();
        DefaultFrame.setVisible(true);
        DefaultFrame.pack();
        DefaultFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagerActionPerformed
        ManagerDashboard ManagerDashboardFrame = new ManagerDashboard();
        ManagerDashboardFrame.setVisible(true);
        ManagerDashboardFrame.pack();
        ManagerDashboardFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnManagerActionPerformed

    private void btnPendingOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPendingOrdersActionPerformed
        // Just displays the orderline table
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);

        model.addColumn("Product Codes");
        model.addColumn("Quantity");
        model.addColumn("Linecost");
        model.addColumn("Order Number");

        try (
            Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team015", "team015", "eSh7Shahk");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM orderline WHERE linecost = 'CONFIRMED'")
        ){
            // Add rows to the model
            while (rs.next()) {
                Object[] row = new Object[4];
                row[0] = rs.getString("product_code");
                row[1] = rs.getInt("quantity");
                row[2] = rs.getDouble("linecost");
                row[3] = rs.getInt("order_number");
                model.addRow(row);
            }

            // Set the model to the existing JTable
            jTable1.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception (log or show an error message)
        }


    }//GEN-LAST:event_btnPendingOrdersActionPerformed

    private void btnListCustomers1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListCustomers1ActionPerformed
        // Code to list customers in a table
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);

        // Add column headers
        model.addColumn("User ID");
        model.addColumn("Forename");
        model.addColumn("Surname");
        model.addColumn("Email");
        model.addColumn("Role");

        try (
        Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team015", "team015", "eSh7Shahk");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "SELECT users.user_id, users.forename, users.surname, users.email, " +
            "roles.role_name " +
            "FROM users " +
            "JOIN roles ON users.user_id = roles.role_id " +
            "WHERE roles.role_name = 'customer'"
        )
        ) {
            // Add rows to the model
            while (rs.next()) {
                Object[] row = new Object[5];
                row[0] = rs.getString("user_id");
                row[1] = rs.getString("forename");
                row[2] = rs.getString("surname");
                row[3] = rs.getString("email");
                row[4] = rs.getString("role_name");
                model.addRow(row);
            }

            // Set the model to the existing JTable
            jTable1.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception (log or show an error message)
        }
        
    }//GEN-LAST:event_btnListCustomers1ActionPerformed

    private void btnAddProduct1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProduct1ActionPerformed
        // TODO add your handling code here:
        StockAdjust StockAdjustFrame = new StockAdjust();
        StockAdjustFrame.setVisible(true);
        StockAdjustFrame.pack();
        StockAdjustFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAddProduct1ActionPerformed

    private void btnAddProduct3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProduct3ActionPerformed
        // TODO add your handling code here:
        loadData();
    }//GEN-LAST:event_btnAddProduct3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

   private void newProduct(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProduct
       // TODO add your handling code here:
       NewProduct NewProductFrame = new NewProduct();
       NewProductFrame.setVisible(true);
       NewProductFrame.pack();
       NewProductFrame.setLocationRelativeTo(null);
   }//GEN-LAST:event_newProduct

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        // TODO add your handling code here:
        String productID = jTextField1.getText();
        int price = (int) jSpinner1.getValue();

            // Check if the productID is not empty
        if (productID.isEmpty()) {
            return;
        }

        String updateQuery = "UPDATE product SET retail_price = ? WHERE product_code = ?";
        
        try (
            Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team015", "team015", "eSh7Shahk");    
        ) {

            try (PreparedStatement pstmt = con.prepareStatement(updateQuery)) {
                // Set parameters for the prepared statement
                pstmt.setInt(1, price);  // Assuming quantity is a multiplier for the price
                pstmt.setString(2, productID);

                int rowsAffected = pstmt.executeUpdate();

                // Check if the update was successful
                if (rowsAffected > 0) {
                    System.out.println("Price updated successfully.");
                    loadData();
                } else {
                    System.out.println("Product not found or no rows affected.");
                }
            }
        } catch (SQLException e) {
            // Handle database-related exceptions (show an error message, log, etc.)
            e.printStackTrace();
        }

    }//GEN-LAST:event_confirmButtonActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();

    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnRecentOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecentOrdersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRecentOrdersActionPerformed

    private void btnMyDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyDetailsActionPerformed
        // Jump to My Details page:
        MyDetails MyDetailsFrame = new MyDetails();
        MyDetailsFrame.setVisible(true);
        MyDetailsFrame.pack();
        MyDetailsFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnMyDetailsActionPerformed

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduct1;
    private javax.swing.JButton btnAddProduct3;
    private javax.swing.JButton btnListCustomers1;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnManager;
    private javax.swing.JButton btnMyDetails;
    private javax.swing.JButton btnPendingOrders;
    private javax.swing.JButton btnRecentOrders;
    private javax.swing.JButton btnUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
