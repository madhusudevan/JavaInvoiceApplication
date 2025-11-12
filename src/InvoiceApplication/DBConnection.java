package InvoiceApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    // [Server] A temporary password is generated for root@localhost: y-dv(i1wQ7pq
//    public static Connection getConnection(){
//        Connection conn = null;
//        try {
//    conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/invoicedb", "root", "yournewpassword");
//    // ഇവിടെ നിങ്ങളുടെ query കോഡ്
//} catch (SQLException e) {
//    e.printStackTrace();  // Error console-ൽ കാണിക്കാൻ
//}
//
//      return conn;   
//    }
    
    
//    public static Connection getConnection() {
//        Connection conn = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/invoicedb", "root", ""
//            );
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
    
    
    //H2
    
    
//    private static final String URL = "jdbc:h2:~/invoiceDB"; // ഹോം ഫോൾഡറിൽ invoiceDB.mv.db എന്ന ഫയൽ സൃഷ്ടിക്കും
//    private static final String USER = "sa";
//    private static final String PASSWORD = "";
//
//    public static Connection getConnection() {
//        Connection con = null;
//        try {
//            Class.forName("org.h2.Driver");
//            con = DriverManager.getConnection(URL, USER, PASSWORD);
//            System.out.println("✅ H2 Database connected successfully!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return con;
//    }
    
    private static Connection con;

    public static Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                Class.forName("org.h2.Driver");
                Connection con = DriverManager.getConnection("jdbc:h2:~/invoiceapp;AUTO_SERVER=TRUE;AUTO_SERVER_PORT=9092", "sa", "");

                System.out.println("✅ H2 Database connected successfully!");
                createTablesIfNotExists(con);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    // 🔹 Tables not exists എങ്കിൽ create ചെയ്യുന്നു
    private static void createTablesIfNotExists(Connection con) {
        try (Statement st = con.createStatement()) {
            // Products Table
            st.execute("CREATE TABLE IF NOT EXISTS products (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(100), " +
                    "rate DOUBLE)");

            // Invoices Table
            st.execute("CREATE TABLE IF NOT EXISTS invoices (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "invoice_no VARCHAR(50), " +
                    "date VARCHAR(20), " +
                    "customer VARCHAR(100), " +
                    "address VARCHAR(200), " +
                    "po_no VARCHAR(50), " +
                    "grand_total DOUBLE)");

            // Invoice Items Table
            st.execute("CREATE TABLE IF NOT EXISTS invoice_items (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "invoice_id INT, " +
                    "product_name VARCHAR(100), " +
                    "qty DOUBLE, " +
                    "rate DOUBLE, " +
                    "total DOUBLE, " +
                    "FOREIGN KEY (invoice_id) REFERENCES invoices(id))");

            System.out.println("✅ All required tables verified/created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//        private static final String URL = "jdbc:h2:~/invoiceDB"; // ഹോം ഫോൾഡറിൽ invoiceDB.mv.db ഫയൽ സൃഷ്ടിക്കും
//    private static final String USER = "sa";
//    private static final String PASSWORD = "";
//
//    public static Connection getConnection() {
//        Connection con = null;
//        try {
//            Class.forName("org.h2.Driver");
//            con = DriverManager.getConnection(URL, USER, PASSWORD);
//            System.out.println("✅ H2 Database connected successfully!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return con;
//    }
}
