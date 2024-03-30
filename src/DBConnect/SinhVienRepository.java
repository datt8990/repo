package DBConnect;

import j2.view.SinhVienService.SinhVien;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class SinhVienRepository {

    private int MaSV;

    public List<SinhVien> getReadFormDB() {
        List<SinhVien> list = new ArrayList<>();

        String query = "select MaSV,TenSV,SDT,TrangThai from SinhVien";

        try ( Connection conn = DBConnect.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.execute();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sinhVien = new SinhVien();
                sinhVien.setMa(String.valueOf(rs.getInt("MaSV")));
                sinhVien.setTenSV(rs.getString("TenSV"));
                sinhVien.setSdt(rs.getString("SDT"));
                sinhVien.setTrangThai(Integer.valueOf(rs.getString("TrangThai")));
                list.add(sinhVien);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }

}
