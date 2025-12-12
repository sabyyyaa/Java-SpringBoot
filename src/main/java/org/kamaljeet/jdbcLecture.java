package org.kamaljeet;
import java.sql.*;

public class jdbcLecture {
    public static void main(String[] args) throws Exception {

       /*
        Steps of JDBC :
         > Import Package
         > Load & Register Driver
         > Create Connection
         > Create statement
         > Execute statement
         > Close
       */

        String url="jdbc:postgresql://localhost:5432/JavaDB";
        String uname="postgres";
        String pw ="Jeetu@9712";
        String sql = "SELECT * FROM students";
        String sql2 = "INSERT INTO students VALUES (4,'Aklavya')";
        String sql3 = "UPDATE students SET sname='Igloo' WHERE sid=3";
        String sql4 = "DELETE FROM students WHERE sid=4";

        Class.forName("org.postgresql.Driver"); //load and register step (can skip this)
        Connection conn = DriverManager.getConnection(url,uname,pw);    //create connection step
        System.out.println("Connected to database successfully");

        Statement stmt = conn.createStatement();    //create statement step
        //PreparedStatement ps = conn.prepareStatement(sql);//Better than primary statement

                                                                    //READ OPERATION :
/*
        ResultSet rs =  stmt.executeQuery(sql);
          //  rs.next();
          //  String name = rs.getString("sname");//Execute statement step
          //  System.out.println(name);
          // we have lets say 500 rows,so we cannt store every record in variable and then print it, that's why we use loop here.
        while(rs.next()){
            System.out.print(rs.getInt(1) + " - ");
            System.out.println(rs.getString(2));
        }
*/
                                                        //CREATE OPERATION :


           // boolean status = stmt.execute(sql2);
        /*
        execute() returns:
        true → if the SQL statement returns a ResultSet
        (usually a SELECT query)
        false → if the SQL statement does NOT return a ResultSet
                (usually INSERT, UPDATE, DELETE, CREATE, DROP, etc.)
        */
                                                        //UPDATE OPERATION :

        //stmt.execute(sql3);

                                                        //DELETE OPERATION :

        stmt.execute(sql4);


        conn.close();   //last step;
        System.out.println("Connection closed successfully");

    }
}