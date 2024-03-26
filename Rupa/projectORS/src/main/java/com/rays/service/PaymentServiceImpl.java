package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.PaymentDAOImpl;
import com.rays.dto.PaymentDTO;

@Service
@Transactional
public class PaymentServiceImpl {

	@Autowired
	PaymentDAOImpl emp;

	public long add(PaymentDTO dto) {
		return emp.add(dto);

	}

	public List search(PaymentDTO dto, int pageNO, int pageSize) {
		return emp.search(dto, pageNO, pageSize);

	}

	public PaymentDTO findById(long pk) {
		return emp.findById(pk);
	}

	public void delete(PaymentDTO dto) {
		emp.delete(dto);
	}

	public void update(PaymentDTO dto) {
		emp.update(dto);
	}

}
