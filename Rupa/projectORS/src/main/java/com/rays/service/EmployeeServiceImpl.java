package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.EmployeeDAOImp;
import com.rays.dto.EmployeeDTO;

@Service
@Transactional
public class EmployeeServiceImpl {

	@Autowired
	EmployeeDAOImp emp;

	public long add(EmployeeDTO dto) {
		return emp.add(dto);

	}

	public List search(EmployeeDTO dto, int pageNO, int pageSize) {
		return emp.search(dto, pageNO, pageSize);

	}

	public EmployeeDTO findById(long pk) {
		return emp.findById(pk);
	}

	public void delete(EmployeeDTO dto) {
		emp.delete(dto);
	}

	public void update(EmployeeDTO dto) {
		emp.update(dto);
	}

}
