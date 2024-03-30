package De9.service;

import De9.model.GiangVien;

public interface QuanLyNhanVien {

    public String add(GiangVien gv);

    public String update(GiangVien gv);

    public String remove(int index);
}
