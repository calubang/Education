package com.kitri.dto;

import java.io.Serializable;

public class ProductCategory implements Serializable{
	//DB의 PRODUCT_CATEGORY 와 연결
	private String cate_no;
	private String cate_name;
	
	public ProductCategory() {
		super();
	}
	public String getCate_no() {
		return cate_no;
	}
	public void setCate_no(String cate_no) {
		this.cate_no = cate_no;
	}
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	@Override
	public String toString() {
		return "ProductCategory [cate_no=" + cate_no + ", cate_name=" + cate_name + "]";
	}

}
