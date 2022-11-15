/**
 * CET - CS Academic Level 3
 * Declaration: All the works are individually finished by Boyu Li
 * This class contains implements all the functions for a inventory system
 * Student Name: Boyu Li
 * Student Number:041003345
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * 
 */

import java.io.FileNotFoundException;
import java.util.*;

/**
 * The class contains implements all the functions for a inventory system
 * 
 * @author Boyu Li
 * 
 */

public class Assign2 {
	
	/**
	 * this method is the starting point of the program
	 * 
	 * @param args - String array as a parameter
	 */

	public static void main(String args[]){
		//Create a scanner object to receive all the users' input
		Scanner input = new Scanner(System.in);
		//Create a Inventory object to implements all the functions
		Inventory myInventory = new Inventory();
		//Create a integer variable to hold the users' option
		int option = 0;
		/*
		 * do while structure here will keep the program run unless the user enter the exit key
		 */
		do {
			/*
			 * Try catch block to avoid program crash when the invalid input received
			 */
			try {
				//Display the menu here and receive an option from user
			displayMenu();
			option = input.nextInt();
			input.nextLine();
			/*
			 * Switch structure here will based on users' option the program will implement corresponding functions
			 */
			switch(option) {
			//Invoke the addItem method to add a foodItem into inventory array
			case 1:
				myInventory.addItem(input,true);
				break;
			//Invoke the toString method to show all the information of all the foodItem objects
			case 2:
				System.out.println(myInventory.toString());
				break;
			//Invoke the updateQuantity method to implement item buying function
			case 3:
				myInventory.updateQuantity(input, true);
				break;
			//Invoke the updateQuantity method to implement item selling function
			case 4:
				myInventory.updateQuantity(input, false);
				break;
			//Invoke the searchForItem method to implement item searching
			case 5:
				myInventory.searchForItem(input);
				break;
			//Invoke the searchForItem method to implement file writing
			case 6:
				myInventory.saveToFile(input);
				break;
			//Invoke the searchForItem method to implement file reading
			case 7:
				myInventory.readFromFile(input);
				break;
			case 8:
				break;
				/*
				 * When users' input is out of bound, them prompt the user to
				 * enter the correct option
				 */
			default:
				System.out.println("...Invalid input, please try again...");
			}
			}catch(InputMismatchException e) {
				System.out.println("...Invalid input, please try again...");
				input.nextLine();
			}
		}while(option!=8);
		//close the scanner
		input.close();
		System.out.println("Exiting...");
	}
	
	/**
	 * Print the main menu
	 */

	public static void displayMenu() {
		System.out.println("Please select one of the following:");
		System.out.println("1: Add Item to Inventory");
		System.out.println("2: Display Current Inventory");
		System.out.println("3: Buy Item(s)");
		System.out.println("4: Sell Item(s)");
		System.out.println("5: Search for Item");
		System.out.println("6: Save Inventory to File");
		System.out.println("7: Read Inventory from File");
		System.out.println("8: To exit");
		System.out.print("> ");
	}
}
