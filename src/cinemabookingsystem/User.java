/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemabookingsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
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
    
    public User() {
        this.name = "none";
        this.password = "none";
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
     * Make new users.txt file
     * If exists:
     * Write user info into .txt file
     */
    public int checkUser(User usr) throws FileNotFoundException, IOException{
        File file = new File("users.txt");
        StringBuffer users = new StringBuffer();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String text = null;
        
        // reads all lines
        while((text = br.readLine()) != null){
            users.append(text).append(System.getProperty("line.seperator"));
        }
        br.close();
        
        // check if user exists in .txt file
        
        //......
        
        return 0;
    }
    
    public void writeNewUser(User usr) throws IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                      new FileOutputStream("users.txt"), "utf-8"))) {
           writer.write(usr.getName()+" "+usr.getPassword()+"\n");
        }
        
    }
}
