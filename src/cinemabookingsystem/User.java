/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemabookingsystem;

import java.io.BufferedWriter;
import java.io.File;
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
     * @param usr
     */
    
    public void writeNewUser(User usr) throws IOException  {
        File f = new File("users.txt");
            if(!f.exists()){
              f.createNewFile();
            }else{
              System.out.println("File already exists");
            }
        System.out.println("Happens 1 ");
        PrintWriter pw = null;
        
        try {
            System.out.println("Happens 2 ");
            pw = new PrintWriter(f);
            
            BufferedWriter bw = new BufferedWriter(pw);
            System.out.println("Happens 3 ");
            bw.write("Test");
            System.out.println("Happens 4 ");
//            bw.write(usr.getName());
            bw.write("Namee");
//            bw.write("Name");
            System.out.println("Name has been written");
            bw.newLine();
            bw.write(usr.getPassword());
//            bw.write("Pass");
            System.out.println("Password has been written");

            pw.close();
            
        } catch (FileNotFoundException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
//    public void generateUsers() throws IOException {
//        for (int i = 0; i < 10; i++) {
//            String tmp = Integer.toString(i);
//            User usr = new User("user"+tmp, "pass"+tmp);
//            writeNewUser(usr);
//        }
//    }
    
}
