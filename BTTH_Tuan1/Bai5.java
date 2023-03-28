package BT_TH.BTTH_W1;

import java.util.Arrays;

public class Bai5 {
    public static void main(String[] args) {
        // Nhập vào dãy số thực từ tham số dòng lệnh
        double[] arr = new double[args.length];
        for (int i = 0; i < args.length; i++) {
            arr[i] = Double.parseDouble(args[i]);
        }
        
        // Hiển thị dãy đã nhập
        System.out.print("Dãy số đã nhập: ");
        for (double num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Sắp xếp dãy và hiển thị dãy đã sắp xếp
        Arrays.sort(arr);
        System.out.print("Dãy số đã sắp xếp: ");
        for (double num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        // Tính trung bình cộng của dãy và hiển thị kết quả
        double sum = 0;
        for (double num : arr) {
            sum += num;
        }
        double avg = sum / arr.length;
        System.out.println("Trung bình cộng của dãy: " + avg);
    }
}