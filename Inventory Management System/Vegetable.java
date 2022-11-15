/**
 * CET - CS Academic Level 3
 * Declaration: All the works are individually finished by Boyu Li
 * This class is a child class of FoodItem. it contains the functions to fill and print the data for a Vegetable object
 * Student Name: Boyu Li
 * Student Number:041003345
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * 
 */

import java.util.*;

/**
 * This class is a child class of FoodItem. it contains the functions to fill and print the data for a Vegetable object
 * And writes them to a text file 
 * @author Boyu Li
 * 
 */

public class Vegetable extends FoodItem{
		
	/**
	 * Stores the farm name of a fruit object
	 */
	
	String farmName;
	
	/**
	 * Default Constructor
	 */
	
	public Vegetable() {}
	
	/**
	 * Override method to return all the information of a Vegetable object in a String
	 * 
	 * @return String value that includes all the information of a Vegetable object
	 */
	
	@Override
	public String toString() {
		//Put all the information of a preserve object into a string array
		String extraData = super.toString()+"farm supplier: "+farmName;
		return extraData;
	}
	
	/**
	 * Override method to read all the information of a Vegetable object from a text file or keybaord
	 * @param scanner - the Scanner object that is used to read information from a text file
	 * @param fromFile - Boolean values that recognize whether user's input is from a file or keyboard
	 * @return Boolean value that indicates if a Vegetable item has been successfully added
	 */
	@Override
	public boolean addItem(Scanner scanner,boolean fromFile) {
		//First make user input the basic elements for a FoodItem object
		boolean state = true;
		if(super.addItem(scanner,fromFile)==false) {
			state = false;
			return state;
		}
		//Then make the user input the name of the farm supplier
		if(fromFile)
		System.out.print("Enter the name of the farm supplier: ");
		farmName = scanner.nextLine();
		return state;
	}
	
	/**
	 * Writes all information of a vegetable object to a text file
	 * @param writer - the Formatter object to write the information of a Vegetable object to a file
	 */
	public void outputItem(Formatter writer) {
		//First write the type identifier to a file
		writer.format("v\n");
		//Then inherit the output method from parent class to output the basic information of a food item object
		super.outputItem(writer);
		//Lastly Write the extra information of a vegetable object to a file 
		writer.format("%s\n",farmName);
	}
}
