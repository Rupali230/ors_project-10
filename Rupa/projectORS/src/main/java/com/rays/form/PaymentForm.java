package com.rays.form;

import javax.validation.constraints.NotEmpty;


import com.rays.dto.PaymentDTO;

public class PaymentForm {
	
	private Long id;

	
	@NotEmpty(message = "please Enter payment")
	public String payment;
	
	@NotEmpty(message = "please Enter paymentid")
	public String paymentid;
	
	@NotEmpty(message = "please Enter paymentmode")
	public String paymentmode;
	
	@NotEmpty(message = "please Enter paymentstauts")
	public String paymentstauts;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;

	}
	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	public String getPaymentstauts() {
		return paymentstauts;
	}

	public void setPaymentstauts(String paymentstauts) {
		this.paymentstauts = paymentstauts;
	}

	
	public <T extends PaymentDTO> T initDTO(T dto) {

		if (id != null && id > 0) {
			dto.setId(id)
;

		} else {

			dto.setId(null);
		}
		return dto;
	}

	
	public PaymentDTO getDTO() {

	 PaymentDTO dto = initDTO(new  PaymentDTO()) ;
	 dto.setPayment(payment);
	dto.setPaymentid(paymentid);
dto.setPaymentmode(paymentmode);
   dto.setPaymentstauts(paymentstauts);

	 return dto;
	}
}

	


