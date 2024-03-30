package dethi4.Repository;

import dethi4.Model.NguoiHoc;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class NguoiHocRepository {

    private List<NguoiHoc> list = new ArrayList<>();
    private Component parentComponent;

    public List<NguoiHoc> getFormDataDB() {
        String query = "select MaNH,HoTen,NgaySinh,DienThoai from NguoiHoc  ";
        try ( Connection conn = DBConnect.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                NguoiHoc hoc = new NguoiHoc();
                hoc.setMa(rs.getString("MaNH"));
                hoc.setTen(rs.getString("HoTen"));
                hoc.setNgaySinh(rs.getString("NgaySinh"));
                hoc.setsDT(Integer.valueOf(rs.getString("DienThoai")));
                list.add(hoc);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void add(NguoiHoc hoc) {
        String query = "insert into NguoiHoc(MaNH,HoTen,NgaySinh,DienThoai) values (?,?,?,?) ";

        try ( Connection conn = DBConnect.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, hoc.getMa());
            ps.setString(2, hoc.getTen());
            ps.setString(3, hoc.getNgaySinh());
            ps.setInt(4, hoc.getsDT());
            ps.execute();
            JOptionPane.showMessageDialog(parentComponent, "Thêm thành công");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(parentComponent, "Thêm thất bại");

        }
    }

    public void remove(String ma) {
        String query = "delete from NguoiHoc where MaNH = ?";
        try ( Connection conn = DBConnect.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, ma);
            ps.execute();
            JOptionPane.showMessageDialog(parentComponent, "Xóa thành công");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(parentComponent, "Xóa thất bại");

        }

    }

}
