/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InvoiceApplication;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
//package InvoiceApplication;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
/**
 *
 * @author user
 */
public class SalesReports {
    
    
    

public class SalesReportTable extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JTextField txtFrom, txtTo;
    private JButton btnLoad;

    public SalesReportTable() {
        setTitle("Sales Report (H2 Database)");
        setSize(800, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("From (YYYY-MM-DD):"));
        txtFrom = new JTextField(10);
        topPanel.add(txtFrom);
        topPanel.add(new JLabel("To:"));
        txtTo = new JTextField(10);
        topPanel.add(txtTo);
        btnLoad = new JButton("Load Report");
        topPanel.add(btnLoad);
        add(topPanel, BorderLayout.NORTH);

        model = new DefaultTableModel(new String[]{"Invoice No", "Date", "Customer", "Total"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        btnLoad.addActionListener(e -> loadReport());

        setVisible(true);
    }

    private void loadReport() {
        try {
            String from = txtFrom.getText();
            String to = txtTo.getText();

            Class.forName("org.h2.Driver");
            Connection con = DriverManager.getConnection("jdbc:h2:C:/InvoiceApp/data/invoiceDB", "sa", "");
            String sql = "SELECT invoice_no, date, customer, total_amount FROM sales WHERE date BETWEEN ? AND ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, from);
            pst.setString(2, to);
            ResultSet rs = pst.executeQuery();

            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("invoice_no"),
                    rs.getString("date"),
                    rs.getString("customer"),
                    rs.getDouble("total_amount")
                });
            }

            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
        
        
    }
    
    
}
public static void main(String[] args) {
        //new MenuExample();
    }
    
}
