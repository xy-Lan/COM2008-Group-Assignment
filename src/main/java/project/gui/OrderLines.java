
package project.gui;


import project.dao.OrderDao;
import project.daoimpl.OrderDaoImpl;
import project.model.order.Order;
import project.model.product.*;
import project.model.user.User;
import project.service.MysqlService;
import project.utils.UserSessionManager;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author linyu
 */
public class OrderLines extends javax.swing.JFrame {

    /**
     * Creates new form Default
     */
    public OrderLines() {
        initComponents();
        loadPendingOrders();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        orderContainer = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        btnCheckOut = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        jPopupMenu1.setPreferredSize(new java.awt.Dimension(20, 50));

        jMenuItem1.setText("jMenuItem1");
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Category");
        setPreferredSize(new java.awt.Dimension(440, 640));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 300));
        jPanel1.setLayout(null);

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout orderContainerLayout = new javax.swing.GroupLayout(orderContainer);
        orderContainer.setLayout(orderContainerLayout);
        orderContainerLayout.setHorizontalGroup(
            orderContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 668, Short.MAX_VALUE)
        );
        orderContainerLayout.setVerticalGroup(
            orderContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(orderContainer);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(30, 90, 370, 430);

        title.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Basket");
        jPanel1.add(title);
        title.setBounds(40, 20, 130, 50);

        btnCheckOut.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        btnCheckOut.setText("Check out");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });
        jPanel1.add(btnCheckOut);
        btnCheckOut.setBounds(230, 550, 130, 50);

        btnBack.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack);
        btnBack.setBounds(70, 550, 90, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 440, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        CheckOut CheckOutFrame = new CheckOut();
        CheckOutFrame.setVisible(true);
        CheckOutFrame.pack();
        CheckOutFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCheckOutActionPerformed

    private void loadPendingOrders(){
        User currentUser = UserSessionManager.getInstance().getLoggedInUser();
        MysqlService mysqlService = new MysqlService();
        OrderDao orderDao = new OrderDaoImpl(mysqlService);
        Optional<Order> optionalOrder = orderDao.getPendingOrderByUserId(currentUser.getUserID());
        //List all the pending orders and set the layout of the order panel
        orderContainer.removeAll();
        orderContainer.setLayout(new BoxLayout(orderContainer, BoxLayout.Y_AXIS));
        orderContainer.add(Box.createVerticalStrut(15));
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel orderContainer;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
