/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.AccountDA;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author it353s833
 */
@ManagedBean (name="AccountBean")
@SessionScoped
public class AccountBean {
    String student;
    String username;
    String email;
    String firstName;
    String lastName;
    String highschool;
    String sports;
    String university;

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
    String major;
    String awards;
    String clubs;
    String gpa;
    String sat;
            
    
    
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

    }//end of updateFrom method
    
    public String searchStudent(String student){
    AccountBean temp;
        if ((temp = AccountDA.searchStudent(student)) != null) {
            System.out.println("Successful Search");
            
            updateFrom(temp);
            setProfileResponse(this.firstName + " " + this.lastName
                    + "! Welcome to "+ this.firstName + "'s account!");
            return "profile.xhtml";
        }//end of else statement
        return "badLogin.xhtml";
    
    }//end of search student

}
