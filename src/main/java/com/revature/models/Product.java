package com.revature.models;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Product {
	
	private int product_id;
	private String product_name;
	private String product_description;
	private BigDecimal price;
	private int stock;
	private int department_id;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(int product_id, String product_name, String product_description, BigDecimal price, int stock,
			int department_id) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_description = product_description;
		this.price = price;
		this.stock = stock;
		this.department_id = department_id;
	}


	public Product(String product_name, String product_description, BigDecimal price, int stock, int department_id) {
		super();
		this.product_name = product_name;
		this.product_description = product_description;
		this.price = price;
		this.stock = stock;
		this.department_id = department_id;
	}


	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		return "[ID: " + product_id + "] [Name: " + product_name + "] [Description: "
				+ product_description + "] [Price: $" + df.format(price) + "] [Stock: " + stock + "] [Department ID: " + department_id
				+ "]";
	}


	public int getProduct_id() {
		return product_id;
	}


	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}


	public String getProduct_name() {
		return product_name;
	}


	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


	public String getProduct_description() {
		return product_description;
	}


	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getDepartment_id() {
		return department_id;
	}


	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + department_id;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((product_description == null) ? 0 : product_description.hashCode());
		result = prime * result + product_id;
		result = prime * result + ((product_name == null) ? 0 : product_name.hashCode());
		result = prime * result + stock;
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
		if (department_id != other.department_id)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (product_description == null) {
			if (other.product_description != null)
				return false;
		} else if (!product_description.equals(other.product_description))
			return false;
		if (product_id != other.product_id)
			return false;
		if (product_name == null) {
			if (other.product_name != null)
				return false;
		} else if (!product_name.equals(other.product_name))
			return false;
		if (stock != other.stock)
			return false;
		return true;
	}
	
	
}
