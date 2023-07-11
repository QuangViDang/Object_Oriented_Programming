package Cau2;

import java.util.Scanner;

public class OddNumbersInArray {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Nhập vào số lượng phần tử của mảng: ");
            int n = input.nextInt();
            int[] arr = new int[n];
            System.out.println("Nhập vào các phần tử của mảng:");
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            System.out.println("Các số lẻ trong mảng là:");
            for (int i = 0; i < n; i++) {
                if (arr[i] % 2 != 0) {
                    System.out.print(arr[i] + " ");
                }
            }
        }
    }
}
