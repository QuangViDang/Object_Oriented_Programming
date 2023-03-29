package BTTH_Tuan2;

import java.io.*;

public class Bai5 {
    public static void main(String[] args) {
        try {
            // Đọc tên tệp từ bàn phím
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Nhap ten tep tin: ");
            String fileName = br.readLine();
            
            // Tạo một tệp tin sử dụng FileWriter
            FileWriter fw = new FileWriter(fileName);
            
            // Đọc một hoặc nhiều chuỗi và chuyển đổi các chuỗi đó thành chữ viết hoa và ghi vào tệp tin
            System.out.println("Nhap cac chuoi (nhap 'q' de ket thuc): ");
            String line;
            while (!(line = br.readLine()).equals("q")) {
                // Chuyển đổi chuỗi thành chữ viết hoa
                String upperCaseLine = line.toUpperCase();
                
                // Ghi chuỗi đã chuyển đổi vào tệp tin
                fw.write(upperCaseLine + "\n");
            }
            
            // Đóng FileWriter
            fw.close();
            
            // Sử dụng FileReader để đọc lại các xâu vừa ghi và in ra màn hình
            FileReader fr = new FileReader(fileName);
            BufferedReader br2 = new BufferedReader(fr);
            System.out.println("Noi dung tep tin:");
            while ((line = br2.readLine()) != null) {
                System.out.println(line);
            }
            
            // Đóng FileReader
            fr.close();
        } catch (IOException e) {
            // Xử lý ngoại lệ nếu có
            e.printStackTrace();
        }
    }
}
