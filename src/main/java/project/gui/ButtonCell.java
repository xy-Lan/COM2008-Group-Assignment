package project.gui;
import project.dao.OrderDao;
import project.dao.ProductDao;
import project.daoimpl.OrderDaoImpl;
import project.daoimpl.ProductDaoImpl;
import project.exceptions.StaffOrderException;
import project.model.order.Order;
import project.model.product.abstractproduct.Product;
import project.service.OrderService;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumnModel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonCell extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {

    private JTable table;
    private JButton button;
    private String label ="click";

//    private Product product;

    private int editingColumn;
    private boolean isPushed;

    public ButtonCell() {
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(this);
//        System.out.println("BUTTON CELL---------------------");
    }

//    public ButtonCell(Product product) {
//        this.product = product;
//        button = new JButton();
//        button.setOpaque(true);
//        button.addActionListener(this);
//    }

    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
//        if (hasColumn(table, "Edit")) {
//            label = "Edit";
//        } else if (hasColumn(table, "Fulfil")) {
//            if (editingColumn == table.getColumn("Fulfil").getModelIndex()){
//                label = "Fulfil";
//            } else if (editingColumn == table.getColumn("Refuse").getModelIndex()) {
//                label = "Refuse";
//            }
//        }
//        label = (value == null) ? "" : value.toString();
        button.setText(label);
        return button;
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
       this.table = table;
       this.editingColumn = column;
//        isPushed = true;
        return this.button;
    }

    public Object getCellEditorValue() {
        return button.getText();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("ACTION");
        if (table != null) {
            System.out.println("Table is not null");
            if (hasColumn(table, "Edit")) {
                if (editingColumn == table.getColumn("Edit").getModelIndex()) {
                    int row = table.convertRowIndexToModel(table.getEditingRow());
                    Object productCode = table.getModel().getValueAt(row, 0);
                    ProductDao productDao = new ProductDaoImpl();
                    Product product = productDao.getProduct(productCode.toString());
                    ProductEditor ProductEditorFrame = new ProductEditor(product);
                    ProductEditorFrame.setVisible(true);
                    ProductEditorFrame.pack();
                    ProductEditorFrame.setLocationRelativeTo(null);
               }
            } else if (hasColumn(table, "Fulfil") || hasColumn(table, "Refuse")) {
                if (editingColumn == table.getColumn("Fulfil").getModelIndex()) {

                    int row = table.convertRowIndexToModel(table.getEditingRow());
                    Object orderNum = table.getModel().getValueAt(row, 0);
                    OrderDao orderDao = new OrderDaoImpl();
                    OrderService orderService = new OrderService(orderDao);
                    Order order = orderDao.getOrderById(Integer.parseInt(orderNum.toString())).get();
                    try {
                        orderService.fulfillOrder(order);
                        JOptionPane.showMessageDialog(null, "Status changed",
                                "", JOptionPane.INFORMATION_MESSAGE);
                    } catch (StaffOrderException ex) {
                        throw new RuntimeException(ex);
                    }

                } else if (editingColumn == table.getColumn("Refuse").getModelIndex()) {
                    int row = table.convertRowIndexToModel(table.getEditingRow());
                    Object orderNum = table.getModel().getValueAt(row, 0);
                    OrderDao orderDao = new OrderDaoImpl();
                    OrderService orderService = new OrderService(orderDao);
                    Order order = orderDao.getOrderById(Integer.parseInt(orderNum.toString())).get();
                    try {
                        orderService.refuseOrder(order);
                        JOptionPane.showMessageDialog(null, "Status changed",
                                "", JOptionPane.INFORMATION_MESSAGE);
                    } catch (StaffOrderException ex) {
                        throw new RuntimeException(ex);
                        }
                }
            }

        } else {
            System.out.println("Table is null");
        }
        fireEditingStopped();
    }

    public boolean hasColumn(JTable table, String columnName) {
        TableColumnModel columnModel = table.getColumnModel();
        int columns = columnModel.getColumnCount();
        for (int i = 0; i < columns; i++) {
            if (columnModel.getColumn(i).getHeaderValue().equals(columnName)) {
                return true;
            }
        }
        return false;
    }
}

