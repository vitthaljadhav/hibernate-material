package com.info.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Empolyee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer emp_Id;
	
	private String emp_name;
	
	private Date date_of_join;
	
	private Double emp_salary;

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

	@Override
	public String toString() {
		return "Empolyee [emp_Id=" + emp_Id + ", emp_name=" + emp_name + ", date_of_join=" + date_of_join
				+ ", emp_salary=" + emp_salary + "]";
	}
}
