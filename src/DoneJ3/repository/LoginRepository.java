package DoneJ3.repository;

import DoneJ3.jdbc.DBConnect;
import DoneJ3.model.Users;
import DoneJ3.view.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class LoginRepository {

    public List<Users> LoginCheck() {
        List<Users> userList = new ArrayList<>();
        String query = "SELECT * FROM Users";

        try ( Connection conn = DBConnect.getConnection();  PreparedStatement ps = conn.prepareStatement(query);  ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Users users = new Users();
                users.setUserName(rs.getString("UserName"));
                users.setDisplayName(rs.getString("DisplayName"));
                users.setPassWord(rs.getString("Password"));
                users.setDescription(rs.getString("Description"));
                userList.add(users);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

}
