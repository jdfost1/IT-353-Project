/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    
    public void searchStudent(String student){
    
    }//end of search student

}
