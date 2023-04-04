package BTTH_Tuan2;

import java.io.*;

public class Bai3_FileIOExam
{
    public static void main(String[] args)
    {

        try{
        // Tạo một luồng xuất dữ liệu để ghi vào tập tin được chỉ định trong tham số đầu vào
        OutputStream os = new FileOutputStream("Q.txt");
        
        // Chuỗi s cần được ghi vào tập tin
        String s = "Thu nghiem voi luong xuat nhap tap tin cua Vi Dang Quang";
        
        // Ghi từng ký tự trong chuỗi vào luồng xuất
        for(int i=0; i<s.length(); i++) {
            os.write(s.charAt(i));
        }
        // Đóng luồng xuất
        os.close();
        
        // Mở một luồng nhập dữ liệu để đọc tập tin
        InputStream is = new FileInputStream(args[0]);
        
        // Lấy số lượng byte có trong tập tin
        int len = is.available();
        
        // In ra số lượng byte đã đọc được từ tập tin
        System.out.println("Luong nhap co "+len+ " bytes");
        
        // Tạo một mảng byte để lưu trữ dữ liệu đọc được từ tập tin
        byte b[] = new byte[len];
        
        // Đọc dữ liệu từ luồng nhập và lưu vào mảng byte b
        int sobyte = is.read(b,0,len);
        
        // In ra số lượng byte đã đọc được từ luồng nhập
        System.out.println(sobyte+ " la so bytes da doc");
        
        // In ra chuỗi đã được đọc từ tập tin
        System.out.println(new String(b));
        
        // Đóng luồng nhập
            is.close();
        }
        catch(IOException e) {
        // Xử lý ngoại lệ nếu có
        System.err.println(e);
        }
    }
}

