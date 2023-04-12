package BTTH_Tuan3_2.Bai2;

import java.io.*;
import java.net.*;

public class Server {
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
                    
                    // Đọc xâu ký tự từ client
                    String input = in.readLine();
                    System.out.println("Received message from client: " + input);
                    
                    // Biến đổi xâu ký tự thành chữ hoa
                    String output = input.toUpperCase();
                    
                    // Gửi lại xâu ký tự đã biến đổi cho client
                    out.println(output);
                    
                    // Đóng kết nối
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}