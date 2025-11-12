package InvoiceApplication;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static Connection conn;

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                // H2 JDBC URL (file-based)
                String url = "jdbc:h2:./data/invoicedb"; 
                String user = "sa"; 
                String pass = ""; 
                
                // Load driver
                Class.forName("org.h2.Driver");
                conn = DriverManager.getConnection(url, user, pass);
                System.out.println("✅ H2 Database Connected!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
