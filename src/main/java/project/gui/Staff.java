/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project.gui;

import project.dao.*;
import project.daoimpl.*;
import project.model.order.Order;
import project.model.product.*;
import project.model.product.abstractproduct.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author linyu
 */
public class Staff extends javax.swing.JFrame {
//    private ButtonCell buttonCell = new ButtonCell();

    /**
     * Creates new form Default
     */
    public Staff() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnLoadConfirmedOrders = new javax.swing.JButton();
        btnLoadAllOrders = new javax.swing.JButton();
        btnTrackPack = new javax.swing.JButton();
        btnNewProduct = new javax.swing.JButton();
        btnTrainSets = new javax.swing.JButton();
        btnTrack = new javax.swing.JButton();
        btnLocomotives = new javax.swing.JButton();
        btnRollingStock = new javax.swing.JButton();
        btnController = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Category");
        setPreferredSize(new java.awt.Dimension(1000, 800));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 800));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 800));

        btnBack.setBackground(new java.awt.Color(0, 102, 0));
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(492, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 120, 800);

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("Staff Dashboard");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(140, 60, 350, 47);

        jPanel3.setBackground(new java.awt.Color(0, 102, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(120, 120, 880, 70);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnLoadConfirmedOrders.setBackground(new java.awt.Color(0, 102, 0));
        btnLoadConfirmedOrders.setForeground(new java.awt.Color(255, 255, 255));
        btnLoadConfirmedOrders.setText("List confirmed orders");
        btnLoadConfirmedOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadConfirmedOrdersActionPerformed(evt);
            }
        });

        btnLoadAllOrders.setBackground(new java.awt.Color(0, 102, 0));
        btnLoadAllOrders.setForeground(new java.awt.Color(255, 255, 255));
        btnLoadAllOrders.setText("List all orders");
        btnLoadAllOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadAllOrdersActionPerformed(evt);
            }
        });

        btnTrackPack.setBackground(new java.awt.Color(0, 204, 102));
        btnTrackPack.setText("List track packs");
        btnTrackPack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrackPackActionPerformed(evt);
            }
        });

        btnNewProduct.setBackground(new java.awt.Color(0, 102, 0));
        btnNewProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnNewProduct.setText("Add a product");
        btnNewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProductActionPerformed(evt);
            }
        });

        btnTrainSets.setBackground(new java.awt.Color(0, 204, 102));
        btnTrainSets.setText("List train sets");
        btnTrainSets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrainSetsActionPerformed(evt);
            }
        });

        btnTrack.setBackground(new java.awt.Color(0, 204, 102));
        btnTrack.setText("List track");
        btnTrack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrackActionPerformed(evt);
            }
        });

        btnLocomotives.setBackground(new java.awt.Color(0, 204, 102));
        btnLocomotives.setText("List Locomotives");
        btnLocomotives.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocomotivesActionPerformed(evt);
            }
        });

        btnRollingStock.setBackground(new java.awt.Color(0, 204, 102));
        btnRollingStock.setText("List rolling stocks");
        btnRollingStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRollingStockActionPerformed(evt);
            }
        });

        btnController.setBackground(new java.awt.Color(0, 204, 102));
        btnController.setText("List controllers");
        btnController.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControllerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(btnTrainSets, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTrackPack, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnTrack, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnLocomotives, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(btnLoadAllOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btnLoadConfirmedOrders)
                                .addGap(38, 38, 38)
                                .addComponent(btnNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRollingStock)
                        .addGap(11, 11, 11)
                        .addComponent(btnController, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadAllOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadConfirmedOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNewProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTrackPack, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrainSets, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrack, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocomotives, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRollingStock, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnController, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(120, 190, 880, 610);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1000, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrackPackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrackPackActionPerformed
        // TODO add your handling code here:
        TrackPackDao TrackPackDao = new TrackPackDaoImpl();
        List<TrackPack> allTrackPacks = TrackPackDao.getAllTrackPacks();
        loadProductTabelByTable(allTrackPacks);
    }//GEN-LAST:event_btnTrackPackActionPerformed

    private void btnLoadAllOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadAllOrdersActionPerformed
        // TODO add your handling code here:
        loadAllOrderTable();
    }//GEN-LAST:event_btnLoadAllOrdersActionPerformed

    private void btnLoadConfirmedOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadConfirmedOrdersActionPerformed
        // TODO add your handling code here:
        loadConfirmedOrderTable();
    }//GEN-LAST:event_btnLoadConfirmedOrdersActionPerformed

    private void btnNewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProductActionPerformed
       NewProduct NewProductFrame = new NewProduct();
       NewProductFrame.setVisible(true);
       NewProductFrame.pack();
       NewProductFrame.setLocationRelativeTo(null); 
    }//GEN-LAST:event_btnNewProductActionPerformed

    private void btnTrainSetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrainSetsActionPerformed
        TrainSetDao TrainSetDao = new TrainSetDaoImpl();
        List<TrainSet> allTrainSets = TrainSetDao.getAllTrainSets();
        loadProductTabelByTable(allTrainSets);
    }//GEN-LAST:event_btnTrainSetsActionPerformed

    private void btnTrackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrackActionPerformed
        // TODO add your handling code here:
        TrackDao TrackDao = new TrackDaoImpl();
        List<Track> allTracks = TrackDao.getAllTracks();
        loadProductTabelByTable(allTracks);
    }//GEN-LAST:event_btnTrackActionPerformed

    private void btnLocomotivesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocomotivesActionPerformed
        // TODO add your handling code here:
        LocomotiveDao LocomotiveDao = new LocomotiveDaoImpl();
        List<Locomotive> allLocomotives = LocomotiveDao.getAllLocomotives();
        loadProductTabelByTable(allLocomotives);
    }//GEN-LAST:event_btnLocomotivesActionPerformed

    private void btnRollingStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRollingStockActionPerformed
        // TODO add your handling code here:
        RollingStockDao rollingStockDao = new RollingStockDaoImpl();
        List<RollingStock> allRollingStocks = rollingStockDao.getAllRollingStock();
        loadProductTabelByTable(allRollingStocks);
    }//GEN-LAST:event_btnRollingStockActionPerformed

    private void btnControllerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControllerActionPerformed
        // TODO add your handling code here:
        ControllerDao ControllerDao = new ControllerDaoImpl();
        List<Controller> allControllers = ControllerDao.getAllControllers();
        loadProductTabelByTable(allControllers);
    }//GEN-LAST:event_btnControllerActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Default DefaultFrame = new Default();
            DefaultFrame.setVisible(true);
            DefaultFrame.pack();
            DefaultFrame.setLocationRelativeTo(null);
            
            DefaultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void loadProductTabelByTable(List<? extends Product> allProducts) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        model.setRowCount(0);
        model.setColumnCount(0);

        // Add column headers
        model.addColumn("Code");
        model.addColumn("Name");
        model.addColumn("Brand");
        model.addColumn("Price");
        model.addColumn("Gauge Type");
        model.addColumn("Quantity");
        model.addColumn("Edit");



        //Get all the products
        InventoryDao inventoryDao = new InventoryDaoImpl();

        for (Product product : allProducts){
            //Add rows to the model
            Object[] row = new Object[7];
            JButton editProduct = new JButton();
            editProduct.setText("Edit");
            row[0] = product.getProductCode();
            row[1] = product.getProductName();
            row[2] = product.getBrandName();
            row[3] = product.getRetailPrice();
            row[4] = product.getGaugeType();
            row[5] = inventoryDao.getStock(product.getProductCode());
            row[6] = editProduct;
            model.addRow(row);
        }
        jTable1.setModel(model);
        ButtonCell buttonCell = new ButtonCell();
        jTable1.getColumn("Edit").setCellRenderer(buttonCell);
        jTable1.getColumn("Edit").setCellEditor(buttonCell);
    }

    private void loadAllOrderTable(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        model.setRowCount(0);
        model.setColumnCount(0);

        // Add column headers
        model.addColumn("Order Number");
        model.addColumn("Date");
        model.addColumn("User ID");
        model.addColumn("Status");
        model.addColumn("Fulfil");
        model.addColumn("Refuse");

        //Get all the products
        OrderDao orderDao = new OrderDaoImpl();
        List<Order> allOrders = orderDao.getAllOrders();

        for (Order order : allOrders){
//            System.out.println("Order: " + order.getDate() + order.getOrderNumber());
            //Add rows to the model
            Object[] row = new Object[6];
            JButton btnFulfil = new JButton();
            btnFulfil.setText("Fulfil");
            JButton btnRefuse = new JButton();
            btnRefuse.setText("Refuse");
            row[0] = order.getOrderNumber();
            row[1] = order.getDate();
            row[2] = order.getUser().getUserID();
            row[3] = order.getOrderStatus();
            row[4] = btnFulfil;
            row[5] = btnRefuse;
            model.addRow(row);
        }
        jTable1.setModel(model);
        ButtonCell buttonCell = new ButtonCell();
        jTable1.getColumn("Fulfil").setCellRenderer(buttonCell);
        jTable1.getColumn("Fulfil").setCellEditor(buttonCell);
        jTable1.getColumn("Refuse").setCellRenderer(buttonCell);
        jTable1.getColumn("Refuse").setCellEditor(buttonCell);
    }

    private void loadConfirmedOrderTable(){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        model.setRowCount(0);
        model.setColumnCount(0);

        // Add column headers
        model.addColumn("Order Number");
        model.addColumn("Date");
        model.addColumn("User ID");
        model.addColumn("Status");
        model.addColumn("Fulfil");
        model.addColumn("Refuse");



        //Get all the products
        OrderDao orderDao = new OrderDaoImpl();
        List<Order> allOrders = orderDao.getConfirmedOrder();

        for (Order order : allOrders){
            //Add rows to the model
            Object[] row = new Object[6];
            JButton btnFulfil = new JButton();
            btnFulfil.setText("Fulfil");
            JButton btnRefuse = new JButton();
            btnRefuse.setText("Refuse");
            row[0] = order.getOrderNumber();
            row[1] = order.getDate();
            row[2] = order.getUser().getUserID();
            row[3] = order.getOrderStatus();
            row[4] = btnFulfil;
            row[5] = btnRefuse;
            model.addRow(row);
        }
        jTable1.setModel(model);
        ButtonCell buttonCell = new ButtonCell();
        jTable1.getColumn("Fulfil").setCellRenderer(buttonCell);
        jTable1.getColumn("Fulfil").setCellEditor(buttonCell);
        jTable1.getColumn("Refuse").setCellRenderer(buttonCell);
        jTable1.getColumn("Refuse").setCellEditor(buttonCell);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnController;
    private javax.swing.JButton btnLoadAllOrders;
    private javax.swing.JButton btnLoadConfirmedOrders;
    private javax.swing.JButton btnLocomotives;
    private javax.swing.JButton btnNewProduct;
    private javax.swing.JButton btnRollingStock;
    private javax.swing.JButton btnTrack;
    private javax.swing.JButton btnTrackPack;
    private javax.swing.JButton btnTrainSets;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
