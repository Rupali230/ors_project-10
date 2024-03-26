package com.rays.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.dto.PaymentDTO;

@Repository
public class PaymentDAOImpl {

	@PersistenceContext
	EntityManager en;

	public long add(PaymentDTO dto) {
		en.persist(dto);
		return dto.getId();

	}

	public PaymentDTO findById(Long pk) {
		return en.find(PaymentDTO.class, pk);
	}

	public PaymentDTO update(PaymentDTO dto) {
		return en.merge(dto);

	}

	public void delete(PaymentDTO dto) {
		en.remove(dto);
	}

	public List<PaymentDTO> search(PaymentDTO dto, int pageNo, int pageSize) {
		CriteriaBuilder builder = en.getCriteriaBuilder();
		CriteriaQuery<PaymentDTO> cq = builder.createQuery(PaymentDTO.class);
		Root<PaymentDTO> qroot = cq.from(PaymentDTO.class);

		if (dto.getPayment() != null && dto.getPayment().length() > 0) {
			cq.where(builder.like(qroot.get("payment"), dto.getPayment() + "%"));
		}
	
		if (dto.getPaymentid() != null && dto.getPaymentid().length() > 0) {
			cq.where(builder.like(qroot.get("paymentid"), dto.getPaymentid() + "%"));
		}
	

		if (dto.getPaymentmode() != null && dto.getPaymentmode().length() > 0) {
			cq.where(builder.like(qroot.get("paymentmode"), dto.getPaymentmode() + "%"));
		}
	

		if (dto.getPaymentstauts() != null && dto.getPaymentstauts().length() > 0) {
			cq.where(builder.like(qroot.get("paymentstauts"), dto.getPaymentstauts() + "%"));
		}
	


		TypedQuery<PaymentDTO> query = en.createQuery(cq);

		if (pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		List<PaymentDTO> list = query.getResultList();
		return list;
		
	
		
	}
	}
