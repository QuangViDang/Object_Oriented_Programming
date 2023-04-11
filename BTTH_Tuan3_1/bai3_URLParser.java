package BTTH_Tuan3_1;

import java.net.URL;

public class bai3_URLParser {
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

            // Phân tích URL thành các thành phần
            String protocol = url.getProtocol();
            String host = url.getHost();
            int port = url.getPort();
            String path = url.getPath();
            String query = url.getQuery();
            String fragment = url.getRef();

            // In ra các thành phần của URL
            System.out.println("Protocol: " + protocol);
            System.out.println("Host: " + host);
            System.out.println("Port: " + port);
            System.out.println("Path: " + path);
            System.out.println("Query: " + query);
            System.out.println("Fragment: " + fragment);
        } catch (Exception e) {
            System.out.println("Không thể phân tích URL " + url_string);
            e.printStackTrace();
        }
    }
}   