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

/**
 * This class is used to represent a Customer in the program.
 * @author Isa
 *
 */
public class Customer implements Comparable<Customer>{

	/**
	 * This field is a String that holds the name of the customer.
	 */
	private String name;
	
	/**
	 * This field is an int that holds the priority class of the customer.
	 * It is used to compare the priorities of instances of the class.
	 */
	private int priority;
	
	/**
	 * Constructor that sets the {@link name} and {@link priority} fields.
	 * @param name
	 * The name of the instance of Customer
	 * @param priority
	 * The priority of the instance of Customer.
	 */
	public Customer(String name, int priority){
		this.name = name;
		this.priority = priority;
	}
	
	/**
	 * Returns the name of the Customer.
	 * @return
	 * {@link name}
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Returns the priority class of the Customer.
	 * @return
	 * {@link priority}
	 */
	public int getPriority(){
		return priority;
	}

	/**
	 * Method that overrides Comparables method. Is used to compare the priorities of instances of
	 * the class. If the priority of this instance is greater than that of another instance,
	 * returns 1. If the priority of this instance is less than that of another instance, returns -1.
	 * Else, it returns 0.
	 */
	@Override
	public int compareTo(Customer o) {
		int value = 0;
		
		if(this.priority > o.priority){
			value = 1;
		} else {
			if(this.priority < o.priority){
				value = -1;
			}
		}
		return value;
	}
	
	/**
	 * Prints out the instance of Customer's {@link name} and {@link priority}.
	 */
	public String toString(){
		return ("Name: " + name + "Priority: " + priority);
	}


}
