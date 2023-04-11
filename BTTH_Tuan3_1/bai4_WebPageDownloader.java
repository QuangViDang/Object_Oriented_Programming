package BTTH_Tuan3_1;

import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bai4_WebPageDownloader {
    public static void main(String[] args) {
        // Kiểm tra xem đã nhập đúng số lượng tham số chưa
        if (args.length != 1) {
            System.out.println("Vui lòng nhập URL vào như một tham số dòng lệnh.");
            return;
        }

        // Lấy URL từ tham số dòng lệnh
        String url_string = args[0];

        try {
            // Tạo đối tượng URL từ chuỗi URL
            URL url = new URL(url_string);

            // Mở kết nối đến URL
            URLConnection connection = url.openConnection();

            // Lấy luồng đầu vào từ kết nối
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            // Đọc nội dung của trang web vào một chuỗi
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            // Đóng luồng đầu vào
            in.close();

            // In ra mã HTML của trang web
            System.out.println(content.toString());
        } catch (Exception e) {
            System.out.println("Không thể kết nối đến " + url_string);
            e.printStackTrace();
        }
    }
}