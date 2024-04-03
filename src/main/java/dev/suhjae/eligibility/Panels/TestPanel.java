package dev.suhjae.eligibility.Panels;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestPanel extends MainPanel {
    public TestPanel(String[][] data) {
        super(data);
        this.setFocusable(false);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setFocusable(false);

        //Table Data
        String[] titles = data[0];
        //String[] data = {"aaa","bbb","ccc","ddd"};

        for (String c : titles) {
            tableModel.addColumn(c);
        }
        updateTableData();

        // Add a TableModelListener to listen for changes in the table
        tableModel.addTableModelListener(new MyTableModelListener());

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setFocusable(false);

        importButton = new JButton("Import");
        importButton.addActionListener(new MyButtonListener());

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to save the data shown on the screen?", "Save", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.NO_OPTION) {

                } else if (result == JOptionPane.YES_OPTION) {

                }
            }
        });

        this.setLayout(new BorderLayout());
        JPanel controlsPanel = new JPanel();
        controlsPanel.setLayout(new FlowLayout());

        this.add(scrollPane);

        controlsPanel.add(importButton);
        controlsPanel.add(saveButton);

        this.add(controlsPanel, BorderLayout.SOUTH);
    }

    private class MyButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button");

            // Example: Update String array with a new value
            String newValue = JOptionPane.showInputDialog("[0][0] new value:");
            data[0][0] = newValue;
            updateTableData();
        }
    }

    private class MyTableModelListener implements TableModelListener {
        @Override
        public void tableChanged(TableModelEvent e) {
            // Check if the change is in the data column (column 0)
            if (e.getColumn() == 0 && e.getType() == TableModelEvent.UPDATE) {
                int rowIndex = e.getFirstRow();
                String updatedValue = (String) tableModel.getValueAt(rowIndex, 0);
                data[rowIndex][0] = updatedValue;
                updateTableData();

                for (String[] dat : data) {
                    for (String d : dat) {
                        System.out.print(d + " ");
                    }
                    System.out.println();
                }

            }
        }
    }
}
