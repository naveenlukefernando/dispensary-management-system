package com.EntityClasses;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gayashan on 9/10/2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Access(AccessType.PROPERTY)
public abstract class Employee {

    private IntegerProperty employeeid;
    private StringProperty name;
    private StringProperty gender;
    private Date dateOfBirth;
    private StringProperty email;
    private StringProperty contactNumber;
    private StringProperty qualifications;
    private List<PreviousEmployment> previousEmploymentList;





    public Employee() {
        this.employeeid = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.gender = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.contactNumber = new SimpleStringProperty();
        this.qualifications = new SimpleStringProperty();
        previousEmploymentList = new ArrayList<>();


    }



    @Id
    public int getEmployeeid() {
        return employeeid.get();
    }

    public IntegerProperty employeeidProperty() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid.set(employeeid);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getContactNumber() {
        return contactNumber.get();
    }

    public StringProperty contactNumberProperty() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber.set(contactNumber);
    }

    @Lob
    public String getQualifications() {
        return qualifications.get();
    }

    public StringProperty qualificationsProperty() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications.set(qualifications);
    }

    @ElementCollection
    public List<PreviousEmployment> getPreviousEmploymentList() {
        return previousEmploymentList;
    }

    public void setPreviousEmploymentList(List<PreviousEmployment> previousEmploymentList) {
        this.previousEmploymentList = previousEmploymentList;
    }
}
