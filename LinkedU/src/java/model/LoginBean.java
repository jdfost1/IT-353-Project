/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.LoginBeanDA;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author it353s833
 */
@ManagedBean(name="LoginBean")
@RequestScoped
public class LoginBean {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String errorResponse ="";
    private String highSchool;

    public String getHighSchool() {
        return highSchool;
    }

    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
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
    private boolean login = false;
     private String accountResponse;
    

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
    
    
 public void updateFrom(LoginBean lb){
        setEmail(lb.getEmail());
        setFirstName(lb.getFirstName());
        setLastName(lb.getLastName());
    
    }
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
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

    public String login() {
       System.out.println("Login Fired");
    errorResponse = "";
    LoginBean temp;
    if((temp = LoginBeanDA.validInfo(getUsername(), getPassword()))!=null){
    System.out.println("Good Login");
    login = true;
    updateFrom(temp);
            setAccountResponse("Hello "+ this.firstName + " "+ this.lastName
            + "! Welcome to your account!");
    return "account.xhtml";
        }//end of else statement
return "badLogin.xhtml";
    }//end of login method
    
    /**
     * @param accountResponse the accountResponse to set
     */
    public void setAccountResponse(String accountResponse) {
        this.accountResponse = accountResponse;
    }
     

    

}
