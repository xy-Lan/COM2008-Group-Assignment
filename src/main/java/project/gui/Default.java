/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project.gui;

import project.dao.*;
import project.daoimpl.*;
import project.model.product.*;
import project.model.product.abstractproduct.Product;
import project.model.user.User;
import project.service.MySqlService;
import project.service.OrderService;
import project.service.UserService;
import project.utils.UserSessionManager;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

/**
 *
 * @author linyu
 */
public class Default extends javax.swing.JFrame {

   private UserDao userDao = new UserDaoImpl();
    private UserService userService = new UserService(userDao);

    /**
     * Creates new form Default
     */
    public Default() {
        User user = UserSessionManager.getInstance().getLoggedInUser();
        System.out.println("User: " + UserSessionManager.getInstance().getLoggedInUser().toMap());

        initComponents();
        btnManagerDashboard.setVisible(false);
        btnStaffDashboard1.setVisible(false);
        if (userService.isUserManager(user.getUserID())){
            btnManagerDashboard.setVisible(true);
        }
        if (userService.isUserStaff(user.getUserID())) {
            btnStaffDashboard1.setVisible(true);
        }

        title.setText("Train Sets");
        TrainSetDao TrainSetDao = new TrainSetDaoImpl();
        List<TrainSet> allTrainSets = TrainSetDao.getAllTrainSets();
        loadProductsByType(allTrainSets);
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
        btnLogOut = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        scrollPanel = new javax.swing.JScrollPane();
        productContainer = new javax.swing.JPanel();
        btnManagerDashboard = new javax.swing.JButton();
        btnBasket = new javax.swing.JButton();
        btnStaffDashboard1 = new javax.swing.JButton();

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
        jLabel2.setBounds(279, 56, 310, 47);

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

        scrollPanel.setBackground(new java.awt.Color(255, 255, 255));
        scrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout productContainerLayout = new javax.swing.GroupLayout(productContainer);
        productContainer.setLayout(productContainerLayout);
        productContainerLayout.setHorizontalGroup(
            productContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
        );
        productContainerLayout.setVerticalGroup(
            productContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );

        scrollPanel.setViewportView(productContainer);

        jPanel1.add(scrollPanel);
        scrollPanel.setBounds(300, 220, 660, 450);

        btnManagerDashboard.setBackground(new java.awt.Color(0, 102, 0));
        btnManagerDashboard.setForeground(new java.awt.Color(204, 204, 204));
        btnManagerDashboard.setText("Manager interface");
        btnManagerDashboard.setBorder(null);
        btnManagerDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagerDashboardActionPerformed(evt);
            }
        });
        jPanel1.add(btnManagerDashboard);
        btnManagerDashboard.setBounds(840, 50, 150, 17);

        btnBasket.setBackground(new java.awt.Color(0, 102, 0));
        btnBasket.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        btnBasket.setForeground(new java.awt.Color(255, 255, 255));
        btnBasket.setText("Go to basket");
        btnBasket.setBorder(null);
        btnBasket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBasketActionPerformed(evt);
            }
        });
        jPanel1.add(btnBasket);
        btnBasket.setBounds(790, 680, 170, 40);

        btnStaffDashboard1.setBackground(new java.awt.Color(0, 102, 0));
        btnStaffDashboard1.setForeground(new java.awt.Color(204, 204, 204));
        btnStaffDashboard1.setText("Staff interface");
        btnStaffDashboard1.setBorder(null);
        btnStaffDashboard1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffDashboard1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnStaffDashboard1);
        btnStaffDashboard1.setBounds(840, 10, 130, 17);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1000, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrackPacksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrackPacksActionPerformed
        title.setText("Track Packs");
        TrackPackDao TrackPackDao = new TrackPackDaoImpl();
        List<TrackPack> allTrackPacks = TrackPackDao.getAllTrackPacks();
        loadProductsByType(allTrackPacks);
    }//GEN-LAST:event_btnTrackPacksActionPerformed

    private void btnLocomotivesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocomotivesActionPerformed
        title.setText("Locomotives");
        LocomotiveDao LocomotiveDao = new LocomotiveDaoImpl();
        List<Locomotive> allLocomotives = LocomotiveDao.getAllLocomotives();
        loadProductsByType(allLocomotives);

    }//GEN-LAST:event_btnLocomotivesActionPerformed

    private void btnTrainSetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrainSetsActionPerformed
        title.setText("Train Sets");
        TrainSetDao TrainSetDao = new TrainSetDaoImpl();
        List<TrainSet> allTrainSets = TrainSetDao.getAllTrainSets();
        loadProductsByType(allTrainSets);
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
        RecentOrders RecentOrdersFrame = new RecentOrders();
        RecentOrdersFrame.setVisible(true);
        RecentOrdersFrame.pack();
        RecentOrdersFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnRecentOrdersActionPerformed

    private void btnControllersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControllersActionPerformed
        title.setText("Controllers");
        ControllerDao ControllerDao = new ControllerDaoImpl();
        List<Controller> allControllers = ControllerDao.getAllControllers();
        loadProductsByType(allControllers);
    }//GEN-LAST:event_btnControllersActionPerformed

    private void btnTrackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrackActionPerformed
        title.setText("Track");
        TrackDao TrackDao = new TrackDaoImpl();
        List<Track> allTracks = TrackDao.getAllTracks();
        loadProductsByType(allTracks);
    }//GEN-LAST:event_btnTrackActionPerformed

    private void btnRollingStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRollingStockActionPerformed
        title.setText("Rolling Stock");
        RollingStockDao rollingStockDao = new RollingStockDaoImpl();
        List<RollingStock> allRollingStocks = rollingStockDao.getAllRollingStock();
        loadProductsByType(allRollingStocks);
    }//GEN-LAST:event_btnRollingStockActionPerformed

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

    private void btnBasketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBasketActionPerformed
        OrderLines OrderLinesFrame = new OrderLines();
        OrderLinesFrame.setVisible(true);
        OrderLinesFrame.pack();
        OrderLinesFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnBasketActionPerformed

    private void btnStaffDashboard1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffDashboard1ActionPerformed
        Staff StaffFrame = new Staff();
        StaffFrame.setVisible(true);
        StaffFrame.pack();
        StaffFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnStaffDashboard1ActionPerformed


    private void loadProductsByType(List<? extends Product> allProducts) {
        //TODO
        productContainer.removeAll();
        //List all the products
        productContainer.setLayout(new BoxLayout(productContainer, BoxLayout.Y_AXIS));
        productContainer.add(Box.createVerticalStrut(15));
        for (Product product : allProducts) {
            // Add a productPanel for every train set
            JPanel productPanel = new JPanel();
            productPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.insets = new Insets(10,20,10,20);
            InventoryDao inventoryDao = new InventoryDaoImpl();


            JLabel lblName = new JLabel(product.getProductName());
            JLabel lblPrice = new JLabel("Price: " + " £" + product.getRetailPrice() );
            JLabel defaultImage = new JLabel();
            JButton btnViewDetails = new JButton("View details");
            JButton btnAddOrderLine = new JButton("Add to basket");
            JSpinner quantityVal = new JSpinner();
            quantityVal.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
            //Set layout
            productPanel.setBackground(new java.awt.Color(24, 150, 62));

            lblName.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
            lblName.setForeground(new java.awt.Color(255, 255, 255));

            btnViewDetails.setText("View details");

            lblPrice.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
            lblPrice.setForeground(new java.awt.Color(255, 255, 255));

//            URL imageUrl = Thread.currentThread().getContextClassLoader().getResource("/images/train_sets.jpg");
//            ImageIcon imageIcon = new ImageIcon(imageUrl);
//
//            defaultImage.setIcon(imageIcon); // NOI18N

            productPanel.add(defaultImage, gbc);
            productPanel.add(lblName, gbc);
            productPanel.add(lblPrice, gbc);
            if (inventoryDao.getStock(product.getProductCode()).intValue() == 0){
                JLabel lblStock = new JLabel();
                lblStock.setText("Out of Stock!");
                lblStock.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 19)); // NOI18N
                lblStock.setForeground(new java.awt.Color(208, 36, 36));
                productPanel.add(lblStock, gbc);
            }
            productPanel.add(btnViewDetails, gbc);
            productPanel.add(quantityVal, gbc);
            productPanel.add(btnAddOrderLine, gbc);


            btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    viewProductDetails(product);
                }
            });

            btnAddOrderLine.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    int quantity = (Integer) quantityVal.getValue();
                    User currentUser = UserSessionManager.getInstance().getLoggedInUser();
                    OrderDao orderDao = new OrderDaoImpl();
                    OrderService OrderService = new OrderService(orderDao);
                    InventoryDao inventoryDao = new InventoryDaoImpl();
                    int stock = inventoryDao.getStock(product.getProductCode());

                    if ( quantity > stock) {
                        JOptionPane.showMessageDialog(null, "The quantity selected exceeds the stock available! Please reduce the purchase quantity",
                                "Out of stock", WARNING_MESSAGE);
                    } else {
                        OrderService.addToBasket(currentUser.getUserID(), product.getProductCode(), quantity);
                        JOptionPane.showMessageDialog(null, "Product successfully added! Please check your basket!",
                                "Product Added", INFORMATION_MESSAGE);
                    }
                }
            });

            // Add the productPanel to the productContainer
//            javax.swing.GroupLayout productContainerLayout = new javax.swing.GroupLayout(productContainer);
//            productContainerLayout.setHorizontalGroup(
//                    productContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addGroup(productContainerLayout.createSequentialGroup()
//                                    .addGap(21, 21, 21)
//                                    .addComponent(productPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                    .addContainerGap(70, Short.MAX_VALUE))
//            );
//            productContainerLayout.setVerticalGroup(
//                    productContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addGroup(productContainerLayout.createSequentialGroup()
//                                    .addGap(27, 27, 27)
//                                    .addComponent(productPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                    .addContainerGap(401, Short.MAX_VALUE))
//            );
            productContainer.add(productPanel);
            productContainer.add(Box.createVerticalStrut(20));
        }
        //Refresh to update the panel
        productContainer.revalidate();
        productContainer.repaint();
    }

    private void viewProductDetails(Product product){
//        new ProductDetails(productCode, price);
        ProductDetails ProductDetailsFrame = new ProductDetails(product);
        ProductDetailsFrame.setVisible(true);
        ProductDetailsFrame.pack();
        ProductDetailsFrame.setLocationRelativeTo(null);
        this.dispose();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBasket;
    private javax.swing.JButton btnControllers;
    private javax.swing.JButton btnLocomotives;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnManagerDashboard;
    private javax.swing.JButton btnMyDetails;
    private javax.swing.JButton btnRecentOrders;
    private javax.swing.JButton btnRollingStock;
    private javax.swing.JButton btnStaffDashboard1;
    private javax.swing.JButton btnTrack;
    private javax.swing.JButton btnTrackPacks;
    private javax.swing.JButton btnTrainSets;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPanel productContainer;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
