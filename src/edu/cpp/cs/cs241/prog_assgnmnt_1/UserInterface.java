/**
 * CS 241: Data Structures and Algorithms II
 * Professor: Edwin Rodríguez
 *
 * Programming Assignment #1
 *
 * Implementation of Heap data strcuture using linked nodes.
 * An application that uses the heap data structure to implement a priority queue at a
 * restaurant.
 *
 * Isaac Gonzalez
 */
package edu.cpp.cs.cs241.prog_assgnmnt_1;

import java.util.Scanner;

/**
 * This class handles all the interaction between the user and the Restaraunt application.
 * Recieves all input and transfers it to the engine.
 * @author Isa
 *
 */
public class UserInterface{

	/**
	 * Scanner to take in user input.
	 */
	private static Scanner kb;
	
	/**
	 * Initializes the Scanner to take user input.
	 */
	public UserInterface() {
		kb = new Scanner(System.in);
	}
	
	/**
	 * Closes {@link kb}
	 */
	public void endUI(){
		System.out.println("Ending the program.");
		kb.close();
	}

	/**
	 * Initializes an int variable called choice to take in user input. This method prints out
	 * The 3 different options the user has and validates user input. Returns the input.
	 * @return
	 * {@code choice}
	 */
	public int prompt(){
		int choice = 0;
		System.out.println("Please choose a function: ");
		System.out.println("1. Seat the next available customer.");
		System.out.println("2. Queue a customer.");
		System.out.println("3. Exit the program.");
		choice = validateNumber();
		
		return choice;
	}
	
	public void seating(Customer removed){
		System.out.println("Seating: " + removed.getName() + ".");
		System.out.println();
	}
	
	/**
	 * Asks the user for a name for the customer. Then, it uses the {{@link #promptPriority()} method to
	 * ask the user for the priority of the customer. After both the name and the priority are determined,
	 * the two values are used to create a new instance of the {@link Customer} class.
	 * @return
	 * The newly created instance of Customer.
	 */
	public Customer getNextCustomer() {

		String name;
		int priority = 0;
		System.out
				.print("Please enter the name of the next customer to be seated: ");
		name = kb.nextLine();
		priority = promptPriority();
		
		Customer nextCustomer = new Customer(name, priority);
		return nextCustomer;
		
	}
	
	/**
	 * Prints out the name of a Customer.
	 * @param customer
	 * The Customer instance that will be used.
	 */
	public void topCustomer(Customer customer){
		System.out.println("Next customer to be seated is: " + customer.getName());
		System.out.println();
	}

	/**
	 * Uses the Customer Class enum to print through each type of priority class.
	 * Uses the count variable to make the correct priority will be paired with the
	 * correct type of priority.
	 * @return
	 * The choice of the user.
	 */
	public int promptPriority(){
		int count = CustomerClass.values().length;
		int priority = 0;
		System.out.println('\n' + "Enter the number corresponding to this customer's priority: ");
		for(CustomerClass c : CustomerClass.values()){
			System.out.println(count-- + ". " + c.getCategory());
		}
		priority = validateNumber();
		
		return priority;
	}
	
	/**
	 * Asks the user to input a int until the conditions are met. If the input is not an
	 * integer or if the input is less than 0, it will keep asking for new input.
	 * @return
	 * The validated input of the user.
	 */
	public int validateNumber(){
		int num = 0;
		do {
	        while (!kb.hasNextInt()) {
	            System.out.print("Please enter a valid number: ");
	            kb.next();
	        }
	        num = kb.nextInt();
	        kb.nextLine();
	    } while (num <= 0);
		return num;
	}
}
