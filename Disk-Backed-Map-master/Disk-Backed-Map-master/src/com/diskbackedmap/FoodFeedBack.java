package com.diskbackedmap;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class FoodFeedBack {

	public static void main(String[] args) {
		int choice, key, capacity;
		int rating, cost;
		String name;
		key = 0;
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Enter Maximum Size of Map on Heap");
			capacity = sc.nextInt();
			DMap<Integer, Food> dmap = new DMap<Integer, Food>(capacity, "record.txt");
			Food objEmp = null;
			while (true) {
				System.out.println("Enter choice only Number: ");
				System.out.println("ADD new food :    1       ");
				System.out.println("Find food    :    2       ");
				System.out.println("Delete food  :    3       ");
				System.out.println("Exit         :    4       ");
				choice = sc.nextInt();
				switch (choice) {
				case 1: {
					key++;

					System.out.println("Enter Name of food  ");
					name = sc.next();
					System.out.println("Enter Dish rating   ");
					rating = sc.nextInt();
					System.out.println("Enter cost of food ");
					cost = sc.nextInt();
					objEmp = new Food(rating, name, cost);
					dmap.put(key, objEmp);
					break;
				}
				case 2: {
					System.out.println("Please Enter Key to find food");
					int keyTofindObj = sc.nextInt();

					Food dish = dmap.get(keyTofindObj);
					if (dish != null) {
						System.out.println(dish.dishName);
						System.out.println(dish.dishRating);
						System.out.println(dish.dishCost);
					} else {
						System.out.println("No such food");
					}
					break;
				}
				case 3: {
					System.out.println("Enter Key to remove food");
					int deleteKey = sc.nextInt();
					Food dish = dmap.remove(deleteKey);
					System.out.println(dish.dishName + " removed");
					break;
				}
				case 4: {
					if (dmap.exit())
						System.exit(0);
				}
				default:
					System.out.println("Wrong Choice");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
