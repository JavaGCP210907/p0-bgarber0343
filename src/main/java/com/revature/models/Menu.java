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
		System.out.println();
		
		while(showMenu) {
			
			System.out.println("/////////////////////////////");
			System.out.println("//    SELECT AN OPTION     //");
			System.out.println("/////////////////////////////");
			System.out.println("//Show product             //");
			System.out.println("//Show department inventory//");
			System.out.println("//Show all inventory       //");
			System.out.println("//Show all departments     //");
			System.out.println("//Show total sales         //");
			System.out.println("//Update stock             //");
			System.out.println("//Update sales             //");
			System.out.println("//Add new product          //");
			System.out.println("//Delete product           //");
			System.out.println("//Help                     //");
			System.out.println("//Exit                     //");
			System.out.println("/////////////////////////////");
			
			String input = scan.nextLine();
			
			switch(input.toUpperCase()) {
			
			case "SHOW PRODUCT": {
				
				System.out.println("Which product would you like to display?");
				
				int idInput = scan.nextInt();
				scan.nextLine();
				
				Product prod = pDao.getProductsByProductId(idInput);
				System.out.println(prod);
				
				break;
				
			} case "SHOW DEPARTMENT INVENTORY": {
				
				System.out.println("Which department would you like to display?");
				
				int idInput = scan.nextInt();
				scan.nextLine();
				
				List<Product> products = pDao.getProductsByDepartmentId(idInput);
				
				for(Product prod : products) {
					System.out.println(prod);
				}
				
				break;
				
			} case "SHOW ALL INVENTORY": {
				
				List<Product> products = pDao.getProducts();
				
				for(Product prod : products) {
					System.out.println(prod);
				}
				
				break;
				
			} case "SHOW ALL DEPARTMENTS": {
				
				List<Department> departments = dDao.getDepartments(); 
				
				for(Department dept : departments) {
					System.out.println(dept);
				}
				
				break;
				
			} case "SHOW TOTAL SALES": {
				
				BigDecimal sales = dDao.getTotalSales();
				System.out.println(sales);
				
				break;
				
			} case "UPDATE STOCK": {
				
				System.out.println("Enter the ID of the item you wish to update");
				int idInput = scan.nextInt();
				
				System.out.println("Enter the new total stock for the item");
				int stockInput = scan.nextInt();
				scan.nextLine();
				
				pDao.updateStock(idInput, stockInput);
				
				break;
				
			} case "UPDATE SALES": {
				
				System.out.println("Enter the ID of the department you wish to update");
				int idInput = scan.nextInt();
				
				System.out.println("Enter the new sales for the department");
				BigDecimal salesInput = scan.nextBigDecimal();
				scan.nextLine();
				
				dDao.updateSales(idInput, salesInput);
				
				break;
				
			}
			
			case "ADD NEW PRODUCT": {
				
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
				
			} case "DELETE PRODUCT": {
				
				System.out.println("Enter the id of the product you want to delete");
				
				int id = scan.nextInt();
				scan.nextLine();
				
				pDao.removeProduct(id);
				
				break;
				
			} case "HELP": {
				
				System.out.println("Coming soon!");
				
				break;
				
			} case "EXIT": {
				
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
