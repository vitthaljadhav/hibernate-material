package com.info.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
@Entity
@DynamicUpdate
@Table(name="empolyee")
public class Empolyee {  // it is represent entity object

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_Id")
	private Integer emp_Id;
	
	@Column(name="emp_name")
	private String emp_name;
	
	@Column(name="date_of_join")
	private Date date_of_join;
	
	@Column(name="emp_salary")
	private Double emp_salary;

	@Embedded
	private Address address;   //it is represnt as a value object or embedded object
	
	public Integer getEmp_Id() {
		return emp_Id;
	}

	public void setEmp_Id(Integer emp_Id) {
		this.emp_Id = emp_Id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public Date getDate_of_join() {
		return date_of_join;
	}

	public void setDate_of_join(Date date_of_join) {
		this.date_of_join = date_of_join;
	}

	public Double getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(Double emp_salary) {
		this.emp_salary = emp_salary;
	}

	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Empolyee [emp_Id=" + emp_Id + ", emp_name=" + emp_name + ", date_of_join=" + date_of_join
				+ ", emp_salary=" + emp_salary + "]"+address.toString();
	}
}
