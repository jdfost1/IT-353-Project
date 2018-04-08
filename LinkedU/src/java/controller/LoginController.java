/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.LoginBean;
import DAO.LoginBeanDA;


/**
 *
 * @author it353s833
 */
public class LoginController {
    
    private String response;
    private LoginBean theModel;
    
    LoginController(){
    theModel = new LoginBean();
    
    }//end of loginController

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public LoginBean getTheModel() {
        return theModel;
    }

    public void setTheModel(LoginBean theModel) {
        this.theModel = theModel;
    }
    
}
