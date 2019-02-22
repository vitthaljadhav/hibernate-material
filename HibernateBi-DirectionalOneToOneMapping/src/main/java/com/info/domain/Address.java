package com.info.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "add_id")
	private Integer add_id;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Empolyee employee;
	
	@Column(name = "city_name", length = 100)
	private String city_name;

	@Column(name = "pin_code", length = 100)
	private String pin_code;

	@Column(name = "state_name")
	private String state_name;

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getPin_code() {
		return pin_code;
	}

	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	
	public Integer getAdd_id() {
		return add_id;
	}

	public void setAdd_id(Integer add_id) {
		this.add_id = add_id;
	}

	public Empolyee getEmployee() {
		return employee;
	}

	public void setEmployee(Empolyee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Address [city_name=" + city_name + ", pin_code=" + pin_code + ", state_name=" + state_name + "]";
	}
}
