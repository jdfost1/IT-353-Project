/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import model.UniversityBean;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author IT353S833
 */
public class UniversityDA {
    
    
    public static int storeUniversityToDB(UniversityBean university){
    
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
            insertString = "INSERT INTO itkstu.universities VALUES ('"
                    + university.getCollegeName()
                    + "', '" + university.getCity()
                    + "', '" + university.getState()
                    + "', '" + university.getMascot()
                    + "', '" + university.getAddress()
                    + "', '" + university.getPhone()
                    + "', '" + university.getTuition()
                    + "', '" + university.getEnrollment()
                    
                    + "')";
            rowCount = stmt.executeUpdate(insertString);
            System.out.println("insert string =" + insertString);
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
        return rowCount;

   

    
    }//end of store university to DB method
    
}//end of class
