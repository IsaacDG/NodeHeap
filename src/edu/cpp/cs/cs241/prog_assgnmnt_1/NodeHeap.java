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
 * This class is an implementation of the heap data structure using Nodes. The Nodes are linked like a linked
 * list, but have 3 links. One for the parent, and 2 for the children.
 * @author Isa
 *
 */
public class NodeHeap<V extends Comparable<V>> implements Heap<V> {

	/**
	 * Keeps track of the first node in the heap. This is the node that is at the very top
	 * of the heap, and is the largest element in it.
	 */
	Node<V> root;
	
	/**
	 * The last element that was added to the heap.
	 */
	Node<V> lastElement;
	
	/**
	 * The number of elements that are in the heap.
	 */
	private int numElements;
	
	/**
	 * Default constuctor that sets the root to null and the number of elements to 0.
	 */
	public NodeHeap(){
		root = null;
		
		numElements = 0;
	}
	
	/**
	 * This method wraps around the {{@link #add(Node, Node)} method. A value is passed in
	 * that we want to add. First it checks the base case where the heap is empty. If it is empty,
	 * The root is set to a new Node with the value we want to add. Otherwise, we use the {{@link #add(Node, Node)}
	 * method to add a new node at the deepest, left most node and sift it up.
	 */
	@Override
	public void add(V value) {
		
		Node<V> addedNode;
		
		if(root == null){
			root = new Node<V>(value, null, 0); //makes sure the element index of the first node is 0, for array purposes.
			addedNode = root;
		} else {
			addedNode = add(root, new Node<V>(value, numElements));
			siftUp(addedNode);
		}
		
		lastElement = addedNode;
		++numElements;
		
	}
	
	/**
	 * This method starts by identifying the parent node of the node we want to sift up.
	 * If the parent is not a null node, the data of the parent node and the current node
	 * are compared. If the parent node is smaller, then the nodes data is swapped.
	 * Next, the parent is sifted up to continue the sifting up process recursively.
	 * @param current
	 * The current node that needs to be compared and checked for possible sifting.
	 */
	public void siftUp(Node<V> current){
		
		Node<V> parent = current.getParent();
		
		if(parent != null){
			V parentData = parent.getData();
			
			V targetData = current.getData();
			
			if(targetData.compareTo(parent.getData()) > 0){
				parent.setData(targetData);
				current.setData(parentData);
			}
			
			siftUp(parent);
		}
	
	}
	
	/**
	 * This method is used to find the correct path to the deepest, left-most node. First, the location(or index)
	 * of the parent node is calculated by getting the index of the node to add and using the basic parent finding
	 * equation on that value. If the parent index is equal to the index of the node that was used to begin the path
	 * (or origin node), then the path to add is chosen by simply figuring out whether to add the node to the origin node's
	 * left or right child.
	 * 
	 * If the origin index is not the parent of the node we want to add, a loop is used to find the parent of
	 * the parent of the node we want to add. The loop executes until the ancestor node's index finds the origin node's
	 * index. This loop essentially traverses the heap upwards until it finds the origin node.
	 * 
	 * After the origin node is found, a conditional statement is used to determine which path the next
	 * instance of the method should take. It does this by using the ancestor node's index to figure out
	 * if it should go left or right using the modulus operation. Once the path is found, this method is called
	 * again using a new origin node, which is the path we just found, and the same node we want to add.
	 * @param origin
	 * The node that the path of the method originates from. It starts from the top to find which path it should
	 * take downwards.
	 * @param addNode
	 * The node we want to add, we need the information like its index to perform many of the operations in this
	 * method.
	 * @return
	 * The node we added.
	 */
	public Node<V> add(Node<V> origin, Node<V> addNode){
		
		int parent = (addNode.getNum() - 1) / 2; //find parent index
		
		if(parent == origin.getNum()){ //if the parent of the node to add is the node that began the path of the method call
									   //then find the path to add by checking existence of left and right children.
			if(origin.getLeft() == null){
				origin.setLeft(addNode);
			} else {
				origin.setRight(addNode);
			}
			addNode.setParent(origin);
			
		} else {
			
			int ancestor = parent;
			while(((ancestor - 1) / 2) > origin.getNum()){ //loop to traverse heap upwards to find origin node index.
				ancestor = (ancestor - 1) / 2;
			}
			Node<V> path = ((ancestor % 2) == 1) ? origin.getLeft() : origin.getRight();
			addNode = add(path, addNode);
		}
		
		return addNode;
		
	}
	
	
	
	/**
	 * This method is used to find a specific node in the heap. A {@code int} value is passed
	 * in, and a Node is set to the root. Using Integer, the binary value of the int passed in is 
	 * found and stored in a char array called {@code binary}.
	 * A for loop is then used to process every bit(except the first) of the char array. If the bit value is '0',
	 * then the cursor node traverses to its left child. If the bit value is '1', then the cursor node
	 * traverses to its right child. Once the traversing is done, the Node in the place we wanted to find
	 * is returned.
	 * @param place
	 * The place in the heap that we want the node for.
	 * @return
	 * The node in the place we wanted to find.
	 */
	public Node<V> findPlace(int place){
		int n = place; 
		Node<V> cursor = root;
		
		char[] binary = Integer.toBinaryString(n).toCharArray();
		char bit;
		for(int i = 1; i < binary.length; i++){
			bit = binary[i];
			if(bit == '0'){
				cursor = cursor.getLeft();
			} else {
				cursor = cursor.getRight();
			}
		}
		return cursor;
	}
	
	public void printInorder(Node<V> root) {
	    if (root == null) return;
	    printInorder(root.getLeft());
	    System.out.print("Hi, i am "+ root.getData() +" and my parent is ");
	    if (root.getParent() == null) System.out.println ("NULL");
	        else System.out.println(root.getParent().getData() + ". I am element " + root.getNum());
	    printInorder(root.getRight());
	    }
	
	/**
	 * This method simply traverses the NodeHeap. It visits every node using the {{@link #traverse(Node, Comparable[])}
	 * method and adds each element to the array. After the method is done, it returns the array.
	 */
	@Override
	public V[] toArray(V[] array) {
		array = traverse(root, array);
		
		return array;
	}

	/**
	 * This method traverses the entire NodeHeap, no matter what size it is. A Node is passed in as an argument and is
	 * treated as a cursor. If the cursor is not null, then the element of the cursor node is added to the array
	 * by getting the {@code getNum()} method of the Node class. This returns the element index of the Node, which
	 * is also the index of the place in the array that the element belongs to. The element in the array is set to
	 * the data of the cursor node. Then, {{@link #traverse(Node, Comparable[])} is called recursively on the
	 * cursors children to repeat the process until the entire tree has been traversed.
	 * @param cursor
	 * The node we want to add to the array, and the node we want the children for.
	 * @param array
	 * The array we want to add elements to.
	 * @return
	 * The complete array representation of the heap.
	 */
	public V[] traverse(Node<V> cursor, V[] array){
		
		if(cursor != null){
			array[cursor.getNum()] = cursor.getData(); //set element in array.
			traverse(cursor.getLeft(), array);
			traverse(cursor.getRight(), array);
		}
		return array;
		
	}

	/**
	 * This method is used to remove an element from the heap. This will always remove the data at the root of the
	 * heap. First, the base case is checked where the root is the only element in the heap. If this is the case,
	 * the root is simply set to null. Otherwise, {{@link #lastElement} is found by using the {{@link #findPlace(int)}
	 * method. The root data is then set to {{@link #lastElement}'s data and the parent of the last element is found.
	 * If the parent of the last element is full, then that means we need to remove the right child. If it is not full,
	 * then we remove the left child. Lastly, the recursive method {{@link #siftDown(Node)} is called on the root
	 * to maintain the heap structure.
	 */
	@Override
	public V remove() { //beta
		
		V removed = null;
		
		if(numElements != 0){ //if there are elements in the heap at all
			removed = root.getData();
			
			if(numElements == 1){ //base case
				root = null;
			} else {
				lastElement = findPlace(numElements); //find the deepest, left-most node.
				root.setData(lastElement.getData()); //set root data to the last node.
				Node<V> parentOfLast = lastElement.getParent();
				if(parentOfLast.isFull()){ //check the structure of the bottom of the tree to determine where to remove.
					parentOfLast.setRight(null);
				} else {
					parentOfLast.setLeft(null);
				}
				siftDown(root);
			}
			
			--numElements;
		}
		return removed;
	}
	
	/**
	 * This is a recursive method that sifts a Node down the heap structure to maintain the rules of the heap.
	 * First, the base case is checked where the node being sifted is a leaf. If it is a leaf, then the method
	 * simply terminates. Otherwise, The data of the child nodes is found. 
	 * 
	 * All swaps are only made if the data in a child is greater than the data in the current node.
	 * 
	 * If the node only has one child(the left child),
	 * then the current nodes data is only compared to the left child's data. Otherwise, the method checks if 
	 * either of the children are greater than the parent nodes data. If one of them is, the data of the children
	 * is compared to figure out which child the parent's data should be swapped to. Once the data is swapped,
	 * the method is called recursively on the sifted down node.
	 * @param current
	 * The current node that needs to be checked for sifting.
	 */
	public void siftDown(Node<V> current){
		
		if(!current.isLeaf()){
			Node<V> left = current.getLeft();
			Node<V> right = current.getRight();
			
			V leftData = left.getData();
			V currentData = current.getData();
			V rightData;
			if(!current.isFull()){
				if(currentData.compareTo(leftData) < 0){
					left.setData(currentData);
					current.setData(leftData);
					current = left;
					siftDown(current);
					
				}
			} else {
				rightData = right.getData();
				
				if((currentData.compareTo(leftData) < 0) || (currentData.compareTo(rightData) < 0 )){
					if(leftData.compareTo(rightData) < 0 || leftData.compareTo(rightData) == 0){
						right.setData(currentData);
						current.setData(rightData);
						current = right; //keeps track of which direction the sift happened.
					} else {
						left.setData(currentData);
						current.setData(leftData);
						current = left; //keeps track of which direction the sift happened.
					}
					siftDown(current); //sift in the new direction.
				}
				
			}
		}
		
	}

	/**
	 * This method simply takes in any array of elements and adds each element to the heap.
	 */
	@Override
	public void fromArray(V[] array) {
		for(V data : array){
			add(data); //add element to heap.
		}
	}

	/**
	 * This method sends the heap to its array form, which is unsorted. Once the array form is computed, the method returns
	 * {{@link #heapSort(Comparable[])} called on that array.
	 */
	@Override
	public V[] getSortedContents(V[] array) {
		
		array = toArray(array); //send heap to array.

		return heapSort(array); //return the sorted array.
	}
	
	/**
	 * This method is used to heapify an array. This method is not used throughout the code, but I wanted to try
	 * to implement it any way. First, the last non-leaf element is found. Then, the base case is checked. If
	 * the heap only has one element, then nothing happens.
	 * Otherwise, a loop is executed that calls the {{@link #arraySiftDown(Comparable[], int, int)} method on
	 * the last non leaf element. The loop then goes through each element before the last non leaf element until
	 * it is at the root. Because of the properties of sift down, this heapifies the array.
	 * @param array
	 * The array we want to heapify.
	 * @return
	 * The heapified array.
	 */
	public V[] heapify(V[] array){
    	int index = (array.length / 2) - 1;
		if(array.length != 1){
			while(index != -1){
				arraySiftDown(array, index, array.length);
				index -= 1;
			}
		}
		return array;
	}
	
	/**
	 * This method sorts a heapified array. In order to do this, a variable called {@code unsorted} is kept track of.
	 * At first, unsorted is the size of the array passed in, because the entire array is unsorted. A while-loop
	 * is then executed until {@code unsorted} is equal to 1. In the loop, the {{@link #swap(Comparable[], int, int)}
	 * method is called, swapping the first element in the array with the last element in the UNSORTED array. This sorts
	 * the array because the first element of the heap is always the greatest element in the heap. After the swap, the
	 * {{@link #arraySiftDown(Comparable[], int, int)} method is called to sift down the new root element to reheapify
	 * the array.
	 * @param arrayHeap
	 * The heap in array form.
	 * @return
	 * The sorted array.
	 */
	public V[] heapSort(V[] arrayHeap){
		int unsorted = arrayHeap.length;
		
		while(unsorted > 1){
			unsorted--;
			swap(arrayHeap, 0, unsorted);
    		arraySiftDown(arrayHeap, 0, unsorted);
		}
		
		return arrayHeap;
	}
	
	/**
	 * NOTE: The length parameter is not necessarily the length of the entire array. This param is
	 * used to stop sifting at a certain index of the array for {{@link #heapSort(Comparable[])}
	 * purposes.
	 * 
	 * This method sifts down an element in an array heap. First, the left and right children are found
	 * are found for the current index that we want to sift down. If the left and right indices are not
	 * greater than or equal to the length of the array, this means that element is not a leaf and we can continue
	 * the method, otherwise the method simply terminates.
	 * 
	 * All swaps are made only if the data in the parent index is less than the data in the child index.
	 * The {{@link #swap(Comparable[], int, int)} method is used for any swap that occurs.
	 * 
	 * Otherwise, the method checks if the right index is equal to the length of the array, which means that
	 * the right index does not exist and we will only have to compare the current data to the left index's data.
	 * Otherwise, we compare the current index data with both of its children. If one of them is greater than
	 * the current data, then we compare the child indices to determine which child to swap with. Lastly, this method
	 * is called recursively on the child index that was swapped with to continue the sifting process.
	 * @param array
	 * The array that we want to work with
	 * @param current
	 * This is the current index we want to sift down.
	 * @param length
	 * This is the int value of the index where we want to stop the sifting process. Not necessarily the
	 * length of the entire array.
	 */
	public void arraySiftDown(V[] array, int current, int length){
		int leftIndex = (current * 2) + 1;
		int rightIndex = (current * 2) + 2;
		
		if(!(leftIndex >= length && rightIndex >= length)){ //check if current index is leaf.
			if(rightIndex == length){
				if(array[current].compareTo(array[leftIndex]) < 0){
					swap(array, current, leftIndex);
					
				}
			} else {
				if(array[current].compareTo(array[leftIndex]) < 0 || array[current].compareTo(array[rightIndex]) < 0){
					if(array[leftIndex].compareTo(array[rightIndex]) < 0 || array[leftIndex].compareTo(array[rightIndex]) == 0){
						swap(array, current, rightIndex);
						arraySiftDown(array, rightIndex, length); //recursive sift
					} else {
						swap(array, current, leftIndex);
						arraySiftDown(array, leftIndex, length); //recursive sift
					}
				}
			}
		}
	}
	
	/**
	 * This method is a standard swapping method for swapping elements in an array.
	 * @param array
	 * The array we want to swap elements in.
	 * @param from
	 * The index we are swapping from
	 * @param to
	 * The index we are swapping to
	 */
	public void swap(V[] array, int from, int to){
		
		V temp = array[from];
		array[from] = array[to];
		array[to] = temp;
		
		
	}
	
	/**
	 * Returns {{@link #numElements}.
	 * @return
	 * {{@link #numElements}
	 */
	public int size(){
		return numElements;
	}
	
	/**
	 * Returns {@link #root}
	 * @return
	 * {{@link #root}
	 */
	public V getRoot(){
		return root.getData();
	}

}
