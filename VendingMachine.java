package vending;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachine {
	
	private int numItems;
	private VendingItem [] items;
	private double money;
	
	public VendingMachine() {
		try {
			Scanner fileScanner= new Scanner(new File("food.txt"));
			//number of items at the top of the file, so we know the size of array allocation
			numItems=fileScanner.nextInt();
			//use the number of items to initialize array of items (member variable)
			items= new VendingItem[numItems];
			//read in the blank line after the number
			fileScanner.nextLine();
			for(int i=0; i<numItems; i++) {
				String itemData=fileScanner.nextLine();
				String [] itemInfo=itemData.split(",");
				String kind=itemInfo[0];
				double price=Double.parseDouble(itemInfo[1]);
				int quantity=Integer.parseInt(itemInfo[2]);
				items[i]= new VendingItem(kind, quantity, price);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File exception generated!");
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		VendingMachine vm = new VendingMachine();
		do {
			System.out.println("Welcome to my vending machine! What would you like to do?");
			System.out.println("1. Insert Money");
			System.out.println("2. Display items");
			System.out.println("3. Purchase items");
			System.out.println("4. Get change");

			Scanner input= new Scanner(System.in);
			int choice= input.nextInt();

			switch(choice) {
			case 1:
				System.out.println("How much money do you wish to insert?");
				double moneyIn= input.nextDouble();
				vm.insertMoney(moneyIn);
				break;
			case 2:
				vm.displayItems();
				break;
			case 3:
				System.out.println("Which item number do you wish to purchase?");
				int itemNum= input.nextInt();
				vm.purchaseItem(itemNum);
				break;
			case 4:
				System.out.println("Your change is "+ vm.getChange());
				return;
			}
			
		}while(true);

	}

	private String getChange() {
		return money+ ""; //need to add empty string to change the type to String since money is a double
	}

	private void purchaseItem(int itemNum) {
		if(items[itemNum].getPrice()<=money&&items[itemNum].getQuantity()>0) {
		//tell the user they got the item
			System.out.println("Congratulations! You now own "+items[itemNum].getKind());
			//remove the item by reducing the quantity
			items[itemNum].setQuantity(items[itemNum].getQuantity()-1);
			//remove the cost of the item from the balance
			 money-=items[itemNum].getPrice();
		}
		
	}

	private void displayItems() {
		for(int i=0; i<numItems; i++) {
			System.out.println(i+":"+items[i].toString());
		}
	}

	private void insertMoney(double moneyIn) {
		money+=moneyIn;
		
	}

}
