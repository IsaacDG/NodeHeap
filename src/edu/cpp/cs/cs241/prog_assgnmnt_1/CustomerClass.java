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
 * This enum is used to dynamically add and remove customer classes for use in the Restaurant program.
 * To add, simply type in an enum with a constructed string in the desired place.
 * @author Isa
 *
 */
public enum CustomerClass {

	VIP("VIP"), ADVANCE("Advance Call"), SENIOR("Senior"), VETERAN("Veteran"), LARGE(
			"Large Group(more than 4)"), FAMILY("Family with children"), OTHER(
			"None of the above");

	/**
	 * String that describes the category.
	 */
	private String category;
	
	/**
	 * Constructor so that {{@link #category} can be set.
	 * @param category
	 * The string that we want to set to {{@link #category}.
	 */
	CustomerClass(String category) {
		this.category = category;
	}
	
	/**
	 * Returns the string held in {{@link #category}
	 * @return
	 * {{@link #category}
	 */
	public String getCategory(){
		return category;
	}
	
}
