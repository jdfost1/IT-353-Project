/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author IT353S833
 */
@ManagedBean
@RequestScoped
public class resetBean {
String resetEmail;
String resetPhone;

    public String getResetPhone() {
        return resetPhone;
    }

    public void setResetPhone(String resetPhone) {
        this.resetPhone = resetPhone;
    }

    public String getResetEmail() {
        return resetEmail;
    }

    public void setResetEmail(String resetEmail) {
        this.resetEmail = resetEmail;
    }
    /**
     * Creates a new instance of resetBean
     */
    public resetBean() {
    }
    public String resetByEmail(){
    
    return null;
            }
    public String resetByPhone(){
    
    return null;
    }
    
}
