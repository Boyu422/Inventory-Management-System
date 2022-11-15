/**
 * CET - CS Academic Level 3
 * Declaration: All the works are individually finished by Boyu Li
 * This class is a child class of FoodItem. it contains the functions to fill and print the data for a Preserve object
 * Student Name: Boyu Li
 * Student Number:041003345
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * 
 */

import java.util.*;

/**
 * This class is a child class of FoodItem. it contains the functions to fill and print the data for a Preserve object 
 * And writes them to a text file 
 * 
 * @author Boyu Li
 * 
 */

public class Preserve extends FoodItem{
	
	/**
	 * Stores the jar size of a Preserve object
	 */
	
	int jarSize;
	
	/**
	 * Default Constructor
	 */
	
	public Preserve() {}
	
	/**
	 * Override method to return all the information of a Preserve object in a String
	 * 
	 * @return String value that includes all the information of a Preserve object
	 */
	
	@Override
	public String toString() {
		//Put all the information of a preserve object into a string array
		String extraData = super.toString()+"size: "+jarSize+"mL";
		return extraData;
	}
	
	/**
	 * Override method to read all the information of a Preserve object from a text file or keyboard
	 * @param scanner - the Scanner object that is used to read information from a text file
	 * @param fromFile - Boolean values that recognize whether user's input is from a file or keyboard
	 * @return Boolean value that indicates if a Preserve item has been successfully added
	 */
	
	@Override
	public boolean addItem(Scanner scanner,boolean fromFile) {
		boolean state = true;
		//If the previous process failed, then immediately end the method with failure state
		if(super.addItem(scanner,fromFile)==false) {
			state = false;
			return state;
		}		
		//Then make the user input the size of the jar or read from a file
		int paraSize=0;
		/*
		 *  the do while here will make sure the user enter the valid value
		 */
		do {
			if(fromFile)
			System.out.print("Enter the size of the jar in millilitres: ");
			state = true;
			/*
			 *  Try catch block to avoid program crash when the invalid input received
			 */
			try {
			paraSize = scanner.nextInt();
			scanner.nextLine();
			//When the method read size of jar from a file and the size is a negative number
			//Then immediately end the method with failure state
			if(fromFile == false) {
			if(paraSize<0) {
				state = false;
				return state;
			}
			}
			//When the positive number received from keyboard, the method will make the user input again
		if(fromFile) {
		if(paraSize<0) {
			System.out.println("Please only enter postive number");
			state = false;
		}
		//Once the valid input received, put it as a size of jar of a preserve
		else {
			jarSize = paraSize;
		}
		}
	}catch(InputMismatchException e){
		state = false;
		System.out.println("Please only enter integer");
		System.out.println("Invalid entry");
		scanner.nextLine();
	}
		}while(state==false);
		return state;
}
	
	/**
	 * Writes all information of a Fruit object to a text file
	 * @param writer - the Formatter object to write the information of a Preserve object to a file
	 */
	public void outputItem(Formatter writer) {
		//First write the type identifier to a file
		writer.format("p\n");
		//Then inherit the output method from parent class to output the basic information of a food item object
		super.outputItem(writer);
		//Lastly Write the extra information of a preserve object to a file 
		writer.format("%d\n",jarSize);
	}
}
