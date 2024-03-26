package com.rays.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.dto.TicketDTO;

@Repository
public class TicketDAOImpl {

	@PersistenceContext
	EntityManager en;

	public long add(TicketDTO dto) {
		en.persist(dto);
		return dto.getId();

	}

	public TicketDTO findById(Long pk) {
		return en.find(TicketDTO.class, pk);
	}

	public void update(TicketDTO dto) {
		en.merge(dto);

	}

	public void delete(TicketDTO dto) {
		en.remove(dto);
	}

	public List<TicketDTO> search(TicketDTO dto, int pageNo, int pageSize) {
		CriteriaBuilder builder = en.getCriteriaBuilder();
		CriteriaQuery<TicketDTO> cq = builder.createQuery(TicketDTO.class);
		Root<TicketDTO> qroot = cq.from(TicketDTO.class);

		if (dto.getTickettype() != null && dto.getTickettype().length() > 0) {
			cq.where(builder.like(qroot.get("Tickettype"), dto.getTickettype() + "%"));
		}

		TypedQuery<TicketDTO> query = en.createQuery(cq);

		if (pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		List<TicketDTO> list = query.getResultList();
		return list;

	}
}
