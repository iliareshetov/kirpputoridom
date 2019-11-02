package com.example.hyperlearner.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;


@Entity
public class Appointment {


    @Id
    @GenericGenerator(name = "appointment_id", strategy = "com.example.hyperlearner.util.IdGenerator")
    @GeneratedValue(generator = "appointment_id")
    @Column(name="appointment_id")
    private String appointmentId;
    @Column(name="appointment_ref")
    private String appointmentReference;
    @Column(name="create_time")
    private Date createTime;
    @Column(name="revision_time")
    private Date revisionTime;
    @Column(name="status")
    private int status;
    @Column(name="active_flag")
    private boolean activeFlag;
    @Column(name="email")
    private String email;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="number_of_weeks")
    private int numberOfWeeks;
    @Column(name="amount")
    private BigDecimal amount;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="start_date")
    private Date startDate;



    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentReference() {
        return appointmentReference;
    }

    public void setAppointmentReference(String appointmentReference) {
        this.appointmentReference = appointmentReference;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getRevisionTime() {
        return revisionTime;
    }

    public void setRevisionTime(Date revisionTime) {
        this.revisionTime = revisionTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
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


    public int getNumberOfWeeks() {
        return numberOfWeeks;
    }

    public void setNumberOfWeeks(int numberOfWeeks) {
        this.numberOfWeeks = numberOfWeeks;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
