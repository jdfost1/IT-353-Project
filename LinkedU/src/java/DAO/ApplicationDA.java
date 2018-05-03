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

import model.ApplicationBean;
/**
 *
 * @author IT353S833
 */
public class ApplicationDA {
    
    public static int storeApplicationToDB(ApplicationBean application){
    System.out.println("Application First Name: "+application.getFirst());
        //load driver for apache derby jdbc
    try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        int rowCount = 0;
        //set connection to sql database
        try {
            String myDB = "jdbc:derby://localhost:1527/LinkedUDB";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            String insertString;
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO itkstu.applications VALUES ('"
                    + application.getLast()
                    + "', '" + application.getFirst()
                    + "', '" + application.getCollegeName()
                    + "', '" + application.getPhone()
                    + "', '" + application.getHighschool()
                    + "', '" + application.getAddress()
                    + "', '" + application.getState()
                    + "', '" + application.getGpa()
                    + "', '" + application.getSat()
                    + "', '" + application.getSport()
                    + "', '" + application.getEmail()
                    + "', '" + application.getCoverLetter()
                    + "', '" + application.getDate()
                   
                    
                    + "')";
            rowCount = stmt.executeUpdate(insertString);
            System.out.println("insert string =" + insertString);
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;

    
    }//end of store application to database method
    
}
