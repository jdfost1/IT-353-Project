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

    //method to search through data base to find universities that match search criteria.. return array of universities found
    public static String[] searchUniversities(String university) {

        //create array to store universities found that match search criteria
        String[] universities = new String[25];
        //set driver
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }//end of catch

        try {
            //set connection to data base    
            String myDB = "jdbc:derby://localhost:1527/LinkedUDB";
            Connection DBConn = DriverManager.getConnection(myDB, "itkstu", "student");

            //execute query for sql database ...search collegename and state for values that contain..
            String queryString = "select * from itkstu.universities WHERE LOWER(COLLEGENAME) LIKE LOWER ('" + university + "%') OR LOWER (STATE) LIKE LOWER('" + university + "%')";
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(queryString);

            //check out result statement and get the college names and add them to the university array
            int i = 0;
            while (rs.next()) {

                universities[i] = rs.getString("collegename");
                i++; // go to next spot in array to fill with next university found

            }//end of while loop
            return universities; //return list of univresities found
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }//end of catch

        return null;
    }//end of search universities method

    //search for the university chosen from university list to get other info to create profile page for user to view... return university bean
    public static UniversityBean searchUniversity(String university) {
        //create temp bean to return after method is finished
        UniversityBean ub = null;

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }//end of catch
        
        try{
            //create connection to data base
        String myDB = "jdbc:derby://localhost:1527/LinkedUDB";
        Connection DBConn = DriverManager.getConnection(myDB,"itkstu","student");
        
        //create query string and execute statement in database.. return result to rs 
        String queryString = "select * from itkstu.universities WHERE LOWER(COLLEGENAME) LIKE LOWER ('" +university+"%')";
        Statement stmt = DBConn.createStatement();
        ResultSet rs = stmt.executeQuery(queryString);
        
        boolean r = rs.next();
        
        if(r){
        ub = new UniversityBean();
        ub.setAddress(rs.getString("address"));
        ub.setCity(rs.getString("city"));
        ub.setCollegeName(rs.getString("collegename"));
        ub.setPhone(rs.getString("phone"));
        ub.setState(rs.getString("state"));
        ub.setTuition(rs.getString("tuitionrate"));
        ub.setMascot(rs.getString("mascot"));
        ub.setEnrollment(rs.getString("enrollment"));
        
        }//end of if statement
        DBConn.close();
        return ub;
        
        
        }catch (SQLException e){
        System.err.println(e.getMessage());
        }

        return null;
    }//end of search university method

    public static int storeUniversityToDB(UniversityBean university) {

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
                    + "', '" + university.getUsername()
                    + "', '" + university.getPassword()
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
