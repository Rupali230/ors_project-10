package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Ticket")
public class TicketDTO {

	@Id
	@GeneratedValue(generator = "ncsPk")
	@GenericGenerator(name = "ncsPk", strategy = "native")
	@Column(name = "ID", unique = true, nullable = false)
	protected Long id;

	private String Ticketid;
	private String Tickettype;
	private String Customername;
	private String Ticketaddress;
	private String Ticketamount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTicketid() {
		return Ticketid;
	}

	public void setTicketid(String ticketid) {
		Ticketid = ticketid;
	}

	public String getTickettype() {
		return Tickettype;
	}

	public void setTickettype(String tickettype) {
		Tickettype = tickettype;
	}

	public String getCustomername() {
		return Customername;
	}

	public void setCustomername(String customername) {
		Customername = customername;
	}

	public String getTicketaddress() {
		return Ticketaddress;
	}

	public void setTicketaddress(String ticketaddress) {
		Ticketaddress = ticketaddress;
	}

	public String getTicketamount() {
		return Ticketamount;
	}

	public void setTicketamount(String ticketamount) {
		Ticketamount = ticketamount;
	}

}