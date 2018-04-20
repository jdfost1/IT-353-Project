/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;
 
@ManagedBean(name="fileUploadController")
public class FileUploadController {
//   private String destination="D:\\Billy\\";
   private String destination=".\\";

    public void upload(FileUploadEvent event) {  
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }  

    public void copyFile(String fileName, InputStream in) {
           try {
             
             String relativeWebPath = "\\resources\\images";
ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
String absoluteDiskPath = servletContext.getRealPath(relativeWebPath);
String absoluteFileName = absoluteDiskPath + "\\" + fileName;
File file = new File(absoluteFileName);

                // write the inputStream to a FileOutputStream
                OutputStream out = new FileOutputStream(file);
             
                int read = 0;
                byte[] bytes = new byte[1024];
             
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
             
                in.close();
                out.flush();
                out.close();
             
                System.out.println("New file created at:" + file.getAbsolutePath());
                } catch (IOException e) {
                System.out.println(e.getMessage());
                }
    }
}