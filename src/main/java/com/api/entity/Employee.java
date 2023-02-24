

package com.api.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.mysql.cj.xdevapi.Collection;





/**
 * ProductCategory
 */

@Entity
@Table(name = "Employee")
public class Employee  {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column
    private String Name;
    @Column
    private String email;
    @Column
    private String address;
    @Column
    @Size(message = "Mobilenumber should be of 10 digits",min = 8 , max = 10)
    private String mobilenumber;
    @Column
    private String gender;
    @Column
    private String position;
    @Column
//    @OneToMany(mappedBy = "employee",orphanRemoval = true, cascade = {jakarta.persistence.CascadeType.REMOVE})
//    List<Vacations> vacations = new ArrayList<Vacations>();
//    @OneToMany(mappedBy = "employee")
//    private Set<Vacations> vacations;
    @Fetch(FetchMode.SELECT)
    @LazyCollection(LazyCollectionOption.TRUE)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee") 
    private List<Vacations> vacations;
//    List<Vacations> vacations = new ArrayList<Vacations>();

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFistName() {
        return Name;
    }

    public void setFistName(String fistName) {
        this.Name = fistName;
    }

  

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

 

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

	public List<Vacations> getVacations() {
		return vacations;
	}

	public void setVacations(List<Vacations> vacations) {
		this.vacations = vacations;
	}

	



  
}
