package huongdoituong;

import javax.swing.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class searchbutton extends JFrame {
    private Connection connection;
    private JTable table;
    private DefaultTableModel tableModel;

    public searchbutton() {
    	  // Tạo frame
        JFrame frame = new JFrame("Tìm kiếm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo panel chứa ô tìm kiếm, nút tìm kiếm, và nhãn "Tìm kiếm nhân viên id"
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Tìm kiếm nhân viên id:");
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Tìm kiếm");
        panel.add(label);
        panel.add(searchField);
        panel.add(searchButton);

        // Tạo bảng để hiển thị kết quả tìm kiếm
        String[] columnNames = {"ID", "Tên", "Khoa", "Lương"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Thêm panel và bảng vào frame
        frame.getContentPane().add(panel, "North");
        frame.getContentPane().add(scrollPane, "Center");

        // Xử lý sự kiện khi nhấn nút tìm kiếm
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy giá trị nhập vào ô tìm kiếm
                String searchText = searchField.getText();

                try {
                    // Chuyển đổi giá trị sang kiểu số nguyên
                    int id = Integer.parseInt(searchText);

                    // Xóa toàn bộ dữ liệu trong bảng
                    tableModel.setRowCount(0);

                    // Gọi phương thức findEmployeeById() của lớp employeeDao
                    employee emp = employeeDao.findEmployeeById(id);

                    if (emp.getID() != 0) {
                        // Nếu tìm thấy nhân viên, hiển thị thông tin của nhân viên này trên bảng
                        Object[] rowData = {emp.getID(), emp.getTen(), emp.getKhoa(), emp.getLuong()};
                        tableModel.addRow(rowData);
                    } else {
                        // Nếu không tìm thấy nhân viên, hiển thị thông báo lỗi
                        JOptionPane.showMessageDialog(frame, "Không tìm thấy nhân viên với ID này.");
                    }
                } catch (NumberFormatException ex) {
                    // Nếu giá trị nhập vào không phải là số nguyên, hiển thị thông báo lỗi
                    JOptionPane.showMessageDialog(frame, "Vui lòng nhập ID là một số nguyên.");
                }
            }
        });


        // Cài đặt kích thước và hiển thị frame
        frame.pack();
        frame.setVisible(true);
    }
}