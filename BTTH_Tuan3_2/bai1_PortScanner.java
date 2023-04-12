package BTTH_Tuan3_2;

import java.net.*;

public class bai1_PortScanner {
    public static void main(String[] args) {
        String host = "localhost"; // Địa chỉ IP hoặc tên miền của máy chủ cần quét
        int startPort = 1; // Cổng bắt đầu quét
        int endPort = 65535; // Cổng kết thúc quét
        
        for (int port = startPort; port <= endPort; port++) {
            try {
                // Tạo một đối tượng ServerSocket với cổng được chỉ định
                ServerSocket serverSocket = new ServerSocket(port, 1, InetAddress.getByName(host));
                // Đóng kết nối
                serverSocket.close();
                System.out.println("Port " + port + " is open");
            } catch (Exception e) {
                // Nếu có lỗi xảy ra, cổng đó đang không được sử dụng
            }
        }
    }
}