package com.kitri.dto;

import java.io.Serializable;
import java.util.Comparator;

import org.json.JSONObject;

public class Product implements Comparator<Product>, Serializable{
	//DB PRODUCT 와 연결
	private String prod_no;
	private ProductCategory productCategory;
	private String prod_name;
	private int prod_price;
	private String prod_detail;
	
	public Product() {
		super();
	}
	public String getProd_no() {
		return prod_no;
	}
	public void setProd_no(String prod_no) {
		this.prod_no = prod_no;
	}
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	public String getProd_detail() {
		return prod_detail;
	}
	public void setProd_detail(String prod_detail) {
		this.prod_detail = prod_detail;
	}
	@Override
	public String toString() {
		 return "Product [prod_no=" + prod_no + ", productCategory=" + productCategory
		 + ", prod_name=" + prod_name + ", prod_price=" + prod_price +
		 ", prod_detail=" + prod_detail + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prod_no == null) ? 0 : prod_no.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (prod_no == null) {
			if (other.prod_no != null)
				return false;
		} else if (!prod_no.equals(other.prod_no))
			return false;
		return true;
	}
	@Override
	public int compare(Product p1, Product p2) {
		return p1.getProd_no().compareTo(p2.getProd_no()) ;
	}

	
}
