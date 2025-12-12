package org.kamaljeet;
import java.sql.*;

public class PreparedStmt {
    public static void main(String args[]) throws Exception {

        String url="jdbc:postgresql://localhost:5432/JavaDB";
        String uname="postgres";
        String pw ="Jeetu@9712";
        String sql = "INSERT INTO students VALUES (?,?)";
        int id = 4;
        String name = "Aklavya";
        Connection con = DriverManager.getConnection(url,uname,pw);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,id);
        ps.setString(2,name);
        ps.execute();
        con.close();
    }
}
