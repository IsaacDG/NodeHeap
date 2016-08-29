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
 * This class is where the UserInterface interacts with the actual Heap data structure.
 * The Heap is constructed based on the input the user provides the the UI.
 * @author Isa
 *
 */
public class Engine {

	/**
	 * UserInterface instance that is used to interact with the user.
	 */
	UserInterface ui;
	
	/**
	 * The actual heap data structure that will be used to hold the data.
	 */
	NodeHeap<Customer> heap;
	
	/**
	 * Creates a new instance of UserInterface called ui and a new instance of NodeHeap
	 * called heap that is of type Customer.
	 */
	public Engine(){
		ui = new UserInterface();
		
		heap = new NodeHeap<Customer>();
	}
	
	/**
	 * Runs the program. Uses a loop to keep asking for user input until they enter a 3.
	 * Uses various UserInterface methods in order to execute the program and take in input.
	 */
	public void run(){
		int choice = 0;
		do{
			choice = ui.prompt();
			if(choice == 1){
				ui.seating(heap.remove());
				if(heap.size() != 0){
					ui.topCustomer(heap.getRoot());
				}
			} else if(choice == 2){
				heap.add(ui.getNextCustomer());
				ui.topCustomer(heap.getRoot());
			}
			
		} while(choice != 3);
		ui.endUI();
		System.exit(0);
	}
	
}
