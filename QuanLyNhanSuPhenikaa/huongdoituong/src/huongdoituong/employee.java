package huongdoituong;

public class employee {
	private int ID;
	private String ten;
	private String khoa;
	private double luong;

	// Constructor
	public employee(int ID, String ten, String khoa, double luong) {
		this.ID = ID;
		this.ten = ten;
		this.khoa = khoa;
		this.luong = luong;
	}

	// Getter và Setter cho thuộc tính ID
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	// Getter và Setter cho thuộc tính ten
	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	// Getter và Setter cho thuộc tính khoa
	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	// Getter và Setter cho thuộc tính luong
	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}
}