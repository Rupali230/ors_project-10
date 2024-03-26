
package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "employee")
public class EmployeeDTO {

	public String employeename;
	public String employeeid;
	public String employeework;
	public String employeesalery;
	

	@Id
	@GeneratedValue(generator = "ncsPk")
	@GenericGenerator(name = "ncsPk", strategy = "native")
	@Column(name = "ID", unique = true, nullable = false)

	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeework() {
		return employeework;
	}

	public void setEmployeework(String employeework) {
		this.employeework = employeework;
	}

	public String getEmployeesalery() {
		return employeesalery;
	}

	public void setEmployeesalery(String employeesalery) {
		this.employeesalery = employeesalery;
	}
}