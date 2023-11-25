
package project.gui;
import project.dao.*;
import project.daoimpl.*;
import project.model.order.Order;
import project.model.order.OrderLine;
import project.model.product.*;
import project.model.user.User;
import project.service.MysqlService;
import project.utils.UserSessionManager;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author linyu
 */
public class ProductDetails extends javax.swing.JFrame {

    /**
     * Creates new form Default
     */
    private String productCode;
    private BigDecimal price;

    public ProductDetails(String productCode, BigDecimal price) {
        this.productCode = productCode;
        this.price = price;
        initComponents();
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
        btnTrainSets = new javax.swing.JButton();
        btnTrackPacks = new javax.swing.JButton();
        btnLocomotives = new javax.swing.JButton();
        btnTrack = new javax.swing.JButton();
        btnRollingStock = new javax.swing.JButton();
        btnControllers = new javax.swing.JButton();
        btnMyDetails = new javax.swing.JButton();
        btnRecentOrders = new javax.swing.JButton();
        btnLogOut2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        btnLogOut1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAddOrderLine = new javax.swing.JButton();
        quantityVal = new javax.swing.JSpinner();

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

        btnLogOut2.setBackground(new java.awt.Color(0, 102, 0));
        btnLogOut2.setForeground(new java.awt.Color(204, 204, 204));
        btnLogOut2.setText("Log out");
        btnLogOut2.setBorder(null);
        btnLogOut2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOut2ActionPerformed(evt);
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
                                .addComponent(btnLogOut2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(btnLogOut2)
                .addGap(61, 61, 61))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 250, 800);

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("Train sets");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(279, 56, 186, 43);

        jPanel3.setBackground(new java.awt.Color(0, 102, 0));

        title.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Product name");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(title)
                .addContainerGap(553, Short.MAX_VALUE))
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

        btnLogOut.setBackground(new java.awt.Color(0, 102, 0));
        btnLogOut.setForeground(new java.awt.Color(204, 204, 204));
        btnLogOut.setText("Staff interface");
        btnLogOut.setBorder(null);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogOut);
        btnLogOut.setBounds(840, 10, 130, 17);

        btnLogOut1.setBackground(new java.awt.Color(0, 102, 0));
        btnLogOut1.setForeground(new java.awt.Color(204, 204, 204));
        btnLogOut1.setText("Manager interface");
        btnLogOut1.setBorder(null);
        btnLogOut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOut1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogOut1);
        btnLogOut1.setBounds(840, 50, 150, 17);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(270, 210, 240, 160);

        jLabel3.setText("Name");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(630, 230, 34, 17);

        jLabel4.setText("Brand");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(630, 260, 41, 17);

        jLabel5.setText("Type");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(630, 290, 29, 17);

        btnAddOrderLine.setBackground(new java.awt.Color(0, 102, 0));
        btnAddOrderLine.setForeground(new java.awt.Color(255, 255, 255));
        btnAddOrderLine.setText("Add to basket");
        btnAddOrderLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrderLineActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddOrderLine);
        btnAddOrderLine.setBounds(770, 610, 140, 60);
        jPanel1.add(quantityVal);
        quantityVal.setBounds(780, 560, 110, 30);

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

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // log out
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnLogOut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOut1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogOut1ActionPerformed

    private void btnLogOut2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOut2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogOut2ActionPerformed

    private void btnAddOrderLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrderLineActionPerformed
        //Add a product to orderline
        int quantity = (Integer) quantityVal.getValue();
        User currentUser = UserSessionManager.getInstance().getLoggedInUser();
        // TODO If there is already a order, then just add a orderline
        Order order = new Order(currentUser);
        OrderLine orderLine = new OrderLine(productCode, quantity, price, order.getOrderNumber());
        MysqlService mysqlService = new MysqlService();
        OrderDao orderDao = new OrderDaoImpl(mysqlService);
        orderDao.addOrderLine(orderLine);
    }//GEN-LAST:event_btnAddOrderLineActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddOrderLine;
    private javax.swing.JButton btnControllers;
    private javax.swing.JButton btnLocomotives;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnLogOut1;
    private javax.swing.JButton btnLogOut2;
    private javax.swing.JButton btnMyDetails;
    private javax.swing.JButton btnRecentOrders;
    private javax.swing.JButton btnRollingStock;
    private javax.swing.JButton btnTrack;
    private javax.swing.JButton btnTrackPacks;
    private javax.swing.JButton btnTrainSets;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JSpinner quantityVal;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
