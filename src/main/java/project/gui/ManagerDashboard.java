/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project.gui;

import javax.swing.table.DefaultTableModel;

import project.model.user.Role;

import java.sql.*;

/**
 *
 * @author linyu
 */
public class ManagerDashboard extends javax.swing.JFrame {

    /**
     * Creates new form Default
     */
    public ManagerDashboard() {
        initComponents();
        loadManagerData();
    }

    private void loadManagerData(){
    DefaultTableModel model = new DefaultTableModel();
    
    // Add column headers
    model.addColumn("User ID");
    model.addColumn("Forename");
    model.addColumn("Surname");
    model.addColumn("Email");
    model.addColumn("Role");

    // Use try-with-resources to automatically close resources
    try (
        Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team015", "team015", "eSh7Shahk");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "SELECT users.user_id, users.forename, users.surname, users.email, " +
            "roles.role_name " +
            "FROM users " +
            "JOIN roles ON users.user_id = roles.role_id "
        )
    ) {
        // Add rows to the model
        while (rs.next()) {
            Object[] row = new Object[5];
            row[0] = rs.getString("user_id");
            row[1] = rs.getString("forename");
            row[2] = rs.getString("surname");
            row[3] = rs.getString("email");
            row[4] = rs.getString("role_name"); // Note: Make sure this matches the actual column name in the result set
            model.addRow(row);
        }

        // Set the model to the existing JTable
        jTable1.setModel(model);
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception (log or show an error message)
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnMyDetails = new javax.swing.JButton();
        btnRecentOrders = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnStaff = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        choice1 = new java.awt.Choice();
        label1 = new java.awt.Label();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();

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
        title.setText("Staff List");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(title)
                .addContainerGap(616, Short.MAX_VALUE))
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

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 126, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel5);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(320, 280, 630, 430);

        btnStaff.setBackground(new java.awt.Color(0, 102, 0));
        btnStaff.setForeground(new java.awt.Color(204, 204, 204));
        btnStaff.setText("Staff interface");
        btnStaff.setBorder(null);
        btnStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffActionPerformed(evt);
            }
        });
        jPanel1.add(btnStaff);
        btnStaff.setBounds(840, 10, 130, 16);

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
        btnUser.setBounds(840, 50, 150, 16);

        jTextField1.setText("User ID");
        jPanel1.add(jTextField1);
        jTextField1.setBounds(530, 720, 180, 22);
        jPanel1.add(choice1);
        choice1.setBounds(720, 720, 60, 20);

        label1.setText("Change User Role:");
        jPanel1.add(label1);
        label1.setBounds(420, 720, 110, 20);

        button1.setActionCommand("Confirm");
        button1.setBackground(new java.awt.Color(0, 102, 0));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setLabel("Confirm");
        jPanel1.add(button1);
        button1.setBounds(790, 720, 58, 24);

        button2.setActionCommand("Confirm");
        button2.setBackground(new java.awt.Color(0, 102, 0));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setLabel("All");
        jPanel1.add(button2);
        button2.setBounds(340, 250, 50, 20);

        button3.setActionCommand("Confirm");
        button3.setBackground(new java.awt.Color(0, 102, 0));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setLabel("Staff");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1(evt);
            }
        });
        jPanel1.add(button3);
        button3.setBounds(410, 250, 50, 20);

        button4.setActionCommand("Confirm");
        button4.setBackground(new java.awt.Color(0, 102, 0));
        button4.setForeground(new java.awt.Color(255, 255, 255));
        button4.setLabel("Managers");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1(evt);
            }
        });
        jPanel1.add(button4);
        button4.setBounds(480, 250, 60, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1000, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMyDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyDetailsActionPerformed
        // Jump to My Details page:
        MyDetails MyDetailsFrame = new MyDetails();
        MyDetailsFrame.setVisible(true);
        MyDetailsFrame.pack();
        MyDetailsFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnMyDetailsActionPerformed

    private void btnRecentOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecentOrdersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRecentOrdersActionPerformed

    private void btnStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffActionPerformed
        // log out
        StaffDashboard StaffDashboardFrame = new StaffDashboard();
        StaffDashboardFrame.setVisible(true);
        StaffDashboardFrame.pack();
        StaffDashboardFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnStaffActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        Default DefaultFrame = new Default();
        DefaultFrame.setVisible(true);
        DefaultFrame.pack();
        DefaultFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void button1(java.awt.event.ActionEvent evt) {                         
    // Get the selected role from choice1
    String selectedRole = choice1.getSelectedItem();

    // Get the user_id from the text area
    String userId = jTextField1.getText();

    // Validate user_id and selectedRole
    if (userId.isEmpty() || selectedRole == null || selectedRole.isEmpty()) {
        // Handle the case where user_id or selectedRole is empty
        // (show an error message, log, etc.)
        return;
    }

    // SQL query to update the role_id in the users table
    String updateQuery = "UPDATE roles SET role_name = ? WHERE role_id = ?";

    try (
        Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team015", "team015", "eSh7Shahk");
        PreparedStatement pstmt = con.prepareStatement(updateQuery);
    ) {
        // Set parameters for the prepared statement
        pstmt.setString(1, selectedRole);
        pstmt.setString(2, userId);

        // Execute the update
        int rowsAffected = pstmt.executeUpdate();

        // Check if the update was successful
        if (rowsAffected > 0) {
            // Reload manager data to update the table
            loadManagerData();
            System.out.println("User role updated successfully.");
        } else {
            System.out.println("Failed to update user role.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception (log or show an error message)
    }
}


    private void defaultTable(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultTable
        loadManagerData();
    }//GEN-LAST:event_defaultTable

    private void staffTable(java.awt.event.ActionEvent evt) {
        DefaultTableModel model = new DefaultTableModel();
        
        // Add column headers
        model.addColumn("User ID");
        model.addColumn("Forename");
        model.addColumn("Surname");
        model.addColumn("Email");
        model.addColumn("Role");
    
        // Use try-with-resources to automatically close resources
        try (
            Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team015", "team015", "eSh7Shahk");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                "SELECT users.user_id, users.forename, users.surname, users.email, " +
                "roles.role_name " +
                "FROM users " +
                "JOIN roles ON users.user_id = roles.role_id " +
                "WHERE roles.role_name = 'staff'"
            )
        ) {
            // Add rows to the model
            while (rs.next()) {
                Object[] row = new Object[5];
                row[0] = rs.getString("user_id");
                row[1] = rs.getString("forename");
                row[2] = rs.getString("surname");
                row[3] = rs.getString("email");
                row[4] = rs.getString("role_name"); // Note: Make sure this matches the actual column name in the result set
                model.addRow(row);
            }
    
            // Set the model to the existing JTable
            jTable1.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception (log or show an error message)
        }
    }
    
    

    private void managerTable(java.awt.event.ActionEvent evt) {                              
        DefaultTableModel model = new DefaultTableModel();
        
        // Add column headers
        model.addColumn("User ID");
        model.addColumn("Forename");
        model.addColumn("Surname");
        model.addColumn("Email");
        model.addColumn("Role");
    
        // Use try-with-resources to automatically close resources
        try (
            Connection con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team015", "team015", "eSh7Shahk");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                "SELECT users.user_id, users.forename, users.surname, users.email, " +
                "roles.role_name " +
                "FROM users " +
                "JOIN roles ON users.user_id = roles.role_id " +
                "WHERE roles.role_name = 'manager'"
            )
        ) {
            // Add rows to the model
            while (rs.next()) {
                Object[] row = new Object[5];
                row[0] = rs.getString("user_id");
                row[1] = rs.getString("forename");
                row[2] = rs.getString("surname");
                row[3] = rs.getString("email");
                row[4] = rs.getString("role_name"); // Note: Make sure this matches the actual column name in the result set
                model.addRow(row);
            }
    
            // Set the model to the existing JTable
            jTable1.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception (log or show an error message)
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnMyDetails;
    private javax.swing.JButton btnRecentOrders;
    private javax.swing.JButton btnStaff;
    private javax.swing.JButton btnUser;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private java.awt.Choice choice1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
