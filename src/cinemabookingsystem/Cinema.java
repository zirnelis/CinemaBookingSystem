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
public class Cinema {
    public String Name;
    public String Address;
    public String location;

    public Cinema() {
    }

    public Cinema(String Name, String Address, String location) {
        this.Name = Name;
        this.Address = Address;
        this.location = location;
    }


    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    
}
