/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author green
 */
@Entity
public class Student {
    private String firstName;
    private String lastName;
    @Id
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
    private String gender;
    private String password;
    
    private File file;
    private String category;
    private Date registrionDate=new Date();
    private int amountPaid=0;
    
    @OneToMany(targetEntity = Attendance.class, mappedBy="student")
    private List<Attendance> attendance;
   
    @ManyToOne(fetch = FetchType.EAGER)
    private Driver driver;
    @ManyToOne(fetch = FetchType.EAGER)
    private Location location;
    
    public Student() {
    }

    public Student(String firstName, String lastName, String email, String phoneNumber, LocalDate birthDate, String gender, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.gender = gender;
        this.password = password;
    }
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Attendance> getAttendance() {
        return attendance;
    }

    public void setAttendance(List<Attendance> attendance) {
        this.attendance = attendance;
    }

    public Date getRegistrionDate() {
        return registrionDate;
    }

    public void setRegistrionDate(Date registrionDate) {
        this.registrionDate = registrionDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }
    
    
    
}
