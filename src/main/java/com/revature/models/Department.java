package com.revature.models;

import java.math.BigDecimal;

public class Department {
	
	private int department_id;
	private String department_name;
	private BigDecimal department_sales;
	
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Department(int department_id, String department_name, BigDecimal department_sales) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.department_sales = department_sales;
	}


	@Override
	public String toString() {
		return "Department [department_id=" + department_id + ", department_name=" + department_name
				+ ", department_sales=" + department_sales + "]";
	}


	public int getDepartment_id() {
		return department_id;
	}


	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}


	public String getDepartment_name() {
		return department_name;
	}


	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}


	public BigDecimal getDepartment_sales() {
		return department_sales;
	}


	public void setDepartment_sales(BigDecimal department_sales) {
		this.department_sales = department_sales;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + department_id;
		result = prime * result + ((department_name == null) ? 0 : department_name.hashCode());
		result = prime * result + ((department_sales == null) ? 0 : department_sales.hashCode());
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
		Department other = (Department) obj;
		if (department_id != other.department_id)
			return false;
		if (department_name == null) {
			if (other.department_name != null)
				return false;
		} else if (!department_name.equals(other.department_name))
			return false;
		if (department_sales == null) {
			if (other.department_sales != null)
				return false;
		} else if (!department_sales.equals(other.department_sales))
			return false;
		return true;
	}
	
}
