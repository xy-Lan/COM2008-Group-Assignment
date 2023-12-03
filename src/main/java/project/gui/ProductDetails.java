
package project.gui;
import project.dao.*;
import project.daoimpl.*;
import project.model.order.Order;
import project.model.order.OrderLine;
import project.model.product.*;
import project.model.product.abstractproduct.Part;
import project.model.product.abstractproduct.Product;
import project.model.product.association.PartBoxedSetAssociation;
import project.model.user.User;
import project.service.MySqlService;
import project.service.OrderService;
import project.service.UserService;
import project.utils.UserSessionManager;
import java.net.URL;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import static javax.swing.JOptionPane.*;

/**
 *
 * @author linyu
 */
public class ProductDetails extends javax.swing.JFrame {

    /**
     * Creates new form Default
     */
    private Product product;
    private UserDao userDao = new UserDaoImpl();
    private UserService userService = new UserService(userDao);

    public ProductDetails(Product product) {
        User user = UserSessionManager.getInstance().getLoggedInUser();
        this.product = product;
        initComponents();
        btnManagerInterface.setVisible(false);
        btnStaffInterface.setVisible(false);
        if (userService.isUserManager(user.getUserID())){
            btnManagerInterface.setVisible(true);
        }
        if (userService.isUserStaff(user.getUserID())) {
            btnStaffInterface.setVisible(true);
        }
        loadSpecialProperties();
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
        btnStaffInterface = new javax.swing.JButton();
        btnManagerInterface = new javax.swing.JButton();
        defaultImage = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        brandLabel = new javax.swing.JLabel();
        productCodeLabel = new javax.swing.JLabel();
        btnAddOrderLine = new javax.swing.JButton();
        quantityVal = new javax.swing.JSpinner();
        typeLabel = new javax.swing.JLabel();
        btnBasket = new javax.swing.JButton();
        btnBack1 = new javax.swing.JButton();

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
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnMyDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecentOrders)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 664, Short.MAX_VALUE)
                .addComponent(btnLogOut)
                .addGap(61, 61, 61))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 200, 800);

        jPanel3.setBackground(new java.awt.Color(0, 102, 0));

        title.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText(product.getProductName());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(469, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(title)
                .addGap(19, 19, 19))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(200, 120, 800, 70);

        btnStaffInterface.setBackground(new java.awt.Color(0, 102, 0));
        btnStaffInterface.setForeground(new java.awt.Color(204, 204, 204));
        btnStaffInterface.setText("Staff interface");
        btnStaffInterface.setBorder(null);
        btnStaffInterface.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffInterfaceActionPerformed(evt);
            }
        });
        jPanel1.add(btnStaffInterface);
        btnStaffInterface.setBounds(840, 10, 130, 17);

        btnManagerInterface.setBackground(new java.awt.Color(0, 102, 0));
        btnManagerInterface.setForeground(new java.awt.Color(204, 204, 204));
        btnManagerInterface.setText("Manager interface");
        btnManagerInterface.setBorder(null);
        btnManagerInterface.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagerInterfaceActionPerformed(evt);
            }
        });
        jPanel1.add(btnManagerInterface);
        btnManagerInterface.setBounds(840, 50, 150, 17);

//        defaultImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/tran_sets.jpg"))); // NOI18N
//        jPanel1.add(defaultImage);
//        defaultImage.setBounds(270, 210, 240, 160);

        nameLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(0, 102, 0));
        nameLabel.setText("Price: "+product.getRetailPrice()+"£");
        jPanel1.add(nameLabel);
        nameLabel.setBounds(630, 207, 320, 40);

        brandLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        brandLabel.setText("Brand: " + product.getBrandName());
        jPanel1.add(brandLabel);
        brandLabel.setBounds(630, 257, 330, 20);

        productCodeLabel.setText("Type: " + product.getGaugeType());
        jPanel1.add(productCodeLabel);
        productCodeLabel.setBounds(630, 290, 310, 17);

        btnAddOrderLine.setBackground(new java.awt.Color(0, 102, 0));
        btnAddOrderLine.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        btnAddOrderLine.setForeground(new java.awt.Color(255, 255, 255));
        btnAddOrderLine.setText("Add to basket");
        btnAddOrderLine.setBorder(null);
        btnAddOrderLine.setMaximumSize(new java.awt.Dimension(151, 24));
        btnAddOrderLine.setMinimumSize(new java.awt.Dimension(151, 24));
        btnAddOrderLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrderLineActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddOrderLine);
        btnAddOrderLine.setBounds(280, 500, 140, 60);

        quantityVal.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        jPanel1.add(quantityVal);
        quantityVal.setBounds(280, 430, 140, 40);

        typeLabel.setForeground(new java.awt.Color(102, 102, 102));
        typeLabel.setText("Product code: " + product.getProductCode());
        jPanel1.add(typeLabel);
        typeLabel.setBounds(630, 320, 360, 17);

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
        btnBasket.setBounds(280, 580, 140, 60);

        btnBack1.setBackground(new java.awt.Color(0, 102, 0));
        btnBack1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        btnBack1.setForeground(new java.awt.Color(255, 255, 255));
        btnBack1.setText("Back ");
        btnBack1.setBorder(null);
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack1);
        btnBack1.setBounds(280, 660, 140, 60);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1000, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadSpecialProperties(){
        char firstChar = product.getProductCode().charAt(0);
        System.out.println("First Char is "+firstChar);
        switch (firstChar) {
            case 'R':
                TrackDao trackDao = new TrackDaoImpl();
                Track track = trackDao.getTrack(product.getProductCode());
                JLabel lblTrackType = new JLabel("Track type: " + track.getTrackType());
                lblTrackType.setBounds(630, 350, 310, 17);
                jPanel1.add(lblTrackType);
                System.out.println("it is a track");
                break;

            case 'C':
                ControllerDao controllerDao = new ControllerDaoImpl();
                Controller controller = controllerDao.getController(product.getProductCode());
                JLabel lblConTrollerType = new JLabel("Controller type: " + controller.getControllerType());
                lblConTrollerType.setBounds(630, 350, 310, 17);
                JLabel lblIsDigit = new JLabel("Is digit: " + controller.getIsDigital());
                lblIsDigit.setBounds(630, 375, 310, 17);
                jPanel1.add(lblConTrollerType);
                jPanel1.add(lblIsDigit);
                System.out.println("it is a controller");
                break;

            case 'L':
                LocomotiveDao locomotiveDao = new LocomotiveDaoImpl();
                Locomotive locomotive = locomotiveDao.getLocomotive(product.getProductCode());
                JLabel lblDCCType = new JLabel("DCC type: " + locomotive.getDccType());
                lblDCCType.setBounds(630, 350, 310, 17);
                JLabel lblLocomotiveEra = new JLabel("Era: " + locomotive.getEra());
                lblLocomotiveEra.setBounds(630, 375, 310, 17);
                jPanel1.add(lblDCCType);
                jPanel1.add(lblLocomotiveEra);
                System.out.println("it is a locomotive");
                break;

            case 'S':
                RollingStockDao rollingStockDao = new RollingStockDaoImpl();
                RollingStock rollingStock = null;
                try {
                    rollingStock = rollingStockDao.getRollingStock(product.getProductCode());
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                JLabel lblRollingStockType = new JLabel("Rolling stock type: " + rollingStock.getRollingStockType());
                lblRollingStockType.setBounds(630, 350, 310, 17);
                JLabel lblRollingStockEra = new JLabel("Era: " + rollingStock.getEra());
                lblRollingStockEra.setBounds(630, 375, 310, 17);
                jPanel1.add(lblRollingStockType);
                jPanel1.add(lblRollingStockEra);

                System.out.println("it is a locomotive");
                break;
            case 'M':
                TrainSetDao trainSetDao = new TrainSetDaoImpl();
                PartBoxedSetAssociationDao partBoxedSetAssociationDao = new PartBoxedSetAssociationDaoImpl();
                //List all parts
                JLabel jLabel = new JLabel("Part: ");
                jLabel.setBounds(630, 350, 310, 17);
                List<PartBoxedSetAssociation> partBoxedSetAssociations = partBoxedSetAssociationDao.getAssociationsForBoxedSet(product.getProductCode());
                int i = 35;
                for (PartBoxedSetAssociation partBoxedSetAssociation : partBoxedSetAssociations) {
//                    parts.add(partBoxedSetAssociation.getPart());
                    JLabel part = new JLabel("Name: " + partBoxedSetAssociation.getPart().getProductName() +
                            "Quantity: " + partBoxedSetAssociation.getQuantity());
                    part.setBounds(630, 350+i, 310, 17);
                    i+=35;
                    JButton viewDetail = new JButton();
                    viewDetail.setText("view details");
                    viewDetail.setBounds(630, 350+i, 310, 17);
                    i+=35;
                    viewDetail.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            viewProductDetails(partBoxedSetAssociation.getPart());
                        }
                    });
                    jPanel1.add(part);
                    jPanel1.add(viewDetail);
                }
                jPanel1.add(jLabel);
                //TODO get parts
//                Part trainSetPart = pbsad.getPartByProductCode();
                System.out.println("it is a TrainSet");
                break;
            case 'P':
                TrackPackDao trackPackDao = new TrackPackDaoImpl();
                PartBoxedSetAssociationDao partBoxedSetAssociationDao1 = new PartBoxedSetAssociationDaoImpl();
                TrackPack trackPack = trackPackDao.getTrackPack(product.getProductCode());
                JLabel lblPackType = new JLabel("Pack type: " + trackPack.getPackType());
                lblPackType.setBounds(630, 350, 310, 17);
                JLabel jLabel1 = new JLabel("Part: ");
                jLabel1.setBounds(630, 375, 310, 17);
                List<PartBoxedSetAssociation> trackPackPartBoxedSetAssociations = partBoxedSetAssociationDao1.getAssociationsForBoxedSet(product.getProductCode());
                int interval = 35;
                for (PartBoxedSetAssociation partBoxedSetAssociation : trackPackPartBoxedSetAssociations) {
//                    parts.add(partBoxedSetAssociation.getPart());
                    JLabel part = new JLabel("Name: " + partBoxedSetAssociation.getPart().getProductName() +
                            "Quantity: " + partBoxedSetAssociation.getQuantity());
                    part.setBounds(630, 375+interval, 310, 17);
                    interval+=35;
                    JButton viewDetail = new JButton();
                    viewDetail.setText("view details");
                    viewDetail.setBounds(630, 375+interval, 310, 17);
                    interval+=35;
                    viewDetail.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            viewProductDetails(partBoxedSetAssociation.getPart());
                        }
                    });
                    jPanel1.add(part);
                    jPanel1.add(viewDetail);
                }
                jPanel1.add(lblPackType);
                jPanel1.add(jLabel1);
                System.out.println("it is a TrackPack");
                break;
            default:
                throw new IllegalArgumentException("Unknown product type: " + firstChar);
        }
    }
    private void btnBasketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBasketActionPerformed
        OrderLines OrderLinesFrame = new OrderLines();
        OrderLinesFrame.setVisible(true);
        OrderLinesFrame.pack();
        OrderLinesFrame.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnBasketActionPerformed

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

    private void btnStaffInterfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffInterfaceActionPerformed
        Staff StaffFrame = new Staff();
        StaffFrame.setVisible(true);
        StaffFrame.pack();
        StaffFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnStaffInterfaceActionPerformed

    private void btnManagerInterfaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagerInterfaceActionPerformed
        ManagerDashboard ManagerDashboardFrame = new ManagerDashboard();
        ManagerDashboardFrame.setVisible(true);
        ManagerDashboardFrame.pack();
        ManagerDashboardFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnManagerInterfaceActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // log out
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnAddOrderLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrderLineActionPerformed
        //Add a product to basket
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
    }//GEN-LAST:event_btnAddOrderLineActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        Default DefaultFrame = new Default();
        DefaultFrame.setVisible(true);
        DefaultFrame.pack();
        DefaultFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void viewProductDetails(Product product){
//        new ProductDetails(productCode, price);
        ProductDetails ProductDetailsFrame = new ProductDetails(product);
        ProductDetailsFrame.setVisible(true);
        ProductDetailsFrame.pack();
        ProductDetailsFrame.setLocationRelativeTo(null);
        this.dispose();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brandLabel;
    private javax.swing.JButton btnAddOrderLine;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnBasket;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnManagerInterface;
    private javax.swing.JButton btnMyDetails;
    private javax.swing.JButton btnRecentOrders;
    private javax.swing.JButton btnStaffInterface;
    private javax.swing.JLabel defaultImage;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel productCodeLabel;
    private javax.swing.JSpinner quantityVal;
    private javax.swing.JLabel title;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
