package j2.view.SinhVienService;

public class SinhVien {

    private String ma;

    private String tenSV;

    private String sdt;

    private int trangThai;

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public SinhVien(String ma, String tenSV, String sdt, int trangThai) {
        this.ma = ma;
        this.tenSV = tenSV;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }

    public SinhVien() {
    }

    public Object[] toRowTable() {
        return new Object[]{ma, tenSV, sdt, trangThai == 0 ? "Hoạt Động" : "Không Hoạt Động"};
    }

}
