/**
 * CET - CS Academic Level 3
 * Declaration: All the works are individually finished by Boyu Li
 * This class contains the dynamically allocated FoodItem array and it's processing
 * Student Name: Boyu Li
 * Student Number:041003345
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * The class contains all the basic methods to implement all the functions
 * for main class
 * 
 * @author Boyu Li
 * 
 */

public class Inventory {

	/**
	 * Stores FoodItem objects
	 */
	
	private ArrayList<FoodItem> inventory = new ArrayList<FoodItem>();
	
	/**
	 * Store the number of FoodItem objects currently in the array.
	 */
	
	private int numItems;
	
	/**
	 * Default Constructor
	 */
	
	public Inventory() {}
	
	/**
	 * Override method to return all the information of all foodItem objects in the inventory array
	 * 
	 * @return String value that includes all the information of the foodItem objects in the array
	 */
	
	@Override
	public String toString() {
		String itemData="Inventory: \n";
		//For loop to fetch all the elements in the array
		for(int i = 0; i < numItems; i++) {
			//Put all the information of foodItem objects into a string array
			itemData += inventory.get(i).toString()+"\n";
		}
		return itemData;
	}
	
	/**
	 * Checks if the itemCode of item object is already existed in the inventory array and return its index
	 * @param item - the item object that needs to be checked its item code
	 * @return Integer value that may is the index of the FoodItem object when it is found or -1 when it cannot be found
	 */
	public int alreadyExists(FoodItem item) {
		//For loop to fetch all the elements in the array
		for(int i = 0; i < numItems; i++) {
			//check if any foodItem object has the same value with the food object
			if(inventory.get(i).isEqual(item)) {
				//If it is, return the index
				return i;
			}
		}
		//Otherwise return -1 to represent object not found
		return -1;
	}
	
	/**
	 * Adds an FoodItem object to the inventory array
	 * @param scanner - the Scanner object that is used to read adding option from users' keyboard or file
	 * @param fromFile - Boolean values that recognize whether user's input is from a file or keyboard
	 * @return Boolean value that indicates if the a new FoodItem object is successfully added
	 */
	
	public boolean addItem(Scanner scanner,boolean fromFile) {
		boolean state = true;
		FoodItem newItem=null;
		String itemOption = "";
			/*
			 * The do while structure will keep the program loop until the user enter the valid option 
			 */
		do {
			//prompt the user to input the option for added item
			if(fromFile) {
			System.out.print("Do you wish to add a fruit(f), vegetable(v), preserve(p) or seafood(s)? ");
			}
			state = true;
		itemOption = scanner.nextLine();
		//The switch structure will create different type of objects based on users' choice
		switch(itemOption) {
		/*
		 * When the user want to create a Fruit object, the method will first check if the item code is existed
		 * , then add a fruit item to the inventory array
		 */
		case "f":
			newItem = new Fruit();
			break;
			/*
			 * When the user want to create a Vegetable object, the method will first check if the item code is existed
			 * , then add a Vegetable item to the inventory array
			 */
		case "v":
			newItem = new Vegetable();
			/*
			 * When the user want to create a Preserve object, the method will first check if the item code is existed
			 * , then add a Preserve item to the inventory array
			 */
			break;
		case "p":
			newItem = new Preserve();
			break;
			/*
			 * When the user want to create a SeaFood object, the method will first check if the item code is existed
			 * , then add a SeaFood item to the inventory array
			 */
		case "s":
			newItem = new SeaFood();
			break;
			/*
			 * If the invalid code received, the program will prompt the user and loop again 
			 */
		default:
			System.out.println("Invalid Enter");
			System.out.println("There is no this type of item in inventory");
			state = false;
			break;
		}
		//If the previous steps successfully processed, then start to receive the data of a new item object
		if(state) {
		//If something wrong with code inputting, immediate return the item is failure to create and end the method
		if(newItem.inputCode(scanner,fromFile)==false) {
			state = false;
			return state;
		}
		//If there is no duplicate item code, then starts to add a new foodItem object
		if(alreadyExists(newItem)==-1) {
		//If something wrong with infromation inputting, immediate return the item is failure to create and end the method
		if(newItem.addItem(scanner,fromFile)==false)
		{
			state = false;
			return false;
		}
		//If the previous steps successfully processed, then add the FoodItem to inventory
		inventory.add(newItem);
		numItems++;
		//Sorting the food item in inventory by the item code after adding a new item
		Collections.sort(inventory);
		}
		else {
			//If the duplicated is found then prompt the user and end the method
			System.out.println("Item code already exists");
			state = false;
			return state;
		}
		}
		}while(state==false);
		return state;
	}
	
	/**
	 * Updates the quantity of a specific FoodItem object in the inventory array
	 * @param scanner - the Scanner object that is used to read valid quantity and item code from users' keyboard
	 * @param buyOrSell - to denote the method whether do buying operation or do selling operation 
	 * @return Boolean value that indicates if the quantity of a FoodItem object is successfully updated
	 */
	
	public boolean updateQuantity(Scanner scanner,boolean buyOrSell) {
		boolean state;
		/*
		 * do while structure here will keep the loop unless the user enter the valid value
		 */
		do {
			state = true;
			/*
			 * Try catch block to avoid program crash when the invalid input received
			 */
		try {
		if(buyOrSell) {
			//Checks if the array is empty first
		if(numItems==0) {
			System.out.println("The inventory is empty now...");
			System.out.println("Error...could not buy item");
		}
		else {
			//Create a object to test if the object has the same item code with users' input one
			FoodItem tempItem = new FoodItem();
			//user input the item code for the object first
			tempItem.inputCode(scanner,true);
			//then check if the code is the same with any object
			int index = alreadyExists(tempItem);
			//if not, prompt the user there is no matched item
		if(index == -1) {
			System.out.println("Code not found in inventory...");
			System.out.println("Error...could not buy item");
		}
		//prompt the user to input the quantity
		else {
			System.out.print("Enter valid quantity to buy: ");
			int quantity = scanner.nextInt();
			scanner.nextLine();
			//if the quantity is negative, prompt the user
			if(quantity<0) {
				System.out.println("The quantity cannot be smaller than 0");
				System.out.println("Error...could not buy item");
			}
			//update the value
			else {
			inventory.get(index).updateItem(quantity);
			}
		}
		}
	}
		
		else {
			//Checks if the array is empty first
			if(numItems==0) {
				System.out.println("The inventory is empty now...");
				System.out.println("Error...could not sell item");
			}
			else {
				FoodItem tempItem = new FoodItem();
			try {
				//Create a object to test if the object has the same item code with users' input one
				//user input the item code for the object first
				tempItem.inputCode(scanner,true);
				
				}catch(InputMismatchException e) {
					state = false;
					scanner.nextLine();
					System.out.println("Please only input integer");
					System.out.println("Invliad Enter");
				}
				//then check if the code is the same with any object
				int index = alreadyExists(tempItem);
				//if not, prompt the user there is no matched item
			if(index == -1) {
				System.out.println("Code not found in inventory...");
				System.out.println("Error...could not sell item");
			}
			//prompt the user to input the quantity
			else {
				System.out.print("Enter valid quantity to sell:  ");
				int quantity = scanner.nextInt();
				scanner.nextLine();
				//if the quantity is negative, prompt the user
				if(quantity<0) {
					System.out.println("The quantity cannot be smaller than 0");
					System.out.println("Error...could not buy item");
				}
				else {
					//update the value
				state = inventory.get(index).updateItem(-quantity);
				//If quantity is too large, prompt the user
				if(state==false) {
					System.out.println("Insufficient stock in inventory...");
					System.out.println("Error...could not sell item");
					break;
				}
			}
			}
			}
		}
		}catch(InputMismatchException  e) {
			//If there is invalid input, flush the buffer and make user enter again
			state = false;
			scanner.nextLine();
			System.out.println("Please only input integer");
			System.out.println("Invliad Enter");
		}
		}while(state == false);
		return  state;
	}
	
	/**
	 * Implements binary search to retrieve specific food item
	 * @param scanner - the Scanner object that is used to read item code from users' keyboard
	 */
	public void searchForItem(Scanner scanner) {
		//Create a foodItem object foe search
		FoodItem tempItem = new FoodItem();
		//Get an item code for a FoodItem object 
		tempItem.inputCode(scanner,true);
		//Creates two variables as the starts and the end points of searching
		int low = 0;
		int high = inventory.size() - 1;
		  /*
		   * The searching will keep until the all the elements between start and end points are checked
		   */
		  while (low <= high) {
			  //initialized the mid point value at each start of the loop
			  //to make sure it is always at the middle of the end and start points
		    int mid = (low + high) / 2;
		    //If the item code is the target item code, then return the information of that item
		    if (inventory.get(mid).compareTo(tempItem)==0) {
		      System.out.println(inventory.get(mid));
		      return;
		      //If the item code is greater than the target item code, then starts the new searching from the right side
		    } else if (inventory.get(mid).compareTo(tempItem)>0) {
		    	high = mid - 1;	
		    	//If the item code is less than the target item code, then starts the new searching from the left side
		    } else {
		    	low = mid + 1;;
		    }
		  }
		  //If code not found after searching, then prompt the user
		  System.out.println("Code not found in inventory...");
	}
	
	/**
	 * Writes all the information of each food item in inventory ArrayList to a text file
	 * @param scanner - the Scanner object that is used to write information to a text file
	 */
	public void saveToFile(Scanner scanner){
		//Make the user to enter the name of the file
		System.out.print("Enter the filename to save to ");
		String fileName = scanner.nextLine();
		/*
		 * Implements try catch block to protect the program crash from file not found
		 * formatter close, no element, and no write permission exception 
		 */
		try {
		//Create a new Formatter object for file writing
		Formatter output = new Formatter(fileName);
		//For loop to output the information of each food item object
		for(int i = 0; i < inventory.size(); i++) {
			inventory.get(i).outputItem(output);
		}
		//Close the formatter
		output.close();
		}catch(FileNotFoundException fileNotFoundException) {
			System.out.println("File Not Found, ignoring...");
		}catch(FormatterClosedException formatterClosedException) {
			System.out.println("Error writing to file. Terminating.");
		}catch(NoSuchElementException elementException) {
			System.out.println("Invalid input. Please try again.");
			scanner.nextLine();
		}catch(SecurityException securityExcpetion) {
			System.out.println("Write permission denied. Terminating");
		}
	}
	
	/**
	 * Adds all the information of each food item from a text file to inventory ArrayList
	 * @param scanner - the Scanner object that is used to read information from a text file
	 */
	public void readFromFile(Scanner scanner){
		//Make the user enter the name of a file and initialize a File object with that name
		System.out.print("Please enter the name of the file: ");
		String fileName = scanner.nextLine();
		File targetFile = new File(fileName);
		/*
		 * Implements try catch block to protect the program crash from file not found
		 * mismatched input type, no element, and no read permission exception 
		 */
		try {
		scanner = new Scanner(targetFile);
		/*
		 * while loop to make sure all the content in the file can be read and make sure the reading will end
		 * when there is no element
		 */
		while(scanner.hasNextLine()) {
		if(addItem(scanner,false)==false) {
			//If the item is not successfully created, the method won't continue to read and stop the reading
			System.out.println("Error Encountered while reading the file, aborting...");
			break;
		}
		}
		}catch(FileNotFoundException fileNotFoundExcpetion) {
			System.out.println("File Not Found, ignoring...");
		}catch(InputMismatchException e) {
			System.out.println("Error Encountered while reading the file, aborting...");
		}catch(SecurityException securityExcpetion) {
			System.out.println("Read permission denied. Terminating");
		}catch(NoSuchElementException elementException) {
			System.out.println("Invalid input. Please try again.");
			scanner.nextLine();
		}
	}
}
