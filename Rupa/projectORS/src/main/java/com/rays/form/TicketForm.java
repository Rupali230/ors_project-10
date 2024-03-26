package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.dto.ProductDTO;
import com.rays.dto.TicketDTO;

public class TicketForm {

	protected Long id;

	public String Ticketid;

	@NotEmpty(message = "please enter")
	public String Tickettype;

	@NotEmpty(message = "please enter")
	public String Customername;

	@NotEmpty(message = "please enter")
	public String Ticketaddress;

	@NotEmpty(message = "please enter")
	public String Ticketamount;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public <T extends TicketDTO> T initDTO(T dto) {

		if (id != null && id > 0) {
			dto.setId(id);

		} else {

			dto.setId(null);
		}
		return dto;
	}

	public TicketDTO getDTO() {

		TicketDTO dto = initDTO(new TicketDTO());
		dto.setTicketid(Ticketid);
		dto.setTickettype(Tickettype);
		dto.setCustomername(Customername);
		dto.setTicketaddress(Ticketaddress);
		dto.setTicketamount(Ticketamount);

		return dto;
	}
}
