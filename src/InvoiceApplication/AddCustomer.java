import InvoiceApplication.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddCustomer {
    public static void main(String[] args) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO customers(name, address) VALUES(?, ?)");
            ps.setString(1, "Madhusudevan");
            ps.setString(2, "Kochi, Kerala");
            ps.executeUpdate();
            System.out.println("✅ Customer Added!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
