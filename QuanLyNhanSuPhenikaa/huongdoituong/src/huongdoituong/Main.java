package huongdoituong;

// import java.util.List;

public class Main {
    public static void main(String[] args) {
        employeeDao dao = new employeeDao();

        // Thêm nhân viên
        employee newEmployee = new employee(0, "Nguyen Van A", "Khoa A", 5000);
        dao.addEmployee(newEmployee);

        // Tìm kiếm thông tin nhân viên
        employee searchEmployee = employeeDao.findEmployeeById(3);
        if (searchEmployee != null) {
            System.out.println("Thong tin nhan vien:");
            System.out.println("ID: " + searchEmployee.getID());
            System.out.println("Ten: " + searchEmployee.getTen());
            System.out.println("Khoa: " + searchEmployee.getKhoa());
            System.out.println("Luong: " + searchEmployee.getLuong());
            System.out.println("=====================");
        } else {
            System.out.println("Khong tim thay nhan vien co ID = 3");
        }

        // Xóa nhân viên
        dao.deleteEmployee(1);

        // Đóng kết nối
        dao.closeConnection();
    }
}