package De9.view;

import De9.DB.GiangVienRepository;
import De9.model.GiangVien;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import De9.service.QuanLyNhanVien;
import De9.service.QuanLyNhanVienImpl;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

public class view extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    private List<GiangVien> list = new ArrayList<>();
    private QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVienImpl();
    private GiangVienRepository giangVienRepository = new GiangVienRepository();

    public view() {
        initComponents();
        list = giangVienRepository.getFormDataDB();
        init();
    }

    public void init() {
        this.setLocationRelativeTo(null);
        fillTable(list);
    }

    public void fillTable(List<GiangVien> list) {
        defaultTableModel = (DefaultTableModel) tblDanhSachGiangVien.getModel();
        defaultTableModel.setRowCount(0);
        for (GiangVien giangVien : list) {
            defaultTableModel.addRow(giangVien.toRowTable());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTuoi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboBac = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cboLoaiGV = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnGVFullTime = new javax.swing.JButton();
        btnSapXep = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachGiangVien = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel1.setText("Quản Lý Giảng Viên");

        btnClear.setText("Clear Form");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã ");

        jLabel3.setText("Tên");

        jLabel4.setText("Tuổi");

        jLabel5.setText("Bậc");

        cboBac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", " " }));

        jLabel6.setText("Loại Giảng Viên");

        cboLoaiGV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FullTime", "PartTime", " " }));

        jLabel7.setText("Giới Tính");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnGVFullTime.setText("GV FullTime");
        btnGVFullTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGVFullTimeActionPerformed(evt);
            }
        });

        btnSapXep.setText("Sắp Xếp");
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jLabel8.setText("List Data");

        tblDanhSachGiangVien.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblDanhSachGiangVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên", "Loại GV", "Tuổi", "Bậc", "Giới Tính"
            }
        ));
        tblDanhSachGiangVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachGiangVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSachGiangVien);

        txtTimKiem.setToolTipText("Tìm kiếm theo mã");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(225, 225, 225))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnClear)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(cboLoaiGV, 0, 164, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                            .addComponent(txtTuoi, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                            .addComponent(txtTimKiem))))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addGap(52, 52, 52)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtTen)
                                                .addComponent(cboBac, 0, 201, Short.MAX_VALUE))))
                                    .addComponent(btnSearch)))
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addGap(18, 18, 18)
                        .addComponent(btnGVFullTime)
                        .addGap(18, 18, 18)
                        .addComponent(btnSapXep)
                        .addGap(18, 18, 18)
                        .addComponent(btnThoat)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClear)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cboBac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboLoaiGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnGVFullTime)
                    .addComponent(btnSapXep)
                    .addComponent(btnThoat))
                .addGap(45, 45, 45)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        int row = tblDanhSachGiangVien.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Không có dòng nào được chọn");
            return;
        }

        GiangVien gv = list.get(row);
        String ma = gv.getMa();
        giangVienRepository.remove(ma);
        list.clear();
        list = giangVienRepository.getFormDataDB();
        fillTable(list);
        resetForm();

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnGVFullTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGVFullTimeActionPerformed
        List<GiangVien> listNew = new ArrayList<>();

        for (GiangVien giangVien : list) {
            if (giangVien.getLoaiGV().equalsIgnoreCase("FullTime")) {
                listNew.add(giangVien);
            }
        }
        fillTable(listNew);
    }//GEN-LAST:event_btnGVFullTimeActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void tblDanhSachGiangVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachGiangVienMouseClicked

        int row = tblDanhSachGiangVien.getSelectedRow();
        fillData(row);
    }//GEN-LAST:event_tblDanhSachGiangVienMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        giangVienRepository.add(getFormData());
        list.clear();
        list = giangVienRepository.getFormDataDB();
        fillTable(list);
        resetForm();

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        resetForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            int index = tblDanhSachGiangVien.getSelectedRow();
            GiangVien gv = list.get(index);
            JOptionPane.showMessageDialog(this, giangVienRepository.update(getFormData()));
            list.clear();
            list = giangVienRepository.getFormDataDB();
            fillTable(list);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chưa chọn bản ghi");
        }


    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
        List<GiangVien> listNew1 = list;
        Comparator comp = new Comparator<GiangVien>() {
            @Override
            public int compare(GiangVien o1, GiangVien o2) {
                return o1.getTen().compareTo(o2.getTen());
            }
        };
        Collections.sort(listNew1, comp);
        fillTable(listNew1);
    }//GEN-LAST:event_btnSapXepActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        List<GiangVien> listt = list;
        listt.clear();
        listt = giangVienRepository.search(txtTimKiem.getText());
        fillTable(listt);
        resetForm();
    }//GEN-LAST:event_btnSearchActionPerformed

    public void resetForm() {
        txtMa.setText("");
        txtTen.setText("");
        txtTuoi.setText("");
        cboLoaiGV.setSelectedItem("");
        cboBac.setSelectedIndex(0);
        buttonGroup1.clearSelection();
    }

    public GiangVien getFormData() {
        String ma = txtMa.getText();
        String ten = txtTen.getText();
        int tuoi = Integer.valueOf(txtTuoi.getText());
        String loai = (String) cboLoaiGV.getSelectedItem();
        String selectedBac = (String) cboBac.getSelectedItem();
        int bac = Integer.parseInt(selectedBac);
        int gioiTinh;

        if (rdoNam.isSelected()) {
            gioiTinh = 0;
        } else {
            gioiTinh = 1;
        }
        return new GiangVien(ma, ten, tuoi, bac, loai, gioiTinh);
    }

    public void fillData(int index) {
        GiangVien giangVien = list.get(index);
        txtMa.setText(giangVien.getMa());
        txtTen.setText(giangVien.getTen());
        txtTuoi.setText(String.valueOf(giangVien.getTuoi()));
        cboLoaiGV.setSelectedItem(giangVien.getLoaiGV());
        cboBac.setSelectedIndex(giangVien.getBac() - 1);
        if (giangVien.getGioiTinh() == 0) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnGVFullTime;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboBac;
    private javax.swing.JComboBox<String> cboLoaiGV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblDanhSachGiangVien;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}
