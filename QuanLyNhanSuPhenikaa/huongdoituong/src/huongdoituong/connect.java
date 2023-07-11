package huongdoituong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class connect {
    private static final String DB_URL = "jdbc:sqlite:/home/quangvid/Documents/OPP/BaiTapLonHuongdoituong_Nhom 5/huongdoituong/bin/huongdoituong/mydatabase.db"; // Đường dẫn đến file cơ sở dữ liệu SQLite
    private static Connection connection = null;

    // Phương thức để kết nối tới cơ sở dữ liệu
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection(DB_URL);
                System.out.println("Ket noi thanh cong!");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Phương thức để đóng kết nối tới cơ sở dữ liệu
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Dong ket noi thanh cong!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
