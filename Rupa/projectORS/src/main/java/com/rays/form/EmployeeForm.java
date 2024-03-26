package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.dto.EmployeeDTO;

public class EmployeeForm {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty(message = "please Enter Employeename")
	public String employeename;

	@NotEmpty(message = "please Enter Employeeid")
	public String employeeid;

	@NotEmpty(message = "please Enter Employeework")
	public String employeework;

	@NotEmpty(message = "please Enter Employeesalery")
	public String employeesalery;

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

	public <T extends EmployeeDTO> T initDTo(T dto) {

		if (id != null && id > 0) {
			dto.setId(id);

		} else {

			dto.setId(null);
		}
		return dto;
	}

	public EmployeeDTO getDTO() {

		EmployeeDTO dto = initDTo(new EmployeeDTO());
		dto.setEmployeename(employeename);
		dto.setEmployeeid(employeeid);
		dto.setEmployeework(employeework);
		dto.setEmployeesalery(employeesalery);
		return dto;
	}

}
