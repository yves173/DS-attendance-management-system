/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.*;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.*;
import util.HibernateUtil;

/**
 *
 * @author green
 */
public class Dao {

    Session sn;
    Transaction tr;

    public void saveAttendance(Attendance atc) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.save(atc);
        tr.commit();
        sn.close();
    }

    public void updateAttendance(Attendance atc) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.update(atc);
        tr.commit();
        sn.close();
    }

    public void deleteAttendance(Attendance atc) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.delete(atc);
        tr.commit();
        sn.close();
    }

    public List<Attendance> retrieveAttendance() {
        sn = HibernateUtil.getSessionFactory().openSession();
//        Criteria ctr = sn.createCriteria(Attendance.class);
        List<Attendance> lst = sn.createQuery("from Attendance").list();
        sn.close();
        return lst;
    }

    public void saveAutoMobile(AutoMobile mobile) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.save(mobile);
        tr.commit();
        sn.close();
    }

    public void updateAutoMobile(AutoMobile mobile) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.update(mobile);
        tr.commit();
        sn.close();
    }

    public void deleteAutoMobile(AutoMobile mobile) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.delete(mobile);
        tr.commit();
        sn.close();
    }

    public List<AutoMobile> retrieveAutoMobile() {
        sn = HibernateUtil.getSessionFactory().openSession();
//        Criteria ctr = sn.createCriteria(AutoMobile.class);
        List<AutoMobile> lst =sn.createQuery("from AutoMobile").list();
        sn.close();
        return lst;
    }

    public void saveDriver(Driver driver) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.save(driver);
        tr.commit();
        sn.close();
    }

    public void updateDriver(Driver driver) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.update(driver);
        tr.commit();
        sn.close();
    }

    public void deleteDriver(Driver driver) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.delete(driver);
        tr.commit();
        sn.close();
    }

    public List<Driver> retrieveDriver() {
        sn = HibernateUtil.getSessionFactory().openSession();
//        Criteria ctr = sn.createCriteria(Driver.class);
         List<Driver> lst=sn.createQuery("from Driver").list();
         sn.close();
        return lst;
    }

    public void saveLocation(Location location) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.save(location);
        tr.commit();
        sn.close();
    }

    public void updateLocation(Location location) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.update(location);
        tr.commit();
        sn.close();
    }

    public void deleteLocation(Location location) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.delete(location);
        tr.commit();
        sn.close();
    }

    public List<Location> retrieveLocation() {
        sn = HibernateUtil.getSessionFactory().openSession();
//        Criteria ctr = sn.createCriteria(Location.class);
        List<Location> lst = sn.createQuery("from Location").list();
        sn.close();
        return lst;
    }

    public void saveMember(Member member) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.save(member);
        tr.commit();
        sn.close();
    }

    public void updateMember(Member member) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.update(member);
        tr.commit();
        sn.close();
    }

    public void deleteMember(Member member) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.delete(member);
        tr.commit();
        sn.close();
    }

    public List<Member> retrieveMember() {
        sn = HibernateUtil.getSessionFactory().openSession();
//        Criteria ctr = sn.createCriteria(Member.class);
        List<Member> lst = sn.createQuery("from Member").list();
        sn.close();
        return lst;
    }

    public void saveRegistra(Registra registra) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.save(registra);
        tr.commit();
        sn.close();
    }

    public void updateRegistra(Registra registra) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.update(registra);
        tr.commit();
        sn.close();
    }

    public void deleteRegistra(Registra registra) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.delete(registra);
        tr.commit();
        sn.close();
    }

    public List<Registra> retrieveRegistra() {
        sn = HibernateUtil.getSessionFactory().openSession();
//        Criteria ctr = sn.createCriteria(Registra.class);
        List<Registra> lst = sn.createQuery("from Registra").list();
        sn.close();
        return lst;
    }

    public void saveStudent(Student student) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.save(student);
        tr.commit();
        sn.close();
    }

    public void updateStudent(Student student) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.update(student);
        tr.commit();
        sn.close();
    }

    public void deleteStudent(Student student) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.delete(student);
        tr.commit();
        sn.close();
    }

    public List<Student> retrieveStudent() {
        sn = HibernateUtil.getSessionFactory().openSession();
//        Criteria ctr = sn.createCriteria(Student.class);
        List<Student> lst = sn.createQuery("from Student").list();
        sn.close();
        return lst;
    }
     public void savePrice(CategoryPrice price) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.save(price);
        tr.commit();
        sn.close();
    }

    public void updatePrice(CategoryPrice price) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.update(price);
        tr.commit();
        sn.close();
    }

    public void deletePrice(CategoryPrice price) {
        sn = HibernateUtil.getSessionFactory().openSession();
        tr = sn.beginTransaction();
        sn.delete(price);
        tr.commit();
        sn.close();
    }

    public List<CategoryPrice> retrievePrice() {
        sn = HibernateUtil.getSessionFactory().openSession();
//        Criteria ctr = sn.createCriteria(Student.class);
        List<CategoryPrice> lst = sn.createQuery("from CategoryPrice").list();
        sn.close();
        return lst;
    }

//    public static void main(String[] args) {
//        Member mm=new Member("Kaberuka", "Gentille", "kaberukagentille@gmail.com", "0783234435");
//        Dao dao = new Dao();
        
//        dao.saveMember(mm);
//       
//          Driver driver = new Driver("Sifa", "Neza", "sifaneza@gmail.com", "1234567890", "c", "kayitesi");
//     
//       dao.saveDriver(driver);
//       dao.saveStudent(student);

//        Location location = new Location("Rubavu");
//        location.setId(1);
//        dao.saveLocation(location);
//        Registra reg = new Registra("John", "Peter", "johnpeter@gmail.com", "11111111", "john");
//        dao.saveRegistra(reg);
//        
//        AutoMobile autoMobile = new AutoMobile("RAE482U", "Car", "B");
//        autoMobile.setLocation(location);
//        autoMobile.setMember(mm);
//        dao.saveAutoMobile(autoMobile);

//       driver.setAutoMobile(autoMobile);
//       dao.saveDriver(driver);
   
//        Student student = new Student("Eric", "Hunico", "hunicoeric@gmail.com", "0727399303", LocalDate.now(), "male", "kaberuka");
//        student.setDriver(driver);
//        dao.saveStudent(student);


//        dao.retrieveStudent().forEach((i) -> {
//            System.out.println(i.getFirstName());
//        });
        
//        dao.retrieveAutoMobile().forEach((i) -> {
//            System.out.println(i.getPlateNumber()+" "+i.getLocation().getDistrict());
//        });AutoMobile
        
//        dao.retrieveDriver().forEach((i) -> {
//            System.out.println(i.getFirstName()+" ");
//    });
//        
//        dao.retrieveLocation().forEach((i) -> {
//            System.out.println(i.getDistrict());
//    });
        
//        for(Attendance i : dao.retrieveAttendance() ){
//            System.out.println(i.getDay()+" "+ i.getDriver().getFirstName()+" "+i.getStudent().getFirstName());
//        }

//        CategoryPrice ctg= new CategoryPrice();
//        ctg.setCategoryName("E");
//        ctg.setPriceCategory(90000);
//        Dao d=new Dao();
//        d.savePrice(ctg);
//
//    }

}
