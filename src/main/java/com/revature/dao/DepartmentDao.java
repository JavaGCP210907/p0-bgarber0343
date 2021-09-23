package com.revature.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Department;
import com.revature.models.Product;
import com.revature.utils.ConnectionUtil;

public class DepartmentDao implements DepartmentDaoInterface {

	@Override
	public List<Department> getDepartments() {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			ResultSet rs = null;
			String sql = "select * from departments order by(department_id)";
			Statement s = conn.createStatement();
			rs = s.executeQuery(sql);
			
			List<Department> departmentList = new ArrayList<>();
			
			while(rs.next()) {
				
				Department d = new Department(
						rs.getInt("department_id"),
						rs.getString("department_name"),
						rs.getBigDecimal("department_sales")
						);
				departmentList.add(d);
			}
			
			return departmentList;
			
		}
		catch (SQLException e) {
			
			System.out.println("There was an error with your database!");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public BigDecimal getTotalSales() {

		try(Connection conn = ConnectionUtil.getConnection()) {
			
			ResultSet rs = null;
			
			String sql = "select sum(department_sales) from departments";
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			rs.next();
			
			BigDecimal sales = rs.getBigDecimal(1);
			
			return sales;
			
		}
		catch (SQLException e) {
			
			System.out.println("There was an error with your database!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateSales(int id, BigDecimal newSales) {

		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "update departments set department_sales = ? where department_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setBigDecimal(1, newSales);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
			System.out.println("Update successful!");
			
		}
		catch (SQLException e) {
			
			System.out.println("There was an error with your database!");
			e.printStackTrace();
		}
		
	}

}
