/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemabookingsystem;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elina
 */
public class User {
    public String name;
    public String password;

    
    public User(String name, String password) {
        this.name = name;
        this.password = password;

    }

    User() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    /**
     * Make new userst.txt file
     * If exists:
     * Write user info into .txt file
     */
    
    public void writeNewUser(User usr) throws IOException {
        PrintWriter pw = null;
        
        try {
            pw = new PrintWriter("users.txt");
            
            BufferedWriter bw = new BufferedWriter(pw);
            bw.write(usr.getName());
//            bw.write("Name");
            System.out.println("Name has been written");
            bw.newLine();
            bw.write(usr.getPassword());
//            bw.write("Pass");
            System.out.println("Password has been written");

//            pw.close();
            
        } catch (FileNotFoundException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    
}
