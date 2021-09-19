package com.revature.models;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.ProductDao;

public class Menu {
	
	ProductDao pDao = new ProductDao();
	
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
			
			System.out.println("Show all inventory");
			System.out.println("Help");
			System.out.println("Exit");
			
			String input = scan.nextLine();
			
			switch(input) {
			
			case "Show all inventory": {
				
				List<Product> products = pDao.getProducts();
				
				for(Product prod : products) {
					System.out.println(prod);
				}
				
				break;
			}
			
			case "Help": {
				System.out.println("Coming soon!");
				break;
			}
			
			case "Exit": {
				showMenu = false;
				System.out.println("Thank you for using the Inventory and Sales Tracking System!");
				break;
			}
			
			default: {
				System.out.println("Invalid input! Try again or select Help for more information.");
				break;
			}
			
			}
			
		}
		
		scan.close();
		
	}

}
