/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.UniversityDA;
import static DAO.UniversityDA.storeUniversityToDB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author IT353S833
 */
@ManagedBean(name = "UniversityBean")
@SessionScoped
public class UniversityBean implements Serializable {

    String university;
    public static String collegeName;
    String[] universityArray;
    String city;
    String state;
    String address;
    String phone;
    String tuition;
    String enrollment;
    String mascot;
    String dean;
    String username;
    String password;
    String picture;
    
    /**
     * Creates a new instance of UniversityBean
     */
    public UniversityBean() {
    }


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String[] getUniversityArray() {
        return universityArray;
    }

    public void setUniversityArray(String[] universityArray) {
        this.universityArray = universityArray;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String univeristy) {
        this.university = univeristy;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTuition() {
        return tuition;
    }

    public void setTuition(String tuition) {
        this.tuition = tuition;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public String getMascot() {
        return mascot;
    }

    public void setMascot(String mascot) {
        this.mascot = mascot;
    }

    public String getDean() {
        return dean;
    }

    public void setDean(String dean) {
        this.dean = dean;
    }

    //method to update current bean
    public void updateFrom(UniversityBean ub) {

        setCollegeName(ub.getCollegeName());
        setCity(ub.getCity());
        setState(ub.getState());
        setMascot(ub.getMascot());
        setPhone(ub.getPhone());
        setTuition(ub.getTuition());
        setAddress(ub.getAddress());
        setEnrollment(ub.getEnrollment());
        setPicture(ub.getPicture());

    }//end of updateFrom method

    public String searchUniversities() {

        if ((universityArray = UniversityDA.searchUniversities(university)) != null) {
            System.out.println("Successfull Search");

            //print array to console for testing
            for (int i = 0; i < universityArray.length; i++) {
                System.out.println(universityArray[i]);
            }//end of for loop
            return "UniversitySearchResults.xhtml";
        }//end of if
        return null;
    }
//method to search for university chosen from results list to return single universities profile page

    public String searchUniversity(String university) {
        UniversityBean temp;
        if ((temp = UniversityDA.searchUniversity(university)) != null) {
            System.out.println("Successfull Search");
            updateFrom(temp);
            return "UniversityProfile.xhtml";
        }//end of if statement
        return null;
    }//end of searchStudent method

}
