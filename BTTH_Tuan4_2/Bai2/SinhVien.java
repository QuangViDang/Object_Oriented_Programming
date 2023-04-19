package BTTH_Tuan4_2.Bai2;

import java.util.Arrays;
import java.util.Comparator;

public class SinhVien {
    private String maSV;
    private String tenSV;
    private double diem;

    public SinhVien(String maSV, String tenSV, double diem) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.diem = diem;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public static void sapXepSinhVienTheoDiemGiamDan(SinhVien[] danhSachSinhVien) {
        Comparator<SinhVien> comparator = new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                return Double.compare(sv2.getDiem(), sv1.getDiem());
            }
        };
        Arrays.sort(danhSachSinhVien, comparator);
    }
}
