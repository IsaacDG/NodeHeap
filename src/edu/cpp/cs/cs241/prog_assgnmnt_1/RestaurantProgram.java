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
 * This is the main class of the Restaurant program.
 * @author Isa
 *
 */
public class RestaurantProgram {

	/**
	 * Simply runs the program using the Engine method.
	 * @param args
	 * default
	 */
	public static void main(String[] args) {
		run();
	}
	
	/**
	 * Creates a new Engine called program, and uses the {@code run()} method to execute the
	 * program.
	 */
	public static void run(){
		Engine program = new Engine();
		program.run();
	}
}


