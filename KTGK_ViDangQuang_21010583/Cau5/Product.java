package Cau5;

import java.sql.*;

public class Product {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/product_db";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "password";

    public static void main(String[] args) {
        // Kết nối với cơ sở dữ liệu
        try (Connection conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD)) {
            System.out.println("Connected to database.");

            // Tìm kiếm sản phẩm theo mã sản phẩm
            String productCode = "P001";
            findProductByCode(conn, productCode);

            // Chỉnh sửa thông tin sản phẩm theo mã sản phẩm
            String productName = "New Product";
            double price = 10.99;
            String location = "Section B";
            int quantity = 50;
            updateProductByCode(conn, productCode, productName, price, location, quantity);
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Tìm kiếm sản phẩm theo mã sản phẩm
    private static void findProductByCode(Connection conn, String productCode) throws SQLException {
        String sql = "SELECT * FROM products WHERE product_code = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, productCode);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String productName = rs.getString("product_name");
                double price = rs.getDouble("price");
                String location = rs.getString("location");
                int quantity = rs.getInt("quantity");

                System.out.println("Product found:");
                System.out.println("Product Code: " + productCode);
                System.out.println("Product Name: " + productName);
                System.out.println("Price: " + price);
                System.out.println("Location: " + location);
                System.out.println("Quantity: " + quantity);
            } else {
                System.out.println("Product not found.");
            }
        }
    }

    // Chỉnh sửa thông tin sản phẩm theo mã sản phẩm
    private static void updateProductByCode(Connection conn, String productCode, String productName, double price, String location, int quantity) throws SQLException {
        String sql = "UPDATE products SET product_name = ?, price = ?, location = ?, quantity = ? WHERE product_code = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, productName);
            stmt.setDouble(2, price);
            stmt.setString(3, location);
            stmt.setInt(4, quantity);
            stmt.setString(5, productCode);
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Product updated.");
            } else {
                System.out.println("Product not found.");
            }
        }
    }
}