/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author green
 */
@Entity
public class Member {
    private String firstName;
    private String lastName;
    @Id
    private String email;
    private String phoneNumber;

    @OneToMany(targetEntity = AutoMobile.class, mappedBy = "member",fetch = FetchType.EAGER)
    private List<AutoMobile> autoMobile;
    
    public Member() {
    }

    public Member(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public List<AutoMobile> getAutoMobile() {
        return autoMobile;
    }

    public void setAutoMobile(List<AutoMobile> autoMobile) {
        this.autoMobile = autoMobile;
    }
    
    
}
