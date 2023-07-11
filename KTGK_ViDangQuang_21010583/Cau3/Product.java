package Cau3;

import java.util.ArrayList;
import java.util.Scanner;

public class Product {
    private String productCode;
    private String shortDescription;
    private String detailedDescription;
    private ArrayList<Option> options;

    public Product() {
        this.options = new ArrayList<Option>();
    }

    public void inputProductInfo() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Nhập thông tin sản phẩm:");
            System.out.print("Mã sản phẩm: ");
            this.productCode = input.nextLine();
            System.out.print("Mô tả ngắn: ");
            this.shortDescription = input.nextLine();
            System.out.print("Thông tin chi tiết: ");
            this.detailedDescription = input.nextLine();
        }
    }

    public void addOption() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Thêm tuỳ chọn cho sản phẩm:");
            System.out.print("Tên tuỳ chọn: ");
            String optionName = input.nextLine();
            System.out.print("Giá: ");
            double optionPrice = input.nextDouble();
            Option option = new Option(optionName, optionPrice);
            this.options.add(option);
        }
        System.out.println("Tuỳ chọn đã được thêm thành công.");
    }

    public void editOption() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Sửa thông tin một tuỳ chọn:");
            System.out.print("Nhập tên tuỳ chọn cần sửa: ");
            String optionName = input.nextLine();
            for (Option option : this.options) {
                if (option.getName().equals(optionName)) {
                    System.out.print("Tên mới: ");
                    String newOptionName = input.nextLine();
                    System.out.print("Giá mới: ");
                    double newOptionPrice = input.nextDouble();
                    option.setName(newOptionName);
                    option.setPrice(newOptionPrice);
                    System.out.println("Tuỳ chọn đã được sửa thành công.");
                    return;
                }
            }
        }
        System.out.println("Không tìm thấy tuỳ chọn cần sửa.");
    }

    public void printProductInfo() {
        System.out.println("Thông tin chi tiết của sản phẩm:");
        System.out.println("Mã sản phẩm: " + this.productCode);
        System.out.println("Mô tả ngắn: " + this.shortDescription);
        System.out.println("Thông tin chi tiết: " + this.detailedDescription);
        if (this.options.size() > 0) {
            System.out.println("Danh sách các tuỳ chọn và giá của chúng:");
            for (Option option : this.options) {
                System.out.println(option.getName() + ": " + option.getPrice());
            }
        } else {
            System.out.println("Sản phẩm này không có các tuỳ chọn.");
        }
    }

    private class Option {
        private String name;
        private double price;

        public Option(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}