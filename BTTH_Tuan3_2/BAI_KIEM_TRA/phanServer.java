package BTTH_Tuan3_2.BAI_KIEM_TRA;

import java.io.*;
import java.net.*;

public class phanServer {
    public static void main(String[] args) {
        try {
            try (// Tạo đối tượng ServerSocket với cổng 1234
            ServerSocket serverSocket = new ServerSocket(1234)) {
                System.out.println("Server is running...");
                
                while (true) {
                    // Chấp nhận kết nối từ client
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
                    
                    // Lấy luồng nhập và luồng xuất từ socket
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    
                    // Đọc 2 số từ client
                    double num1 = Double.parseDouble(in.readLine());
                    double num2 = Double.parseDouble(in.readLine());
                    
                    // Thực hiện các phép tính trên 2 số và gửi kết quả về cho client
                    out.println("Tổng: " + (num1 + num2));
                    out.println("Hiệu: " + (num1 - num2));
                    out.println("Tích: " + (num1 * num2));
                    out.println("Thương: " + (num1 / num2));
                    
                    // Đóng socket
                    clientSocket.close();
                }
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}