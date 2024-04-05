import java.sql.*;

public class S7Q2 {
    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";// jdbc.postgresql path
    //static final String USER = "username";
    //static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute a query to create Product table
            System.out.println("Creating Product table...");
            stmt = conn.createStatement();
            String createTableSql = "CREATE TABLE Product (" +
                                    "Pid INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                                    "Pname VARCHAR(255) NOT NULL," +
                                    "Price DOUBLE NOT NULL)";
            stmt.executeUpdate(createTableSql);
            System.out.println("Product table created successfully.");

            // Insert records into the Product table
            System.out.println("Inserting records into the Product table...");
            String[] products = {"Mobile", "Laptop", "Tablet", "Headphones", "Smartwatch"};
            double[] prices = {500.0, 1000.0, 300.0, 50.0, 200.0};
            for (int i = 0; i < products.length; i++) {
                String insertSql = "INSERT INTO Product (Pname, Price) VALUES ('" + products[i] + "', " + prices[i] + ")";
                stmt.executeUpdate(insertSql);
            }
            System.out.println("Records inserted successfully.");

            // Display all records from the Product table
            System.out.println("Displaying all records from the Product table:");
            String selectSql = "SELECT * FROM Product";
            ResultSet rs = stmt.executeQuery(selectSql);
            while (rs.next()) {
                int pid = rs.getInt("Pid");
                String pname = rs.getString("Pname");
                double price = rs.getDouble("Price");
                System.out.println("Product ID: " + pid + ", Product Name: " + pname + ", Price: $" + price);
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Program completed.");
    }
}
