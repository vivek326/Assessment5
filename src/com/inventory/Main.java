package com.inventory;

import java.util.Scanner;

import java.util.*;
public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int option = 0;

		InventoryDao l = new InventoryDao();

		do {
			System.out.println("--------------------Inventory Manager--------------------");
			System.out.println("1.New Product");
			System.out.println("2.Print all products");
			System.out.println("3.Update Product");
			System.out.println("4.Delete Product");
			System.out.println("5. Exit");
			
			System.out.print("\nOption > ");
			option = s.nextInt();
			switch (option) {
			case 1:
            l.add();

				break;
			case 2:
				System.out.println("The products in inventory are: ");
				  List<Inventory> m=l.printList();
                  for(Inventory i:m)
                  {
                  	System.out.println(i);
                  }
				

				break;
			case 3:
				System.out.println("Enter product to update:");
				String productname=s.next();
            	l.update(productname);

				break;
			case 4:
				System.out.println("Enter product to delete:");
				String name=s.next();
            	l.delete(name);
				break;
			
			default:
				option = 5;
				break;
			}

		} while (option != 5);

	}
		
		

}
