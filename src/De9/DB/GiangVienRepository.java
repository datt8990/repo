package De9.DB;

import De9.model.GiangVien;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class GiangVienRepository {

    List<GiangVien> list = new ArrayList<>();
    private Component parentComponent;

    public List<GiangVien> getFormDataDB() {
        String query = "select ma,ten,loai,tuoi,bac,gioi_tinh from GiangVien";

        try ( Connection conn = DBConnect.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GiangVien gv = new GiangVien();
                gv.setMa(rs.getString("ma"));
                gv.setTen(rs.getString("ten"));
                gv.setLoaiGV(rs.getString("loai"));
                gv.setTuoi(rs.getInt("tuoi"));
                gv.setBac(rs.getInt("bac"));
                gv.setGioiTinh(rs.getInt("gioi_tinh"));
                list.add(gv);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    public void add(GiangVien gv) {
        String query = "insert into GiangVien(ma, ten, loai, tuoi, bac, gioi_tinh) values (?,?,?,?,?,?)";

        try ( Connection conn = DBConnect.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, gv.getMa());
            ps.setString(2, gv.getTen());
            ps.setString(3, gv.getLoaiGV());
            ps.setInt(4, gv.getTuoi());
            ps.setInt(5, gv.getBac());
            ps.setInt(6, gv.getGioiTinh());
            ps.execute();
            JOptionPane.showMessageDialog(parentComponent, "Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(parentComponent, "Thêm thất bại");
        }

    }

    public String update(GiangVien gv) {
        String query = "update GiangVien set ten = ? , loai = ? , tuoi = ? , bac = ? , gioi_tinh = ? where ma = ?";
        try ( Connection conn = DBConnect.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, gv.getTen());
            ps.setString(2, gv.getLoaiGV());
            ps.setInt(3, gv.getTuoi());
            ps.setInt(4, gv.getBac());
            ps.setInt(5, gv.getGioiTinh());
            ps.setString(6, gv.getMa());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(parentComponent, "Sửa thành công");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(parentComponent, "Sửa thất bại");

        }
        return null;

    }

    public void remove(String ma) {
        String query = "delete from GiangVien where ma = ?";
        try ( Connection conn = DBConnect.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, ma);
            ps.execute();
            JOptionPane.showMessageDialog(parentComponent, "Xóa thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(parentComponent, "Xóa thất bại");

        }

    }

    public List<GiangVien> search(String ma) {
        String query = "select ma,ten,loai,tuoi,bac,gioi_tinh from GiangVien where ma = ?";

        try ( Connection conn = DBConnect.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GiangVien gv = new GiangVien();
                gv.setMa(rs.getString("ma"));
                gv.setTen(rs.getString("ten"));
                gv.setLoaiGV(rs.getString("loai"));
                gv.setTuoi(rs.getInt("tuoi"));
                gv.setBac(rs.getInt("bac"));
                gv.setGioiTinh(rs.getInt("gioi_tinh"));
                list.add(gv);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

}
