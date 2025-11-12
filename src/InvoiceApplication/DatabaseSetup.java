import InvoiceApplication.DatabaseConnection;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {
    public static void main(String[] args) {
        try {
            Connection con = DatabaseConnection.getConnection();
            Statement st = con.createStatement();

            // Customer Table
            st.execute("CREATE TABLE IF NOT EXISTS customers (" +
                       "id INT AUTO_INCREMENT PRIMARY KEY, " +
                       "name VARCHAR(255), " +
                       "address VARCHAR(255))");

            // Product Table
            st.execute("CREATE TABLE IF NOT EXISTS products (" +
                       "id INT AUTO_INCREMENT PRIMARY KEY, " +
                       "name VARCHAR(255), " +
                       "rate DOUBLE)");

            // Invoice Table
            st.execute("CREATE TABLE IF NOT EXISTS invoices (" +
                       "id INT AUTO_INCREMENT PRIMARY KEY, " +
                       "invoice_no VARCHAR(50), " +
                       "date VARCHAR(50), " +
                       "customer_id INT, " +
                       "po_no VARCHAR(50), " +
                       "grand_total DOUBLE)");

            // Invoice Items Table
            st.execute("CREATE TABLE IF NOT EXISTS invoice_items (" +
                       "id INT AUTO_INCREMENT PRIMARY KEY, " +
                       "invoice_id INT, " +
                       "product_name VARCHAR(255), " +
                       "qty DOUBLE, " +
                       "rate DOUBLE, " +
                       "total DOUBLE)");

            System.out.println("✅ Tables Created Successfully!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
