/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author green
 */
@Entity
public class AutoMobile {
    @Id
    private String plateNumber;
    private String type;
    private String category;
    private Date registrionDate=new Date();
    @ManyToOne(cascade = CascadeType.ALL)
    private Location location;
    @ManyToOne
    private Member member;
   
//    private Driver driver;
    
    public AutoMobile() {
    }

    public AutoMobile(String plateNumber, String type, String category) {
        this.plateNumber = plateNumber;
        this.type = type;
        this.category = category;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
//
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getRegistrionDate() {
        return registrionDate;
    }

    public void setRegistrionDate(Date registrionDate) {
        this.registrionDate = registrionDate;
    }
    
    
//    public Driver getDriver() {
//        return driver;
//    }
//
//    public void setDriver(Driver driver) {
//        this.driver = driver;
//    }

}
