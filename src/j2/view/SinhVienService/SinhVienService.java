package j2.view.SinhVienService;

import java.util.List;

public interface SinhVienService {

    public List<SinhVien> fakeData();
    public String themSinhVien(SinhVien sv);
    public String xoaSinhVien(int index);

}
