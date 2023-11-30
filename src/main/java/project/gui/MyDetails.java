/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project.gui;

import project.dao.AddressDao;
import project.dao.BankCardDao;
import project.dao.UserDao;
import project.daoimpl.AddressDaoImpl;
import project.daoimpl.BankCardDaoImpl;
import project.daoimpl.UserDaoImpl;
import project.model.address.Address;
import project.model.bankcard.BankCard;
import project.model.user.User;
import project.utils.UserSessionManager;

import javax.swing.*;

/**
 *
 * @author linyu
 */
public class MyDetails extends javax.swing.JFrame {

    private User user;

    private Address address;

    private BankCard bankCard;

    private String newPassword;

    /**
     * Creates new form Default
     */
    public MyDetails() {
        user = UserSessionManager.getInstance().getLoggedInUser();
        AddressDao addressDao = new AddressDaoImpl();
        System.out.println("ID: " + user.getAddressId());
        address = addressDao.getAddress(user.getAddressId());
        BankCardDao bankCardDao = new BankCardDaoImpl();
        bankCard = bankCardDao.getBankCardByUserID(user.getUserID());
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

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnProfile = new javax.swing.JButton();
        btnMyDetails = new javax.swing.JButton();
        btnRecentOrders = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        personalDetailPanel = new javax.swing.JPanel();
        lblUserName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JFormattedTextField();
        txtRoadName = new javax.swing.JFormattedTextField();
        txtCityName = new javax.swing.JFormattedTextField();
        txtPostcode = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        btnChangePassword = new javax.swing.JButton();
        btnSavePersonalDetails = new javax.swing.JButton();
        txtHouseNum = new javax.swing.JFormattedTextField();
        bankCardPanel = new javax.swing.JPanel();
        btnDeleteBankCard = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtSecurityCode1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtBankCardName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtExpiryYear = new javax.swing.JTextField();
        txtExpiryMonth = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCardNumber = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Category");
        setPreferredSize(new java.awt.Dimension(1000, 800));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 800));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(250, 800));

        btnProfile.setBackground(new java.awt.Color(0, 102, 0));
        btnProfile.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        btnProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnProfile.setText("Profile");
        btnProfile.setBorder(null);
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
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
                    .addComponent(btnProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnMyDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btnRecentOrders)))
                        .addGap(0, 123, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnMyDetails)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRecentOrders)
                .addGap(202, 202, 202)
                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 402, Short.MAX_VALUE)
                .addComponent(btnLogOut)
                .addGap(78, 78, 78))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 250, 800);

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("My Details");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(279, 56, 330, 47);

        jPanel3.setBackground(new java.awt.Color(0, 102, 0));

        title.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Profile");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(title)
                .addContainerGap(640, Short.MAX_VALUE))
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

        personalDetailPanel.setBackground(new java.awt.Color(204, 204, 204));

        lblUserName.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(0, 102, 0));
        lblUserName.setText(user.getForename() + " " + user.getSurname());

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel3.setText("Email:");

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel5.setText("Address:");

        txtEmail.setForeground(new java.awt.Color(0, 102, 0));
        txtEmail.setText(user.getEmail());
        txtEmail.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N

        txtRoadName.setForeground(new java.awt.Color(0, 102, 0));
        txtRoadName.setText(address.getRoadName());
        txtRoadName.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N

        txtCityName.setForeground(new java.awt.Color(0, 102, 0));
        txtCityName.setText(address.getCityName());
        txtCityName.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N

        txtPostcode.setForeground(new java.awt.Color(0, 102, 0));
        txtPostcode.setText(address.getPostCode());
        txtPostcode.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel7.setText("Postcode:");

        btnChangePassword.setText("Change Password");
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });

        btnSavePersonalDetails.setBackground(new java.awt.Color(255, 102, 102));
        btnSavePersonalDetails.setForeground(new java.awt.Color(255, 255, 255));
        btnSavePersonalDetails.setText("Save");
        btnSavePersonalDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePersonalDetailsActionPerformed(evt);
            }
        });

        txtHouseNum.setForeground(new java.awt.Color(0, 102, 0));
        txtHouseNum.setText(address.getHouseNumber());
        txtHouseNum.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout personalDetailPanelLayout = new javax.swing.GroupLayout(personalDetailPanel);
        personalDetailPanel.setLayout(personalDetailPanelLayout);
        personalDetailPanelLayout.setHorizontalGroup(
            personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailPanelLayout.createSequentialGroup()
                .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(personalDetailPanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSavePersonalDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(personalDetailPanelLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(personalDetailPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(personalDetailPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(personalDetailPanelLayout.createSequentialGroup()
                                .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRoadName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtHouseNum, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCityName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        personalDetailPanelLayout.setVerticalGroup(
            personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(personalDetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHouseNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRoadName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(personalDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnChangePassword)
                .addGap(18, 18, 18)
                .addComponent(btnSavePersonalDetails)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jPanel1.add(personalDetailPanel);
        personalDetailPanel.setBounds(260, 230, 360, 440);

        bankCardPanel.setBackground(new java.awt.Color(204, 204, 204));

        btnDeleteBankCard.setBackground(new java.awt.Color(255, 102, 102));
        btnDeleteBankCard.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteBankCard.setText("Delete");
        btnDeleteBankCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBankCardActionPerformed(evt);
            }
        });

        jLabel4.setText("Expiry Year:");

        txtSecurityCode1.setText(bankCard.getEncryptedSecurityCode());

        jLabel6.setText("Card Number:");

        txtBankCardName.setText("e.g. Visa");

        jLabel8.setText("Expiry Month:");

        txtFirstName.setText("First name");
        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });

        txtExpiryYear.setText(bankCard.getExpiryYear().toString());

        txtExpiryMonth.setText(bankCard.getExpiryMonth().toString());

        jLabel9.setText("Security Code:");

        txtLastName.setText("Last name");

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 0));
        jLabel10.setText("Bank card detail");

        jLabel11.setText("Bank Card Name:");

        txtCardNumber.setText(bankCard.getCardNumber());
        txtCardNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCardNumberActionPerformed(evt);
            }
        });

        jLabel12.setText("Card Holder:");

        javax.swing.GroupLayout bankCardPanelLayout = new javax.swing.GroupLayout(bankCardPanel);
        bankCardPanel.setLayout(bankCardPanelLayout);
        bankCardPanelLayout.setHorizontalGroup(
            bankCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bankCardPanelLayout.createSequentialGroup()
                .addGroup(bankCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bankCardPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bankCardPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(bankCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bankCardPanelLayout.createSequentialGroup()
                                .addGroup(bankCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(txtExpiryMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(bankCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bankCardPanelLayout.createSequentialGroup()
                                        .addComponent(txtExpiryYear, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtSecurityCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(bankCardPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(bankCardPanelLayout.createSequentialGroup()
                                .addGroup(bankCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(bankCardPanelLayout.createSequentialGroup()
                                        .addGroup(bankCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtBankCardName, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(bankCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(bankCardPanelLayout.createSequentialGroup()
                                                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 3, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(bankCardPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnDeleteBankCard, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bankCardPanelLayout.setVerticalGroup(
            bankCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bankCardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bankCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bankCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExpiryMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExpiryYear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSecurityCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bankCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bankCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBankCardName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnDeleteBankCard)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        jPanel1.add(bankCardPanel);
        bankCardPanel.setBounds(630, 230, 360, 440);

        btnBack.setBackground(new java.awt.Color(0, 102, 0));
        btnBack.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.setBorder(null);
        btnBack.setBorderPainted(false);
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack);
        btnBack.setBounds(470, 700, 304, 43);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1000, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed

    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnMyDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyDetailsActionPerformed
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

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        newPassword = JOptionPane.showInputDialog(null, "New password",
                "Reset Password", JOptionPane.QUESTION_MESSAGE).trim();
    }//GEN-LAST:event_btnChangePasswordActionPerformed

    private void btnDeleteBankCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBankCardActionPerformed
        // TODO add your handling code here:
        if (isAnyFieldEmpty(txtCardNumber, txtExpiryMonth, txtExpiryYear,
                txtSecurityCode1, txtFirstName, txtLastName, txtBankCardName)){
            JOptionPane.showMessageDialog(null, "Please enter valid inputs",
                    "Invalid Input", JOptionPane.WARNING_MESSAGE);
        }else {
            BankCardDao bankCardDao = new BankCardDaoImpl();
            bankCardDao.deleteBankCard(user.getUserID());
            //Add a new bank card
            BankCard newBankCard = new BankCard(user, txtCardNumber.getText().trim(), Integer.parseInt(txtExpiryMonth.getText()),
                    Integer.parseInt(txtExpiryYear.getText()), txtSecurityCode1.getText().trim(), txtFirstName.getText().trim(),
                    txtLastName.getText().trim(), txtBankCardName.getText().trim());
            bankCardDao.addBankCard(newBankCard);
            JOptionPane.showMessageDialog(null, "Bank card successfully updated",
                    "Saved", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnDeleteBankCardActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Default DefaultFrame = new Default();
        DefaultFrame.setVisible(true);
        DefaultFrame.pack();
        DefaultFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSavePersonalDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePersonalDetailsActionPerformed

        UserDao userDao = new UserDaoImpl();
        if (txtEmail.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter a valid email address",
                    "Invalid Input", JOptionPane.WARNING_MESSAGE);
        } else {
            if (!newPassword.isEmpty()){
                userDao.updateUserPasswordHash(user.getUserID(), newPassword);
            }
            user.setEmail(txtEmail.getText().trim());
            userDao.updateUser(user);
            //Update address
            if(isAnyFieldEmpty(txtHouseNum, txtRoadName, txtCityName, txtPostcode)) {
                JOptionPane.showMessageDialog(null, "Please enter valid inputs",
                        "Invalid Input", JOptionPane.WARNING_MESSAGE);
            } else {
                address.setHouseNumber(txtHouseNum.getText().trim());
                address.setRoadName(txtRoadName.getText().trim());
                address.setCityName(txtCityName.getText().trim());
                address.setPostCode(txtPostcode.getText().trim());
                AddressDao addressDao = new AddressDaoImpl();
                addressDao.updateAddress(address);
                JOptionPane.showMessageDialog(null, "Details successfully updated",
                        "Saved", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnSavePersonalDetailsActionPerformed

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void txtCardNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCardNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCardNumberActionPerformed

    private boolean isAnyFieldEmpty(JTextField... fields) {
        for (JTextField field : fields) {
            if (field.getText() == null || field.getText().trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bankCardPanel;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnDeleteBankCard;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnMyDetails;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnRecentOrders;
    private javax.swing.JButton btnSavePersonalDetails;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPanel personalDetailPanel;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtBankCardName;
    private javax.swing.JTextField txtCardNumber;
    private javax.swing.JFormattedTextField txtCityName;
    private javax.swing.JFormattedTextField txtEmail;
    private javax.swing.JTextField txtExpiryMonth;
    private javax.swing.JTextField txtExpiryYear;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JFormattedTextField txtHouseNum;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JFormattedTextField txtPostcode;
    private javax.swing.JFormattedTextField txtRoadName;
    private javax.swing.JTextField txtSecurityCode1;
    // End of variables declaration//GEN-END:variables
}
