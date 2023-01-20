/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.Dao;
import entity.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;
import org.primefaces.model.chart.*;

/**
 *
 * @author green
 */
@ManagedBean(name = "utd")
@SessionScoped
public class UnitedController {

    Dao dao = new Dao();
    Attendance attendance = new Attendance();
    AutoMobile autoMobile = new AutoMobile();
    Driver driver = new Driver();
    Location location = new Location();
    Member member = new Member();
    Registra registra = new Registra();
    Student student = new Student();
    String pass2 = "";
    Date birthDate;
    String automobileOwner;
    String automobileDistrict;
    String driverPlateNumber;
    String studMail;
    Date attendanceDate = new Date();
    String categoryType = "temporary permit";
    String teacherMail = "";
    List<Student> listOfStudents = new ArrayList<>();
    String clientMsg = "";
    String locat = "";
    String theSearch = "";
    int year = Year.now().getValue();
    CategoryPrice categoryPrice=new CategoryPrice();
    int price=0;

    public Attendance getAttendance() {
        return attendance;
    }

    public AutoMobile getAutoMobile() {
        return autoMobile;
    }

    public Driver getDriver() {
        return driver;
    }

    public Location getLocation() {
        return location;
    }

    public Member getMember() {
        return member;
    }

    public Registra getRegistra() {
        return registra;
    }

    public Student getStudent() {
        return student;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAutomobileOwner() {
        return automobileOwner;
    }

    public void setAutomobileOwner(String automobileOwner) {
        this.automobileOwner = automobileOwner;
    }

    public String getAutomobileDistrict() {
        return automobileDistrict;
    }

    public void setAutomobileDistrict(String automobileDistrict) {
        this.automobileDistrict = automobileDistrict;
    }

    public String getDriverPlateNumber() {
        return driverPlateNumber;
    }

    public void setDriverPlateNumber(String driverPlateNumber) {
        this.driverPlateNumber = driverPlateNumber;
    }

    public String getStudMail() {
        return studMail;
    }

    public void setStudMail(String studMail) {
        this.studMail = studMail;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getTeacherMail() {
        return teacherMail;
    }

    public void setTeacherMail(String teacherMail) {
        this.teacherMail = teacherMail;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public String getClientMsg() {
        return clientMsg;
    }

    public void setClientMsg(String clientMsg) {
        this.clientMsg = clientMsg;
    }

    public String getLocat() {
        return locat;
    }

    public void setLocat(String locat) {
        this.locat = locat;
    }

    public String getTheSearch() {
        return theSearch;
    }

    public void setTheSearch(String theSearch) {
        this.theSearch = theSearch;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public CategoryPrice getCategoryPrice() {
        return categoryPrice;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    

    public String saveStudent_() {

        try {
            student.setBirthDate(convertDatetoLocal_(getBirthDate()));

            for (Location i : dao.retrieveLocation()) {
                if (i.getDistrict().equals(locat)) {
                    student.setLocation(i);
                    break;
                }
            }
            dao.saveStudent(student);
            return "clientLogin";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("user email already exist, try another email");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            System.out.println(e.getMessage());
            return "clientRegister";
        }

    }

    public String updateStudent_() {

        try {
            student.setBirthDate(convertDatetoLocal_(getBirthDate()));

            for (Location i : dao.retrieveLocation()) {
                if (i.getDistrict().equals(locat)) {
                    student.setLocation(i);
                    break;
                }
            }
            dao.updateStudent(student);
            return "clientLogin";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("The process of update isn't successful");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            System.out.println(e.getMessage());
            return "clientRegister";
        }

    }
    
    public String updateStudentPayment_() {

        try {

            for (Location i : dao.retrieveLocation()) {
                if (i.getDistrict().equals(locat)) {
                    student.setLocation(i);
                    break;
                }
            }
            student.setAmountPaid(price);
            dao.updateStudent(student);
            return "clientWelcome";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("The process of confirmation isn't successful");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            System.out.println(e.getMessage());
            return "clientFinalProcess";
        }

    }

    public String checkStudentLogin_() {
        try {
            List<Student> students = dao.retrieveStudent();
            System.out.println(student.getEmail() + " " + student.getPassword());
            for (Student i : students) {
                if (i.getEmail().equals(student.getEmail()) && i.getPassword().equals(student.getPassword())) {
                    student = i;
                    String url = "dashboard/clientWelcome.xhtml";

                    FacesContext.getCurrentInstance().getExternalContext().redirect(url);
                }
            }
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("sorry something is wrong,please contact the system administrator");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "clientLogin";
        }
        FacesMessage msg = new FacesMessage("incorrect user mail or password");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "clientLogin";
    }

    public String checkMemberLogin_() {
        try {
            List<Member> members = dao.retrieveMember();
            System.out.println(member.getEmail());
            for (Member i : members) {
                if (i.getEmail().equals(member.getEmail())) {
                    return "memberRegister";
                }
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
        return "clientLogin";
    }

    private LocalDate convertDatetoLocal_(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public String saveAutoMobile_() {

        try {
            for (Member i : dao.retrieveMember()) {

                if (i.getEmail().equals(getAutomobileOwner())) {
                    autoMobile.setMember(i);
                    break;
                }
            }

            for (Location i : dao.retrieveLocation()) {
                if (i.getDistrict().equals(locat)) {
                    autoMobile.setLocation(i);
                    break;
                }
            }

            for (Location i : dao.retrieveLocation()) {
                if (i.getDistrict().equals(automobileDistrict)) {
                    autoMobile.setLocation(i);
                    break;
                }
            }
            dao.saveAutoMobile(autoMobile);
            String url = "dashboard/adminDashboard.xhtml";
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);

        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("car plate number already exist, try another plate number");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "autoMobileRegister";
        }
        return "autoMobileRegister";

    }

    public String updateAutoMobile_() {

        try {
            for (Member i : dao.retrieveMember()) {

                if (i.getEmail().equals(getAutomobileOwner())) {
                    autoMobile.setMember(i);
                    break;
                }
            }

            for (Location i : dao.retrieveLocation()) {
                if (i.getDistrict().equals(locat)) {
                    autoMobile.setLocation(i);
                    break;
                }
            }

            for (Location i : dao.retrieveLocation()) {
                if (i.getDistrict().equals(automobileDistrict)) {
                    autoMobile.setLocation(i);
                    break;
                }
            }
            dao.updateAutoMobile(autoMobile);
            String url = "dashboard/adminDashboard.xhtml";
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);

        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("The process of update isn't successful");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "autoMobileRegister";
        }
        return "autoMobileRegister";

    }

    public String saveMember_() {

        try {
            dao.saveMember(member);
            return "Member saved";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("user email already exist, try another email");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "memberRegister";
        }

    }

    public String updateMember_() {

        try {
            dao.updateMember(member);
            return "Member saved";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("The process of update isn't successful");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "memberRegister";
        }

    }

    public String saveDriver_() {

        try {
            for (AutoMobile i : dao.retrieveAutoMobile()) {
                if (i.getPlateNumber().equals(getDriverPlateNumber())) {
                    driver.setAutoMobile(i);
                    break;
                }
            }

            for (Location i : dao.retrieveLocation()) {
                if (i.getDistrict().equals(locat)) {
                    driver.setLocation(i);
                    break;
                }
            }
            dao.saveDriver(driver);
            return "Driver";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("user email already exist, try another email");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "teacherRegister";
        }

    }

    public String updateDriver_() {

        try {
            for (AutoMobile i : dao.retrieveAutoMobile()) {
                if (i.getPlateNumber().equals(getDriverPlateNumber())) {
                    driver.setAutoMobile(i);
                    break;
                }
            }

            for (Location i : dao.retrieveLocation()) {
                if (i.getDistrict().equals(locat)) {
                    driver.setLocation(i);
                    break;
                }
            }
            dao.updateDriver(driver);
            return "Driver";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("The process of update isn't successful");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "teacherRegister";
        }

    }

    public String saveLocation_() {

        try {

            dao.saveLocation(location);
            return "adminDashboard";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("location id already exist, try another");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "locationRegister";
        }

    }

    public String updateLocation_() {

        try {

            dao.updateLocation(location);
            return "adminDashboard";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("The process of update isn't successful");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "locationRegister";
        }

    }

    public String checkTeacherLogin_() {
        try {
            List<Driver> drivers = dao.retrieveDriver();

            for (Driver i : drivers) {
                if (i.getEmail().equals(driver.getEmail()) && i.getPassword().equals(driver.getPassword())) {
                    driver = i;
                    listOfStudents = i.getStudent();
                    String url = "dashboard/studentList.xhtml";
                    FacesContext.getCurrentInstance().getExternalContext().redirect(url);
                }
            }
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("sorry something is wrong,please contact the system administrator");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "teacherLogin";
        }
        FacesMessage msg = new FacesMessage("incorrect user mail or password");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "teacherLogin";
    }

    public String checkRegistraLogin_() {
        try {
            List<Registra> registras = dao.retrieveRegistra();

            for (Registra i : registras) {
                if (i.getEmail().equals(registra.getEmail()) && i.getPassword().equals(registra.getPassword())) {
                    registra = i;
                    String url = "dashboard/adminDashboard.xhtml";
                    FacesContext.getCurrentInstance().getExternalContext().redirect(url);
                }
            }
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("sorry something is wrong,please contact the system administrator");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "adminLogin";
        }
        FacesMessage msg = new FacesMessage("incorrect user mail or password");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "adminLogin";
    }

    public String saveStudentAttendance_() {

        for (Student i : dao.retrieveStudent()) {
            if (i.getEmail().equals(getStudMail())) {

                attendance.setStudent(i);
                attendance.setDriver(driver);
                attendance.setDay(convertDatetoLocal_(attendanceDate));
                try {
                    dao.saveAttendance(attendance);
                    FacesMessage msg = new FacesMessage("attendance is successfully saved");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                    return "teacherAttendance";
                } catch (Exception e) {
                    FacesMessage msg = new FacesMessage("attendance is not saved");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                    return "teacherAttendance";
                }
            }
        }
        FacesMessage msg = new FacesMessage("student email doesnt exist!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "teacherAttendance";
    }

    public void retrieveAllStudentsForTeacher_() {

        listOfStudents = driver.getStudent();

    }

    public List<Student> retrieveAllStudents_() {

        List<Student> a = dao.retrieveStudent();
        List<Student> b = new ArrayList<>();
        for (Student i : a) {

            if (i.getEmail().startsWith(theSearch) || i.getFirstName().startsWith(theSearch) || i.getLastName().startsWith(theSearch)) {
                b.add(i);
            }
        }

        return b;
    }

    public List<Student> retrieveAllStudentsToAssign_() {

        List<Student> unsignedStudent = new ArrayList<>();
        for (Student i : dao.retrieveStudent()) {
            if (i.getDriver() == null && i.getAmountPaid()!=0) {
                unsignedStudent.add(i);
            }
        }
        return unsignedStudent;
    }

    public List<Attendance> retrieveStudentAttendances_() {
        List<Attendance> att = new ArrayList<>();
        for (Attendance i : dao.retrieveAttendance()) {
            if (i.getStudent().getEmail().equals(student.getEmail())) {
                att.add(i);
            }
        }
        return att;
    }

    public List<Driver> retrieveAllTeachers_() {

        List<Driver> a = dao.retrieveDriver();
        List<Driver> b = new ArrayList<>();
        for (Driver i : a) {

            if (i.getEmail().startsWith(theSearch) || i.getFirstName().startsWith(theSearch) || i.getLastName().startsWith(theSearch)) {
                b.add(i);
            }
        }
        return b;
    }

    public List<Location> retrieveAllLocation_() {

        List<Location> a = dao.retrieveLocation();
        List<Location> b = new ArrayList<>();
        for (Location i : a) {

            if (i.getDistrict().startsWith(theSearch)) {
                b.add(i);
            }
        }

        return b;
    }

    public List<Member> retrieveAllMember_() {

        List<Member> a = dao.retrieveMember();
        List<Member> b = new ArrayList<>();
        for (Member i : a) {

            if (i.getEmail().startsWith(theSearch) || i.getFirstName().startsWith(theSearch) || i.getLastName().startsWith(theSearch)) {
                b.add(i);
            }
        }

        return b;
    }

    public List<AutoMobile> retrieveAllTAutomobiles_() {

        List<AutoMobile> a = dao.retrieveAutoMobile();
        List<AutoMobile> b = new ArrayList<>();
        for (AutoMobile i : a) {

            if (i.getPlateNumber().startsWith(theSearch) || i.getType().startsWith(theSearch) || i.getCategory().startsWith(theSearch) || i.getMember().getFirstName().startsWith(theSearch)) {
                b.add(i);
            }
        }
        return b;
    }

    public List<AutoMobile> retrieveMemberProperty_() {
        return member.getAutoMobile();
    }

    public String assignStudentToTeacher_(Student studUpdt) {
        this.student = studUpdt;
        return "clientAssign";
    }

    public String updateStudent_(Student studUpdt) {
        this.student = studUpdt;
        String url = "../clientUpdate.xhtml";
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        } catch (IOException ex) {
            return "updateStudent";
        }
        return "updateStudent";
    }

    public String updateMember_(Member membr) {
        this.member = membr;
        String url = "../memberUpdate.xhtml";
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        } catch (IOException ex) {
            return "updateMember";
        }
        return "updateMember";
    }

    public String updateTeacher_(Driver teacher) {
        this.driver = teacher;
        String url = "../teacherUpdate.xhtml";
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        } catch (IOException ex) {
            return "updateTeacher";
        }
        return "updateTeacher";
    }

    public String updateLocation_(Location loc) {
        this.location = loc;
        String url = "../locationUpdate.xhtml";
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        } catch (IOException ex) {
            return "updateLocation";
        }
        return "updateLocation";
    }

    public String updateAutomobile_(AutoMobile automobl) {
        this.autoMobile = automobl;
        String url = "../automobileUpdate.xhtml";
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        } catch (IOException ex) {
            return "updateAutomobile";
        }
        return "updateAutomobile";
    }

    public String deleteStudent_(Student studUpdt) {
        dao.deleteStudent(studUpdt);
        return "adminDashboard";
    }

    public String deleteTeacher_(Driver teacher) {
        dao.deleteDriver(teacher);
        return "adminDashboard";
    }

    public String deleteLocation_(Location loc) {
        dao.deleteLocation(loc);
        return "adminDashboard";
    }

    public String deleteAutomobile_(AutoMobile automobl) {
        dao.deleteAutoMobile(automobl);
        return "adminDashboard";
    }

    public String deleteMember_(Member membr) {
        dao.deleteMember(membr);
        return "adminDashboard";
    }

    public String propertyMember_(Member membr) {
        member = membr;
        return "memberProperty";
    }

    public List<String> categoryList_() {

        List<String> catg = new ArrayList();
        if (categoryType.equals("temporary permit")) {
            catg.add("None");
            return catg;
        } else {
            catg.add("A");
            catg.add("B");
            catg.add("C");
            catg.add("D");
            catg.add("E");
            return catg;
        }
    }
    
    
    public void categoryPrice_() {

        for(CategoryPrice i : dao.retrievePrice()){
            
            if(i.getCategoryName().equals(student.getCategory())){
                price=i.getPriceCategory();
                
                break;
            }
        }
    }

    public List<String> driverListToAssign_() {

        List<String> driv = new ArrayList();

        for (Driver i : dao.retrieveDriver()) {

            if (i.getCategory().equals(student.getCategory()) && i.getLocation().getDistrict().equals(student.getLocation().getDistrict())) {
                String val = i.getEmail() + "-" + i.getFirstName() + " " + i.getLastName();
                driv.add(val);
            }
        }

        return driv;
    }

    public String saveAssignedStudent_() {

        String tM = teacherMail.split("-")[0];

        for (Driver i : dao.retrieveDriver()) {
            if (i.getEmail().equals(tM)) {
                student.setDriver(i);
                try {
                    dao.updateStudent(student);
                    return "adminDashboard.xhtml";
                } catch (Exception e) {
                    FacesMessage msg = new FacesMessage(e.getMessage());
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                    return "clientAssign.xhtml";
                }
            }
        }

        return "clientAssign.xhtml";
    }

    public String clientMessage_() {

        if (student.getDriver() == null) {
            clientMsg = "Make payment on left Menu 'Pay For Class' and check in to your account tommorrow to get the instructor you've been assign to";
            return clientMsg;
        } else {
            clientMsg = "instructor's info: " + "  |   names: " + student.getDriver().getFirstName() + " " + student.getDriver().getLastName() + "   | phone: " + student.getDriver().getPhoneNumber();
            return clientMsg;
        }
    }

    public String studForTeacher_(List<Student> stud) {
        listOfStudents = stud;
        return "viewStudentForTeacher";
    }

    public List<Student> searchStudForTeacher_() {

        List<Student> a = new ArrayList<>();
        for (Student i : listOfStudents) {
            if (i.getEmail().startsWith(theSearch) || i.getFirstName().startsWith(theSearch) || i.getLastName().startsWith(theSearch)) {
                a.add(i);
            }
        }

        return a;
    }

    public String checkAttendance_(Student stud) {

        student = stud;
        return "viewAttendance";
    }

    public String redirectAttendance_(Student stud) {

        studMail = stud.getEmail();
        return "teacherAttendance";
    }

    public PieChartModel getPieModelForStudent_() {

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (Location i : dao.retrieveLocation()) {
            int countStud = 0;

            for (Student j : i.getStudent()) {
                if (j.getRegistrionDate().toString().substring(0, 4).equals(year + "")) {
                    countStud++;
                }
            }
            map.put(i.getDistrict(), countStud);
        }

        PieChartModel model = new PieChartModel();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            model.set(e.getKey(), e.getValue());
        }

        model.setTitle("Pie Chart");
        model.setShowDataLabels(true);
        model.setLegendPosition("w");
        return model;
    }

    public PieChartModel getPieModelForTeacher_() {

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (Location i : dao.retrieveLocation()) {
            int countTeach = 0;
            for (Driver j : i.getDriver()) {
                if (Integer.parseInt(j.getRegistrionDate().toString().substring(0, 4)) <= year) {
                    countTeach++;
                }
            }
            map.put(i.getDistrict(), countTeach);
        }

        PieChartModel model = new PieChartModel();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            model.set(e.getKey(), e.getValue());
        }

        model.setTitle("Pie Chart");
        model.setShowDataLabels(true);
        model.setLegendPosition("w");
        return model;
    }

    public PieChartModel getPieModelForAutomobile_() {

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (Location i : dao.retrieveLocation()) {
            int countAut = 0;
            for (AutoMobile j : i.getAutomobile()) {
                if (Integer.parseInt(j.getRegistrionDate().toString().substring(0, 4)) <= year) {
                    countAut++;
                }
            }
            map.put(i.getDistrict(), countAut);
        }

        PieChartModel model = new PieChartModel();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            model.set(e.getKey(), e.getValue());
        }

        model.setTitle("Pie Chart");
        model.setShowDataLabels(true);
        model.setLegendPosition("w");
        return model;
    }

    public LineChartModel getMkodel_() {

        int m1 = 0, m2 = 0, m3 = 0, m4 = 0, m5 = 0, m6 = 0, m7 = 0, m8 = 0, m9 = 0, m10 = 0, m11 = 0, m12 = 0;
        for (Student i : dao.retrieveStudent()) {
            if (i.getRegistrionDate().toString().substring(0, 4).equals(year + "")) {
                if (i.getRegistrionDate().getMonth() == 0) {
                    m1++;
                } else if (i.getRegistrionDate().getMonth() == 1) {
                    m2++;
                } else if (i.getRegistrionDate().getMonth() == 2) {
                    m3++;
                } else if (i.getRegistrionDate().getMonth() == 3) {
                    m4++;
                } else if (i.getRegistrionDate().getMonth() == 4) {
                    m5++;
                } else if (i.getRegistrionDate().getMonth() == 5) {
                    m6++;
                } else if (i.getRegistrionDate().getMonth() == 6) {
                    m7++;
                } else if (i.getRegistrionDate().getMonth() == 7) {
                    m8++;
                } else if (i.getRegistrionDate().getMonth() == 8) {
                    m9++;
                } else if (i.getRegistrionDate().getMonth() == 9) {
                    m10++;
                } else if (i.getRegistrionDate().getMonth() == 10) {
                    m11++;
                } else if (i.getRegistrionDate().getMonth() == 11) {
                    m12++;
                }
            }
        }
        LineChartModel model = new LineChartModel();

        ChartSeries girls = new ChartSeries();
        girls.setLabel("Months");
        girls.set("1", m1);
        girls.set("2", m2);
        girls.set("3", m3);
        girls.set("4", m4);
        girls.set("5", m5);
        girls.set("6", m6);
        girls.set("7", m7);
        girls.set("8", m8);
        girls.set("9", m9);
        girls.set("10", m10);
        girls.set("11", m11);
        girls.set("12", m12);

        model.addSeries(girls);
        model.setTitle("Category Chart");
        model.setLegendPosition("e");
        model.setShowPointLabels(true);
        model.getAxes().put(AxisType.X, new CategoryAxis("Month"));
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("Number");
        yAxis.setMin(0);
        yAxis.setMax(10);
        return model;
    }

    public BarChartModel getBarModelForStudent_() {
        int boy_None = 0, boy_A = 0, boy_B = 0, boy_C = 0, boy_D = 0, boy_E = 0, girl_None = 0, girl_A = 0, girl_B = 0, girl_C = 0, girl_D = 0, girl_E = 0;
        for (Student i : dao.retrieveStudent()) {

            if (i.getRegistrionDate().toString().substring(0, 4).equals(year + "")) {

                if (i.getGender().equals("male") && i.getCategory().equals("None")) {
                    boy_None++;
                } else if (i.getGender().equals("male") && i.getCategory().equals("A")) {
                    boy_A++;
                } else if (i.getGender().equals("male") && i.getCategory().equals("B")) {
                    boy_B++;
                } else if (i.getGender().equals("male") && i.getCategory().equals("C")) {
                    boy_C++;
                } else if (i.getGender().equals("male") && i.getCategory().equals("D")) {
                    boy_D++;
                } else if (i.getGender().equals("male") && i.getCategory().equals("E")) {
                    boy_E++;
                }
                if (i.getGender().equals("female") && i.getCategory().equals("None")) {
                    girl_None++;
                } else if (i.getGender().equals("female") && i.getCategory().equals("A")) {
                    girl_A++;
                } else if (i.getGender().equals("female") && i.getCategory().equals("B")) {
                    girl_B++;
                } else if (i.getGender().equals("female") && i.getCategory().equals("C")) {
                    girl_C++;
                } else if (i.getGender().equals("female") && i.getCategory().equals("D")) {
                    girl_D++;
                } else if (i.getGender().equals("female") && i.getCategory().equals("E")) {
                    girl_E++;
                }
            }
        }
        BarChartModel model = new BarChartModel();
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("None", boy_None);
        boys.set("A", boy_A);
        boys.set("B", boy_B);
        boys.set("C", boy_C);
        boys.set("D", boy_D);
        boys.set("E", boy_E);

        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("None", girl_None);
        girls.set("A", girl_A);
        girls.set("B", girl_B);
        girls.set("C", girl_C);
        girls.set("D", girl_D);
        girls.set("E", girl_E);
        model.addSeries(boys);
        model.addSeries(girls);
        model.setTitle("Bar Chart");
        model.setShowPointLabels(true);
        model.setLegendPosition("ne");
        Axis xAxis = model.getAxis(AxisType.X);
        xAxis.setLabel("Category");
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("Number");
        yAxis.setMin(0);
        yAxis.setMax(10);
        return model;
    }

    public BarChartModel getBarModelForTeacher_() {
        int boy_None = 0, boy_A = 0, boy_B = 0, boy_C = 0, boy_D = 0, boy_E = 0, girl_None = 0, girl_A = 0, girl_B = 0, girl_C = 0, girl_D = 0, girl_E = 0;

        for (Driver i : dao.retrieveDriver()) {
            if (Integer.parseInt(i.getRegistrionDate().toString().substring(0, 4)) <= year) {
                if (i.getGender().equals("male") && i.getCategory().equals("None")) {
                    boy_None++;
                } else if (i.getGender().equals("male") && i.getCategory().equals("A")) {
                    boy_A++;
                } else if (i.getGender().equals("male") && i.getCategory().equals("B")) {
                    boy_B++;
                } else if (i.getGender().equals("male") && i.getCategory().equals("C")) {
                    boy_C++;
                } else if (i.getGender().equals("male") && i.getCategory().equals("D")) {
                    boy_D++;
                } else if (i.getGender().equals("male") && i.getCategory().equals("E")) {
                    boy_E++;
                }
                if (i.getGender().equals("female") && i.getCategory().equals("None")) {
                    girl_None++;
                } else if (i.getGender().equals("female") && i.getCategory().equals("A")) {
                    girl_A++;
                } else if (i.getGender().equals("female") && i.getCategory().equals("B")) {
                    girl_B++;
                } else if (i.getGender().equals("female") && i.getCategory().equals("C")) {
                    girl_C++;
                } else if (i.getGender().equals("female") && i.getCategory().equals("D")) {
                    girl_D++;
                } else if (i.getGender().equals("female") && i.getCategory().equals("E")) {
                    girl_E++;
                }
            }
        }
        BarChartModel model = new BarChartModel();
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("None", boy_None);
        boys.set("A", boy_A);
        boys.set("B", boy_B);
        boys.set("C", boy_C);
        boys.set("D", boy_D);
        boys.set("E", boy_E);

        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("None", girl_None);
        girls.set("A", girl_A);
        girls.set("B", girl_B);
        girls.set("C", girl_C);
        girls.set("D", girl_D);
        girls.set("E", girl_E);

        model.addSeries(boys);
        model.addSeries(girls);
        model.setTitle("Bar Chart");
        model.setShowPointLabels(true);
        model.setShowDatatip(true);
        model.setLegendPosition("ne");
        Axis xAxis = model.getAxis(AxisType.X);
        xAxis.setLabel("Category");
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("Number");
        yAxis.setMin(0);
        yAxis.setMax(5);
        return model;
    }

    public BarChartModel getBarModelForAtmCtgr_() {
        int A = 0, B = 0, C = 0, D = 0, E = 0;
        for (AutoMobile i : dao.retrieveAutoMobile()) {
            if (Integer.parseInt(i.getRegistrionDate().toString().substring(0, 4)) <= year) {
                if (i.getCategory().equals("A")) {
                    A++;
                } else if (i.getCategory().equals("B")) {
                    B++;
                } else if (i.getCategory().equals("C")) {
                    C++;
                } else if (i.getCategory().equals("D")) {
                    D++;
                } else if (i.getCategory().equals("E")) {
                    E++;
                }
            }
        }
        BarChartModel model = new BarChartModel();
        ChartSeries catg = new ChartSeries();
        catg.setLabel("Category");
        catg.set("A", A);
        catg.set("B", B);
        catg.set("C", C);
        catg.set("D", D);
        catg.set("E", E);

        model.addSeries(catg);
        model.setTitle("Bar Chart");
        model.setShowPointLabels(true);
        model.setShowDatatip(true);
        model.setLegendPosition("ne");
        Axis xAxis = model.getAxis(AxisType.X);
        xAxis.setLabel("Category");
        Axis yAxis = model.getAxis(AxisType.Y);
        yAxis.setLabel("Number");
        yAxis.setMin(0);
        yAxis.setMax(5);
        return model;
    }

    public void changeCarType_() {
        if (autoMobile.getCategory().equals("A")) {
            autoMobile.setType("Motor");
        } else {
            autoMobile.setType("Car");
        }
    }

    public List<AutoMobile> checkCarLocation_() {

        List<AutoMobile> autom = new ArrayList<>();

        if (driver.getCategory() == null) {

            return autom;
        }

        if (!driver.getCategory().equals("None")) {
            List<String> a = new ArrayList<>();

            for (Driver i : dao.retrieveDriver()) {

                if (i.getAutoMobile() != null) {

                    a.add(i.getAutoMobile().getPlateNumber());
                }
            }

            for (Location i : dao.retrieveLocation()) {

                if (i.getDistrict().equals(locat)) {

                    for (AutoMobile j : i.getAutomobile()) {

                        if (!a.contains(j.getPlateNumber()) && j.getCategory().equals(driver.getCategory())) {
                            autom.add(j);

                        }
                    }

                }
            }

        }

        return autom;
    }
    
   public String makepay_(){
       
       return "clientPayProceed";
   }
}
