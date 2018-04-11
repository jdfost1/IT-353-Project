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
    private String confirmPassword="";

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
    }//end of set account response method
    
    public boolean checkEmail(){
        boolean result = true;
        int atPosition = email.indexOf("@");
        if (atPosition == -1 // must have an @ sign
                || atPosition == 0 // no @ at the beginning
                || atPosition == email.length() - 1) // no @ at the end
        {
            result = false;
        } else {
            atPosition = email.indexOf("@", atPosition + 1);
            if (atPosition != -1) {
                result = false; //more than one @ symbol
            }
        }

        if (result) {
            //check periods
            if(email.charAt(0)=='.'||email.charAt(email.length()-1)=='.'){
                result=false;
            }else{
                atPosition = email.indexOf("@");
                int periodPos = email.indexOf(".", atPosition+1);
                if(email.charAt(atPosition-1)=='.'||periodPos==atPosition+1||periodPos == -1){
                    result=false;
                }
            }
        }

        if(!result){
            errorResponse = "Invalid email address";
        }
        return result;

    }//end of check email method
    
       public boolean checkUserName() {
        if (username.length() < 6 || username.length() > 12) {
            errorResponse = "Username must be between 6 and 12 characters";
            return false;
        }
        if(LoginBeanDA.usernameTaken(username)){
            errorResponse = "Username '"+username+"' has already been taken";
            return false;
        }
        return true;
    }

    public boolean checkPassword() {
        if (password.length() < 6 || password.length() > 12) {
            errorResponse = "Password must be between 6 and 12 characters";
            return false;
        }
        return true;
    }
     public boolean checkName(){
        if(firstName.equals("") || lastName.equals("")){
            errorResponse = "Please enter your name";
            return false;
        }
        return true;
    }//end of check name

     
public String createProfile(){
int error = 0;
        errorResponse = "";
        
        if (checkName()&&checkUserName() && checkPassword()&&checkEmail()) {
            error = LoginBeanDA.storeCustomerToDB(this);
        }
        if (error == 0) {
            return "signup.xhtml";
        }
        login();
        return "account.xhtml";

}//end of create profile method
    

}
