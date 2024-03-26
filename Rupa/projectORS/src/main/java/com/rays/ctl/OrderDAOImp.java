package com.rays.ctl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.springframework.stereotype.Repository;


import com.rays.dto.OrderDTO;

@Repository
	public class OrderDAOImp  {

		@PersistenceContext
		EntityManager en;

		public long add(OrderDTO dto) {
			en.persist(dto);
			return dto.getId();

		}
		

		public OrderDTO findById(Long pk) {
			return en.find(OrderDTO.class, pk);
		}

		public OrderDTO update(OrderDTO dto) {
			return en.merge(dto);

		}

		
		
		
		
		public void delete(OrderDTO dto) {
			en.remove(dto);
		}

		public List<OrderDTO> search(OrderDTO dto, int pageNo, int pageSize) {
			CriteriaBuilder builder = en.getCriteriaBuilder();
			CriteriaQuery<OrderDTO> cq = builder.createQuery(OrderDTO.class);
			Root<OrderDTO> qroot = cq.from(OrderDTO.class);

			if (dto.getOrderName() != null && dto.getOrderName().length() > 0) {
				cq.where(builder.like(qroot.get("OrderName"), dto.getOrderName() + "%"));
			}
//
//			if (dto.getOrderAddress() != null && dto.getOrderAddress().length() > 0) {
//				cq.where(builder.like(qroot.get("OrderAddress"), dto.getOrderAddress() + "%"));
//			}
//
//			
//			if (dto.getOrderAmount() != null && dto.getOrderAmount().length() > 0) {
//				cq.where(builder.like(qroot.get("OrderAmoun"), dto.getOrderAmount() + "%"));
//			}
//
//			
//			if (dto.getOrderType() != null && dto.getOrderType().length() > 0) {
//				cq.where(builder.like(qroot.get("OrderType"), dto.getOrderType() + "%"));
//			}

			


			
			
			
	

			TypedQuery<OrderDTO> query = en.createQuery(cq);

			if (pageSize > 0) {
				query.setFirstResult(pageNo * pageSize);
				query.setMaxResults(pageSize);
			}

			List<OrderDTO> list = query.getResultList();

			return list;
		}
}



