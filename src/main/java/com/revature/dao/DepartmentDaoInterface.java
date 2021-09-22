package com.revature.dao;

import java.math.BigDecimal;
import java.util.List;
import com.revature.models.Department;

public interface DepartmentDaoInterface {
	
	public List<Department> getDepartments();
	
	public BigDecimal getTotalSales();
	
	public void updateSales(int id, BigDecimal newSales);

}
