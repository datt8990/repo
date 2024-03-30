package De9.model;

public class GiangVien {

    private String ma;

    private String ten;

    private int tuoi;

    private int bac;

    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        this.bac = bac;
    }

    public GiangVien(String ma, String ten, int tuoi, int bac, String loaiGV, int gioiTinh) {
        this.ma = ma;
        this.ten = ten;
        this.tuoi = tuoi;
        this.bac = bac;
        this.loaiGV = loaiGV;
        this.gioiTinh = gioiTinh;
    }

    private String loaiGV;

    private int gioiTinh;

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getLoaiGV() {
        return loaiGV;
    }

    public void setLoaiGV(String loaiGV) {
        this.loaiGV = loaiGV;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }
    
    public int isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public GiangVien(String ma, String ten, int tuoi, String loaiGV, int gioiTinh) {
        this.ma = ma;
        this.ten = ten;
        this.tuoi = tuoi;
        this.loaiGV = loaiGV;
        this.gioiTinh = gioiTinh;
    }

    public GiangVien() {
    }

    public Object[] toRowTable() {
        return new Object[]{ma, ten,loaiGV ,tuoi, bac, gioiTinh == 0 ? "Nam" : "Nữ"};
    }

}
