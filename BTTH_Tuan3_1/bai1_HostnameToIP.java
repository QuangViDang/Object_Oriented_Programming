package BTTH_Tuan3_1;

import java.net.InetAddress;

public class bai1_HostnameToIP {
    public static void main(String[] args) {
        // Kiểm tra xem đã nhập đúng số lượng tham số chưa
        if (args.length != 1) {
            System.out.println("Vui lòng nhập hostname vào như một tham số dòng lệnh.");
            return;
        }

        // Lấy hostname từ tham số dòng lệnh
        String hostname = args[0];

        try {
            // Lấy địa chỉ IP tương ứng với hostname
            InetAddress ip_address = InetAddress.getByName(hostname);

            // In ra địa chỉ IP tương ứng
            System.out.println("Địa chỉ IP của hostname " + hostname + " là: " + ip_address.getHostAddress());
        } catch (Exception e) {
            System.out.println("Không thể lấy địa chỉ IP cho hostname " + hostname);
            e.printStackTrace();
        }
    }
}