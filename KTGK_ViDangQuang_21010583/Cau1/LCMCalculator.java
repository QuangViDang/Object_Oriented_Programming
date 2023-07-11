package Cau1;

import java.util.Scanner;

public class LCMCalculator {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Nhập vào số thứ nhất: ");
            int num1 = input.nextInt();
            System.out.print("Nhập vào số thứ hai: ");
            int num2 = input.nextInt();
            int lcm = calculateLCM(num1, num2);
            System.out.println("Bội chung nhỏ nhất của " + num1 + " và " + num2 + " là " + lcm);
        }
    }

    public static int calculateLCM(int a, int b) {
        int gcd = calculateGCD(a, b);
        return (a * b) / gcd;
    }

    public static int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return calculateGCD(b, a % b);
        }
    }
}