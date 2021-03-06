package com.info.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
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

	@ElementCollection
	@JoinTable(name="address_table",joinColumns=@JoinColumn(name="emp_id"))//it is represnt Jointable as will as Joincolumn name
	@GenericGenerator(name = "sequence_gen", strategy = "sequence")// added primary key 
	@CollectionId(columns = { @Column (name="address_id")}, generator = "sequence_gen", type = @Type(type = "int"))
	private Collection<Address>   addressList=new HashSet<>();
	
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

	public Collection<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(Collection<Address> addressList) {
		this.addressList = addressList;
	}

	public void setAddressList(Set<Address> addressList) {
		this.addressList = addressList;
	}

	@Override
	public String toString() {
		return "Empolyee [emp_Id=" + emp_Id + ", emp_name=" + emp_name + ", date_of_join=" + date_of_join
				+ ", emp_salary=" + emp_salary + "]";
	}
}
