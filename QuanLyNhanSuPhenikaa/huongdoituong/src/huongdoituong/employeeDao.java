package huongdoituong;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class employeeDao {
    private static Connection connection;

    public employeeDao() {
        // Kết nối tới cơ sở dữ liệu
        connection = connect.getConnection();
    }
    //Kiểm tra xem ID có tồn tại hay không
    public boolean checkIdStatement(int id) {
        try {
            PreparedStatement checkIdStatement = connection.prepareStatement("SELECT COUNT(*) FROM mydatabase WHERE ID = ?");
            checkIdStatement.setInt(1, id);
            ResultSet resultSet = checkIdStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    

 // Thêm nhân viên vào cơ sở dữ liệu
    public void addEmployee(employee employee) {
        try {
            if (checkIdStatement(employee.getID())) {
                // Nếu ID đã tồn tại, hiển thị thông báo cho người dùng và yêu cầu nhập lại ID
                System.out.println("ID da ton tai. Moi nhap lai ID!");
            } else {
                // Nếu ID chưa tồn tại, tiếp tục thêm mới dữ liệu
                PreparedStatement insertStatement = connection
                .prepareStatement("INSERT INTO mydatabase (ID, Ten, Khoa, Luong) VALUES (?, ?, ?, ?)");
                insertStatement.setDouble(1, employee.getID());
                insertStatement.setString(2, employee.getTen());
                insertStatement.setString(3, employee.getKhoa());
                insertStatement.setDouble(4, employee.getLuong());
                insertStatement.executeUpdate();
                System.out.println("Them thanh cong nhan vien!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Tìm kiếm nhân viên trong cơ sở dữ liệu
    public static employee findEmployeeById(int id) {
        employee emp = new employee(0, null, null, 0);
        try {
            PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT * FROM mydatabase WHERE ID = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                emp.setID(rs.getInt("ID"));
                emp.setTen(rs.getString("Ten"));
                emp.setKhoa(rs.getString("Khoa"));
                emp.setLuong(rs.getDouble("Luong"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    // Xóa nhân viên khỏi cơ sở dữ liệu
    public void deleteEmployee(int ID) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM mydatabase WHERE ID =?");
            preparedStatement.setInt(1, ID);
            preparedStatement.executeUpdate();
            System.out.println("Xoa nhan vien thanh cong!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Cập nhật thông tin nhân viên
    public void updateEmployee(employee employee) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE mydatabase SET ID = ?, Ten = ?, Khoa = ?, Luong = ? WHERE ID = ?");
            preparedStatement.setDouble(1, employee.getID());
            preparedStatement.setString(2, employee.getTen());
            preparedStatement.setString(3, employee.getKhoa());
            preparedStatement.setDouble(4, employee.getLuong());
            preparedStatement.setDouble(5, employee.getID());
            preparedStatement.executeUpdate();
            System.out.println("Cap nhat thong tin thanh cong!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Lấy danh sách tất cả nhân viên từ cơ sở dữ liệu
    public static List<employee> getAllEmployees() {
        List<employee> employees = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM mydatabase");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee employee = new employee(0, null, null, 0);
                employee.setID(resultSet.getInt("ID"));
                employee.setTen(resultSet.getString("Ten"));
                employee.setKhoa(resultSet.getString("Khoa"));
                employee.setLuong(resultSet.getDouble("Luong"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
    
    public void saveDatabase() {
        try {
            // Bắt đầu giao dịch
            connection.setAutoCommit(false);
            // Kết thúc giao dịch và lưu lại các thay đổi
            connection.commit();
            System.out.println("Lưu dữ liệu thành công!");
            
            // Đặt lại chế độ tự động commit
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
            // Nếu xảy ra lỗi, hủy bỏ giao dịch
            try {
                connection.rollback();
                System.out.println("Lưu dữ liệu thất bại, giao dịch đã được hủy bỏ!");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    // Đóng kết nối tới cơ sở dữ liệu
    public void closeConnection() {
        connect.closeConnection();
    }
}
