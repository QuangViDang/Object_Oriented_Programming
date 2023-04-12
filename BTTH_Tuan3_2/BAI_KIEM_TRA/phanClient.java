package BTTH_Tuan3_2.BAI_KIEM_TRA;

import java.io.*;
import java.net.*;

public class phanClient {
    public static void main(String[] args) {
        try {
            // Tạo đối tượng Socket để kết nối đến server với địa chỉ IP và cổng
            Socket clientSocket = new Socket("localhost", 1234);
            
            // Lấy luồng nhập và luồng xuất từ socket
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            // Nhập 2 số từ bàn phím và gửi đến server
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhập số thứ nhất: ");
            double num1 = Double.parseDouble(reader.readLine());
            System.out.print("Nhập số thứ hai: ");
            double num2 = Double.parseDouble(reader.readLine());
            out.println(num1);
            out.println(num2);
            
            // Đọc và in ra kết quả từ server
            System.out.println("Kết quả từ server:");
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            
            // Đóng socket
            clientSocket.close();
        } catch (UnknownHostException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}