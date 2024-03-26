package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "order")
public class OrderDTO {
	
	
		public String OrderName;
		public String OrderAmount;
		public String OrderAddress;
		public String OrderType;
		


		@Id
		@GeneratedValue(generator = "ncsPk")
		@GenericGenerator(name = "ncsPk", strategy = "native")
		@Column(name = "ID", unique = true, nullable = false)

		protected Long id;



		public String getOrderName() {
			return OrderName;
		}



		public void setOrderName(String orderName) {
			OrderName = orderName;
		}



		public String getOrderAmount() {
			return OrderAmount;
		}



		public void setOrderAmount(String orderAmount) {
			OrderAmount = orderAmount;
		}



		public String getOrderAddress() {
			return OrderAddress;
		}



		public void setOrderAddress(String orderAddress) {
			OrderAddress = orderAddress;
		}



		public String getOrderType() {
			return OrderType;
		}



		public void setOrderType(String orderType) {
			OrderType = orderType;
		}



		public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}

		
		

}
