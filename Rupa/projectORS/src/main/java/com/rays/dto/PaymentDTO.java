package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.rays.common.DropdownList;

@Entity
@Table(name = "payment")
public class PaymentDTO implements DropdownList {

	@Id
	@GeneratedValue(generator = "ncsPk")
	@GenericGenerator(name = "ncsPk", strategy = "native")
	@Column(name = "ID", unique = true, nullable = false)

	protected Long id;

	public String payment;
	public String paymentid;
	public String paymentmode;
	public String paymentstauts;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return paymentmode;
	}

}
