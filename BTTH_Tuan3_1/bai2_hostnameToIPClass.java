package BTTH_Tuan3_1;
import java.net.InetAddress;

public class bai2_hostnameToIPClass {
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

            byte[] bytes = ip_address.getAddress();
            int first_byte = bytes[0] & 0xff;

            // Kiểm tra lớp địa chỉ
            String address_class;
            if (first_byte >= 1 && first_byte <= 126) {
                address_class = "A";
            } else if (first_byte >= 128 && first_byte <= 191) {
                address_class = "B";
            } else if (first_byte >= 192 && first_byte <= 223) {
                address_class = "C";
            } else if (first_byte >= 224 && first_byte <= 239) {
                address_class = "D";
            } else if (first_byte >= 240 && first_byte <= 255) {
                address_class = "E";
            } else {
                address_class = "Không xác định";
            }

            // In ra địa chỉ IP và lớp địa chỉ tương ứng
            System.out.println("Địa chỉ IP của hostname " + hostname + " là: " + ip_address.getHostAddress());
            System.out.println("Lớp địa chỉ của địa chỉ IP trên là: " + address_class);
        } catch (Exception e) {
            System.out.println("Không thể lấy địa chỉ IP cho hostname " + hostname);
            e.printStackTrace();
        }
    }
}
