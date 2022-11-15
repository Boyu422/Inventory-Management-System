/**
 * CET - CS Academic Level 3
 * Declaration: All the works are individually finished by Boyu Li
 * This class is a child class of FoodItem. it contains the functions to fill and print the data for a SeaFood object
 * Student Name: Boyu Li
 * Student Number:041003345
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * 
 */

import java.util.*;

/**
 * This class is a child class of FoodItem. it contains the functions to fill and print the data for a SeaFood object
 * And writes them to a text file 
 * @author Boyu Li
 * 
 */

public class SeaFood extends FoodItem{
	
	/**
	 * Stores the factory name of a SeaFood object
	 */
	
	String factoryName;
	
	/**
	 * Default Constructor
	 */
	
	public SeaFood() {}
	
	/**
	 * Override method to return all the information of a SeaFood object in a String
	 * 
	 * @return String value that includes all the information of a SeaFood object
	 */
	
	@Override
	public String toString() {
		//Put all the information of a preserve object into a string array
		String extraData = super.toString()+"marine products supplier: "+factoryName;
		return extraData;
	}
	
	/**
	 * Override method to read all the information of a SeaFood object from a text file or keyboard
	 * @param scanner - the Scanner object that is used to read information from a text file
	 * @param fromFile - Boolean values that recognize whether user's input is from a file or keyboard
	 * @return Boolean value that indicates if a SeaFood item has been successfully added
	 */
	
	@Override
	public boolean addItem(Scanner scanner, boolean fromFile) {
		boolean state = true;
		//First make user input the basic elements for a FoodItem object
		if(super.addItem(scanner,fromFile)==false) {
			state = false;
			return state;
		}
		//Then make the user input the name of the marine products supplier
		if(fromFile)
		System.out.print("Enter the name of the marine products supplier: ");
		factoryName = scanner.nextLine();
		return state;
	}
	
	/**
	 * Writes all information of a vegetable object to a text file
	 * @param writer - the Formatter object to write the information of a SeaFood object to a file
	 */
	@Override
	public void outputItem(Formatter writer) {
		//First write the type identifier to a file
		writer.format("s\n");
		//Then inherit the output method from parent class to output the basic information of a food item object
		super.outputItem(writer);
		//Lastly Write the extra information of a SeaFood object to a file 
		writer.format("%s\n",factoryName);
	}
}
