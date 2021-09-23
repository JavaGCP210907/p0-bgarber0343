package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			
			String sql = "select * from products order by(product_id)";
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

	@Override
	public List<Product> getProductsByDepartmentId(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			ResultSet rs = null;
			
			String sql = "select * from products where department_id = ? order by(product_id)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
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

	@Override
	public Product getProductsByProductId(int id) {

		try(Connection conn = ConnectionUtil.getConnection()) {
			
			ResultSet rs = null;
			
			String sql = "select * from products where product_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			rs.next();
			
			Product p = new Product(
					rs.getInt("product_id"),
					rs.getString("product_name"),
					rs.getString("product_description"),
					rs.getBigDecimal("price"),
					rs.getInt("stock"),
					rs.getInt("department_id")
					);
			
			return p;
			
		}
		catch (SQLException e) {
			
			System.out.println("There was an error with your database!");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void addProduct(Product product) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "insert into products (product_name, product_description, price, stock, department_id)" +
			             "values (?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, product.getProduct_name());
			ps.setString(2, product.getProduct_description());
			ps.setBigDecimal(3, product.getPrice());
			ps.setInt(4, product.getStock());
			ps.setInt(5, product.getDepartment_id());
			
			ps.executeUpdate();
			
			System.out.println(product.getProduct_name() + " was successfully added!");
			
		}
		catch (SQLException e) {
			
			System.out.println("There was an error with your database!");
			e.printStackTrace();
		}
		
	}

	@Override
	public void removeProduct(int id) {

		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "delete from products where product_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			ps.executeUpdate();
			
			System.out.println("Product with id " + id + " has been deleted!");
			
		}
		catch (SQLException e) {
			
			System.out.println("There was an error with your database!");
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateStock(int id, int newStock) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "update products set stock = ? where product_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, newStock);
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
