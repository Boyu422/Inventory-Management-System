
/**
 * CET - CS Academic Level 3
 * Declaration: All the works are individually finished by Boyu Li
 * This class is a parent class for food item, The class contains implements all the functions for the processing of a FoodItem object
 * Student Name: Boyu Li
 * Student Number:041003345
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * 
 */
import java.util.*;

/**
 * This class is a parent class for food item, The class contains implements all
 * the functions for the processing of a FoodItem object
 * 
 * @author Boyu Li
 * 
 */

class FoodItem implements Comparable<FoodItem> {

	/**
	 * Stores the code of a FoodItem object
	 */

	private int itemCode;

	/**
	 * Stores the name of a FoodItem object
	 */

	private String itemName;

	/**
	 * Stores the price of a FoodItem object
	 */

	private float itemPrice;

	/**
	 * Stores the current quantity of the a FoodItem object
	 */

	private int itemQuantityInStock;

	/**
	 * Stores the cost of the a FoodItem object
	 */

	private float itemCost;

	/**
	 * Default Constructor
	 */

	public FoodItem() {
	}

	/**
	 * Override method to return all the information of a foodItem object in a
	 * String
	 * 
	 * @return String value that includes all the information of a foodItem object
	 */

	@Override
	public String toString() {
		// Put all the information of a foodItem object into a string array
		String itemData = "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: $"
				+ String.format("%.2f", itemPrice) + " cost: $" + String.format("%.2f", itemCost) + " ";
		return itemData;
	}

	/**
	 * Updates the quantity field of a foodItem object by users' input
	 * 
	 * @param amount - the change of the quantity amount for an FoodItem object
	 * @return Boolean value that indicates if the quantity of a foodItem object is
	 *         successfully updated
	 */

	public boolean updateItem(int amount) {
		boolean state = true;
		if (amount + itemQuantityInStock < 0) {
			// If the amount after adding is less than zero, that means the quantity error
			// occurs
			state = false;
			return state;
		}
		// If the amount is valid, then update the quantity
		else {
			itemQuantityInStock += amount;
		}
		return state;
	}

	/**
	 * Checks if the other foodItem object has the same item code
	 * 
	 * @param item - the item object that needs to be checked its item code
	 * @return Boolean value that indicates if the foodItem objects have the same
	 *         item code
	 */

	public boolean isEqual(FoodItem item) {
		boolean state = true;
		// To check if the item code of the object with the item code of the object from
		// the arguments is the same
		if (this.itemCode == item.itemCode) {
			return state;
		} else {
			state = false;
			return state;
		}
	}

	/**
	 * Fills all the member fields of a foodItem object with the data that user
	 * input through the Scanner object
	 * 
	 * @param scanner - the Scanner object that is used to read input from users' keyboard or a file
	 * @param fromFile - Boolean values that recognize whether user's input is from a file or keyboard
	 * @return Boolean value that indicates if the method successfully fill all the field members
	 */

	public boolean addItem(Scanner scanner, boolean fromFile) {
		boolean state = true;
		if(fromFile){
		// Read a string from keyboard and update it as the name of the foodItem
		System.out.print("Enter the name for the item: ");
		itemName = scanner.nextLine();
		// Read a integer from keyboard and update it as the quantity of the item
		/*
		 * the do while here will make sure the user enter he valid value
		 */
		do {
			state = true;
			/*
			 * Try catch block to avoid program crash when the invalid input received
			 */
			try {
				System.out.print("Enter the quantity for the item: ");
				int paraQuantity = scanner.nextInt();
				scanner.nextLine();
				if (paraQuantity < 0) {
					System.out.println("Invalid enter");
					state = false;
				} else {
					itemQuantityInStock = paraQuantity;
					state = true;
				}
			} catch (InputMismatchException e) {
				// When the bad input received, the catch block will flush the buffer and make
				// user input again
				System.out.println("Invalid enter");
				state = false;
				scanner.nextLine();
			}
		} while (state == false);

		// Read a float from keyboard and update it as the cost of the item
		/*
		 * the do while here will make sure the user enter he valid value
		 */
		do {
			state = true;
			/*
			 * Try catch block to avoid program crash when the invalid input received
			 */
			try {
				System.out.print("Enter the cost of the item: ");
				float paraCost = scanner.nextFloat();
				scanner.nextLine();
				if (paraCost < 0) {
					System.out.println("Invalid enter");
					state = false;
				} else {
					itemCost = paraCost;
					state = true;
				}
			} catch (InputMismatchException e) {
				// When the bad input received, the catch block will flush the buffer and make
				// user input again
				System.out.println("Invalid enter");
				scanner.nextLine();
				state = false;
			}
		} while (state == false);

		// Read a float from keyboard and update it as the price of the item
		/*
		 * the do while here will make sure the user enter he valid value
		 */
		do {
			state = true;
			/*
			 * Try catch block to avoid program crash when the invalid input received
			 */
			try {
				System.out.print("Enter the sales price of the item: ");
				float paraPrice = scanner.nextFloat();
				scanner.nextLine();
				if (paraPrice < 0) {
					System.out.println("Invalid enter");
					state = false;
				} else {
					itemPrice = paraPrice;
					state = true;
				}
			} catch (InputMismatchException e) {
				// When the bad input received, the catch block will flush the buffer and make
				// user input again
				System.out.println("Invalid enter");
				state = false;
				scanner.nextLine();
			}
		} while (state == false);}
		else {
			//Read the first line of the text and use it as a name of item
			itemName = scanner.nextLine();
			//Read the second line of the text and use it as a quantity of item
			itemQuantityInStock = scanner.nextInt();
			//If the negative number was received, then immediately end the program with the failure processing state
			if(itemQuantityInStock<=0) {
			state = false;
			return state;
			}
			//Skip to the next line of the file
			scanner.nextLine();
			//Read the third line of the text and use it as a cost of item
			itemCost = scanner.nextFloat();
			//If the negative number was received, then immediately end the program with the failure processing state
			if(itemCost<=0){
				state = false;
				return state;
			}
			//Skip to the next line of the file
			scanner.nextLine();
			//Read the fourth line of the text and use it as a price of item
			itemPrice = scanner.nextFloat();
			//If the negative number was received, then immediately end the program with the failure processing state
			if(itemPrice<=0) {
				state = false;
				return state;
			}
			//Skip to the next line of the file
			scanner.nextLine();
		}
		return state;
	}

	/**
	 * Updates the itemCode field of a foodItem object by users' input
	 * 
	 * @param scanner - the Scanner object that is used to read input from users' keyboard or a file
	 * @param fromFile - Boolean values that recognize whether user's input is from a file or keyboard
	 * @return Boolean value that indicates if the item code of foodItem object is successfully be updated
	 */
	public boolean inputCode(Scanner scanner, boolean fromFile) {
		// Read a integer from keyboard and update it as the cost of the item
		/*
		 * the do while here will make sure the user enter he valid value
		 */
		boolean state;
		int code;
		do {
			state = true;
			try {
					//Receive a item code from keyboard or a file
					if(fromFile)
					System.out.print("Enter the code for the item: ");
					code = scanner.nextInt();
					scanner.nextLine();
					itemCode = code;
			} catch (InputMismatchException e) {
				// When the bad input received, the catch block will flush the buffer and make
				// user input again
				System.out.println("Invalid enter");
				scanner.nextLine();
				state = false;
			}
		} while (state == false);
		return state;
	}

	/**
	 * Override method to compare each FoodItem object by their item code
	 * @param foodItem - a FoodItem object that is involved in comparation
	 * @return the result of subtraction of two item codes of two FoodItem objects
	 */
	@Override
	public int compareTo(FoodItem foodItem) {
		//subtract the two item codes to decide which one is bigger to implement the comparation
		return getItemCode() - foodItem.getItemCode();
	}
	
	/**
	 * Getter method to return the itemCode of a FoodItem object
	 * @return the item code of a FoodItem object
	 */
	public int getItemCode() {
		return itemCode;
	}
	
	/**
	 * Using Formatter object to implements writing the basic information of an foodItem object to a text file
	 * @param writer - a Formatter object to write the information of an foodItem object to a text file
	 */
	public void outputItem(Formatter writer) {
		//Using the Formatter object to format the output and write the information of a food item object to a file
		writer.format("%d\n%s\n%d\n%.2f\n%.2f\n", this.itemCode, this.itemName, this.itemQuantityInStock, this.itemCost,
				this.itemPrice);
	}
}
