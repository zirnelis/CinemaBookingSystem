/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemabookingsystem;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Elina
 */
public class Movie {
    String Name;
    String Type;
    Date date;
    Time time;
    int CinemaID;

    public Movie(String Name, String Type, Date date, Time time, int CinemaID) {
        this.Name = Name;
        this.Type = Type;
        this.date = date;
        this.time = time;
        this.CinemaID = CinemaID;
    }

    public String getType() {
        return Type;
    }

//    public void setPrice(Double Price) {
//        if(Price<0) {
//            this.Price = Price;
//        } else {
//            JOptionPane.showMessageDialog(null,"Nevar ievadīt negatīvu vērtību!");
//        }
//    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getName() {
        return Name;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public int getCinemaID() {
        return CinemaID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setCinemaID(int CinemaID) {
        this.CinemaID = CinemaID;
    }
    
    
    
}
