import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class Bai3_DigitalClock extends JFrame {

    private JPanel clockPanel;
    private JLabel timeLabel;

    public Bai3_DigitalClock() {
        setTitle("Đồng hồ số tròn");
        setSize(200, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Tạo panel cho đồng hồ số
        clockPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(173, 216, 230)); // Màu lightblue
                g.fillOval(0, 0, getWidth(), getHeight()); // Vẽ khung hình tròn
            }
        };
        add(clockPanel, BorderLayout.CENTER);

        // Tạo label cho thời gian
        timeLabel = new JLabel();
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        updateTime();
        clockPanel.add(timeLabel);

        // Cập nhật thời gian
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();
    }

    private void updateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
        String time = dateFormat.format(new Date());
        timeLabel.setText(time);
    }

    public static void main(String[] args) {
        Bai3_DigitalClock clock = new Bai3_DigitalClock();
        clock.setVisible(true);
    }
}
