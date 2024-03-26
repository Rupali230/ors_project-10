
package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.TicketDAOImpl;
import com.rays.dto.TicketDTO;

@Service
@Transactional
public class TicketServiceimpl {

	@Autowired
	TicketDAOImpl emp;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(TicketDTO dto) {
		return emp.add(dto);

	}

	@Transactional(readOnly = true)
	public List search(TicketDTO dto, int pageNO, int pageSize) {
		return emp.search(dto, pageNO, pageSize);

	}

	@Transactional(readOnly = true)
	public TicketDTO findById(long pk) {
		return emp.findById(pk);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(TicketDTO dto) {
		emp.delete(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(TicketDTO dto) {
		// TODO Auto-generated method stub

	}

}
