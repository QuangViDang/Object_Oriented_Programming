package Cau3;

public class Main {
    public static void main(String[] args) {
        Product product = new Product();

        // Nhập thông tin sản phẩm
        product.inputProductInfo();

        // Thêm các tuỳ chọn
        product.addOption();
        product.addOption();

        // In ra thông tin sản phẩm
        product.printProductInfo();

        // Sửa một tuỳ chọn
        product.editOption();

        // In ra thông tin sản phẩm sau khi sửa
        product.printProductInfo();
    }
}