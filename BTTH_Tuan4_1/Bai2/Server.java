package BTTH_Tuan4_1.Bai2;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        // Khai báo cổng để lắng nghe kết nối từ máy khách
        int port = 6066;

        try {
            // Tạo socket server
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
            
            // Chấp nhận kết nối từ máy khách
            Socket server = serverSocket.accept();
            System.out.println("Just connected to " + server.getRemoteSocketAddress());

            // Nhận thông số của hình trụ tròn từ máy khách
            DataInputStream in = new DataInputStream(server.getInputStream());
            double radius = in.readDouble();
            double height = in.readDouble();

            // Tính thể tích của hình trụ tròn
            double volume = Math.PI * Math.pow(radius, 2) * height;

            // Gửi kết quả về cho máy khách
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            out.writeDouble(volume);

            // Đóng kết nối
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}