/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package final_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jhyvriel
 */
class DatabaseConnection {

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/productscan";  // Make sure this URL is correct
        String username = "root";  // Your MySQL username
        String password = "";      // Your MySQL password

        try {
            // Load MySQL JDBC driver (if not already loaded)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Return the connection
            return java.sql.DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("MySQL JDBC Driver not found.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection failed.");
        }
    }

    // Method to get product name based on the barcode
    public static String getProductNameByBarcode(String barcode) {
        String productName = null;
        try (Connection conn = getConnection()) {
            if (conn != null) {
                String query = "SELECT * FROM addproduct WHERE barcode = ?";
                try (PreparedStatement pst = conn.prepareStatement(query)) {
                    pst.setString(1, barcode);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next()) {
                        productName = rs.getString("product_name");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productName;
    }
}

