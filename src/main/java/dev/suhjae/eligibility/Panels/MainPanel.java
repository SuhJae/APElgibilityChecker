package dev.suhjae.eligibility.Panels;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainPanel extends JPanel {
    DefaultTableModel tableModel;
    JTable table;
    String[][] data;
    JButton importButton, saveButton;

    public MainPanel(String[][] data) {
        this.data = data;
    }

    public MainPanel() {

    }

    public JPanel getPanel() {
        return this;
    }

    public void updateTableData() {
        // Clear existing data
        tableModel.setRowCount(0);

        // Populate table with data from the String array
        for (int i = 1; i < data.length; i++) {
            //tableModel.addRow(new Object[]{d});
            tableModel.addRow(data[i]);
            //System.out.println(d);
        }
    }
}
