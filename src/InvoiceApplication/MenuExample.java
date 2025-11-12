import InvoiceApplication.InvoiceApplication.SalesReportTable;
import javax.swing.*;

public class MenuExample extends JFrame {

    public MenuExample() {
        setTitle("Invoice Application");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ✅ Step 1: Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // ✅ Step 2: Create menus
        JMenu fileMenu = new JMenu("File");
        JMenu reportMenu = new JMenu("Reports");
        JMenu helpMenu = new JMenu("Help");

        // ✅ Step 3: Create menu items
        JMenuItem newInvoiceItem = new JMenuItem("New Invoice");
        JMenuItem salesReportItem = new JMenuItem("Sales Report");
        JMenuItem exitItem = new JMenuItem("Exit");

        // ✅ Step 4: Add items to menus
        fileMenu.add(newInvoiceItem);
        fileMenu.add(exitItem);
        reportMenu.add(salesReportItem);

        // ✅ Step 5: Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(reportMenu);
        menuBar.add(helpMenu);

        // ✅ Step 6: Add menu bar to JFrame
        setJMenuBar(menuBar);

        // ✅ Step 7: Add Actions (ActionListeners)
        newInvoiceItem.addActionListener(e -> openNewInvoice());
        salesReportItem.addActionListener(e -> openSalesReport());
        exitItem.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    // 📘 These methods perform the actions when menu items are clicked:
    private void openNewInvoice() {
        JOptionPane.showMessageDialog(this, "Open New Invoice Form!");
        // Example: new InvoiceForm(); // if you have another JFrame
    }

    private void openSalesReport() {
        // Open your sales report window
        new SalesReportTable(); // <-- your sales report class
    }

    public static void main(String[] args) {
        new MenuExample();
    }
}
