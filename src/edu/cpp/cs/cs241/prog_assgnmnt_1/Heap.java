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
 * @author Isa
 *
 */
public interface Heap<V extends Comparable<V>> {

	public void add(V value);

	public V[] toArray(V[] array);

	public V remove();

	public void fromArray(V[] array);

	public V[] getSortedContents(V[] array);

}
