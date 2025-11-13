/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InvoiceApplication;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.Toolkit;
import java.awt.Toolkit;
import java.awt.Image;
import org.h2.tools.Server;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
// no need to import InvoiceApplication.DBConnection if it's in the same package

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import java.io.FileOutputStream;
import javax.swing.table.DefaultTableModel;
// ❌ Wrong import — remove this line
// import java.awt.Font;

// ✅ Correct import
//import com.itextpdf.text.Font;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;
import org.h2.tools.Server;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.runtime.Debug.id;
import InvoiceApplication.DBConnection;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.draw.LineSeparator;


import java.awt.Graphics;
import java.awt.Graphics2D;
//import com.itextpdf.text.Image; 
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
//import ProductComboFromDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.event.TableModelEvent;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 *
 * @author user
 */
public class InvoiceApplication extends javax.swing.JFrame {

// Declare globally
//private JComboBox<ProductItem> comboProducts;

// Inside constructor or initComponents

java.sql.Date sqlDate = null;
    /**
     * Creates new form InvoiceApplication
     */
 public InvoiceApplication() {
    initComponents();
    //startH2Server();
    connectH2Database();
    
generateInvoiceNumber(); // 🔹 Auto-generate invoice number
    createTablesIfNotExist(); // ✅ Tables ഉണ്ടോ എന്ന് പരിശോധിക്കും// ✅ H2 database connect
    loadProductsToTable(); // Load at startup
    loadProductsToTable();
    loadProductsToComboBox();  // 👈 Add this line

//loadProductsToTable();
   // loadTableData();
    //loadProductsToComboBox();  // ✅ load from DB
    //invoice_no = "INV-" + someNumber;
    //    String invoice_no = lblInvoiceNo.getText();  // get current tex
//    lblInvoiceNo.setText(invoice_no);
     //double grandTotal;                              
   // String newInvoiceNo = generateInvoiceNumber();
    //lblInvoiceNo.setText(newInvoiceNo);
DefaultTableModel model = new DefaultTableModel(
    new Object[]{"Sl No", "Particular", "Qty", "Rate", "Total"}, 0
);




jTable3.setModel(model);

    Date today = new Date();
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String formattedDate = sdf.format(today);
    txtdate.setText(formattedDate);
    
    setTitle("Invoice Application");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu reportMenu = new JMenu("Reports");
        JMenuItem salesReportItem = new JMenuItem("Sales Report");

        reportMenu.add(salesReportItem);
        menuBar.add(reportMenu);
        setJMenuBar(menuBar);

        // When user clicks "Sales Report"
        salesReportItem.addActionListener(e -> {
            new SalesReportTable(); // opens the report window
        });

        setVisible(true); 

}
 
 
 // Convert dd-MM-yyyy → yyyy-MM-dd

// 🔹 1️⃣ Connect to H2 Database
    private void connectH2Database() {
        try {
            Class.forName("org.h2.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:h2:file:~/invoiceapp;AUTO_SERVER=TRUE", "sa", ""
            );
            System.out.println("✅ H2 Database connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //import org.h2.tools.Server;

private void startH2Server() {
    try {
        Server.createWebServer("-webAllowOthers", "-tcpAllowOthers", "-browser").start();
        System.out.println("🌐 H2 Web Console started at: http://localhost:8082");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    
 
    // ---------------------------------------------------------
    // 🔹 2️⃣ Create Tables if not exist
    private void createTablesIfNotExist() {
        try (Connection con = DriverManager.getConnection(
                "jdbc:h2:file:~/invoiceapp;AUTO_SERVER=TRUE", "sa", "");
             Statement st = con.createStatement()) {

            // 🧾 Products Table
            st.execute("CREATE TABLE IF NOT EXISTS products (" +
                       "id INT AUTO_INCREMENT PRIMARY KEY, " +
                       "name VARCHAR(255), " +
                       "rate DOUBLE)");

            // 🧾 Customers Table
            st.execute("CREATE TABLE IF NOT EXISTS customers (" +
                       "id INT AUTO_INCREMENT PRIMARY KEY, " +
                       "name VARCHAR(255), " +
                       "address VARCHAR(255))");

            // 🧾 Invoices Table
            st.execute("CREATE TABLE IF NOT EXISTS invoices (" +
                       "id INT AUTO_INCREMENT PRIMARY KEY, " +
                       "invoice_no VARCHAR(50), " +
                       "date DATE, " +
                       "customer_id INT, " +
                       "po_no VARCHAR(100), " +
                       "grand_total DOUBLE, " +
                       "FOREIGN KEY (customer_id) REFERENCES customers(id))");

            // 🧾 Invoice Items Table
            st.execute("CREATE TABLE IF NOT EXISTS invoice_items (" +
                       "id INT AUTO_INCREMENT PRIMARY KEY, " +
                       "invoice_id INT, " +
                       "product_id INT, " +
                       "qty INT, " +
                       "rate DOUBLE, " +
                       "total DOUBLE, " +
                       "FOREIGN KEY (invoice_id) REFERENCES invoices(id), " +
                       "FOREIGN KEY (product_id) REFERENCES products(id))");

            System.out.println("✅ All required tables verified/created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ---------------------------------------------------------
    // 🔹 മറ്റു functions (addProduct, loadProductsToTable, etc.)

// private void loadProductsToComboBox() {
//    try {
//        Connection con = DBConnection.getConnection();
//        String sql = "SELECT id, name, rate FROM products";
//        PreparedStatement ps = con.prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//
//        cmbProduct.removeAllItems();
//        cmbProduct.addItem("-- Select Product --");
//
//        while (rs.next()) {
//            int id = rs.getInt("id");
//            String name = rs.getString("name");
//            double rate = rs.getDouble("rate");
//            cmbProduct.addItem(name + " (" + rate + ")");
//        }
//
//        rs.close();
//        ps.close();
//        con.close();
//    } catch (Exception e) {
//        e.printStackTrace();
//        JOptionPane.showMessageDialog(this, "Error loading products: " + e.getMessage());
//    }
//}

//private JComboBox<ProductItem> comboProducts;
 // Inside constructor or initComponents



//private javax.swing.JComboBox<String> cmbProduct;

public void loadTableData() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0); // clear old data

    try {
        
        Connection con = DBConnection.getConnection();
        System.out.println("3");
        Statement stmt = con.createStatement();
        System.out.println("4");
        
        ResultSet rs = stmt.executeQuery("SELECT * FROM products");
System.out.println("5");
        while (rs.next()) {
            Object[] row = {
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("rate"),
                
            };
            model.addRow(row);
        }

        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    
    
    
}



// Class inside InvoiceApplication
private static class ProductItem {
    int id;
    String name;
    double rate;
    ProductItem(int id, String name, double rate) {
        this.id = id; this.name = name; this.rate = rate;
    }
    public String toString() { return name + " (" + rate + ")"; }
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        invoiceno = new javax.swing.JLabel();
        lblInvoiceNo = new javax.swing.JLabel();
        txtinvoiceno = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cusumername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        customeraddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtdate = new javax.swing.JLabel();
        txtadddataintable = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        cmbProduct = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtqty = new javax.swing.JTextField();
        txtpo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        lblwords = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lblgtotal = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vishnu Print House");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Products"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "PRICE"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 330, 140));

        jLabel1.setText("Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        jLabel2.setText("Price");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));
        jPanel1.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 210, -1));
        jPanel1.add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 210, -1));

        jButton4.setBackground(new java.awt.Color(51, 51, 255));
        jButton4.setText("REFRESH");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 250, -1));

        btnadd.setBackground(new java.awt.Color(102, 255, 0));
        btnadd.setText("Add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        jPanel1.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 70, -1));

        btnedit.setBackground(new java.awt.Color(255, 255, 51));
        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        jPanel1.add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 70, -1));

        btndelete.setBackground(new java.awt.Color(255, 51, 51));
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 70, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 610, 130));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Invoice"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        invoiceno.setText("Invoice Number :");
        jPanel2.add(invoiceno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        lblInvoiceNo.setText("0");
        jPanel2.add(lblInvoiceNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 90, 20));

        txtinvoiceno.setText("Save Invoice");
        txtinvoiceno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtinvoicenoActionPerformed(evt);
            }
        });
        jPanel2.add(txtinvoiceno, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 120, 30));

        jLabel3.setText("Customer Name");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, -1));
        jPanel2.add(cusumername, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 160, 30));

        jLabel4.setText("Address");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 70, -1));
        jPanel2.add(customeraddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 160, 30));

        jLabel5.setText("Date");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));
        jPanel2.add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 90, 20));

        txtadddataintable.setBackground(new java.awt.Color(0, 255, 0));
        txtadddataintable.setText("Add Item");
        txtadddataintable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtadddataintableActionPerformed(evt);
            }
        });
        jPanel2.add(txtadddataintable, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 100, 30));

        remove.setBackground(new java.awt.Color(255, 0, 0));
        remove.setText("Remove Item");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel2.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 100, 30));

        cmbProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProductActionPerformed(evt);
            }
        });
        jPanel2.add(cmbProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 150, 30));

        jLabel6.setText("Qty");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, -1));
        jPanel2.add(txtqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 60, 30));
        jPanel2.add(txtpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 160, 30));

        jLabel7.setText("PO No.");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 60, -1));

        jTable3.setBackground(new java.awt.Color(102, 153, 255));
        jTable3.setForeground(new java.awt.Color(255, 255, 255));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sl No", "Particular", "Qty", "Rate", "Total"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 310, 150));

        lblwords.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.add(lblwords, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 560, 20));

        jLabel8.setText("Grand Total");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, 20));

        lblgtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(lblgtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 100, 20));

        button1.setLabel("Report");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel2.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 610, 280));

        jPanel3.setBackground(new java.awt.Color(255, 204, 102));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("Vishnu Print House");
        jPanel3.add(jLabel9);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 610, 40));
        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    int selectedRow = jTable1.getSelectedRow();

    // Get values from the selected row
    String id = model.getValueAt(selectedRow, 0).toString();
    String name = model.getValueAt(selectedRow, 1).toString();
    String price = model.getValueAt(selectedRow, 2).toString();
    
    

    // Set them into text fields
    
    txtname.setText(name);
    txtprice.setText(price);
    btnadd.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
addProduct();

//        String name = txtname.getText();
//        String price1 = txtprice.getText(); // TODO add your handling code here:
//        
//         // Validation (optional)
//    if (name.isEmpty()  || price1.isEmpty()) {
//        JOptionPane.showMessageDialog(this, "Please fill all fields");
//        return;
//    }
//
//    try {
////        
//         double price = Double.parseDouble(price1);
//        // SQL INSERT
//        Connection conn = DBConnection.getConnection();
//        String sql = "INSERT INTO products (name, rate) VALUES (?, ?)";
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setString(1, name);
//        ps.setDouble(2, price);
//        
//
//        ps.executeUpdate();
//        JOptionPane.showMessageDialog(this, "Product added successfully!");
//
//        // Optional: refresh table data
//        loadTableData();
//
//        // clear fields
//        txtname.setText("");
//        txtprice.setText("");
//        
//
//        conn.close();
//    } catch (Exception e) {
//        e.printStackTrace();
//        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
//    }
    }//GEN-LAST:event_btnaddActionPerformed
// 🔹 3️⃣ Add Product Function
private void addProduct() {
    try {
        // TextField values വായിക്കുക
        String name = txtname.getText();
        String priceText = txtprice.getText();

        // Validation
        if (name.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
            return;
        }

        double rate = Double.parseDouble(priceText);

        // H2 Database connection
        Connection con = DriverManager.getConnection(
            "jdbc:h2:file:~/invoiceapp;AUTO_SERVER=TRUE", "sa", ""
        );

        // Insert Query
        String sql = "INSERT INTO products (name, rate) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setDouble(2, rate);
        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "✅ Product added successfully!");

        // Clear fields
        txtname.setText("");
        txtprice.setText("");

        // Optional: Table refresh
        loadProductsToTable();

        ps.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "❌ Error: " + e.getMessage());
    }
}
 //🔹 4️⃣ Load all products into JTable


    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
try {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product from the table to edit!");
            return;
        }

        // JTable നിന്നും പഴയ values എടുക്കുക
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int id = (int) model.getValueAt(selectedRow, 0); // ID column
        String name = txtname.getText().trim();
        String priceText = txtprice.getText().trim();

        if (name.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both name and price!");
            return;
        }

        double price = Double.parseDouble(priceText);

        // 🔹 Database update
        updateProductInDatabase(id, name, price);

        // 🔹 JTable refresh (reload data from DB)
        loadProductsToTable();

        JOptionPane.showMessageDialog(this, "✅ Product updated successfully!");

        // Clear fields
        txtname.setText("");
        txtprice.setText("");

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "❌ Invalid price format!");
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "❌ Error: " + e.getMessage());
    }
    //editSelectedItem();
    
    
//  DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//int selectedRow = jTable1.getSelectedRow();
//
//if (selectedRow == -1) {
//    JOptionPane.showMessageDialog(this, "Please select a row to update");
//    return;
//}

//int id = (int) model.getValueAt(selectedRow, 0);
//String name = txtname.getText().trim();
//String price = txtprice.getText().trim();

//if (name.isEmpty() || price.isEmpty()) {
//    JOptionPane.showMessageDialog(this, "Please fill all fields");
//    return;
//}

//try {
//    double price1 = Double.parseDouble(price);
//    Connection con = DBConnection.getConnection();
//
//    String sql = "UPDATE products SET name=?, rate=? WHERE id=?";
//    PreparedStatement ps = con.prepareStatement(sql);
//    ps.setString(1, name);
//    ps.setDouble(2, price1);
//    ps.setInt(3, id);
//
//    ps.executeUpdate();
//    JOptionPane.showMessageDialog(this, "Record updated successfully!");
//    loadTableData(); // refresh the JTable
//txtname.setText("");
//        txtprice.setText("");
//        btnadd.setEnabled(true);
//    con.close();
//} catch (Exception e) {
//    e.printStackTrace();
//    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
//}

    }//GEN-LAST:event_btneditActionPerformed
private void updateProductInDatabase(int id, String name, double rate) {
    try (Connection con = DriverManager.getConnection(
            "jdbc:h2:file:~/invoiceapp;AUTO_SERVER=TRUE", "sa", "");
         PreparedStatement ps = con.prepareStatement(
            "UPDATE products SET name = ?, rate = ? WHERE id = ?")) {

        ps.setString(1, name);
        ps.setDouble(2, rate);
        ps.setInt(3, id);
        ps.executeUpdate();

        System.out.println("✅ Product updated in database: " + name);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Database update error: " + e.getMessage());
    }
}
private void loadProductsToTable() {
    try (Connection con = DriverManager.getConnection(
            "jdbc:h2:file:~/invoiceapp;AUTO_SERVER=TRUE", "sa", "");
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT * FROM products")) {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear old rows

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double rate = rs.getDouble("rate");

            model.addRow(new Object[]{id, name, rate});
        }

        System.out.println("✅ Products loaded into JTable successfully!");

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error loading products: " + e.getMessage());
    }
}



    
    
    private void editSelectedItem() {
    DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
    int selectedRow = jTable3.getSelectedRow();
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, "Please select a row to edit!");
        return;
    }

    try {
        String productName = (String) model.getValueAt(selectedRow, 1);
        int qty = Integer.parseInt(model.getValueAt(selectedRow, 2).toString());
        double rate = Double.parseDouble(model.getValueAt(selectedRow, 3).toString());

        // Prompt new qty
        String newQtyText = JOptionPane.showInputDialog(this,
            "Enter new quantity for " + productName + ":", qty);
        if (newQtyText == null) return;  // Cancelled
        int newQty = Integer.parseInt(newQtyText);

        double newTotal = newQty * rate;

        model.setValueAt(newQty, selectedRow, 2);
        model.setValueAt(newTotal, selectedRow, 4);

        updateGrandTotal();

        JOptionPane.showMessageDialog(this, "✅ Item updated successfully!");

    } catch (NumberFormatException nfe) {
        JOptionPane.showMessageDialog(this, "Please enter a valid number for quantity.");
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error updating item: " + e.getMessage());
    }
}

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
try {
        String name = txtname.getText().trim();
        String priceText = txtprice.getText().trim();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter product name to delete!");
            return;
        }

        // Confirmation message
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete product: " + name + "?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        // Delete from database
        deleteProductFromDatabase(name);

        // Refresh table
        loadProductsToTable();

        // Clear text fields
        txtname.setText("");
        txtprice.setText("");

        JOptionPane.showMessageDialog(this, "🗑️ Product deleted successfully!");

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "❌ Error deleting product: " + e.getMessage());
    }

//        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//    int selectedRow = jTable1.getSelectedRow();
//
//    if (selectedRow == -1) {
//        JOptionPane.showMessageDialog(this, "Please select a row to delete");
//        return;
//    }
//
//    // Get the ID from the selected row (first column)
//    int id = (int) model.getValueAt(selectedRow, 0);
//
//    // Confirm before deleting
//    int confirm = JOptionPane.showConfirmDialog(this,
//            "Are you sure you want to delete this record?",
//            "Confirm Delete", JOptionPane.YES_NO_OPTION);
//
//    if (confirm != JOptionPane.YES_OPTION) {
//        return; // cancel delete
//    }
//
//    try {
//        Connection con = DBConnection.getConnection();
//        String sql = "DELETE FROM products WHERE id=?";
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setInt(1, id);
//
//        int rowsAffected = ps.executeUpdate();
//        if (rowsAffected > 0) {
//            JOptionPane.showMessageDialog(this, "Record deleted successfully!");
//            loadTableData(); // refresh table
//        } else {
//            JOptionPane.showMessageDialog(this, "No record found with ID: " + id);
//        }
//
//        con.close();
//    } catch (Exception e) {
//        e.printStackTrace();
//        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
//    }
    }//GEN-LAST:event_btndeleteActionPerformed
private void deleteProductFromDatabase(String name) {
    try (Connection con = DriverManager.getConnection(
            "jdbc:h2:file:~/invoiceapp;AUTO_SERVER=TRUE", "sa", "");
         PreparedStatement ps = con.prepareStatement("DELETE FROM products WHERE name = ?")) {

        ps.setString(1, name);
        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("✅ Product deleted from database: " + name);
        } else {
            JOptionPane.showMessageDialog(this, "⚠️ No product found with name: " + name);
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Database delete error: " + e.getMessage());
    }
}

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       // ✅ Text fields clear ചെയ്യുക
    cusumername.setText("");
    customeraddress.setText("");
    txtpo.setText("");
    txtqty.setText("");

    // ✅ ComboBox reset ചെയ്യുക
    cmbProduct.setSelectedIndex(-1); // ഒന്നും സെലക്ട് ആക്കാതെ വിടുക

    // ✅ Table (jTable3) ഉള്ള എല്ലാ rows remove ചെയ്യുക
    DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
    model.setRowCount(0);

    // ✅ Labels reset ചെയ്യുക
    lblgtotal.setText("0.00");
    lblwords.setText("");

    // ✅ പുതിയ ഇൻവോയിസ് നമ്പർ generate ചെയ്യുക
    generateNewInvoiceNo();

    // ✅ Success message (optional)
    JOptionPane.showMessageDialog(this, "Form refreshed successfully!"); // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
private void generateNewInvoiceNo() {
    try (Connection con = DriverManager.getConnection(
            "jdbc:h2:file:~/invoiceapp;AUTO_SERVER=TRUE", "sa", "");
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT MAX(id) FROM invoices")) {

        int nextId = 1;
        if (rs.next()) {
            nextId = rs.getInt(1) + 1;
        }
        lblInvoiceNo.setText("INV" + String.format("%04d", nextId));

    } catch (Exception e) {
        e.printStackTrace();
    }
}


    
//    private void generateInvoicePDFf() {
//    Document document = new Document(PageSize.A4, 36, 36, 36, 36);
//    
//    
//    try {
//        // 🔹 PDF File Path
//        String invoiceNo = lblInvoiceNo.getText();
//        String filePath = "C:/Invoices/" + invoiceNo + ".pdf";
//
//        // Folder ഉണ്ടോ എന്ന് പരിശോധിക്കുക
//        java.io.File folder = new java.io.File("C:/Invoices/");
//        if (!folder.exists()) folder.mkdirs();
//
//        PdfWriter.getInstance(document, new FileOutputStream(filePath));
//        document.open();
//
//        // ===========================
//        // 🔹 COMPANY HEADER SECTION
//        // ===========================
//        PdfPTable headerTable = new PdfPTable(2);
//        headerTable.setWidthPercentage(100);
//        headerTable.setWidths(new float[]{1, 3});
//
//        // 🔸 Logo (optional)
//       try {
//    Image logo = Image.getInstance("/Images/vpgh_logo.png");  // Path to your logo
//    logo.scaleToFit(80, 80); // Resize logo
//    logo.setAlignment(Image.ALIGN_LEFT); // Optional alignment
//
//    PdfPCell logoCell = new PdfPCell(logo, false);
//    logoCell.setBorder(PdfPCell.NO_BORDER); // Optional: remove border
//
//    // Example table for header
//    //PdfPTable headerTable = new PdfPTable(2);
//    headerTable.setWidthPercentage(100);
//    headerTable.addCell(logoCell);
//    headerTable.addCell(new PdfPCell(new Paragraph("Vishnu Print House\nAddress Line 1\nPhone: 1234567890")));
//
//    document.add(headerTable);
//} catch (Exception e) {
//    e.printStackTrace();
//}
//       
//       try {
//    // ✅ Dynamically detect project path
//    String basePath = new File("").getAbsolutePath(); 
//    String logoPath = basePath + File.separator + "images" + File.separator + "vph_logo.png";
//
//    PdfPCell logoCell;
//
//    File logoFile = new File(logoPath);
//    if (logoFile.exists()) {
//        // 🖼️ If logo exists, load it
//        Image logo = Image.getInstance(logoPath);
//        logo.scaleToFit(80, 80); // adjust logo size
//        logoCell = new PdfPCell(logo, false);
//        System.out.println("✅ Logo loaded from: " + logoPath);
//    } else {
//        // 🧾 If logo missing, show fallback text
//        Font fallbackFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.GRAY);
//        Paragraph fallback = new Paragraph("Company Logo", fallbackFont);
//        logoCell = new PdfPCell(fallback);
//        logoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        logoCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        System.out.println("⚠️ Logo not found — showing fallback text instead.");
//    }
//
//    logoCell.setBorder(Rectangle.NO_BORDER);
//    headerTable.addCell(logoCell);
//
//} catch (Exception e) {
//    e.printStackTrace();
//}
//
//
//
//        // 🔸 Company Name & Address
//        Font companyFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
//        Font addressFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
//
//        PdfPCell companyCell = new PdfPCell();
//        companyCell.setBorder(Rectangle.NO_BORDER);
//        companyCell.addElement(new Paragraph("Vishnu Print House", companyFont));
//        companyCell.addElement(new Paragraph("Opp:Petrolpump, Koyyamarakkad, Kanjikode, Palakkad-678621", addressFont));
//        companyCell.addElement(new Paragraph("Phone: 8547706377,9809414537 | Email: vishnuprinthouse101@gmail.com", addressFont));
//        headerTable.addCell(companyCell);
//
//        document.add(headerTable);
//        document.add(new Paragraph(" "));
//        document.add(new LineSeparator());
//        document.add(new Paragraph(" "));
//
//        // ===========================
//        // 🔹 INVOICE INFO
//        // ===========================
//        Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
//        Paragraph title = new Paragraph("INVOICE", titleFont);
//        title.setAlignment(Element.ALIGN_CENTER);
//        document.add(title);
//        document.add(new Paragraph(" "));
//
//        document.add(new Paragraph("Invoice No: " + lblInvoiceNo.getText()));
//        document.add(new Paragraph("Date: " + txtdate.getText()));
//        document.add(new Paragraph("Customer Name: " + cusumername.getText()));
//        document.add(new Paragraph("Address: " + customeraddress.getText()));
//        document.add(new Paragraph("PO No: " + txtpo.getText()));
//        document.add(new Paragraph(" "));
//
//        // ===========================
//        // 🔹 ITEMS TABLE
//        // ===========================
//        PdfPTable table = new PdfPTable(5);
//        table.setWidthPercentage(100);
//        table.addCell("Sl No");
//        table.addCell("Particular");
//        table.addCell("Qty");
//        table.addCell("Rate");
//        table.addCell("Total");
//
//        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
//        for (int i = 0; i < model.getRowCount(); i++) {
//            table.addCell(String.valueOf(i + 1));
//            table.addCell(model.getValueAt(i, 1).toString());
//            table.addCell(model.getValueAt(i, 2).toString());
//            table.addCell(model.getValueAt(i, 3).toString());
//            table.addCell(model.getValueAt(i, 4).toString());
//        }
//        document.add(table);
//
//        // ===========================
//        // 🔹 TOTAL & SIGNATURE
//        // ===========================
//        document.add(new Paragraph(" "));
//        document.add(new Paragraph("Grand Total: ₹" + lblgtotal.getText()));
//        document.add(new Paragraph("Amount in Words: " + lblwords.getText()));
//        document.add(new Paragraph(" "));
//
//        Paragraph auth = new Paragraph("Authorized Signature", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
//        auth.setAlignment(Element.ALIGN_RIGHT);
//        document.add(auth);
//
//        document.close();
//
//        JOptionPane.showMessageDialog(this, "✅ Invoice PDF generated successfully!\nSaved at: " + filePath);
//
//        // 🔹 Open PDF automatically
//        java.awt.Desktop.getDesktop().open(new java.io.File(filePath));
//
//    } catch (Exception e) {
//        e.printStackTrace();
//        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
//    }
//}
//Image logo = Toolkit.getDefaultToolkit().getImage("/images/vph_logo.png");
    private void txtinvoicenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtinvoicenoActionPerformed

BufferedImage logo = null;
try {
    java.net.URL logoURL = getClass().getResource("/InvoiceApplication/images/vph_logo.png");
    if (logoURL != null) {
        logo = ImageIO.read(logoURL); // image load പൂർണ്ണമായി
        System.out.println("✅ Logo image fully loaded from inside JAR!");
    } else {
        File externalLogo = new File("images/vph_logo.png");
        if (externalLogo.exists()) {
            logo = ImageIO.read(externalLogo);
            System.out.println("✅ Logo image fully loaded from external path!");
        } else {
            System.out.println("❌ Logo not found anywhere!");
        }
    }
} catch (Exception e) {
    e.printStackTrace();
}



     String invoiceNo = lblInvoiceNo.getText();
    String date = txtdate.getText();
    String customerName = cusumername.getText();
    String customerAddress = customeraddress.getText();
    String po = txtpo.getText();
    

    DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
    
    double grandTotal = calculateGrandTotal();
    String amountInWords = convertToWords(grandTotal);

//String amountInWords = convertToWords(grandTotal);
    PrinterJob job = PrinterJob.getPrinterJob();
    job.setPrintable(new InvoicePrintable(invoiceNo, date, customerName,
            customerAddress, po, model, grandTotal,amountInWords));

    // ✅ Multiple Printer Selection dialog
    if (job.printDialog()) {
        try {
            job.print();
        } catch (PrinterException ex) {
            ex.printStackTrace();
        }
    }  
        
        //generateInvoicePDFf();
        
        
        
        //new
//       try {
//    String invoiceNo = lblInvoiceNo.getText();
//    String date = txtdate.getText();
//    String customerName = cusumername.getText();
//    String customerAddress = customeraddress.getText();
//    String poNo = txtpo.getText();
//    DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
//
//    double grandTotal = Double.parseDouble(lblgtotal.getText());
//    String amountWords = "Rupees " + lblwords.getText() + " Only";
//
//    Image logo = Toolkit.getDefaultToolkit().getImage("InvoiceApplication/Image/vph_logo.png");
//
//
//    PrinterJob job = PrinterJob.getPrinterJob();
//    job.setPrintable(new InvoicePrintable(invoiceNo, date, customerName, customerAddress,
//                                          poNo, model, grandTotal, amountWords, logo));
//
//    // 🔹 Show printer selection dialog
//    if (job.printDialog()) {
//        job.print();
//        JOptionPane.showMessageDialog(this, "✅ Invoice printed successfully!");
//    }
//
//} catch (Exception ex) {
//    ex.printStackTrace();
//    JOptionPane.showMessageDialog(this, "❌ Print failed: " + ex.getMessage());
//}

//        try {
//try {
//    // Create logo image
////    String logoPath = new File("images", "vph_logo.png").getAbsolutePath();
////Image logo = Toolkit.getDefaultToolkit().getImage(logoPath);
//   // Image logo = Toolkit.getDefaultToolkit().getImage("/dist/images/vph_logo.png");
////URL logoUrl = getClass().getResource("/images/vph_logo.png");
////    if (logoUrl != null) {
////        logo = Toolkit.getDefaultToolkit().getImage(logoUrl);
////         System.err.println("⚠️ Logo found inside JAR!");
////    } else {
////        System.err.println("⚠️ Logo not found inside JAR!");
////    }
//   String baseDir = System.getProperty("user.dir");  // current working directory (exe or jar location)
//String logoPath = baseDir + File.separator + "images" + File.separator + "vph_logo.png";
//Image logo = Toolkit.getDefaultToolkit().getImage(logoPath); 
//    File f = new File(logoPath);
//if (!f.exists()) {
//    System.err.println("⚠️ Logo not found at: " + f.getAbsolutePath());
//} else {
//    System.out.println("✅ Logo found: " + f.getAbsolutePath());
//}
//
//    // Get table model
//    DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
//
//    // Create PrinterJob
//    PrinterJob job = PrinterJob.getPrinterJob();
//    job.setJobName("Invoice - " + lblInvoiceNo.getText());
//
//    // Create printable content
//    InvoicePrintable printable = new InvoicePrintable(
//        lblInvoiceNo.getText(),            // Invoice No
//        txtdate.getText(),                 // Date
//        cusumername.getText(),             // Customer Name
//        customeraddress.getText(),         // Address
//        txtpo.getText(),                   // PO No
//        model,                             // JTable model
//        Double.parseDouble(lblgtotal.getText()), // Grand total
//        "Rupees " + lblwords.getText() ,
//        logo
//    );
//
//    job.setPrintable(printable);
//
//    // 🔽 SHOW PRINTER SELECTION DIALOG 🔽
//    boolean doPrint = job.printDialog();   // ← this opens printer selection window
//    if (doPrint) {
//        job.print();                       // user selected a printer → print it
//        JOptionPane.showMessageDialog(this, "🖨️ Invoice sent to printer successfully!");
//    } else {
//        JOptionPane.showMessageDialog(this, "❌ Print cancelled by user.");
//    }
//
//} catch (Exception e) {
//    e.printStackTrace();
//    JOptionPane.showMessageDialog(this, "❌ Print failed: " + e.getMessage());
//}
//
//        } catch (Exception e) {
//        }



 // ഇനി പ്രിന്റ് ചെയ്യുക 👇
//        try {
//            PrinterJob job = PrinterJob.getPrinterJob();
//    job.setPrintable(new InvoicePrintable());
//    if (job.printDialog()) {
//        job.print();
//    } 
//        } catch (Exception e) {
//        }
   

saveInvoiceToDatabase();


//        try {
//        String invoiceNo = lblInvoiceNo.getText();
//        String customer = cusumername.getText();
//        String address = customeraddress.getText();
//        double grandTotal = Double.parseDouble(lblgtotal.getText());
//        String amountWords = lblwords.getText();
//        
//
//        Image logo = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/vph_logo.png"));
//
//        PrinterJob job = PrinterJob.getPrinterJob();
//        job.setPrintable(new InvoicePrintable(invoiceNo, customer, address, grandTotal, amountWords, logo));
//
//        if (job.printDialog()) {
//            job.print();
//            JOptionPane.showMessageDialog(this, "Invoice printed successfully!");
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//try {
//   // String logoPath = "InvoiceApplication/images/vpgh_logo.png";
//    //Image logo = Toolkit.getDefaultToolkit().getImage(logoPath);
//
//    // Customer details
//    String customer = cusumername.getText();
//    String address = customeraddress.getText();
//
//    // ✅ Extract only the numeric part of the invoice number
//    String invStr = lblInvoiceNo.getText().trim(); // Example: "INV0052"
//    String numPart = invStr.replaceAll("[^0-9]", ""); // gives "0052"
//    int invoiceNo = Integer.parseInt(numPart);
//
//    // Get total safely
//    double total = 0.0;
//    try {
//        total = Double.parseDouble(lblgtotal.getText()); // Use total label, not invoice no!
//    } catch (Exception ex) {
//        JOptionPane.showMessageDialog(null, "Invalid Total Amount!");
//        return;
//    }
//
//    String amountWords = "Rupees " + total + " Only";
//
//    // ✅ Convert invoiceNo back to string for printable class
//    String inv = String.format("INV%04d", invoiceNo);
//
//    //PrinterJob job = PrinterJob.getPrinterJob();
//   // job.setPrintable(new InvoicePrintable(inv, customer, address, total, amountWords, logo));
//
//    job.print();
//
//    JOptionPane.showMessageDialog(this, "🖨️ Invoice printed successfully to A4 paper!");
//} catch (Exception e) {
//    e.printStackTrace();
//    JOptionPane.showMessageDialog(this, "❌ Print failed: " + e.getMessage());
//}
////String logoPath = "InvoiceApplication/images/vpgh_logo.png";
//   // Image logo = Toolkit.getDefaultToolkit().getImage(logoPath);
//
//    // Customer details
//    String customer = cusumername.getText();
//    String address = customeraddress.getText();
//
//    // ✅ Extract only the numeric part of the invoice number
//    String invStr = lblInvoiceNo.getText().trim(); // Example: "INV0052"
//    String numPart = invStr.replaceAll("[^0-9]", ""); // gives "0052"
//    int invoiceNo = Integer.parseInt(numPart);
//   //PrinterJob job = PrinterJob.getPrinterJob();
//   
//   //double grandTotal = Double.parseDouble(txtGrandTotal.getText());
//String amountWords = lblwords.getText();
//Image logo = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/vph_logo.png"));
//
//PrinterJob job = PrinterJob.getPrinterJob();
//job.setPrintable(new InvoicePrintable(invoiceNo, customer, address, grandTotal, amountWords, logo));
//
//if (job.printDialog()) {
//    job.print();
//}
//
//job.setPrintable(new InvoicePrintable(invoiceNo, customer, address, grandTotal, amountWords, logo));
//
//if (job.printDialog()) {
//            try {
//                job.print(); // prints to selected printer
//            } catch (PrinterException ex) {
//                Logger.getLogger(InvoiceApplication.class.getName()).log(Level.SEVERE, null, ex);
//            }
//    JOptionPane.showMessageDialog(this, "🖨️ Invoice printed successfully!");
//}
     
        
//         saveInvoiceToDatabase();
//         try {
//             String logoPath = "InvoiceApplication/images/vpgh_logo.png";
//Image logo = Toolkit.getDefaultToolkit().getImage(logoPath);
//
//        // Example data from your form
//        //String invoiceNo = lblInvoiceNo.getText();
//        String customer = cusumername.getText();
//        String address = customeraddress.getText();
//        
//        try {
//    String invStr = txtinvoiceno.getText();
//    String numPart = invStr.replaceAll("[^0-9]", "");
//    int invoiceNo = Integer.parseInt(lblInvoiceNo.getText());
//    // continue your logic here
//} catch (NumberFormatException ex) {
//    JOptionPane.showMessageDialog(null, "Invalid Invoice Number Format!");
//}
//
//        double total = Double.parseDouble(lblInvoiceNo.getText());
//        String amountWords = "Rupees " + total + " Only";
//
//        //Image logo = Toolkit.getDefaultToolkit().getImage("InvoiceApplication/images/vph_logo.png");
////String invoiceNo = lblInvoiceNo.getText();
//int invoiceNo = Integer.parseInt(lblInvoiceNo.getText());
//        PrinterJob job = PrinterJob.getPrinterJob();
//        String inv = String.valueOf(invoiceNo);
//
//        job.setPrintable(new InvoicePrintable(inv, customer, address, total, amountWords, logo));
//
//        // Auto print without showing dialog
//        job.print();
//
//        JOptionPane.showMessageDialog(this, "🖨️ Invoice printed successfully to A4 paper!");
//    } catch (Exception e) {
//        e.printStackTrace();
//        JOptionPane.showMessageDialog(this, "❌ Print failed: " + e.getMessage());
//    }
        
//         try {
//            // ഫോൾഡർ ഉണ്ടാക്കുന്നു
//            File folder = new File("C:/Invoices");
//            if (!folder.exists()) {
//                folder.mkdirs();
//            }
//
//            // ഡോക്യുമെന്റ് സൃഷ്ടിക്കുന്നു
//            Document document = new Document(PageSize.A4, 36, 36, 36, 36);
//            PdfWriter.getInstance(document, new FileOutputStream("C:/Invoices/invoice.pdf"));
//            document.open();
//
//            // ഉള്ളടക്കം ചേർക്കുന്നു
//            document.add(new Paragraph("Invoice Example", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));
//            document.add(new Paragraph("ഇത് ഒരു ഉദാഹരണ ഇൻവോയ്സ് ആണ്."));
//
//            document.close(); // അടയ്ക്കുക
//            System.out.println("✅ PDF വിജയകരമായി സേവ് ചെയ്തു: C:/Invoices/invoice.pdf");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        
//        try {
//         //loo();
//         
//         
//         
//         
//         
//         
//         
//         
//         
//         
//         
//        // String invoiceNo = generateInvoiceNumber();
//         //lblInvoiceNo.setText(invoiceNo);
//         
//         int invoiceNo = Integer.parseInt(lblInvoiceNo.getText().trim());
//         String date = txtdate.getText().trim();
//         String customer = cusumername.getText().trim();
//         String address = customeraddress.getText().trim();
//         String po = txtpo.getText().trim();
//         
//         double total = Double.parseDouble(lblgtotal.getText().trim());
//         String amountInWords = convertNumberToWords((int) total) + " Only";
//         System.out.println(amountInWords+"amount in words");
//         DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
//         System.out.println(amountInWords+"amount in words");
//         String companyName = "Vishnu Print House";
//         String companyAddress = "Opp:Petrolpump, Koyyamarakkad, Kanjikode Palakkad";
//         String email = "vishnuprinthouse101@gmail.com";
//         String website = "www.vishnuprinthouse101.com";
//         String INVOICE = "INVOICE";
//         String logoPath = "\\InvoiceApplication\\images\\vph_logo.png"; // update your logo path
//         //String logoPath = "G:\\InvoiceApplication\\images\\vph_logo.png"; // update your logo path
//         //Image logoPath = ImageIO.read(new File("G:\\InvoiceApplication\\images\\vph_logo.png"));
//         
//         
//         System.out.println(amountInWords+"amount in words");
////         InvoicePrintable.printInvoice(
////                 invoiceNo1, date, customer, address, po, model, total,
////                 companyName, companyAddress, email, website, logoPath, amountInWords, INVOICE
////         );
//         System.out.println(amountInWords+"amount in words last");
//         //printInvoice();
//         //saveInvoiceToDatabase();
//         //calculateGrandTotal();
//         // lblwords.setText();
//         
//         
//         
//         
/////h2
//Connection con = DatabaseConnection.getConnection();
//   
//// Invoice Fields
//// നിങ്ങളുടെ ഫീൽഡ് പേര്
//// നിങ്ങളുടെ PO നമ്പർ field പേര്
//
//// Customer ComboBox നിന്ന് ID എടുക്കുക
//int selectedCustomerId = 0;
////String selectedCustomerName = (String) customerComboBox.getSelectedItem();
//
//PreparedStatement ps2 = con.prepareStatement("SELECT id FROM customers WHERE name = ?");
//ps2.setString(1, customer);
//ResultSet rs = ps2.executeQuery();
//
//
//
//if (rs.next()) {
//    selectedCustomerId = rs.getInt("id");
//}
//
//// JTable ലെ grand total കണക്കാക്കുക
//double grandTotal = 0.0;
//for (int i = 0; i < jTable3.getRowCount(); i++) {
//    //double total = Double.parseDouble(itemsTable.getValueAt(i, 4).toString());
//    grandTotal += total;
//}
//
//// Invoice insert ചെയ്യുക
//PreparedStatement ps = con.prepareStatement(
//        "INSERT INTO invoices(invoice_no, date, customer_id, po_no, grand_total) VALUES(?,?,?,?,?)");
//ps.setString(1,  lblInvoiceNo.getText().trim());
//ps.setString(2, date);
//ps.setInt(3, selectedCustomerId);
//ps.setString(4, po);
//ps.setDouble(5, grandTotal);
//
//ps.executeUpdate();
//System.out.println("✅ Invoice saved successfully!");
//
//
////h2 end
//     } catch (SQLException ex) {
//         Logger.getLogger(InvoiceApplication.class.getName()).log(Level.SEVERE, null, ex);
//     }
// 
 
 
 

    }//GEN-LAST:event_txtinvoicenoActionPerformed

    private double calculateGrandTotal() {
    DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
    double total = 0;
    for (int i = 0; i < model.getRowCount(); i++) {
        try {
            total += Double.parseDouble(model.getValueAt(i, 4).toString());
        } catch (Exception e) {}
    }
    return total;
}



    // lblgtotal → lblwords
//private void calculateGrandTotal() {
//    double total = 0.0;
//    for (int i = 0; i < jTable3.getRowCount(); i++) {
//        total += Double.parseDouble(jTable3.getValueAt(i, 4).toString()); // Total column
//    }
//    lblgtotal.setText(String.format("%.2f", total));
//
//    // 👉 Amount in words സെറ്റ് ചെയ്യുന്നത് ഇവിടെ
//    double grandTotal = Double.parseDouble(lblgtotal.getText());
//    String amountInWords = convertNumberToWords((int) grandTotal);
//    lblwords.setText(amountInWords + " only");
//}

//private String convertToWords(double amount) {
//    if (amount == 0) return "Zero Rupees Only";
//
//    String[] units = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
//                       "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
//                       "Eighteen", "Nineteen" };
//    String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
//
//    long rupees = (long) amount;
//    int paise = (int) Math.round((amount - rupees) * 100);
//
//    String words = "";
//    if (rupees >= 10000000) {
//        words += convertToWords(rupees / 10000000) + " Crore ";
//        rupees %= 10000000;
//    }
//    if (rupees >= 100000) {
//        words += convertToWords(rupees / 100000) + " Lakh ";
//        rupees %= 100000;
//    }
//    if (rupees >= 1000) {
//        words += convertToWords(rupees / 1000) + " Thousand ";
//        rupees %= 1000;
//    }
//    if (rupees >= 100) {
//        words += convertToWords(rupees / 100) + " Hundred ";
//        rupees %= 100;
//    }
//    if (rupees > 0) {
//        if (rupees < 20) {
//            words += units[(int) rupees];
//        } else {
//            words += tens[(int) (rupees / 10)] + " " + units[(int) (rupees % 10)];
//        }
//    }
//
//    words = words.trim();
//
//    if (paise > 0) {
//        words += " and " + convertToWords(paise) + " Paise";
//    }
//
//    return "Rupees " + words + " Only";
//}
//
// private String convertNumberToWords(int number) {
//    String[] units = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
//        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
//        "Seventeen", "Eighteen", "Nineteen" };
//
//    String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
//
//    if (number == 0) {
//        return "Zero";
//    }
//
//    if (number < 20) {
//        return units[number];
//    }
//
//    if (number < 100) {
//        return tens[number / 10] + ((number % 10 != 0) ? " " + units[number % 10] : "");
//    }
//
//    if (number < 1000) {
//        return units[number / 100] + " Hundred" + ((number % 100 != 0) ? " and " + convertNumberToWords(number % 100) : "");
//    }
//
//    if (number < 100000) {
//        return convertNumberToWords(number / 1000) + " Thousand" + ((number % 1000 != 0) ? " " + convertNumberToWords(number % 1000) : "");
//    }
//
//    if (number < 10000000) {
//        return convertNumberToWords(number / 100000) + " Lakh" + ((number % 100000 != 0) ? " " + convertNumberToWords(number % 100000) : "");
//    }
//
//    return convertNumberToWords(number / 10000000) + " Crore" + ((number % 10000000 != 0) ? " " + convertNumberToWords(number % 10000000) : "");
//}
   
    
    private void saveInvoiceToDatabase() {
    Connection con = null;
    PreparedStatement psInvoice = null;
    PreparedStatement psItem = null;

    try {
        // 🧩 Database connection
        con = DriverManager.getConnection("jdbc:h2:file:~/invoiceapp;AUTO_SERVER=TRUE", "sa", "");
        con.setAutoCommit(false); // Start transaction
String dateString = txtdate.getText();  // അല്ലെങ്കിൽ നിന്റെ variable
SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");
String formattedDate = dbFormat.format(inputFormat.parse(dateString));

        // 🧾 Get all values from UI
        String invoiceNo = lblInvoiceNo.getText();
        
        String date = txtdate.getText();
        String customer = cusumername.getText();
        String address = customeraddress.getText();
        String po = txtpo.getText();
        double grandTotal = Double.parseDouble(lblgtotal.getText());

        // ✅ 1️⃣ Insert customer if not exists
        int customerId = 0;
        PreparedStatement psCust = con.prepareStatement(
            "SELECT id FROM customers WHERE name=? AND address=?"
        );
        psCust.setString(1, customer);
        psCust.setString(2, address);
        ResultSet rsCust = psCust.executeQuery();

        if (rsCust.next()) {
            customerId = rsCust.getInt("id");
        } else {
            psCust = con.prepareStatement(
                "INSERT INTO customers (name, address) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS
            );
            psCust.setString(1, customer);
            psCust.setString(2, address);
            psCust.executeUpdate();

            ResultSet genKeys = psCust.getGeneratedKeys();
            if (genKeys.next()) {
                customerId = genKeys.getInt(1);
            }
        }

        // ✅ 2️⃣ Insert into invoices
        psInvoice = con.prepareStatement(
            "INSERT INTO invoices (invoice_no, date, customer_id, po_no, grand_total) VALUES (?, ?, ?, ?, ?)",
            Statement.RETURN_GENERATED_KEYS
        );
        psInvoice.setString(1, invoiceNo);
        
        psInvoice.setString(2, formattedDate);
        psInvoice.setInt(3, customerId);
        psInvoice.setString(4, po);
        psInvoice.setDouble(5, grandTotal);
        psInvoice.executeUpdate();

        ResultSet rsInvoice = psInvoice.getGeneratedKeys();
        int invoiceId = 0;
        if (rsInvoice.next()) {
            invoiceId = rsInvoice.getInt(1);
        }

        // ✅ 3️⃣ Insert invoice items from jTable3
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();

        psItem = con.prepareStatement(
            "INSERT INTO invoice_items (invoice_id, product_id, qty, rate, total) VALUES (?, ?, ?, ?, ?)"
        );

        for (int i = 0; i < model.getRowCount(); i++) {
            String productName = model.getValueAt(i, 1).toString(); // Particular column
            int qty = Integer.parseInt(model.getValueAt(i, 2).toString());
            double rate = Double.parseDouble(model.getValueAt(i, 3).toString());
            double total = Double.parseDouble(model.getValueAt(i, 4).toString());

            // 🔍 Get product_id from products table
            PreparedStatement psProd = con.prepareStatement("SELECT id FROM products WHERE name=?");
            psProd.setString(1, productName);
            ResultSet rsProd = psProd.executeQuery();

            int productId = 0;
            if (rsProd.next()) {
                productId = rsProd.getInt("id");
            }

            psItem.setInt(1, invoiceId);
            psItem.setInt(2, productId);
            psItem.setInt(3, qty);
            psItem.setDouble(4, rate);
            psItem.setDouble(5, total);
            psItem.addBatch();
        }

        psItem.executeBatch();
        con.commit();

        JOptionPane.showMessageDialog(this, "✅ Invoice saved successfully!");
        generateInvoiceNumber(); // Generate next invoice no
        lblgtotal.setText("0.00");
        ((DefaultTableModel) jTable3.getModel()).setRowCount(0); // Clear table

    } catch (Exception e) {
        e.printStackTrace();
        try { if (con != null) con.rollback(); } catch (Exception ex) {}
        JOptionPane.showMessageDialog(this, "❌ Error saving invoice: " + e.getMessage());
    } finally {
        try { if (psInvoice != null) psInvoice.close(); } catch (Exception ex) {}
        try { if (psItem != null) psItem.close(); } catch (Exception ex) {}
        try { if (con != null) con.close(); } catch (Exception ex) {}
    }
}

private void generateInvoiceNumber() {
    try (Connection con = DriverManager.getConnection(
            "jdbc:h2:file:~/invoiceapp;AUTO_SERVER=TRUE", "sa", "");
         Statement st = con.createStatement()) {

        // Get last invoice ID
        ResultSet rs = st.executeQuery("SELECT MAX(id) AS max_id FROM invoices");
        int nextId = 1;

        if (rs.next()) {
            nextId = rs.getInt("max_id") + 1;
        }

        // Format the invoice number like INV0001, INV0002, etc.
        String invoiceNo = String.format("INV%04d", nextId);

        // Set the value into label
        lblInvoiceNo.setText(invoiceNo);
       

        System.out.println("✅ Generated Invoice No: " + invoiceNo);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error generating invoice number: " + e.getMessage());
    }
}


//amount inwords
    
//    private static String  convertToWords(double amount) {
//    if (amount == 0) return "Zero Rupees Only";
//
//    long rupees = (long) amount;
//    int paise = (int) Math.round((amount - rupees) * 100);
//
//    String rupeeWords = convertNumberToWords(rupees);
//    String paiseWords = paise > 0 ? " and " + convertNumberToWords(paise) + " Paise" : "";
//
//    return "Rupees " + rupeeWords + paiseWords + " Only";
//}
//
//private static String  convertNumberToWords(long number) {
//    String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
//            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
//    String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
//
//    if (number < 20) return units[(int) number];
//    if (number < 100) return tens[(int) (number / 10)] + (number % 10 != 0 ? " " + units[(int) (number % 10)] : "");
//    if (number < 1000)
//        return units[(int) (number / 100)] + " Hundred " + convertNumberToWords(number % 100);
//    if (number < 100000)
//        return convertNumberToWords(number / 1000) + " Thousand " + convertNumberToWords(number % 1000);
//    if (number < 10000000)
//        return convertNumberToWords(number / 100000) + " Lakh " + convertNumberToWords(number % 100000);
//    return convertNumberToWords(number / 10000000) + " Crore " + convertNumberToWords(number % 10000000);
//}

    
    
    
//private void saveInvoiceToDatabase() {
//    Connection con = null;
//    PreparedStatement psInvoice = null;
//    PreparedStatement psItems = null;
//    int invoiceId = 0; // declare here so visible everywhere
//
//    try {
//        con = DBConnection.getConnection();
//
//        // 1️⃣ Insert invoice
//        String sqlInvoice = "INSERT INTO invoices (invoice_no, date, customer_name, address, po_no, grand_total) VALUES (?, ?, ?, ?, ?, ?)";
//        psInvoice = con.prepareStatement(sqlInvoice, Statement.RETURN_GENERATED_KEYS);
//
//        // ---- set parameters ----
//        psInvoice.setString(1, lblInvoiceNo.getText());
//
//        // convert date safely
//        java.sql.Date sqlDate = null;
//        try {
//            java.util.Date parsedDate = new java.text.SimpleDateFormat("dd-MM-yyyy").parse(txtdate.getText());
//            sqlDate = new java.sql.Date(parsedDate.getTime());
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Invalid date format (use dd-MM-yyyy)");
//            return;
//        }
//
//        psInvoice.setDate(2, sqlDate);
//        psInvoice.setString(3, cusumername.getText());
//        psInvoice.setString(4, customeraddress.getText());
//        psInvoice.setString(5, txtpo.getText());
//        psInvoice.setDouble(6, Double.parseDouble(lblgtotal.getText()));
//
//        psInvoice.executeUpdate();
//
//        // 2️⃣ Get generated invoice_id
//        ResultSet generatedKeys = psInvoice.getGeneratedKeys();
//        if (generatedKeys.next()) {
//            invoiceId = generatedKeys.getInt(1);
//        }
//
//        System.out.println("Generated invoice ID: " + invoiceId);
//
//        // 3️⃣ Insert items
//        String sqlItems = "INSERT INTO invoice_items (invoice_id, si_no, particular, product_name, qty, rate, total) VALUES (?, ?, ?, ?, ?, ?, ?)";
//        psItems = con.prepareStatement(sqlItems);
//
//        for (int i = 0; i < jTable3.getRowCount(); i++) {
//             double siNo = Double.parseDouble(jTable3.getValueAt(i, 0).toString());
//psItems.setDouble(2, siNo);
//            //int siNo = Integer.parseInt(jTable3.getValueAt(i, 0).toString());
//            String particular = jTable3.getValueAt(i, 1).toString();
//            String productName = jTable3.getValueAt(i, 1).toString(); // adjust column index if needed
//           // int qty = Integer.parseInt(jTable3.getValueAt(i, 2).toString());
//          
//
//            double rate = Double.parseDouble(jTable3.getValueAt(i, 3).toString());
//            double total = Double.parseDouble(jTable3.getValueAt(i, 4).toString());
//
////            psItems.setInt(1, invoiceId);
////            psItems.setInt(2, (int) siNo);
////            psItems.setString(3, particular);
////            psItems.setString(4, productName);
////            psItems.setInt(5, qty);
////            psItems.setDouble(6, rate);
////            psItems.setDouble(7, total);
////            psItems.addBatch();
//
//for (int j = 0; j < jTable3.getRowCount(); j++) {
//    String si = jTable3.getValueAt(j, 0).toString();
//    String name = jTable3.getValueAt(j, 1).toString();
//    double qty = Double.parseDouble(jTable3.getValueAt(j, 2).toString());
//double rat = Double.parseDouble(jTable3.getValueAt(j, 3).toString());
//double tota = Double.parseDouble(jTable3.getValueAt(j, 4).toString());
//
//    psItems.setInt(1, invoiceId);
//    psItems.setString(2, si);
//    psItems.setString(3, particular);
//    psItems.setString(4, name);
////    psItems.setString(3, name);
//    psItems.setInt(5, (int) qty);
//    psItems.setDouble(6, rate);
//    psItems.setDouble(7, tota);
//    
//    
//
//    psItems.addBatch();
//}
//
//
//        }
//
//        psItems.executeBatch();
//        JOptionPane.showMessageDialog(this, "Invoice and items saved successfully!");
//
//    } catch (Exception e) {
//        e.printStackTrace();
//        JOptionPane.showMessageDialog(this, "Error saving invoice: " + e.getMessage());
//    } finally {
//        try {
//            if (psItems != null) psItems.close();
//            if (psInvoice != null) psInvoice.close();
//            if (con != null) con.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//}
private void printInvoice() {
    try {
        // Get current text (e.g., "INV0001")
        String lastNo = lblInvoiceNo.getText().trim();

        // Remove "INV" prefix
        int num = Integer.parseInt(lastNo.replaceAll("INV", ""));

        // Generate next number
        String newInvoiceNo = String.format("INV%04d", num + 1);

        // Display new invoice number
        lblInvoiceNo.setText(newInvoiceNo);
    } catch (Exception e) {
        lblInvoiceNo.setText("INV0001"); // first invoice
    }
}





    private void txtadddataintableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtadddataintableActionPerformed
        //addProductToTable();
        //DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
          

try {
        // 🔹 Get input values
        String customer = cusumername.getText();
        String address = customeraddress.getText();
        String poNo = txtpo.getText();
        String productName = (String) cmbProduct.getSelectedItem();
        String qtyText = txtqty.getText();

        if (productName == null || qtyText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select product and enter quantity!");
            return;
        }

        int qty = Integer.parseInt(qtyText);

        // 🔹 Get product rate from database
        double rate = getProductRate(productName);
        double total = qty * rate;

        // 🔹 Add to jTable3
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        int slNo = model.getRowCount() + 1;

        Object[] row = {slNo, productName, qty, rate, total};
        model.addRow(row);

        // 🔹 Clear quantity field
        txtqty.setText("");
       
    double grandTotal = calculateGrandTotal();
        String amountInWords = convertToWords(grandTotal);
        lblwords.setText(amountInWords);
System.out.println("Duuu"+grandTotal+"amount"+amountInWords);
        System.out.println("✅ Item added to table successfully!");

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "❌ Error: " + e.getMessage());
    }
  updateGrandTotal();
    calculateGrandTotal();
    }//GEN-LAST:event_txtadddataintableActionPerformed
private double getProductRate(String productName) {
    double rate = 0.0;
    try (Connection con = DriverManager.getConnection(
            "jdbc:h2:file:~/invoiceapp;AUTO_SERVER=TRUE", "sa", "");
         PreparedStatement ps = con.prepareStatement("SELECT rate FROM products WHERE name = ?")) {

        ps.setString(1, productName);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            rate = rs.getDouble("rate");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
    return rate;
}

    private void updateGrandTotal() {
    DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
    double grandTotal = 0.0;

    // Total column (5th column = index 4)
    for (int i = 0; i < model.getRowCount(); i++) {
        Object totalObj = model.getValueAt(i, 4); 
        if (totalObj != null) {
            grandTotal += Double.parseDouble(totalObj.toString());
        }
    }

    // lblgtotal update ചെയ്യുക
    lblgtotal.setText(String.format("%.2f", grandTotal));
    
}

    
    
  

     
    
    
    
    
    
//    private void calculateGrandTotal() {
//    double grandTotal = 0.0;
//
//    // Stop any ongoing edit first
//    if (jTable3.isEditing()) {
//        jTable3.getCellEditor().stopCellEditing();
//    }
//
//    DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
//
//    int rowCount = model.getRowCount();
//    if (rowCount == 0) {
//        lblgtotal.setText("0.00");
//        lblwords.setText("Zero Rupees Only");
//        return;
//    }
//
//    for (int i = 0; i < rowCount; i++) {
//        Object totalValue = model.getValueAt(i, 4); // total column = 4
//        if (totalValue != null && !totalValue.toString().trim().isEmpty()) {
//            try {
//                grandTotal += Double.parseDouble(totalValue.toString());
//            } catch (NumberFormatException e) {
//                // ignore invalid numbers
//            }
//        }
//    }
//
//    lblgtotal.setText(String.format("%.2f", grandTotal));
//    lblwords.setText(convertToWords(grandTotal));
//}



    
//    private void addProductToTable() {
//    DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
//
//    // Get input values
//    String customerName = cusumername.getText().trim(); // if you have this field
//    String productText = (String) cmbProduct.getSelectedItem();
//    String qtyText = txtqty.getText().trim();
//
//    if (productText == null || productText.equals("-- Select Product --") || qtyText.isEmpty()) {
//        JOptionPane.showMessageDialog(this, "Please select a product and enter quantity!");
//        return;
//    }
//
//    double qty = Double.parseDouble(qtyText);
//
//    // Extract product name and rate from combo text (e.g., "Pen (10.5)")
//    String productName = productText.substring(0, productText.lastIndexOf("(")).trim();
//    String rateStr = productText.substring(productText.lastIndexOf("(") + 1, productText.lastIndexOf(")"));
//    double rate = Double.parseDouble(rateStr);
//
//    double total = qty * rate;
//    /////////////////////
//   
////////////////////////////////
//// Display on label
////lblwords.setText(amountInWords);
//
//
//    // Serial number = current number of rows + 1
//    int slNo = model.getRowCount() + 1;
//
//    // Add new row to the table
//    model.addRow(new Object[]{slNo, productName, qty, rate, total});
//
//    // Optional: Clear qty field
//    txtqty.setText("");
//}

    private void cmbProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProductActionPerformed


       // TODO add your handling code here:
    }//GEN-LAST:event_cmbProductActionPerformed
// 🔹 Load all product names into combo box
private void loadProductsToComboBox() {
    try (Connection con = DriverManager.getConnection(
            "jdbc:h2:file:~/invoiceapp;AUTO_SERVER=TRUE", "sa", "");
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("SELECT name FROM products")) {

        cmbProduct.removeAllItems(); // Clear old items

        while (rs.next()) {
            cmbProduct.addItem(rs.getString("name")); // Add each product
        }

        System.out.println("✅ Product combo box updated!");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
//        removeSelectedRow();
//        lblgtotal.setText("00");
int selectedRow = jTable3.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row to remove!");
        return;
    }

    // Confirm dialog (optional)
    int confirm = JOptionPane.showConfirmDialog(this, 
        "Do you really want to remove this item?", 
        "Confirm", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        // Table model എടുത്ത് row remove ചെയ്യുക
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.removeRow(selectedRow);

        // Grand total വീണ്ടും കണക്കാക്കുക
        calculateGrandTotal(); 
    }
    }//GEN-LAST:event_removeActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // പുതിയ JPanel object സൃഷ്ടിക്കുന്നു
    // 1) create panel instance
    Report reportPanel = new Report();
//
//    // 2) clear current contents
//    getContentPane().removeAll();
//
//    // 3) set BorderLayout and add panel (fill whole frame)
//    getContentPane().setLayout(new java.awt.BorderLayout());
//    getContentPane().add(reportPanel, java.awt.BorderLayout.CENTER);
//
//    // 4) refresh UI
//    getContentPane().revalidate();
//    getContentPane().repaint();

  JFrame frame = new JFrame("Sales Report");
frame.setContentPane(new Report());
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);

    
    }//GEN-LAST:event_button1ActionPerformed

 
private void removeSelectedRow() {
    DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
    int selectedRow = jTable3.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row to remove!");
        return;
    }

    // Confirm before deleting (optional)
    int confirm = JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to remove this item?",
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION
    );

    if (confirm == JOptionPane.YES_OPTION) {
        model.removeRow(selectedRow);
        // Recalculate serial numbers after removal
        resetSerialNumbers(model);
    }
}

private void resetSerialNumbers(DefaultTableModel model) {
    for (int i = 0; i < model.getRowCount(); i++) {
        model.setValueAt(i + 1, i, 0); // 0 = "Sl No" column index
    }
}




    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
      
    
        
        
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InvoiceApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("invoice.pdf"));
            document.open();

            // Create table with 5 columns
            PdfPTable table = new PdfPTable(5);
            table.addCell("S.No");
            table.addCell("Particulars");
            table.addCell("Qty");
            table.addCell("Rate");
            table.addCell("Total");

            document.add(table);
            document.add(new Paragraph("Authorized Signature",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));

            document.close();
            System.out.println("Invoice PDF created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoiceApplication().setVisible(true);
            }
        });
//        try {
//            // ✅ H2 Console Start (Web + TCP mode)
//            Server.createWebServer(
//                "-web", "-webAllowOthers",
//                "-tcp", "-tcpAllowOthers"
//            ).start();
//
//            System.out.println("✅ H2 Console Started at: http://localhost:8082");
//
//            // 🔹 Your existing startup code
//            javax.swing.SwingUtilities.invokeLater(() -> {
//                new InvoiceApplication().setVisible(true);
//            });
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    } 
        
    }
    //H2 PRODUCT ADD
    
    //H2 PRODUCT ADD END FUNCTION
//    private void addProduct() {
//    String productName = txtname.getText().trim();
//    String rateText = txtprice.getText().trim();
//
//    if (productName.isEmpty() || rateText.isEmpty()) {
//        JOptionPane.showMessageDialog(this, "❌ Please enter product name and rate!");
//        return;
//    }
//
//    try {
//        double rate = Double.parseDouble(rateText);
//
//        Connection con = DBConnection.getConnection();
//        String sql = "INSERT INTO products (name, rate) VALUES (?, ?)";
//        PreparedStatement ps = con.prepareStatement(sql);
//
//        ps.setString(1, productName);
//        ps.setDouble(2, rate);
//        ps.executeUpdate();
//
//        JOptionPane.showMessageDialog(this, "✅ Product added successfully!");
//
//        // Add ചെയ്ത ശേഷം TextFields clear ചെയ്യാം
//        txtname.setText("");
//        txtprice.setText("");
//
//        ps.close();
//        con.close();
//
//    } catch (NumberFormatException nfe) {
//        JOptionPane.showMessageDialog(this, "❌ Please enter a valid number for rate!");
//    } catch (Exception e) {
//        e.printStackTrace();
//        JOptionPane.showMessageDialog(this, "❌ Error while adding product: " + e.getMessage());
//    }
//}
/// PRODUCT DISPLY FUNCTION
//    private void loadProductsToTable() {
//    try {
//        Connection con = DBConnection.getConnection();
//        String sql = "SELECT * FROM products";
//        PreparedStatement ps = con.prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//
//        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        model.setRowCount(0); // പഴയ ഡാറ്റ clear ചെയ്യുക
//
//        while (rs.next()) {
//            Object[] row = {
//                rs.getInt("id"),
//                rs.getString("name"),
//                rs.getDouble("rate")
//            };
//            model.addRow(row);
//        }
//
//        rs.close();
//        ps.close();
//        con.close();
//
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//}

    ///PRODUCT DISPLY END
   //h2 save function
private void saveInvoice() {
    Connection con = null;
    PreparedStatement psInvoice = null;
    PreparedStatement psItem = null;

    try {
        con = DBConnection.getConnection();

        String invoiceNo = lblInvoiceNo.getText();
        String date = txtdate.getText();
        String customerName = cusumername.getText();
        String poNo = txtpo.getText();
        double grandTotal = Double.parseDouble(lblgtotal.getText());

        // ആദ്യം customer ഉണ്ടോ എന്ന് പരിശോധിക്കുക അല്ലെങ്കിൽ insert ചെയ്യുക
        int customerId = -1;
        String checkQuery = "SELECT id FROM customers WHERE name = ?";
        PreparedStatement checkPs = con.prepareStatement(checkQuery);
        checkPs.setString(1, customerName);
        ResultSet rs = checkPs.executeQuery();
        if (rs.next()) {
            customerId = rs.getInt("id");
        } else {
            String insertCustomer = "INSERT INTO customers(name) VALUES(?)";
            PreparedStatement insertPs = con.prepareStatement(insertCustomer, Statement.RETURN_GENERATED_KEYS);
            insertPs.setString(1, customerName);
            insertPs.executeUpdate();
            ResultSet keys = insertPs.getGeneratedKeys();
            if (keys.next()) {
                customerId = keys.getInt(1);
            }
            insertPs.close();
        }
        checkPs.close();

        // Invoice insert ചെയ്യുക
        String sql = "INSERT INTO invoices (invoice_no, date, customer_id, po_no, grand_total) VALUES (?, ?, ?, ?, ?)";
        psInvoice = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        psInvoice.setString(1, invoiceNo);
        psInvoice.setString(2, date);
        psInvoice.setInt(3, customerId);
        psInvoice.setString(4, poNo);
        psInvoice.setDouble(5, grandTotal);
        psInvoice.executeUpdate();

        ResultSet generatedKeys = psInvoice.getGeneratedKeys();
        int invoiceId = 0;
        if (generatedKeys.next()) {
            invoiceId = generatedKeys.getInt(1);
        }

        // Invoice items insert ചെയ്യുക (JTable → jTable3)
        String insertItemSQL = "INSERT INTO invoice_items (invoice_id, particular, qty, rate, total) VALUES (?, ?, ?, ?, ?)";
        psItem = con.prepareStatement(insertItemSQL);

        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            String particular = model.getValueAt(i, 1).toString();
            double qty = Double.parseDouble(model.getValueAt(i, 2).toString());
            double rate = Double.parseDouble(model.getValueAt(i, 3).toString());
            double total = Double.parseDouble(model.getValueAt(i, 4).toString());

            psItem.setInt(1, invoiceId);
            psItem.setString(2, particular);
            psItem.setDouble(3, qty);
            psItem.setDouble(4, rate);
            psItem.setDouble(5, total);
            psItem.addBatch();
        }
        psItem.executeBatch();

        JOptionPane.showMessageDialog(this, "✅ Invoice saved successfully!");

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "❌ Error: " + e.getMessage());
    } finally {
        try {
            if (psInvoice != null) psInvoice.close();
            if (psItem != null) psItem.close();
            if (con != null) con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

    
    // invoice number generate function
//private String generateInvoiceNumber() {
//    String prefix = "";
//    int nextNumber = 1;
//
//    try (Connection con = DBConnection.getConnection()) {
//        String sql = "SELECT invoice_no FROM invoices ORDER BY id DESC LIMIT 1";
//        PreparedStatement ps = con.prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//
//        if (rs.next()) {
//            String lastInvoice = rs.getString("invoice_no"); // e.g., "INV-1001"
//
//            if (lastInvoice != null && lastInvoice.contains("-")) {
//                String[] parts = lastInvoice.split("-");
//                int lastNumber = Integer.parseInt(parts[1].trim());
//                nextNumber = lastNumber + 1;
//            } else {
//                // Handle old or invalid format like "INV1001"
//                String numberPart = lastInvoice.replaceAll("\\D+", "");
//                if (!numberPart.isEmpty()) {
//                    nextNumber = Integer.parseInt(numberPart) + 1;
//                }
//            }
//        }
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//
//    return prefix + nextNumber;
//}


    // ✅ ഈ ക്ലാസ് main ക്ലാസ്സിന് അകത്ത് വേണമെങ്കിൽ ഇങ്ങനെ വേണം
    public static class SalesReportTable extends JFrame {
        public SalesReportTable() {
            setTitle("Sales Report");
            setSize(500, 400);
            setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private java.awt.Button button1;
    private javax.swing.JComboBox<String> cmbProduct;
    private javax.swing.JTextField customeraddress;
    private javax.swing.JTextField cusumername;
    private javax.swing.JLabel invoiceno;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JLabel lblInvoiceNo;
    private javax.swing.JLabel lblgtotal;
    private javax.swing.JButton lblwords;
    private javax.swing.JButton remove;
    private javax.swing.JButton txtadddataintable;
    private javax.swing.JLabel txtdate;
    private javax.swing.JButton txtinvoiceno;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpo;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtqty;
    // End of variables declaration//GEN-END:variables

    private void clearFields() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
   private void loo(){
        DefaultTableModel model1 = (DefaultTableModel) jTable3.getModel();
         for (int j = 0; j < model1.getColumnCount(); j++) {
                Object cellValue = model1.getValueAt(0, j);
                System.out.println("Column " + j + ": " + cellValue);
            }
        }
   
   
//   private String convertToWords(int number) {
//    // You can later enhance this as needed
//    return NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(number);
//}

   
   
   
   private class InvoicePrintable implements Printable {
    private String invoiceNo, date, customerName, customerAddress, po;
    private DefaultTableModel tableModel;
    private double grandTotal;
    private String amountInWords;
    private Image logo;

    public InvoicePrintable(String invoiceNo, String date, String customerName,
                            String customerAddress, String po,
                            DefaultTableModel tableModel, double grandTotal,String amountInWords) {
        this.invoiceNo = invoiceNo;
        this.date = date;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.po = po;
        this.tableModel = tableModel;
        this.grandTotal = grandTotal;
        this.amountInWords=amountInWords;

        // ✅ Logo Path (for .exe or JAR build)
        String logoPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + "vph_logo.png";
        File file = new File(logoPath);
        if (file.exists()) {
            logo = Toolkit.getDefaultToolkit().getImage(logoPath);
            System.out.println("✅ Logo found: " + logoPath);
        } else {
            System.out.println("❌ Logo not found at: " + logoPath);
        }
    }

    @Override
    public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
        if (pageIndex > 0) return NO_SUCH_PAGE;

        Graphics2D g2 = (Graphics2D) g;
       g2.translate(pf.getImageableX(), pf.getImageableY());
        g2.setPaint(Color.black);

        int pageWidth = (int) pf.getImageableWidth();
        int pageHeight = (int) pf.getImageableHeight();

        // ✅ Page Border
        g2.drawRect(20, 20, pageWidth - 40, pageHeight - 40);

        int y = 60;
if (logo != null) {
    g2.drawImage(logo, 50, 40, 100, 60, null);  // സ്ഥാനം, വലുപ്പം ആവശ്യത്തിന് മാറ്റാം
}

        // ✅ Draw Logo
//        if (logo != null) {
//            g2.drawImage(logo, 40, 30, 80, 80, null);
//        }

        // ✅ Firm Header
        g2.setFont(new Font("Arial", Font.BOLD, 16));
        g2.drawString("Vishnu Print House", 170, 50);
        g2.setFont(new Font("Arial", Font.PLAIN, 10));
        g2.drawString("Opp: Petrol Pump, Koyyamarakkad", 170, 65);
        g2.drawString("Kanjikode, Palakkad - 678621", 170, 80);
        g2.drawString("Phone: +91 8547706377, 9809414537", 170, 95);
        g2.drawString("Email: vishnuprinthouse101@gmail.com", 170, 110);
        g2.drawString("Website: vishnuprinthouse.unaux.com", 170, 125);

        g2.drawLine(30, 135, pageWidth - 30, 135);

        // ✅ INVOICE Heading
        g2.setFont(new Font("Arial", Font.BOLD, 14));
        g2.drawString("INVOICE", pageWidth / 2 - 30, 155);

        g2.setFont(new Font("Arial", Font.PLAIN, 10));
        g2.drawString("Invoice No: " + invoiceNo, 40, 170);
        g2.drawString("Date: " + date, pageWidth - 200, 170);
        g2.drawString("Customer Name: " + customerName, 40, 185);
        g2.drawString("Customer Address: " + customerAddress, 40, 200);
        g2.drawString("PO: " + po, 40, 215);

        g2.drawLine(30, 225, pageWidth - 30, 225);

        // ✅ Table Header
        int tableStartY = 245;
        g2.setFont(new Font("Arial", Font.BOLD, 10));
        g2.drawString("Sl No", 40, tableStartY);
        g2.drawString("Particular", 100, tableStartY);
        g2.drawString("Qty", 350, tableStartY);
        g2.drawString("Rate", 420, tableStartY);
        g2.drawString("Total", 500, tableStartY);
        g2.drawLine(30, tableStartY + 5, pageWidth - 30, tableStartY + 5);

        // ✅ Table Items
        int yPos = tableStartY + 20;
        g2.setFont(new Font("Arial", Font.PLAIN, 10));
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String sl = String.valueOf(tableModel.getValueAt(i, 0));
            String part = String.valueOf(tableModel.getValueAt(i, 1));
            String qty = String.valueOf(tableModel.getValueAt(i, 2));
            String rate = String.valueOf(tableModel.getValueAt(i, 3));
            String total = String.valueOf(tableModel.getValueAt(i, 4));

            g2.drawString(sl, 40, yPos);
            g2.drawString(part, 100, yPos);
            g2.drawString(qty, 350, yPos);
            g2.drawString(rate, 420, yPos);
            g2.drawString(total, 500, yPos);
            yPos += 18;
        }

        g2.drawLine(30, yPos + 5, pageWidth - 30, yPos + 5);

        // ✅ Grand Total
        g2.setFont(new Font("Arial", Font.BOLD, 10));
        g2.drawString("Grand Total: ₹" + grandTotal, pageWidth - 180, yPos + 25);

        // ✅ Amount in Words
        g2.setFont(new Font("Arial", Font.PLAIN, 10));
       // String amountInWords = convertToWords(grandTotal);
       // g2.drawString("Amount in Words: " + amountInWords, 70, y + 30);
        g2.drawString("Amount in Words: " +amountInWords, 40, yPos + 25);

        //g2.drawString("Amount in Words: " + convertToWords((int) grandTotal), 40, yPos + 25);

        // ✅ Bank Details
        int footerY = pageHeight - 120;
        g2.setFont(new Font("Arial", Font.PLAIN, 9));
        g2.drawString("Bank Name: Indian Overseas Bank", 40, footerY);
        g2.drawString("Branch: Kanjikode", 40, footerY + 12);
        g2.drawString("A/c No: 035702000000155", 40, footerY + 24);
        g2.drawString("IFSC: IOBA0000357", 40, footerY + 36);

        // ✅ Signature Section (with more gap)
        g2.drawString("For Vishnu Print House", pageWidth - 180, footerY);
        g2.drawString("Authorised Signature", pageWidth - 170, footerY + 50);

        return PAGE_EXISTS;
    }
}
private String convertToWords(double amount) {
    if (amount == 0) return "Rupees Zero Only";

    String[] units = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen" };
    String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

    long rupees = (long) amount;
    int paise = (int) Math.round((amount - rupees) * 100);

    String words = "";
    words += convertNumberToWords(rupees);

    if (paise > 0) {
        words += " and " + convertNumberToWords(paise) + " Paise";
    }

    return "Rupees " + words.trim() + " Only";
}

private String convertNumberToWords(long n) {
    String[] units = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen" };
    String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

    String result = "";

    if (n >= 10000000) {
        result += convertNumberToWords(n / 10000000) + " Crore ";
        n %= 10000000;
    }
    if (n >= 100000) {
        result += convertNumberToWords(n / 100000) + " Lakh ";
        n %= 100000;
    }
    if (n >= 1000) {
        result += convertNumberToWords(n / 1000) + " Thousand ";
        n %= 1000;
    }
    if (n >= 100) {
        result += convertNumberToWords(n / 100) + " Hundred ";
        n %= 100;
    }
    if (n > 0) {
        if (n < 20) {
            result += units[(int) n];
        } else {
            result += tens[(int) (n / 10)] + " " + units[(int) (n % 10)];
        }
    }
    return result.trim();
}

    }
    

