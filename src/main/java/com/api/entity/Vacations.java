package com.api.entity;

import java.io.Serializable;

import jakarta.persistence.*;
@Entity
@Table(name = "Vacations")
public class Vacations   {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column
    private String startDate;
    @Column
    private String endDate;
    @Column
    private String reason;
//    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE} @ManyToMany(fetch = FetchType.EAGER))
//    @ElementCollection
//    @ManyToOne(fetch = FetchType.EAGER)
    @ManyToOne()
    @JoinColumn(name="employee_id")
    
    private Employee employee;
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
   /* @Override
    public String toString(){
        return "from:"+startDate+",to:"+endDate+",reason:"+reason;
    }
    */
}

