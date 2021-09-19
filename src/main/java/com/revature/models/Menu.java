package com.revature.models;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.revature.dao.DepartmentDao;
import com.revature.dao.ProductDao;

public class Menu {
	
	ProductDao pDao = new ProductDao();
	DepartmentDao dDao = new DepartmentDao();
	
	public void displayMenu() {
		
		boolean showMenu = true;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("////////////////////////////////////////////////////////");
		System.out.println("//Welcome to your Inventory and Sales Tracking System!//");
		System.out.println("////////////////////////////////////////////////////////");
		
		while(showMenu) {
			
			System.out.println("/////////////////////");
			System.out.println("//SELECT AN OPTION://");
			System.out.println("/////////////////////");
			System.out.println("Show product");
			System.out.println("Show department inventory");
			System.out.println("Show all inventory");
			System.out.println("Show all departments");
			System.out.println("Add new product");
			System.out.println("Delete product");
			System.out.println("Help");
			System.out.println("Exit");
			
			String input = scan.nextLine();
			
			switch(input) {
			
			case "Show product": {
				
				System.out.println("Which product would you like to display?");
				
				int idInput = scan.nextInt();
				scan.nextLine();
				
				Product prod = pDao.getProductsByProductId(idInput);
				System.out.println(prod);
				
				break;
				
			} case "Show department inventory": {
				
				System.out.println("Which department would you like to display?");
				
				int idInput = scan.nextInt();
				scan.nextLine();
				
				List<Product> products = pDao.getProductsByDepartmentId(idInput);
				
				for(Product prod : products) {
					System.out.println(prod);
				}
				
				break;
				
			} case "Show all inventory": {
				
				List<Product> products = pDao.getProducts();
				
				for(Product prod : products) {
					System.out.println(prod);
				}
				
				break;
				
			} case "Show all departments": {
				
				List<Department> departments = dDao.getDepartments(); 
				
				for(Department dept : departments) {
					System.out.println(dept);
				}
				
				break;
				
			} case "Add new product": {
				
				System.out.println("Enter product name");
				String pName = scan.nextLine();
				
				System.out.println("Enter a short product description");
				String pDesc = scan.nextLine();
				
				System.out.println("Enter product price");
				BigDecimal price = scan.nextBigDecimal();
				
				System.out.println("Enter product stock");
				int stock = scan.nextInt();
				
				System.out.println("Enter product department id");
				int depId = scan.nextInt();
				
				Product prod = new Product(pName, pDesc, price, stock, depId);
				
				pDao.addProduct(prod);
				
				break;
				
			} case "Delete product": {
				
				System.out.println("Enter the id of the product you want to delete");
				
				int id = scan.nextInt();
				scan.nextLine();
				
				pDao.removeProduct(id);
				
				break;
				
			} case "Help": {
				System.out.println("Coming soon!");
				break;
				
			} case "Exit": {
				showMenu = false;
				System.out.println("Thank you for using the Inventory and Sales Tracking System!");
				break;
				
			} default: {
				System.out.println("Invalid input! Try again or select Help for more information.");
				break;
				
			}
			
			}
			
		}
		
		scan.close();
		
	}

}
