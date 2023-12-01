/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project.gui;

import java.math.BigDecimal;
import javax.swing.JOptionPane;
import project.daoimpl.ControllerDaoImpl;
import project.daoimpl.LocomotiveDaoImpl;
import project.daoimpl.TrackDaoImpl;
import project.model.product.Controller;
import project.model.product.Locomotive;
import project.model.product.Track;
import project.model.product.enums.ControllerType;
import project.model.product.enums.DCCType;
import project.model.product.enums.Era;
import project.model.product.enums.Gauge;
import project.model.product.enums.TrackType;
import project.service.MySqlService;

/**
 *
 * @author laist
 */
public class AddProduct extends javax.swing.JFrame {

    /**
     * Creates new form AddProduct
     */
    public AddProduct() {
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

        backgroundPanel = new javax.swing.JPanel();
        partTypeTabbedPane = new javax.swing.JTabbedPane();
        locomotivePanel = new javax.swing.JPanel();
        locomotiveTypeBox = new javax.swing.JComboBox<>();
        locomotiveEraBox = new javax.swing.JComboBox<>();
        locomotiveAddButton = new javax.swing.JButton();
        controllerPanel = new javax.swing.JPanel();
        controllerTypeBox = new javax.swing.JComboBox<>();
        addControllerButton = new javax.swing.JButton();
        isDigitalBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        trackPanel = new javax.swing.JPanel();
        trackTypeBox = new javax.swing.JComboBox<>();
        addTrackButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        carriagePanel = new javax.swing.JPanel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        trackPackPanel = new javax.swing.JPanel();
        jComboBox10 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        trainSetPanel = new javax.swing.JPanel();
        generalDetailsPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        brandLabel = new javax.swing.JLabel();
        brandBox = new javax.swing.JComboBox<>();
        nameTextBox = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        gaugeLabel = new javax.swing.JLabel();
        gaugeBox = new javax.swing.JComboBox<>();
        priceLabel = new javax.swing.JLabel();
        priceSpinner = new javax.swing.JSpinner();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 105, 0));

        backgroundPanel.setBackground(new java.awt.Color(0, 105, 0));

        locomotivePanel.setToolTipText("");

        locomotiveTypeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ANALOGUE", "DCC_READY", "DCC_FITTED", "DCC_SOUND" }));

        locomotiveEraBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ERA_1", "ERA_2", "ERA_3", "ERA_4", "ERA_5", "ERA_6", "ERA_8", "ERA_7", "ERA_9", "ERA_10", "ERA_11", "ERA_12" }));

        locomotiveAddButton.setText("Add");
        locomotiveAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locomotiveAddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout locomotivePanelLayout = new javax.swing.GroupLayout(locomotivePanel);
        locomotivePanel.setLayout(locomotivePanelLayout);
        locomotivePanelLayout.setHorizontalGroup(
            locomotivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locomotivePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(locomotivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(locomotiveAddButton)
                    .addComponent(locomotiveEraBox, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locomotiveTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        locomotivePanelLayout.setVerticalGroup(
            locomotivePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locomotivePanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(locomotiveTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(locomotiveEraBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(locomotiveAddButton)
                .addContainerGap())
        );

        partTypeTabbedPane.addTab("Locomotive", locomotivePanel);

        controllerTypeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "STANDARD_CONTROLLER", "DCC_CONTROLLER", "DCC_EDIT_CONTROLLER" }));
        controllerTypeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controllerTypeBoxActionPerformed(evt);
            }
        });

        addControllerButton.setText("Add");
        addControllerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addControllerButtonActionPerformed(evt);
            }
        });

        isDigitalBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "true", "false" }));
        isDigitalBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isDigitalBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Controller Type");

        jLabel2.setText("Is Digital");

        javax.swing.GroupLayout controllerPanelLayout = new javax.swing.GroupLayout(controllerPanel);
        controllerPanel.setLayout(controllerPanelLayout);
        controllerPanelLayout.setHorizontalGroup(
            controllerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controllerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controllerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addControllerButton)
                    .addComponent(controllerTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isDigitalBox, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        controllerPanelLayout.setVerticalGroup(
            controllerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controllerPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(controllerTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(isDigitalBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addComponent(addControllerButton)
                .addContainerGap())
        );

        partTypeTabbedPane.addTab("Controller", controllerPanel);

        trackTypeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "STRAIGHT", "CURVE", "POINT", "CROSSOVER" }));

        addTrackButton.setText("Add");
        addTrackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTrackButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Track Type");

        javax.swing.GroupLayout trackPanelLayout = new javax.swing.GroupLayout(trackPanel);
        trackPanel.setLayout(trackPanelLayout);
        trackPanelLayout.setHorizontalGroup(
            trackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trackPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(trackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trackTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTrackButton)
                    .addComponent(jLabel3))
                .addContainerGap(227, Short.MAX_VALUE))
        );
        trackPanelLayout.setVerticalGroup(
            trackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trackPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trackTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                .addComponent(addTrackButton)
                .addContainerGap())
        );

        partTypeTabbedPane.addTab("Track", trackPanel);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ERA_1", "ERA_2", "ERA_3", "ERA_4", "ERA_5", "ERA_6", "ERA_8", "ERA_7", "ERA_9", "ERA_10", "ERA_11", "ERA_12" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CARRIAGE", "WAGON" }));

        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout carriagePanelLayout = new javax.swing.GroupLayout(carriagePanel);
        carriagePanel.setLayout(carriagePanelLayout);
        carriagePanelLayout.setHorizontalGroup(
            carriagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carriagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(carriagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        carriagePanelLayout.setVerticalGroup(
            carriagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carriagePanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        partTypeTabbedPane.addTab("Carriage", carriagePanel);

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "STARTER_OVAL", "EXTENSION_PACK" }));

        jLabel6.setText("Type of Track Pack");

        javax.swing.GroupLayout trackPackPanelLayout = new javax.swing.GroupLayout(trackPackPanel);
        trackPackPanel.setLayout(trackPackPanelLayout);
        trackPackPanelLayout.setHorizontalGroup(
            trackPackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trackPackPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(trackPackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        trackPackPanelLayout.setVerticalGroup(
            trackPackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trackPackPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(265, Short.MAX_VALUE))
        );

        partTypeTabbedPane.addTab("Track_Pack", trackPackPanel);

        javax.swing.GroupLayout trainSetPanelLayout = new javax.swing.GroupLayout(trainSetPanel);
        trainSetPanel.setLayout(trainSetPanelLayout);
        trainSetPanelLayout.setHorizontalGroup(
            trainSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );
        trainSetPanelLayout.setVerticalGroup(
            trainSetPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        partTypeTabbedPane.addTab("Train Set", trainSetPanel);

        generalDetailsPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setText("General Details");

        brandLabel.setText("Brand");

        brandBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LMS", "LNER", "GWR" }));

        nameTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextBoxActionPerformed(evt);
            }
        });

        nameLabel.setText("Name");

        gaugeLabel.setText("Gauge");

        gaugeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OO_GAUGE", "TT_GAUGE", "N_GAUGE" }));
        gaugeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gaugeBoxActionPerformed(evt);
            }
        });

        priceLabel.setText("Price");

        cancelButton.setText("Cancel");

        javax.swing.GroupLayout generalDetailsPanelLayout = new javax.swing.GroupLayout(generalDetailsPanel);
        generalDetailsPanel.setLayout(generalDetailsPanelLayout);
        generalDetailsPanelLayout.setHorizontalGroup(
            generalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalDetailsPanelLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, generalDetailsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(generalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelButton)
                    .addGroup(generalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(gaugeLabel)
                        .addComponent(brandLabel)
                        .addComponent(brandBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameTextBox)
                        .addComponent(nameLabel)
                        .addComponent(gaugeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(priceLabel)
                        .addComponent(priceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        generalDetailsPanelLayout.setVerticalGroup(
            generalDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(brandLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brandBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nameLabel)
                .addGap(3, 3, 3)
                .addComponent(nameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gaugeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gaugeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(priceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(generalDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(partTypeTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(245, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(generalDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(partTypeTabbedPane))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gaugeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gaugeBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gaugeBoxActionPerformed

    private void nameTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextBoxActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void addTrackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTrackButtonActionPerformed

        TrackDaoImpl trackDao = new TrackDaoImpl();

        int intValue = (Integer) priceSpinner.getValue();
        BigDecimal retailPrice = new BigDecimal(intValue);
        String gaugeType = gaugeBox.getSelectedItem().toString();
        String trackType = trackTypeBox.getSelectedItem().toString();
        String productCode = MySqlService.generateProductCode("TRACK");

        Track track = new Track(
            productCode,
            brandBox.getSelectedItem().toString(),
            nameTextBox.getText(),
            retailPrice,
            Gauge.valueOf(gaugeType),
            TrackType.valueOf(trackType)
        );

        trackDao.addTrack(track);
        JOptionPane.showMessageDialog(this, "Added Track with ID: " + productCode, "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_addTrackButtonActionPerformed

    private void isDigitalBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isDigitalBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isDigitalBoxActionPerformed

    private void addControllerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addControllerButtonActionPerformed
        ControllerDaoImpl controllerDao = new ControllerDaoImpl();

        int intValue = (Integer) priceSpinner.getValue();
        BigDecimal retailPrice = new BigDecimal(intValue);
        String gaugeType = gaugeBox.getSelectedItem().toString();
        ControllerType controllerType = ControllerType.valueOf(controllerTypeBox.getSelectedItem().toString());
        Boolean isDigital = Boolean.valueOf(isDigitalBox.getSelectedItem().toString());
        String productCode = MySqlService.generateProductCode("CONTROLLER");

        // Create a Controller object
        Controller controller = new Controller(
            productCode,
            brandBox.getSelectedItem().toString(),
            nameTextBox.getText(),
            retailPrice,
            Gauge.valueOf(gaugeType),
            controllerType,
            isDigital
        );

        controllerDao.addController(controller);
        JOptionPane.showMessageDialog(this, "Added Controller with ID: " + productCode, "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_addControllerButtonActionPerformed

    private void controllerTypeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controllerTypeBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_controllerTypeBoxActionPerformed

    private void locomotiveAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locomotiveAddButtonActionPerformed
        LocomotiveDaoImpl locomotiveDao = new LocomotiveDaoImpl();

        // Assuming jSpinner1.getValue() returns a BigDecimal
        int intValue = (Integer) priceSpinner.getValue();
        BigDecimal retailPrice = new BigDecimal(intValue);

        // Assuming jComboBox1, jComboBox3, and jComboBox4 return the selected items as Strings
        String gaugeType = gaugeBox.getSelectedItem().toString();
        String dccType = locomotiveTypeBox.getSelectedItem().toString();
        String era = locomotiveEraBox.getSelectedItem().toString();
        String productCode = MySqlService.generateProductCode("LOCOMOTIVE");

        // Create a Locomotive object
        Locomotive locomotive = new Locomotive(
            productCode,
            brandBox.getSelectedItem().toString(),
            nameTextBox.getText(),
            retailPrice,
            Gauge.valueOf(gaugeType),
            DCCType.valueOf(dccType), // Assuming DCCType is an enum
            Era.valueOf(era) // Assuming Era is an enum
        );

        locomotiveDao.addLocomotive(locomotive);
        JOptionPane.showMessageDialog(this, "Added Locomotive with ID: " + productCode, "Success", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_locomotiveAddButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addControllerButton;
    private javax.swing.JButton addTrackButton;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JComboBox<String> brandBox;
    private javax.swing.JLabel brandLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel carriagePanel;
    private javax.swing.JPanel controllerPanel;
    private javax.swing.JComboBox<String> controllerTypeBox;
    private javax.swing.JComboBox<String> gaugeBox;
    private javax.swing.JLabel gaugeLabel;
    private javax.swing.JPanel generalDetailsPanel;
    private javax.swing.JComboBox<String> isDigitalBox;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton locomotiveAddButton;
    private javax.swing.JComboBox<String> locomotiveEraBox;
    private javax.swing.JPanel locomotivePanel;
    private javax.swing.JComboBox<String> locomotiveTypeBox;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextBox;
    private javax.swing.JTabbedPane partTypeTabbedPane;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JSpinner priceSpinner;
    private javax.swing.JPanel trackPackPanel;
    private javax.swing.JPanel trackPanel;
    private javax.swing.JComboBox<String> trackTypeBox;
    private javax.swing.JPanel trainSetPanel;
    // End of variables declaration//GEN-END:variables
}
