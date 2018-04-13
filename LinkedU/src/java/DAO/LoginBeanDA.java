/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.LoginBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author it353s833
 */
public class LoginBeanDA {

    public static LoginBean validInfo(String username, String password) {
        LoginBean lb = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
           
            System.err.println(e.getMessage());
            System.exit(0);

        }//end of catch
        try {
            String myDB = "jdbc:derby://localhost:1527/LinkedUDB";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            String queryString = "select * from itkstu.userlogin where USERNAME = '" + username + "' and PASSWORD = '" + password + "'";
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(queryString);
            boolean r = rs.next();
            if (r) {
                lb = new LoginBean();
                lb.setEmail(rs.getString("email"));
                lb.setFirstName(rs.getString("firstName"));
                lb.setLastName(rs.getString("lastName"));
<<<<<<< HEAD
                lb.setUsername(rs.getString("username"));
                lb.setHighSchool(rs.getString("highschool"));
                lb.setGpa(rs.getDouble("gpa"));
                lb.setSat(rs.getInt("sat"));
                lb.setAwards(rs.getString("awards"));
                lb.setClubs(rs.getString("clubs"));
                lb.setMajor(rs.getString("major"));
                lb.setUniversity(rs.getString("university"));
                
=======
                lb.setAwards(rs.getString("awards"));
                lb.setHighSchool(rs.getString("highschool"));
                lb.setUniversity(rs.getString("university"));
                lb.setSports(rs.getString("sports"));
                lb.setMajor((rs.getString("major")));
                lb.setGpa(Double.parseDouble("gpa"));
                lb.setSat(Integer.parseInt(rs.getString("sat")));
                
               
>>>>>>> 0131696a33775e917e8816f7f47f6d0fdc374581
                

            }
            DBConn.close();
            return lb;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;

  

}//end of validInfo
    
     public static boolean usernameTaken(String username){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        try {
            String myDB = "jdbc:derby://localhost:1527/LinkedUDB";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");


            String queryString = "select * from itkstu.userlogin where USERNAME = '" + username + "'";
            Statement stmt = DBConn.createStatement();

            ResultSet rs = stmt.executeQuery(queryString);

            boolean r = rs.next();

            DBConn.close();
            return r;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }//end of check user name method
     
     
public static int storeCustomerToDB(LoginBean cust) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        int rowCount = 0;
        try {
            String myDB = "jdbc:derby://localhost:1527/LinkedUDB";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            String insertString;
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO itkstu.userlogin VALUES ('"
                    + cust.getUsername()
                    + "', '" + cust.getPassword()
                    + "', '" +cust.getEmail()
                    +"', '"  +cust.getFirstName()
                    + "', '" +cust.getLastName()
                    + "', '" +cust.getHighSchool()
                    + "', '" +cust.getSports()
                    
                    + "', '" +cust.getUniversity()
                    + "', '" +cust.getMajor()
                    + "', '" +cust.getAwards()
                    + "', '" +cust.getClubs()
                    + "', '" +cust.getGpa()
                    + "', '" +cust.getSat()
                    + "')";
            rowCount = stmt.executeUpdate(insertString);
            System.out.println("insert string =" + insertString);
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;

    }


}//end of class
