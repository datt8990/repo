package dethi4.Model;

public class NguoiHoc {

    private String ma;

    private String ten;

    private String ngaySinh;

    private int sDT;

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

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getsDT() {
        return sDT;
    }

    public void setsDT(int sDT) {
        this.sDT = sDT;
    }

    public NguoiHoc(String ma, String ten, String ngaySinh, int sDT) {
        this.ma = ma;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.sDT = sDT;
    }

    public NguoiHoc() {
    }

    public Object[] toRowTable() {
        return new Object[]{ma, ten, ngaySinh, sDT};
    }

}
