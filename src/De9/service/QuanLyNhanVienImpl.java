package De9.service;

import De9.model.GiangVien;
import java.util.List;
import java.util.ArrayList;

public class QuanLyNhanVienImpl implements QuanLyNhanVien {

    List<GiangVien> list = new ArrayList<>();

    @Override
    public String add(GiangVien gv) {
        if (gv != null) {
            list.add(gv);
            return "Thêm thành công";
        }
        return "Thêm thất bại";

    }

    @Override
    public String update(GiangVien gv) {
        return null;
    }

    @Override
    public String remove(int index) {
        if (index != -1) {
            list.remove(index);
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }

}
