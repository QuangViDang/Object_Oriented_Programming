package BT_TH.BTTH_Tuan1;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class Bai3_DigitalClock extends JFrame {

    private JLabel timeLabel;

    public Bai3_DigitalClock() {
        setTitle("Đồng hồ số");
        setSize(200, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        timeLabel = new JLabel();
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        updateTime();
        add(timeLabel, BorderLayout.CENTER);

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