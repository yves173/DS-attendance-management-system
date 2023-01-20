/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

/**
 *
 * @author green
 */
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String district;
    
    @OneToMany(targetEntity = AutoMobile.class,mappedBy = "location",fetch = FetchType.EAGER)
    private List<AutoMobile> automobile;
    
    @OneToMany(targetEntity = Student.class,mappedBy = "location",fetch = FetchType.EAGER)
    private List<Student> student;
    
    @OneToMany(targetEntity = Driver.class,mappedBy = "location",fetch = FetchType.EAGER)
    private List<Driver> driver;
    
    public Location() {
    }

    public Location(String district) {
        this.district = district;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<AutoMobile> getAutomobile() {
        return automobile;
    }

    public void setAutomobile(List<AutoMobile> automobile) {
        this.automobile = automobile;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public List<Driver> getDriver() {
        return driver;
    }

    public void setDriver(List<Driver> driver) {
        this.driver = driver;
    }
    
    
    
}
