package project.gui;
import project.dao.OrderDao;
import project.dao.ProductDao;
import project.daoimpl.OrderDaoImpl;
import project.daoimpl.ProductDaoImpl;
import project.model.order.Order;
import project.model.product.abstractproduct.Product;
import project.service.OrderService;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonCell extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {

    private JTable table;
    private JButton button;
    private String label;

//    private Product product;

    private int editingColumn;
    private boolean isPushed;

    public ButtonCell() {
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(this);
    }

//    public ButtonCell(Product product) {
//        this.product = product;
//        button = new JButton();
//        button.setOpaque(true);
//        button.addActionListener(this);
//    }

    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
//        if (isSelected) {
//            button.setForeground(table.getSelectionForeground());
//            button.setBackground(table.getSelectionBackground());
//        } else {
//            button.setForeground(table.getForeground());
//            button.setBackground(table.getBackground());
//        }
        label = (value == null) ? "" : value.toString();
//        button.setText(label);
        return button;
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
       this.table = table;
       this.editingColumn = column;
        label = (value == null) ? "" : value.toString();
        button.setText(label);
//        isPushed = true;
        return button;
    }

    public Object getCellEditorValue() {
        return button.getText();
    }

    public void actionPerformed(ActionEvent e) {
        if (table != null) {
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
            if (editingColumn == table.getColumn("Fulfil").getModelIndex()) {
                int row = table.convertRowIndexToModel(table.getEditingRow());
                Object orderNum = table.getModel().getValueAt(row, 0);
                OrderDao orderDao = new OrderDaoImpl();
                OrderService orderService = new OrderService(orderDao);
                Order order = orderDao.getOrderById(Integer.parseInt(orderNum.toString())).get();
                orderService.fulfillOrder(order);
            }
            if (editingColumn == table.getColumn("Refuse").getModelIndex()) {
                int row = table.convertRowIndexToModel(table.getEditingRow());
                Object orderNum = table.getModel().getValueAt(row, 0);
                OrderDao orderDao = new OrderDaoImpl();
                OrderService orderService = new OrderService(orderDao);
                Order order = orderDao.getOrderById(Integer.parseInt(orderNum.toString())).get();
                orderService.refuseOrder();
            }



        }
        fireEditingStopped();
    }
}

