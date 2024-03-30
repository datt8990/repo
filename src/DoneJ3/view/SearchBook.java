package DoneJ3.view;

import DoneJ3.model.Books;
import DoneJ3.model.Users;
import DoneJ3.repository.BooksRepository;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class SearchBook extends javax.swing.JFrame {

    private List<Books> listB = new ArrayList<>();
    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    private BooksRepository booksRepository = new BooksRepository();

    public SearchBook(String args) {

        initComponents();
        this.setLocationRelativeTo(null);
        init(args);

    }

    public void init(String arg) {
        lbWelcome.setText("Welcome " + arg);
        defaultTableModel = (DefaultTableModel) tblDanhSachBook.getModel();
        listB = booksRepository.getFormDataDB(arg);
        fillTable(listB);
    }

    public void fillTable(List<Books> list) {
        defaultTableModel.setRowCount(0);
        for (Books books : list) {
            defaultTableModel.addRow(books.toRowTable());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboSearchby = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtKeyWord = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachBook = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        lbWelcome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Search by");

        cboSearchby.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Book ID", "Book Title", "Authors", " " }));

        jLabel2.setText("Enter keyword");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblDanhSachBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Book ID", "Book Title", "Publishers", "Authors", "Note"
            }
        ));
        tblDanhSachBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachBookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSachBook);

        btnAdd.setText("Add New");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(cboSearchby, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel2)
                                .addGap(32, 32, 32)
                                .addComponent(txtKeyWord, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btnSearch)))
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(457, 457, 457)
                        .addComponent(lbWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboSearchby, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(txtKeyWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbWelcome)
                    .addComponent(btnAdd))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String selectedField = cboSearchby.getSelectedItem().toString();
        String keyword = txtKeyWord.getText();

        List<Books> searchResult = booksRepository.searchBooks(selectedField, keyword, lbWelcome.getText().substring(8));

        DefaultTableModel model = (DefaultTableModel) tblDanhSachBook.getModel();
        model.setRowCount(0);
        for (Books books : searchResult) {
            defaultTableModel.addRow(books.toRowTable());
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        this.dispose();
        AddBook ab = new AddBook(lbWelcome.getText().substring(8));
        ab.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblDanhSachBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachBookMouseClicked
        int row = tblDanhSachBook.getSelectedRow();

        if (row >= 0) {
            Books selectedBook = listB.get(row);
            DetailBook book = new DetailBook(lbWelcome.getText().substring(8));
            book.fillFields(selectedBook);
            this.dispose();
            book.setVisible(true);
        }

    }//GEN-LAST:event_tblDanhSachBookMouseClicked

    public static void main(String username) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchBook(username).setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cboSearchby;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbWelcome;
    private javax.swing.JTable tblDanhSachBook;
    private javax.swing.JTextField txtKeyWord;
    // End of variables declaration//GEN-END:variables
}
