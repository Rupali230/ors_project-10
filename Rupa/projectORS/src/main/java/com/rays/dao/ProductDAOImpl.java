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
import com.rays.dto.ProductDTO;

	@Repository
	public class ProductDAOImpl {

		@PersistenceContext
		EntityManager en;

		public long add(ProductDTO dto) {
			en.persist(dto);
			return dto.getId();

		}

		public ProductDTO findById(Long pk) {
			return en.find(ProductDTO.class, pk);
		}

		public ProductDTO update(ProductDTO dto) {
			return en.merge(dto);

		}

		public void delete(ProductDTO dto) {
			en.remove(dto);
		}

		public List<ProductDTO> search(ProductDTO dto, int pageNo, int pageSize) {
			CriteriaBuilder builder = en.getCriteriaBuilder();
			CriteriaQuery<ProductDTO> cq = builder.createQuery(ProductDTO.class);
			Root<ProductDTO> qroot = cq.from(ProductDTO.class);

			if (dto.getProductname() != null && dto.getProductname().length() > 0) {
				cq.where(builder.like(qroot.get("productname"), dto.getProductname() + "%"));
			}

		if (dto.getProductid() !=null && dto.getProductid().length()>0) {
				cq.where(builder.like(qroot.get("productid"), dto.getProductid() + "%"));
			}
			

		if (dto.getCustomername() != null && dto.getCustomername().length() > 0) {
			cq.where(builder.like(qroot.get("customername"), dto.getCustomername() + "%"));
			}
	

			if (dto.getProductaddress() != null && dto.getProductaddress().length() > 0) {
				cq.where(builder.like(qroot.get("productaddress"), dto.getProductaddress() + "%"));			
		
		}
			
			
			if (dto.getProductammount() != null && dto.getProductammount().length() > 0) {
				cq.where(builder.like(qroot.get("productammount"), dto.getProductammount() + "%"));			
		
		}
			

			
	

		TypedQuery<ProductDTO> query = en.createQuery(cq);

		if (pageSize > 0) {
			query.setFirstResult(pageNo * pageSize);
			query.setMaxResults(pageSize);
		}

		List<ProductDTO> list = query.getResultList();
		return list;

			
		
	
			
		}
		}



