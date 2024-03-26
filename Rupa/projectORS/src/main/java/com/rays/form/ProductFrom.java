package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.dto.ProductDTO;

public class ProductFrom {

	protected Long id;

	@NotEmpty(message = "please Enter productname")
	public String productname;

	@NotEmpty(message = "please Enter productid")
	public String productid;

	@NotEmpty(message = "please Enter customername")
	public String customername;

	@NotEmpty(message = "please Enter productaddress")
	public String productaddress;

	@NotEmpty(message = "please Enter productammount")
	public String productammount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getProductaddress() {
		return productaddress;
	}

	public void setProductaddress(String productaddress) {
		this.productaddress = productaddress;
	}

	public String getProductammount() {
		return productammount;
	}

	public void setProductammount(String productammount) {
		this.productammount = productammount;
	}

	public <T extends ProductDTO> T initDTO(T dto) {

		if (id != null && id > 0) {
			dto.setId(id);

		} else {

			dto.setId(null);
		}
		return dto;
	}

	public ProductDTO getDTO() {

		ProductDTO dto = initDTO(new ProductDTO());
		dto.setProductname(productname);
		dto.setProductid(productid);
		dto.setCustomername(customername);
		dto.setProductaddress(productaddress);
		dto.setProductammount(productammount);
		return dto;
	}
}
