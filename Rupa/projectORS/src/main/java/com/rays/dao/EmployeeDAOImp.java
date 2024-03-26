package com.rays.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.dto.EmployeeDTO;

@Repository
public class EmployeeDAOImp {

	@PersistenceContext
	EntityManager en;

	public long add(EmployeeDTO dto) {
		en.persist(dto);
		return dto.getId();

	}
	

	public EmployeeDTO findById(Long pk) {
		return en.find(EmployeeDTO.class, pk);
	}

	public EmployeeDTO update(EmployeeDTO dto) {
		return en.merge(dto);

	}

	public void delete(EmployeeDTO dto) {
		en.remove(dto);
	}

	public List<EmployeeDTO> search(EmployeeDTO dto, int pageNo, int pageSize) {
		CriteriaBuilder builder = en.getCriteriaBuilder();
		CriteriaQuery<EmployeeDTO> cq = builder.createQuery(EmployeeDTO.class);
		Root<EmployeeDTO> qroot = cq.from(EmployeeDTO.class);

		if (dto.getEmployeename() != null && dto.getEmployeename().length() > 0) {
			cq.where(builder.like(qroot.get("employeename"), dto.getEmployeename() + "%"));
		}

		if (dto.getEmployeeid() != null && dto.getEmployeeid().length() > 0) {
			cq.where(builder.like(qroot.get("employeeid"), dto.getEmployeeid() + "%"));
		}
		
		if (dto.getEmployeework() !=null && dto.getEmployeework().length() > 0) {
			cq.where(builder.like(qroot.get("employeework"),dto.getEmployeework() + "%"));
		}

		if (dto.getEmployeesalery() != null && dto.getEmployeesalery().length() > 0) {
			cq.where(builder.like(qroot.get("employeesalery"), dto.getEmployeesalery() + "%"));
		}


		TypedQuery<EmployeeDTO> query = en.createQuery(cq);

		if (pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		List<EmployeeDTO> list = query.getResultList();

		return list;
	}

}
