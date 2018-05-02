/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.UniversityDA;
import DAO.UniversityLoginDA;
import controller.FileUploadController;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author IT353S833
 */
@ManagedBean(name = "UniversityLoginBean")
@SessionScoped
public class UniversityLoginBean implements Serializable{

    public static String adminUsername;
    String adminPassword;
    String errorResponse;
    private boolean login = false;
    String collegeName;
    String city;
    String state;
    String address;
    String phone;
    String tuition;
    String enrollment;
    String mascot;
    String dean;
    public static String picture="";

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(String errorResponse) {
        this.errorResponse = errorResponse;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
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

    /**
     * Creates a new instance of UniversityLoginBean
     */
    public UniversityLoginBean() {
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public void updateFrom(UniversityLoginBean lb) {
        setCollegeName(lb.getCollegeName());
        setCity(lb.getCity());
        setState(lb.getState());
        setMascot(lb.getMascot());
        setAddress(lb.getAddress());
        setPhone(lb.getPhone());
        setTuition(lb.getTuition());
        setEnrollment(lb.getEnrollment());
        setPicture(lb.getPicture());

    }//end of updateFrom method
    public String createUniversity() {
        UniversityDA.storeUniversityToDB(this);
          FileUploadController.accountType =1;  
        //add university to data base
        return "University.xhtml";
    }//end of create university

    public String adminLogin() {
        FileUploadController.accountType=1;
        System.out.println("Login Fired");
        errorResponse = "";
        UniversityLoginBean temp;
        if ((temp = UniversityLoginDA.validInfo(getAdminUsername(), getAdminPassword())) != null) {
            System.out.println("Good Login");
            login = true;
            updateFrom(temp);
            return "University.xhtml";

        }//end of if statement
        return "badLogin.xhtml";

    }//end of login

}
