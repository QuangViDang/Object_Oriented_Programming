package BTTH_Tuan4_1.Bai2;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        // Khai báo địa chỉ IP và cổng của máy chủ
        String serverName = "localhost";
        int port = 6066;
        try {
            // Tạo kết nối đến máy chủ
            System.out.println("Connecting to " + serverName + " on port " + port);
            Socket client = new Socket(serverName, port);

            // Nhập thông số của hình trụ tròn
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the radius of the cylinder: ");
            double radius = Double.parseDouble(input.readLine());
            System.out.print("Enter the height of the cylinder: ");
            double height = Double.parseDouble(input.readLine());

            // Gửi thông số của hình trụ tròn tới máy chủ
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeDouble(radius);
            out.writeDouble(height);

            // Nhận kết quả từ máy chủ và in ra màn hình
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("Volume of the cylinder is: " + in.readDouble());

            // Đóng kết nối
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
