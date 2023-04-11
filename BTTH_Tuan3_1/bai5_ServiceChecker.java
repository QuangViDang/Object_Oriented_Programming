package BTTH_Tuan3_1;

import java.net.Socket;
import java.net.InetAddress;
import java.io.IOException;

public class bai5_ServiceChecker {
    public static void main(String[] args) {
        // Kiểm tra xem đã nhập đúng số lượng tham số chưa
        if (args.length != 1) {
            System.out.println("Vui lòng nhập địa chỉ IP hoặc tên miền vào như một tham số dòng lệnh.");
            return;
        }

        // Lấy địa chỉ IP từ tham số dòng lệnh
        String host = args[0];

        try {
            // Lấy đối tượng InetAddress từ địa chỉ IP
            InetAddress address = InetAddress.getByName(host);

            // Kiểm tra các cổng từ 1 đến 65535
            for (int port = 1; port <= 65535; port++) {
                try {
                    // Tạo đối tượng Socket để kết nối đến cổng
                    Socket socket = new Socket(address, port);

                    // In ra thông tin về cổng đang hoạt động
                    System.out.println("Cổng " + port + " đang hoạt động.");

                    // Đóng socket
                    socket.close();
                } catch (IOException e) {
                    // Nếu không thể kết nối đến cổng, bỏ qua và tiếp tục với cổng tiếp theo
                }
            }
        } catch (IOException e) {
            System.out.println("Không thể kết nối đến " + host);
            e.printStackTrace();
        }
    }
}