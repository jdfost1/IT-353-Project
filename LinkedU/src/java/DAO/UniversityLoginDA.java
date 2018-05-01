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
import model.UniversityLoginBean;
/**
 *
 * @author IT353S833
 */
public class UniversityLoginDA {
    
    public static UniversityLoginBean validInfo(String username, String password){
    UniversityLoginBean lb = null;
    try{
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    } catch (ClassNotFoundException e){
    System.err.println(e.getMessage());
    System.exit(0);
    }//end of catch
    
   try{
    String myDB = "jdbc:derby://localhost:1527/LinkedUDB";
    Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");
    
    String queryString = "select * from itkstu.universities where USERNAME = '" + username + "' and PASSWORD = '" + password + "'";
    Statement stmt =DBConn.createStatement();
    ResultSet rs = stmt.executeQuery(queryString);
    boolean r = rs.next();
    
    if(r){
        lb = new UniversityLoginBean();
        lb.setCollegeName(rs.getString("collegename"));
        lb.setCity(rs.getString("city"));
        lb.setState(rs.getString("state"));
        lb.setMascot(rs.getString("mascot"));
        lb.setAddress(rs.getString("address"));
        lb.setPhone(rs.getString("phone"));
        lb.setTuition(rs.getString("tuitionrate"));
        lb.setEnrollment(rs.getString("enrollment"));
        lb.setPicture(rs.getString("picture"));
        
        
        
    }//end of if statement
    DBConn.close();
    return lb;
   
   }catch(SQLException e){
   System.err.println(e.getMessage());
   }//end of catch
          return null;  
   
    
    
    }//end of validInfo method
    
    public static int storePictureToDB(String imagePath, String userName) {
        System.out.println(" University DB METHOD CALLED image path: " + imagePath +" userName : "+userName);
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        int rowCount = 0;
        //create connection to database and create query string
        try {
            String myDB = "jdbc:derby://localhost:1527/LinkedUDB";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            String insertString = "UPDATE itkstu.universities SET PICTURE = '" + imagePath + "' WHERE LOWER(USERNAME) = '" + userName + "'";
            Statement stmt = DBConn.createStatement();
          
            // if insert is successful, rowCount will be set to 1 (1 row inserted successfully). Else, insert failed.
            rowCount = stmt.executeUpdate(insertString);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return rowCount;

    }//end of store picture to database method
    
    
}
