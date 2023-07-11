package huongdoituong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public login() {
    	// Thiết lập tiêu đề cho frame
        setTitle("Đăng nhập");
        
        // Thiết lập kích thước và hiển thị frame
        setSize(200, 100);
        setMinimumSize(new Dimension(500, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        
        // Tạo các thành phần giao diện
        JLabel usernameLabel = new JLabel("Tài khoản:");
        JLabel passwordLabel = new JLabel("Mật khẩu:");
        usernameTextField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Đăng nhập");

        // Đăng ký sự kiện ActionListener cho button
        loginButton.addActionListener(this);

        // Thiết lập font chữ cho các thành phần giao diện
        Font font = new Font("Times New Roman", Font.PLAIN, 16);
        usernameLabel.setFont(font);
        passwordLabel.setFont(font);
        loginButton.setFont(font);

        // Thiết lập màu sắc cho label và button
        Color color = new Color(75, 158, 219);
        usernameLabel.setForeground(color);
        passwordLabel.setForeground(color);
        loginButton.setBackground(color);
        loginButton.setForeground(Color.BLACK);

        // Tạo panel chứa các thành phần giao diện
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(usernameLabel, constraints);

        constraints.gridx = 1;
        panel.add(usernameTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(passwordLabel, constraints);

        constraints.gridx = 1;
        panel.add(passwordField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, constraints);

        // Thêm panel vào frame
        getContentPane().add(panel, BorderLayout.CENTER);

        // Thiết lập màu nền cho panel và các thành phần giao diện
        panel.setBackground(new Color(245,255,250));
        usernameLabel.setForeground(new Color(4,0,5));
        passwordLabel.setForeground(new Color(4,0,5));
        usernameTextField.setBackground(new Color(255, 255, 255));
        passwordField.setBackground(new Color(255, 255, 255));
        loginButton.setBackground(new Color(103,57,212));
        loginButton.setForeground(Color.white);

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameTextField.getText();
            String password = new String(passwordField.getPassword());

            // Kiểm tra tài khoản và mật khẩu
            if (username.equals("admin") && password.equals("admin")) {
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");

                // Chuyển hướng sang giao diện home
                home homeFrame = new home();
                homeFrame.setVisible(true);

                // Đóng giao diện đăng nhập
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Bạn đã đăng nhập sai. Vui lòng thử lại!",
                        "Đăng nhập thất bại", JOptionPane.ERROR_MESSAGE);
            }
        }
    }	


    public static void main(String[] args) {
    	login login = new login();
        login.setVisible(true);

    }
}
