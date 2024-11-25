package com.luv2code.springboot.demo.mycoolapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="primary_address")
    private String primaryAddress;

    @Column(name="primary_Contact_info")
    private String primaryContactInfo;
    
    @Column(name="age")
    private Integer age;

    @Column(name="years_company")
    private String yearsAtCompany;

    
    // define constructors
    public Employee() {

    }

    public Employee(String name, String primaryAddress, String primaryContactInfo, Integer age, String yearAtCompany) {
        this.name = name;
        this.primaryAddress = primaryAddress;
        this.primaryContactInfo = primaryContactInfo;
        this.age = age;
        this.yearsAtCompany = yearAtCompany;
        
    }

    // define getters/setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(String primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public String getPrimaryContactInfo() {
        return primaryContactInfo;
    }
    
    public void setPrimaryContactInfo(String primaryContactInfo) {
        this.primaryContactInfo = primaryContactInfo;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }
    public void setYearsAtCompany(String yearAtCompany) {
         this.yearsAtCompany = yearAtCompany;
    }

    public String getYearsAtCompany() {
        return yearsAtCompany;
    }

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", primaryAddress=" + primaryAddress + ", primaryContactInfo="
				+ primaryContactInfo + ", age=" + age + ", yearsAtCompany=" + yearsAtCompany + "]";
	}


}
