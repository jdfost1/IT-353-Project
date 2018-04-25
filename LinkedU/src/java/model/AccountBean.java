/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.AccountDA;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.json.JSONArray;
import java.io.Serializable;

/**
 *
 * @author it353s833
 */
@ManagedBean(name = "AccountBean")
@SessionScoped
public class AccountBean implements Serializable{

    public static String student;
    public static String username;
    public static String email;
    public static String firstName;
    public static String lastName;
    public static String highschool;
    public static String sports;
    public static String university;
    public static String major;
    public static String awards;
    public static String clubs;
    public static String gpa;
    public static String sat;
    String[] studentsArray;
    public static String profilePicture;

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
  
    JSONArray mJSONArray;

    public String[] getStudentsArray() {
        return studentsArray;
    }

    public void setStudentsArray(String[] studentsArray) {
        this.studentsArray = studentsArray;
    }

    public String getProfileResponse() {
        return profileResponse;
    }

    public void setProfileResponse(String profileResponse) {
        this.profileResponse = profileResponse;
    }
    String profileResponse;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHighschool() {
        return highschool;
    }

    public void setHighschool(String highschool) {
        this.highschool = highschool;
    }

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getClubs() {
        return clubs;
    }

    public void setClubs(String clubs) {
        this.clubs = clubs;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public String getSat() {
        return sat;
    }

    public void setSat(String sat) {
        this.sat = sat;
    }

    /**
     * Creates a new instance of AccountBean
     */
    public AccountBean() {
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public void updateFrom(AccountBean lb) {
        setEmail(lb.getEmail());
        setFirstName(lb.getFirstName());
        setLastName(lb.getLastName());
        setEmail(lb.getEmail());
        setAwards(lb.getAwards());
        setHighschool(lb.getHighschool());
        setSports(lb.getSports());
        setUniversity(lb.getUniversity());
        setMajor(lb.getMajor());
        setClubs(lb.getClubs());

    }//end of updateFrom method

    public String searchStudent(String fullname) {
          AccountBean temp;
          String[] str = fullname.split(" ",2);
          String first = str[0];
          String last = str[1];
          System.out.println("First Name: "+first);
          System.out.println("Last Name: "  + last);
          if((temp=AccountDA.searchStudent(first,last)) != null){
    System.out.println("successful search");
    updateFrom(temp);
    return "profile.xhtml";
    }
        return null;

    }//end of search student

    public String searchStudents() {

        if ((studentsArray = AccountDA.searchStudents(student)) != null) {
            System.out.println("Successful Search");

            //print array of students to console for testing
            for (int i = 0; i < studentsArray.length; i++) {
                System.out.println(studentsArray[i]);
            }

            mJSONArray = new JSONArray(Arrays.asList(studentsArray));

            //update bean for single student return
            //updateFrom(temp);
            setProfileResponse(this.firstName + " " + this.lastName
                    + "! Welcome to " + this.firstName + "'s profile!");
            return "studentSearchResults.xhtml";
        }//end of else statement
        return "badLogin.xhtml";

    }//end of search student
public String updateProfile(){
System.out.println();
String page = AccountDA.updateProfile(username);


return null;
}//end of update profile method
}
