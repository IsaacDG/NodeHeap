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
 * This class is used to represent a Node in the NodeHeap class.
 * @author Isa
 *
 */
public class Node<V extends Comparable<V>> {
	
	/**
	 * This is the data that is stored in the node.
	 */
	private V data;
	
	/**
	 * This is the index of the node in the heap.
	 */
	private int nodeNum;
	
	/**
	 * These are links to other nodes so we can maintain a binary tree structure.
	 */
	private Node<V> parent, leftChild, rightChild;
	
	/**
	 * This constructor is used when we know the data and the index of the element.
	 * The children of the new node are set to {@code null} by default.
	 * @param data
	 * The data of the node
	 * @param nodeNum
	 * The index of the node.
	 */
	public Node(V data, int nodeNum){
		this.data = data;
		leftChild = null;
		rightChild = null;
		this.nodeNum = nodeNum;
	}
	
	/**
	 * This contructor is used when we know the data, the index, and the parent of the node we want
	 * to add. The children are set to {@code null} by default.
	 * @param data
	 * The data of the node.
	 * @param parent
	 * The parent of the node.
	 * @param nodeNum
	 * The index of the node.
	 */
	public Node(V data, Node<V> parent, int nodeNum){
		this.data = data;
		leftChild = null;
		rightChild = null;
		this.nodeNum = nodeNum;
	}
	
	/**
	 * Returns the data stored in the node.
	 * @return
	 * {{@link #data}
	 */
	public V getData(){
		return data;
	}
	
	/**
	 * Returns the Node stored in {{@link #leftChild}
	 * @return
	 * {{@link #leftChild}
	 */
	public Node<V> getLeft(){
		return leftChild;
	}
	
	/**
	 * Returns the Node stored in {{@link #rightChild}
	 * @return
	 * {{@link #rightChild}
	 */
	public Node<V> getRight(){
		return rightChild;
	}
	
	/**
	 * Returns the Node stored in {{@link #parent}
	 * @return
	 * {{@link #parent}
	 */
	public Node<V> getParent(){
		return parent;
	}
	
	/**
	 * Returns the index of the node.
	 * @return
	 * {{@link #nodeNum}
	 */
	public int getNum(){
		return nodeNum;
	}
	
	/**
	 * Setter that sets the data of the Node.
	 * @param data
	 * The data we want to set.
	 */
	public void setData(V data){
		this.data = data;
	}
	
	/**
	 * Setter that sets the Node of the left child.
	 * @param newNode
	 * The node we want to set {{@link #leftChild} to.
	 */
	public void setLeft(Node<V> newNode){
		leftChild = newNode;
	}
	
	/**
	 * Setter that sets the Node of the right child.
	 * @param newNode
	 * The node we want to set{{@link #rightChild} to.
	 */
	public void setRight(Node<V> newNode){
		rightChild = newNode;
	}
	
	/**
	 * Setter that sets the Node of the parent of this Node.
	 * @param parent
	 * The node we want to set {{@link #parent} to.
	 */
	public void setParent(Node<V> parent){
		this.parent = parent;
	}
	
	/**
	 * Setter that sets the index of the Node.
	 * @param nodeNum
	 * The value we want to set {{@link #nodeNum} to.
	 */
	public void setNum(int nodeNum){
		this.nodeNum = nodeNum;
	}
	
	/**
	 * Returns true if both the leftChild and rightChild are null.
	 * @return
	 * True if leftChild and rightChild are equal to null. False otherwise.
	 */
	public boolean isLeaf(){
		return (leftChild == null) && (rightChild == null);
	}
	
	/**
	 * Returns true if both the leftChild and rightChild are NOT null.
	 * @return
	 * True if both leftChild and rightChild fields are NOT null. False otherwise.
	 */
	public boolean isFull(){
		return (getLeft() != null) && (getRight() != null);
	}

}
