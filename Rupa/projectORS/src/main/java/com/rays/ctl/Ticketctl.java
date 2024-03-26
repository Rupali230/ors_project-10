package com.rays.ctl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;
import com.rays.dto.TicketDTO;
import com.rays.form.TicketForm;
import com.rays.service.TicketServiceimpl;

@RestController
@RequestMapping(value = "Ticket")
public class Ticketctl {

	@Value("${page.size}")
	private int pageSize = 0;

	@Autowired
	TicketServiceimpl ser;

	@PostMapping("add")
	public ORSResponse add(@RequestBody @Valid TicketForm form, BindingResult br) {

		ORSResponse res = validate(br);

		if (!res.isSuccess()) {
			return res;

		}

		TicketDTO dto = form.getDTO();
		if (dto.getId() != null && dto.getId() > 0) {

			ser.update(dto);
			res.addData(form.getId());
			res.addMessage("Data Update Successfully");

		} else {
			long pk = ser.add(dto);
			res.addData(pk);
			res.addMessage("Data Insert Successfully");

		}

		return res;

	}

	public ORSResponse validate(BindingResult bindingResult) {
		ORSResponse res = new ORSResponse(true);

		if (bindingResult.hasErrors()) {

			res.setSuccess(false);

			Map<String, String> errors = new HashMap<String, String>();

			List<FieldError> list = bindingResult.getFieldErrors();

			list.forEach(e -> {
				errors.put(e.getField(), e.getDefaultMessage());
				System.out.println("Field :: " + e.getField() + "  Message :: " + e.getDefaultMessage());
			});
			res.addInputErrors(errors);
		}
		return res;

	}

	@GetMapping("get/{id}")
	public ORSResponse get(@PathVariable Long id) {
		TicketDTO dto = ser.findById(id);

		System.out.println(" get ");
		ORSResponse res = new ORSResponse();
		if (dto != null) {

			res.addData(dto);

		}
		return res;

	}

	@PostMapping("delete/{id}")
	public ORSResponse Delete(@RequestBody @PathVariable Long id) {

		ORSResponse res = new ORSResponse();

		System.out.println("id " + id);

		TicketDTO dto = ser.findById(id);
		if (dto != null) {
			ser.delete(dto);
			res.addMessage("data is deleted");

		} else {
			res.addMessage("id could not found");
		}

		return res;

	}

	@PostMapping("search/{pageNo}")
	public ORSResponse searchPage(@RequestBody TicketForm form, @PathVariable int pageNo, TicketDTO dto) {

		ORSResponse res = new ORSResponse();
		System.out.println("search");

		dto.setTicketid(form.Ticketid);
		dto.setTickettype(form.Tickettype);
		dto.setCustomername(form.Customername);
		dto.setTicketaddress(form.Ticketaddress);
		dto.setTicketamount(form.Ticketamount);

		res.addData(ser.search(dto, pageNo, pageSize));

		List nextList = ser.search(dto, pageNo + 1, pageSize);

		res.addResult("nextList", nextList.size());
		return res;

	}

}
