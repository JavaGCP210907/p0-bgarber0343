package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Product;
import com.revature.utils.ConnectionUtil;

public class ProductDao implements ProductDaoInterface {

	@Override
	public List<Product> getProducts() {

		try(Connection conn = ConnectionUtil.getConnection()) {
			
			ResultSet rs = null;
			String sql = "select * from products";
			Statement s = conn.createStatement();
			rs = s.executeQuery(sql);
			
			List<Product> productList = new ArrayList<>();
			
			while(rs.next()) {
				
				Product p = new Product(
						rs.getInt("product_id"),
						rs.getString("product_name"),
						rs.getString("product_description"),
						rs.getBigDecimal("price"),
						rs.getInt("stock"),
						rs.getInt("department_id")
						);
				productList.add(p);
			}
			
			return productList;
			
		}
		catch (SQLException e) {
			
			System.out.println("There was an error with your database!");
			e.printStackTrace();
		}
		
		return null;
	}

}
