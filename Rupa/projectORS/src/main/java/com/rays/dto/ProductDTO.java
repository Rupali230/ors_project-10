package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "product")
public class ProductDTO  {

	@Id
	@GeneratedValue(generator = "ncsPk")
	@GenericGenerator(name = "ncsPk", strategy = "native")
	@Column(name = "ID", unique = true, nullable = false)

	protected Long id;

	public String productname;
	public String productid;
	public String customername;
	public String productaddress;
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

	
	
}



