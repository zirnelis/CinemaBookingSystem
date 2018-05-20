/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cinemabookingsystem;

/**
 *
 * @author Elina
 */
public class Hall {
    public int id;
    public int hallNumber;

    public Hall(int id, int hallNumber) {
        this.id = id;
        this.hallNumber = hallNumber;
    }

    public int getId() {
        return id;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }
    
    
    
}
