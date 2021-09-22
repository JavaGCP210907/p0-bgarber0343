package com.revature.dao;

import java.util.List;
import com.revature.models.Product;

public interface ProductDaoInterface {
	
	public List<Product> getProducts();
	
	public List<Product> getProductsByDepartmentId(int id);
	
	public Product getProductsByProductId(int id);
	
	public void updateStock(int id, int newStock);
	
	public void addProduct(Product product);
	
	public void removeProduct(int id);

}
