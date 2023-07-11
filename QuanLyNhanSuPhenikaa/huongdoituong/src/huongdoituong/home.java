package huongdoituong;

import javax.swing.*;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

@SuppressWarnings("unused")
public class home extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton showButton;
    private JButton addButton;
    private JButton searchButton;
    private JButton deleteButton;
    private JButton editButton;
    private JTextField idTextField;
    private JTextField nameTextField;
    private JTextField departmentTextField;
    private JTextField salaryTextField;

    public home() {
        // Thiết lập tiêu đề cho frame
        setTitle("Trang chủ");

        // Tạo bảng dữ liệu
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Tên");
        tableModel.addColumn("Khoa");
        tableModel.addColumn("Lương");
        table = new JTable(tableModel);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // Lấy chỉ số của dòng được chọn
                int selectedRow = table.getSelectedRow();

                // Nếu không có dòng nào được chọn, thoát khỏi phương thức
                if (selectedRow < 0) {
                    return;
                }

                // Lấy dữ liệu từ bảng và hiển thị chúng trong các hộp văn bản
                String id = table.getValueAt(selectedRow, 0).toString();
                String name = table.getValueAt(selectedRow, 1).toString();
                String department = table.getValueAt(selectedRow, 2).toString();
                String salary = table.getValueAt(selectedRow, 3).toString();

                idTextField.setText(id);
                nameTextField.setText(name);
                departmentTextField.setText(department);
                salaryTextField.setText(salary);
            }
        });


        // Tạo các ô yêu cầu nhập tên, số điện thoại, khoa, lương
        JLabel idLabel = new JLabel("ID:");
        idTextField = new JTextField();
        JLabel nameLabel = new JLabel("Tên:");
        nameTextField = new JTextField();
        JLabel departmentLabel = new JLabel("Khoa:");
        departmentTextField = new JTextField();
        JLabel salaryLabel = new JLabel("Lương:");
        salaryTextField = new JTextField();

        // Tạo các nút điều khiển
        showButton = new JButton("Hiện");
        editButton = new JButton("Cập nhật");
        addButton = new JButton("Thêm");
        searchButton = new JButton("Tìm kiếm");
        deleteButton = new JButton("Xóa");

        // Tạo panel chứa các ô yêu cầu nhập và thêm vào giao diện
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10),
                BorderFactory.createTitledBorder("Thông tin nhân viên")));
        inputPanel.add(idLabel);
        inputPanel.add(idTextField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);
        inputPanel.add(departmentLabel);
        inputPanel.add(departmentTextField);
        inputPanel.add(salaryLabel);
        inputPanel.add(salaryTextField);

        // Tạo panel chứa các nút điều khiển và thêm vào giao diện
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(showButton);
        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);
        buttonPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10),
                BorderFactory.createTitledBorder("Chức năng")));

     
        // Tạo panel chứa các ô yêu cầu nhập và thêm vào giao diện
       
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 10, 5, 10);
        inputPanel.add(idLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        inputPanel.add(idTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        inputPanel.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        inputPanel.add(nameTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        inputPanel.add(departmentLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        inputPanel.add(departmentTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 0;
        inputPanel.add(salaryLabel, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        gbc.weightx = 1;
        inputPanel.add(salaryTextField, gbc);

       

        // Tạo panel chứa các thành phần trên bên trái
        JPanel leftPanel = new JPanel();
       
        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(inputPanel, BorderLayout.CENTER);
        leftPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Thêm bảng vào giao diện bên phải
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Thêm panel chứa các thành phần bên trái vào giao diện bên trái
        add(leftPanel, BorderLayout.WEST);

        // Thiết lập kích thước và hiển thị frame
        setSize(1200, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // Đăng ký sự kiện cho các nút điều khiển
        showButton.addActionListener(this);
        addButton.addActionListener(this);
        searchButton.addActionListener(this);
        deleteButton.addActionListener(this);
        editButton.addActionListener(this);
    }

    @SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showButton) {
        	// Gọi phương thức getAllEmployees() từ lớp EmployeeDao để lấy danh sách nhân viên
            employeeDao dao = new employeeDao();
            List<employee> employees = dao.getAllEmployees();

            // Xóa dữ liệu hiện có trong bảng (nếu có)
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            model.fireTableDataChanged();

            // Đổ dữ liệu nhân viên vào bảng
            for (employee employee : employees) {
                model.addRow(new Object[]{employee.getID(), employee.getTen(), employee.getKhoa(), employee.getLuong()});
            }
        } else if (e.getSource() == addButton) {
            try {
                // Lấy thông tin từ các ô yêu cầu nhập
                int id = Integer.parseInt(idTextField.getText());
                String name = nameTextField.getText();
                String department = departmentTextField.getText();
                int salary = Integer.parseInt(salaryTextField.getText());

                // Tạo đối tượng nhân viên mới
                employee newEmployee = new employee(id, name, department, salary);

                // Gọi phương thức addEmployee() từ lớp employeeDao để thêm nhân viên vào danh sách
                employeeDao dao = new employeeDao();
                if (dao.checkIdStatement(id)) {
                    // Nếu ID đã tồn tại, hiển thị thông báo lỗi cho người dùng và yêu cầu nhập lại ID
                    JOptionPane.showMessageDialog(null, "ID đã tồn tại. Mời nhập lại ID.");
                } else {
                    dao.addEmployee(newEmployee);

                    // Xóa dữ liệu hiện có trong bảng (nếu có)
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.setRowCount(0);
                    model.fireTableDataChanged();

                    // Gọi lại phương thức getAllEmployees() từ lớp employeeDao để lấy danh sách nhân viên đã được cập nhật
                    List<employee> employees = dao.getAllEmployees();

                    // Đổ dữ liệu nhân viên vào bảng
                    for (employee employee : employees) {
                        model.addRow(new Object[]{employee.getID(), employee.getTen(), employee.getKhoa(), employee.getLuong()});
                    } 
                }
            } catch (NumberFormatException ex) {
                // Nếu nhập liệu không hợp lệ, hiển thị thông báo lỗi cho người dùng
                JOptionPane.showMessageDialog(null, "Dữ liệu nhập không hợp lệ. Mời nhập lại.");
            }
        } else if (e.getSource() == searchButton) {
        	 searchbutton searchFrame = new searchbutton();
             searchFrame.setVisible(true);
            
        } else if (e.getSource() == deleteButton) {
        	int selectedRow = table.getSelectedRow(); // Lấy chỉ số dòng đang được chọn
            if (selectedRow != -1) { // Kiểm tra dòng có được chọn hay không
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int id = (int) model.getValueAt(selectedRow, 0); // Lấy giá trị của cột ID trong dòng đang được chọn
                // Gọi phương thức xóa nhân viên từ đối tượng employeeDao
                employeeDao dao = new employeeDao();
                dao.deleteEmployee(id);
                
                // Xóa dòng đang được chọn trong bảng
                model.removeRow(selectedRow);
                JOptionPane.showMessageDialog(null, "Xóa nhân viên thành công.");
            } 
        }else if (e.getSource() == editButton) {
        	 int selectedRow = table.getSelectedRow(); // Lấy chỉ số dòng đang được chọn
        	    if (selectedRow != -1) { // Kiểm tra dòng có được chọn hay không
        	        DefaultTableModel model = (DefaultTableModel) table.getModel();
        	        int id = Integer.parseInt(idTextField.getText()); // Lấy giá trị ID từ ô yêu cầu nhập
        	        String name = nameTextField.getText(); // Lấy thông tin tên từ ô yêu cầu nhập
        	        String department = departmentTextField.getText();
        	        double salary = Double.parseDouble(salaryTextField.getText()); // Parse input as a double
        	        // Kiểm tra xem ID đã tồn tại trong CSDL chưa
        	        employeeDao dao = new employeeDao();
        	        if (dao.checkIdStatement(id) && id != (int)model.getValueAt(selectedRow, 0)) {
        	            JOptionPane.showMessageDialog(null, "ID đã tồn tại. Mời nhập lại ID.");
        	            idTextField.setText(""); // Xóa giá trị ID đã nhập
        	        } else {
        	            // Thực hiện các thao tác cập nhật thông tin trong CSDL
        	            dao.updateEmployee(new employee(id, name, department, salary));
        	            // Cập nhật lại bảng hiển thị dữ liệu
        	            model.setValueAt(id, selectedRow, 0);
        	            model.setValueAt(name, selectedRow, 1);
        	            model.setValueAt(department, selectedRow, 2);
        	            model.setValueAt(salary, selectedRow, 3);
        	            JOptionPane.showMessageDialog(null, "Thông tin đã được cập nhật thành công.");
        	        }
        	    } else {
        	        JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng để sửa thông tin.");
        	    }
        }

    }
}







