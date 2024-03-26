package com.rays.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.PaymentDAOImpl;
import com.rays.dao.ProductDAOImpl;
import com.rays.dto.PaymentDTO;
import com.rays.dto.ProductDTO;

@Service
@Transactional
public class ProductServiceimpl {

	@Autowired
	ProductDAOImpl emp;

	public long add(ProductDTO dto) {
		return emp.add(dto);

	}

	public List search(ProductDTO dto, int pageNO, int pageSize) {
		return emp.search(dto, pageNO, pageSize);

	}

	public ProductDTO findById(long pk) {
		return emp.findById(pk);
	}

	public void delete(ProductDTO dto) {
		emp.delete(dto);
	}

	public void update(ProductDTO dto) {
		emp.update(dto);
		
	}

	

}
