package BTTH_Tuan3_2.Bai2;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Tạo một đối tượng Socket để kết nối đến server với địa chỉ IP localhost và cổng 1234
            Socket socket = new Socket("localhost", 1234);
            
            // Lấy luồng nhập và luồng xuất từ socket
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            // Gửi xâu ký tự đến server
            String message = "I'm your friend.";
            out.println(message);
            System.out.println("Sent message to server: " + message);
            
            // Đọc xâu ký tự được gửi lại từ server và in ra màn hình
            String response = in.readLine();
            System.out.println("Received message from server: " + response);
            
            // Đóng kết nối
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}