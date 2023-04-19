package BTTH_Tuan4_2.Bai2;

public class main {
    public static void main(String[] args) {
        SinhVien[] danhSachSinhVien = new SinhVien[3];
        danhSachSinhVien[0] = new SinhVien("001", "Vi Dang Quang", 9.5);
        danhSachSinhVien[1] = new SinhVien("002", "Nguyen Duc Viet", 9.0);
        danhSachSinhVien[2] = new SinhVien("003", "Hoang Anh Vu", 10.0);

        SinhVien.sapXepSinhVienTheoDiemGiamDan(danhSachSinhVien);

        for (SinhVien sv : danhSachSinhVien) {
            System.out.println(sv.getMaSV() + " - " + sv.getTenSV() + " - " + sv.getDiem());
        }
    }
}