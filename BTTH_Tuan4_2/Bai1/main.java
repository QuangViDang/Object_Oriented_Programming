package BTTH_Tuan4_2.Bai1;

public class main {
    public static void main(String[] args) {
        SoPhuc sp1 = new SoPhuc(1, 2);
        SoPhuc sp2 = new SoPhuc(3, 4);

        // Tính tổng
        SoPhuc tong = sp1.cong(sp2);
        System.out.println("Tong: " + tong.toString());

        // Tính hiệu
        SoPhuc hieu = sp1.tru(sp2);
        System.out.println("Hieu: " + hieu.toString());

        // Tính tích
        SoPhuc tich = sp1.nhan(sp2);
        System.out.println("Tich: " + tich.toString());

        // Tính thương
        SoPhuc thuong = sp1.chia(sp2);
        System.out.println("Thuong: " + thuong.toString());
        
    }
}
