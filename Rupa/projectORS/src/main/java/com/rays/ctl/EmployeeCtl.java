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
import com.rays.dto.EmployeeDTO;
import com.rays.form.EmployeeForm;
import com.rays.service.EmployeeServiceImpl;

@RestController
@RequestMapping(value = "employee")
public class EmployeeCtl {

	@Value("${page.size}")
	private int pageSize = 0;

	@Autowired
	EmployeeServiceImpl ser;

	@PostMapping("add")
	public ORSResponse add(@RequestBody @Valid EmployeeForm form, BindingResult br) {

		ORSResponse res = validate(br);

		if (!res.isSuccess()) {
			return res;

		}

		EmployeeDTO dto = form.getDTO();
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
		EmployeeDTO dto = ser.findById(id);

		System.out.println(" get ");
		ORSResponse res = new ORSResponse();
		if (dto != null) {

			dto.setEmployeename(dto.employeename);
			dto.setEmployeeid(dto.employeeid);
			dto.setEmployeework(dto.employeework);
			dto.setEmployeesalery(dto.employeesalery);

			res.addData(dto);

		}
		return res;

	}

	@GetMapping("update/{id}")
	public ORSResponse update(@RequestBody @PathVariable Long id, EmployeeForm form) {
		ORSResponse res = new ORSResponse(true);

		id = form.getId();

		EmployeeDTO dto = new EmployeeDTO();

		if (id != 0) {

			dto = ser.findById(id);
			dto.setEmployeename(dto.employeename);
			dto.setEmployeeid(dto.employeeid);
			dto.setEmployeework(dto.employeework);
			dto.setEmployeesalery(dto.employeesalery);

			ser.update(dto);
			res.addMessage("data is update");

		}
		return res;
	}

	@PostMapping("delete/{id}")
	public ORSResponse Delete(@RequestBody @PathVariable Long id) {

		ORSResponse res = new ORSResponse();

		System.out.println("id " + id);

		EmployeeDTO dto = ser.findById(id);
		if (dto != null) {
			ser.delete(dto);
			res.addMessage("data is deleted");

		} else {
			res.addMessage("id could not found");
		}

		return res;

	}

	@PostMapping("search/{pageNo}")
	public ORSResponse searchPage(@RequestBody EmployeeForm form, @PathVariable int pageNo, EmployeeDTO dto) {

		ORSResponse res = new ORSResponse();
		System.out.println("search");

		dto.setEmployeename(form.getEmployeename());
		dto.setEmployeeid(form.getEmployeeid());
		dto.setEmployeework(form.getEmployeework());
		dto.setEmployeesalery(form.getEmployeesalery());
		res.addData(ser.search(dto, pageNo, pageSize));

		List nextList = ser.search(dto, pageNo + 1, pageSize);

		res.addResult("nextList", nextList.size());
		return res;

	}

}
