package com.rays.form;

import javax.validation.constraints.NotEmpty;


import com.rays.dto.OrderDTO;

public class OrderForm {
	
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty(message = "please Enter")
	public String OrderName;
	
	@NotEmpty(message = "please Enter")
	public String OrderAmount;
	
	@NotEmpty(message = "please Enter")
	public String OrderAddress;
	
	@NotEmpty(message = "please Enter")
	public String OrderType;

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
	
	public <T extends OrderDTO> T initDTo(T dto) {

		if (id != null && id > 0) {
			dto.setId(id);

		} else {

			dto.setId(null);
		}
		return dto;
	}

	public OrderDTO getDTO() {

		OrderDTO dto = initDTo(new OrderDTO());
		dto.setId(id);
		dto.setOrderName(OrderName);
		dto.setOrderAmount(OrderAmount);
		dto.setOrderAddress(OrderAddress);
		dto.setOrderType(OrderType);
		return dto;
	}

}
