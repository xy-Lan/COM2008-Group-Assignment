/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project.gui;

import project.utils.UserSessionManager;

/**
 *
 * @author linyu
 */
public class Default extends javax.swing.JFrame {

    /**
     * Creates new form Default
     */
    public Default() {
        System.out.println("User: " + UserSessionManager.getInstance().getLoggedInUser().toMap());
        initComponents();
    }
    
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnTrainSets = new javax.swing.JButton();
        btnTrackPacks = new javax.swing.JButton();
        btnLocomotives = new javax.swing.JButton();
        btnTrack = new javax.swing.JButton();
        btnRollingStock = new javax.swing.JButton();
        btnControllers = new javax.swing.JButton();
        btnMyDetails = new javax.swing.JButton();
        btnRecentOrders = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnStaffDashboard = new javax.swing.JButton();
        btnManagerDashboard = new javax.swing.JButton();

        jPopupMenu1.setPreferredSize(new java.awt.Dimension(20, 50));

        jMenuItem1.setIcon(new javax.swing.ImageIcon("D:\\COM2008-Group-Assignment\\src\\resources\\images\\4105931-add-to-cart-buy-cart-sell-shop-shopping-cart_113919.png")); // NOI18N
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

        btnTrainSets.setBackground(new java.awt.Color(0, 102, 0));
        btnTrainSets.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        btnTrainSets.setForeground(new java.awt.Color(255, 255, 255));
        btnTrainSets.setText("Train Sets");
        btnTrainSets.setBorder(null);
        btnTrainSets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrainSetsActionPerformed(evt);
            }
        });

        btnTrackPacks.setBackground(new java.awt.Color(0, 102, 0));
        btnTrackPacks.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        btnTrackPacks.setForeground(new java.awt.Color(255, 255, 255));
        btnTrackPacks.setText("Track Packs");
        btnTrackPacks.setBorder(null);
        btnTrackPacks.setBorderPainted(false);
        btnTrackPacks.setFocusPainted(false);
        btnTrackPacks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrackPacksActionPerformed(evt);
            }
        });

        btnLocomotives.setBackground(new java.awt.Color(0, 102, 0));
        btnLocomotives.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        btnLocomotives.setForeground(new java.awt.Color(255, 255, 255));
        btnLocomotives.setText("Locomotives");
        btnLocomotives.setBorder(null);
        btnLocomotives.setBorderPainted(false);
        btnLocomotives.setFocusPainted(false);
        btnLocomotives.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocomotivesActionPerformed(evt);
            }
        });

        btnTrack.setBackground(new java.awt.Color(0, 102, 0));
        btnTrack.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        btnTrack.setForeground(new java.awt.Color(255, 255, 255));
        btnTrack.setText("Track");
        btnTrack.setBorder(null);
        btnTrack.setBorderPainted(false);
        btnTrack.setFocusPainted(false);
        btnTrack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrackActionPerformed(evt);
            }
        });

        btnRollingStock.setBackground(new java.awt.Color(0, 102, 0));
        btnRollingStock.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        btnRollingStock.setForeground(new java.awt.Color(255, 255, 255));
        btnRollingStock.setText("Rolling Stock");
        btnRollingStock.setBorder(null);
        btnRollingStock.setBorderPainted(false);
        btnRollingStock.setFocusPainted(false);
        btnRollingStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRollingStockActionPerformed(evt);
            }
        });

        btnControllers.setBackground(new java.awt.Color(0, 102, 0));
        btnControllers.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        btnControllers.setForeground(new java.awt.Color(255, 255, 255));
        btnControllers.setText("Controllers");
        btnControllers.setBorder(null);
        btnControllers.setBorderPainted(false);
        btnControllers.setFocusPainted(false);
        btnControllers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControllersActionPerformed(evt);
            }
        });

        btnMyDetails.setBackground(new java.awt.Color(0, 102, 0));
        btnMyDetails.setForeground(new java.awt.Color(204, 204, 204));
        btnMyDetails.setIcon(new javax.swing.ImageIcon("D:\\COM2008-Group-Assignment\\src\\resources\\images\\user_icon_149851.png")); // NOI18N
        btnMyDetails.setText("My Details");
        btnMyDetails.setBorder(null);
        btnMyDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyDetailsActionPerformed(evt);
            }
        });

        btnRecentOrders.setBackground(new java.awt.Color(0, 102, 0));
        btnRecentOrders.setForeground(new java.awt.Color(204, 204, 204));
        btnRecentOrders.setIcon(new javax.swing.ImageIcon("D:\\COM2008-Group-Assignment\\src\\resources\\images\\process_events_icon_149896.png")); // NOI18N
        btnRecentOrders.setText("Recent Orders");
        btnRecentOrders.setBorder(null);
        btnRecentOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecentOrdersActionPerformed(evt);
            }
        });

        btnLogOut.setBackground(new java.awt.Color(0, 102, 0));
        btnLogOut.setForeground(new java.awt.Color(204, 204, 204));
        btnLogOut.setIcon(new javax.swing.ImageIcon("D:\\COM2008-Group-Assignment\\src\\resources\\images\\process_events_icon_149896.png")); // NOI18N
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
                    .addComponent(btnTrainSets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLocomotives, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTrackPacks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRollingStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(btnTrack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnControllers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnMyDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecentOrders)
                .addGap(155, 155, 155)
                .addComponent(btnTrainSets, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTrackPacks, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLocomotives, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRollingStock, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTrack, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnControllers, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                .addComponent(btnLogOut)
                .addGap(61, 61, 61))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 250, 800);

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("Categories");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(279, 56, 192, 47);

        jPanel3.setBackground(new java.awt.Color(0, 102, 0));

        title.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Train Sets");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(title)
                .addContainerGap(601, Short.MAX_VALUE))
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

        jPanel6.setBackground(new java.awt.Color(24, 150, 62));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(401, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel5);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(320, 280, 630, 500);

        btnStaffDashboard.setBackground(new java.awt.Color(0, 102, 0));
        btnStaffDashboard.setForeground(new java.awt.Color(204, 204, 204));
        btnStaffDashboard.setIcon(new javax.swing.ImageIcon("D:\\COM2008-Group-Assignment\\src\\resources\\images\\process_events_icon_149896.png")); // NOI18N
        btnStaffDashboard.setText("Staff interface");
        btnStaffDashboard.setBorder(null);
        btnStaffDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffDashboardActionPerformed(evt);
            }
        });
        jPanel1.add(btnStaffDashboard);
        btnStaffDashboard.setBounds(840, 10, 130, 32);

        btnManagerDashboard.setBackground(new java.awt.Color(0, 102, 0));
        btnManagerDashboard.setForeground(new java.awt.Color(204, 204, 204));
        btnManagerDashboard.setIcon(new javax.swing.ImageIcon("D:\\COM2008-Group-Assignment\\src\\resources\\images\\process_events_icon_149896.png")); // NOI18N
        btnManagerDashboard.setText("Manager interface");
        btnManagerDashboard.setBorder(null);
        btnManagerDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagerDashboardActionPerformed(evt);
            }
        });
        jPanel1.add(btnManagerDashboard);
        btnManagerDashboard.setBounds(840, 50, 150, 32);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1000, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrackPacksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrackPacksActionPerformed
        title.setText("Track Packs");
    }//GEN-LAST:event_btnTrackPacksActionPerformed

    private void btnLocomotivesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocomotivesActionPerformed
        title.setText("Locomotives");
    }//GEN-LAST:event_btnLocomotivesActionPerformed

    private void btnTrainSetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrainSetsActionPerformed
        title.setText("Train Sets");
    }//GEN-LAST:event_btnTrainSetsActionPerformed

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

    private void btnControllersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControllersActionPerformed
        title.setText("Controllers");
    }//GEN-LAST:event_btnControllersActionPerformed

    private void btnTrackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrackActionPerformed
        title.setText("Track");
    }//GEN-LAST:event_btnTrackActionPerformed

    private void btnRollingStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRollingStockActionPerformed
        title.setText("Rolling Stock");
    }//GEN-LAST:event_btnRollingStockActionPerformed

    private void btnStaffDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffDashboardActionPerformed
        // log out
        StaffDashboard StaffDashboardFrame = new StaffDashboard();
        StaffDashboardFrame.setVisible(true);
        StaffDashboardFrame.pack();
        StaffDashboardFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnStaffDashboardActionPerformed

    private void btnManagerDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagerDashboardActionPerformed
        ManagerDashboard ManagerDashboardFrame = new ManagerDashboard();
        ManagerDashboardFrame.setVisible(true);
        ManagerDashboardFrame.pack();
        ManagerDashboardFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnManagerDashboardActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnControllers;
    private javax.swing.JButton btnLocomotives;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnManagerDashboard;
    private javax.swing.JButton btnMyDetails;
    private javax.swing.JButton btnRecentOrders;
    private javax.swing.JButton btnRollingStock;
    private javax.swing.JButton btnStaffDashboard;
    private javax.swing.JButton btnTrack;
    private javax.swing.JButton btnTrackPacks;
    private javax.swing.JButton btnTrainSets;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
