/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import project.dao.OrderDao;
import project.dao.ProductDao;
import project.daoimpl.OrderDaoImpl;
import project.daoimpl.ProductDaoImpl;
import project.exceptions.StaffOrderException;
import project.model.order.Order;
import project.model.product.abstractproduct.Product;
import project.service.OrderService;

/**
 *
 * @author laist
 */
public class CheckBoxCell extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {

    private JTable table;
    private JCheckBox checkbox;

    private int editingColumn;
    private boolean isPushed;

    public CheckBoxCell() {
        checkbox = new JCheckBox();
        checkbox.setOpaque(true);
        checkbox.addActionListener(this);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        return checkbox;
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
       this.table = table;
       this.editingColumn = column;
//        isPushed = true;
        return this.checkbox;
    }

    public Object getCellEditorValue() {
        return checkbox.isSelected();
    }

    public void actionPerformed(ActionEvent e) {
        
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

