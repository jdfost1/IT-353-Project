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


/**
 *
 * @author it353s833
 */
public class AccountDA {

    public static AccountBean searchStudent(String student) {
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
            String queryString = "select * from itkstu.userlogin where LASTNAME LIKE '" + student + "'";
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(queryString);
            boolean r = rs.next();
            if (r) {
                lb = new AccountBean();
                lb.setEmail(rs.getString("email"));
                lb.setFirstName(rs.getString("firstName"));
                lb.setLastName(rs.getString("lastName"));
                lb.setMajor(rs.getString("major"));
                lb.setHighschool(rs.getString("highschool"));

            }//end of try
            DBConn.close();
            return lb;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;

    }//end of search student method

   
}//end of class
