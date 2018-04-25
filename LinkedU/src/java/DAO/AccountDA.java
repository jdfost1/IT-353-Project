/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.AccountBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.LoginBean;

/**
 *
 * @author it353s833
 */
public class AccountDA {

    public static AccountBean searchStudent(String first, String last) {
        AccountBean lb = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {

            System.err.println(e.getMessage());
            System.exit(0);

        }//end of catch
        try {
            String myDB = "jdbc:derby://localhost:1527/LinkedUDB";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            String queryString = "select * from itkstu.userlogin WHERE LOWER(LASTNAME) LIKE LOWER ('" + last + "%') AND LOWER(FIRSTNAME) LIKE LOWER('" + first + "%')";
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(queryString);

            boolean r = rs.next();
            if (r) {
                //set session bean to student's info 
                lb = new AccountBean();
                lb.setFirstName(rs.getString("firstname"));
                lb.setLastName(rs.getString("lastname"));
                lb.setHighschool(rs.getString("highschool"));
                lb.setEmail(rs.getString("email"));
                lb.setSports(rs.getString("sports"));
                lb.setUniversity(rs.getString("university"));
                lb.setMajor(rs.getString("major"));
                lb.setAwards(rs.getString("awards"));
                lb.setClubs(rs.getString("clubs"));

            }//end of while statement
            DBConn.close();
            return lb; //return student bean
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;

    }//end of searchStudent

    public static String[] searchStudents(String student) {
        AccountBean lb = null;
        String[] students = new String[25];

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {

            System.err.println(e.getMessage());
            System.exit(0);

        }//end of catch

        try {
            String myDB = "jdbc:derby://localhost:1527/LinkedUDB";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
            String queryString = "select * from itkstu.userlogin WHERE LOWER(LASTNAME) LIKE LOWER ('" + student + "%') OR LOWER(FIRSTNAME) LIKE LOWER('" + student + "%')";
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(queryString);

            int i = 0;
            while (rs.next()) {
//               

                //create array of students in data base that match search criteria
                students[i] = rs.getString("firstName") + " " + rs.getString("lastName");
                i++;

            }//end of while statement
            DBConn.close();
            return students; //return students array
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;

    }//end of search student method

    public static String updateProfile(String username) {
      AccountBean lb;

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {

            System.err.println(e.getMessage());
            System.exit(0);

        }//end of catch

        try {
            String myDB = "jdbc:derby://localhost:1527/LinkedUDB";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            String queryString = "UPDATE itkstu.userlogin SET college = '"+AccountBean.university
                    +"', email = '"+AccountBean.email
                     +"', firstname = '"+AccountBean.firstName
                     +"', lastname = '"+AccountBean.lastName
                     +"', highschool = '"+AccountBean.highschool
                     +"', sports = '"+AccountBean.sports
                     +"', major = '"+AccountBean.major
                     +"', awards = '"+AccountBean.awards
                    +"WHERE USERNAME = '"+username+"'" ;
                   
            Statement stmt = DBConn.createStatement();
           
            DBConn.close();
            return null;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }//end of search student method
}//end of class
