package BTTH_Tuan4_2.Bai1;

public class SoPhuc {
    private double thuc;
    private double ao;

    public SoPhuc(double thuc, double ao) {
        this.thuc = thuc;
        this.ao = ao;
    }

    public double getThuc() {
        return thuc;
    }

    public double getAo() {
        return ao;
    }

    public SoPhuc cong(SoPhuc sp) {
        double thucMoi = this.thuc + sp.thuc;
        double aoMoi = this.ao + sp.ao;
        return new SoPhuc(thucMoi, aoMoi);
    }

    public SoPhuc tru(SoPhuc sp) {
        double thucMoi = this.thuc - sp.thuc;
        double aoMoi = this.ao - sp.ao;
        return new SoPhuc(thucMoi, aoMoi);
    }

    public SoPhuc nhan(SoPhuc sp) {
        double thucMoi = this.thuc * sp.thuc - this.ao * sp.ao;
        double aoMoi = this.thuc * sp.ao + this.ao * sp.thuc;
        return new SoPhuc(thucMoi, aoMoi);
    }

    public SoPhuc chia(SoPhuc sp) {
        double mau = sp.thuc * sp.thuc + sp.ao * sp.ao;
        double thucMoi = (this.thuc * sp.thuc + this.ao * sp.ao) / mau;
        double aoMoi = (this.ao * sp.thuc - this.thuc * sp.ao) / mau;
        return new SoPhuc(thucMoi, aoMoi);
    }
    
    public String toString() {
        if (ao >= 0) {
            return thuc + " + " + ao + "i";
        } else {
            return thuc + " - " + (-ao) + "i";
        }
    }
}
