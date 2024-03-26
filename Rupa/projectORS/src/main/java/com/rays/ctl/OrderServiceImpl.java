package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.rays.dto.OrderDTO;

@Service
@Transactional
public class OrderServiceImpl {

	@Autowired
	OrderDAOImp emp;

	public long add(OrderDTO dto) {
		return emp.add(dto);

	}
	public List search(OrderDTO dto, int pageNO, int pageSize) {
		return emp.search(dto, pageNO, pageSize);

	}

	public OrderDTO findById(long pk) {
		return emp.findById(pk);
	}

	public void delete(OrderDTO dto) {
		emp.delete(dto);
	}

	public void update(OrderDTO dto) {
		emp.update(dto);
	}

}



