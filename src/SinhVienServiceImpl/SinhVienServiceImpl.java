package SinhVienServiceImpl;

import j2.view.SinhVienService.SinhVien;
import j2.view.SinhVienService.SinhVienService;
import java.util.ArrayList;
import java.util.List;

public class SinhVienServiceImpl implements SinhVienService {

    List<SinhVien> list = new ArrayList<>();

    @Override
    public List<SinhVien> fakeData() {
        list.add(new SinhVien("SV001", "Nguyễn Văn A", "1234567899", 0));
        list.add(new SinhVien("SV002", "Nguyễn Văn B", "12367890899", 1));
        list.add(new SinhVien("SV003", "Nguyễn Văn C", "1236467867899", 0));
        list.add(new SinhVien("SV004", "Nguyễn Văn D", "67899", 1));
        list.add(new SinhVien("SV005", "Nguyễn Văn E", "13434567899", 0));
        return list;
    }

    @Override
    public String themSinhVien(SinhVien sv) {
        if (sv != null) {
            list.add(sv);
            return "Thêm thành công";
        }
        return "Thêm thất bại";

    }

    @Override
    public String xoaSinhVien(int index) {
        if (index != -1) {
            list.remove(index);
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }

}
