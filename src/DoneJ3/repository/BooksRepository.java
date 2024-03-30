package DoneJ3.repository;

import DoneJ3.jdbc.DBConnect;
import DoneJ3.model.Authors;
import DoneJ3.model.Books;
import DoneJ3.model.Publisher;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class BooksRepository {

    private List<Publisher> listP = new ArrayList<>();
    private List<Authors> listA = new ArrayList<>();
    Component parentComponent;

    public List<Books> getFormDataDB(String users) {
        List<Books> list = new ArrayList<>();
        String query = "select book_id, title,pub_name,au_name,notes\n"
                + "from Books  join Publishers on Books.pub_id = Publishers.pub_id \n"
                + "join Authors on Books.au_id = Authors.au_id\n"
                + "where username = ?";

        try ( Connection conn = DBConnect.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, users);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Books b = new Books();
                b.setBookID(rs.getString("book_id"));
                b.setTitle(rs.getString("title"));
                b.setPubName(rs.getString("pub_name"));
                b.setAuName(rs.getString("au_name"));
                b.setNote(rs.getString("notes"));
                list.add(b);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addBookToDB(Books book) {

        String query = "INSERT INTO Books (book_id, title, pub_id, au_id , notes,username) VALUES (?, ?, ?, ?,?,?)";
        try ( Connection conn = DBConnect.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, book.getBookID());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getPubName());
            ps.setString(4, book.getAuName());
            ps.setString(5, book.getNote());
            ps.setString(6, book.getUser());
            if (ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(parentComponent, "Thêm thành công");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(parentComponent, "Thêm thất bại");

        }

    }

    public boolean checkBookID(String bookid) {
        try {
            String query = "SELECT * FROM Books WHERE BookID = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, bookid);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return true; // bookid đã tồn tại
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false; // bookid chưa tồn tại
    }

    public List<String> getPublishers() {
        List<String> publisherID = new ArrayList<>();
        String query = "select pub_id, pub_name, pub_address from Publishers";

        try ( Connection conn = DBConnect.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String pubID = rs.getString("pub_id");
                String pubName = rs.getString("pub_name");
                String pubAddress = rs.getString("pub_address");

                publisherID.add(pubName);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return publisherID;
    }

    public static List<String> getAuthors() {
        List<String> authorsID = new ArrayList<>();
        String query = "select au_id, au_name, au_address from Authors";

        try ( Connection conn = DBConnect.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String auID = rs.getString("au_id");
                String auName = rs.getString("au_name");
                String auAddress = rs.getString("au_address");

                authorsID.add(auName);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorsID;
    }

    public boolean isBookIDExist(String bookID) {
        String query = "SELECT book_id FROM Books WHERE book_id = ?";

        try ( Connection conn = DBConnect.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, bookID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true; // bookid đã tồn tại
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false; // bookid chưa tồn tại
    }

    public List<Books> searchBooks(String selectedField, String keyword, String user) {
        List<Books> searchResults = new ArrayList<>();

        String query = "select book_id, title,pub_name,au_name,notes\n"
                + "from Books  join Publishers on Books.pub_id = Publishers.pub_id \n"
                + "join Authors on Books.au_id = Authors.au_id\n"
                + "where ";

        if (selectedField.equalsIgnoreCase("Book ID")) {
            query += "book_id LIKE ? and username = ?";
        } else if (selectedField.equalsIgnoreCase("Book Title")) {
            query += "title LIKE ? and username = ?";
        } else if (selectedField.equalsIgnoreCase("Authors")) {
            query += "au_name LIKE ? and username = ? ";
        }

        try ( Connection conn = DBConnect.getConnection();  PreparedStatement statement = conn.prepareStatement(query)) {

            if (selectedField.equals("Book ID")) {
                statement.setString(1, "%" + keyword + "%");
            } else if (selectedField.equals("Book Title")) {
                statement.setString(1, "%" + keyword + "%");
            } else if (selectedField.equals("Authors")) {
                statement.setString(1, "%" + keyword + "%");
            }

            statement.setString(2, user);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String bookID = resultSet.getString("book_id");
                String title = resultSet.getString("title");
                String pubID = resultSet.getString("pub_name");
                String auID = resultSet.getString("au_name");
                String note = resultSet.getString("notes");

                Books book = new Books(bookID, title, pubID, auID, note, user);
                searchResults.add(book);
            }

            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return searchResults;
    }

    public void removeBookToDB(String id) {
        String query = " delete from Books where book_id = ? ";
        try ( Connection conn = DBConnect.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, id);
            if (ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(parentComponent, "Xóa thành công");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(parentComponent, "Xóa thất bại");

        }
    }

    public String getIDPub(String name) {
        String query = "SELECT pub_id FROM Publishers WHERE pub_name = ?";
        String pubId = null;
        try ( Connection conn = DBConnect.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pubId = rs.getString("pub_id");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pubId;
    }

    public String getIDAu(String name) {
        String query = "SELECT au_id FROM Authors WHERE au_name = ?";
        String auId = null;
        try ( Connection conn = DBConnect.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, name);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    auId = rs.getString("au_id");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return auId;
    }

    public String update(Books books, String book_id) {
        String query = "update Books set title = ? , pub_id = ? , au_id = ? , notes = ? where book_id = ?";
        try ( Connection conn = DBConnect.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, books.getTitle());
            ps.setString(2, books.getPubName());
            ps.setString(3, books.getAuName());
            ps.setString(4, books.getNote());
            ps.setString(5, book_id);
            if (ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(parentComponent, "Update thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(parentComponent, "Update thất bại");

        }
        return null;
    }

}
