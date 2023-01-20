/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author green
 */
@Entity
@Table(name = "teacher")
public class Driver {
    private String firstName;
    private String lastName;
    @Id
    private String email;
    private String phoneNumber;
    private String category;
    private String password;
    private String gender;
    private Date registrionDate=new Date();

    @OneToMany(targetEntity = Student.class, mappedBy = "driver",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Student> student;
    
    @OneToMany(targetEntity = Attendance.class,mappedBy = "driver",fetch = FetchType.EAGER)
    private List<Attendance> attendance;
    
    @OneToOne
    private AutoMobile autoMobile;
    
    @ManyToOne
    private Location location;
    
    public Driver() {
    }

    public Driver(String firstName, String lastName, String email, String phoneNumber, String category, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public AutoMobile getAutoMobile() {
        return autoMobile;
    }

    public void setAutoMobile(AutoMobile autoMobile) {
        this.autoMobile = autoMobile;
    }

    public List<Attendance> getAttendance() {
        return attendance;
    }

    public void setAttendance(List<Attendance> attendance) {
        this.attendance = attendance;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
}
