package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 * @author Popov Sergey
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException();
		}
		LLNode<E> currNode;
		LLNode<E> prevNode;
		prevNode = tail.prev;
		currNode = new LLNode<E>(element, prevNode, tail);
		size = this.size();
			
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index < 0 || this.size()==0 || index > this.size()-1) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> tempNode = head;
		int i = -1;
		while(i < this.size()) {
			if (i == index) {
				return tempNode.data;
			}
			i++;
			tempNode = tempNode.next;
		}
		throw new IndexOutOfBoundsException();
	}
	
	
	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException();
		}
		if (index < 0 || this.size() < index) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> currNode;
		LLNode<E> prevNode;
		LLNode<E> nextNode;
		
		if (index == 0 && this.size() > 0) {
			prevNode = head;
			nextNode = this.getNode(index);
		}
		else if (index == this.size() && this.size() != 0) {
			prevNode = this.getNode(index-1);
			nextNode = tail;
		}
		else if (index == 0 && this.size() == 0) {
			prevNode = head;
			nextNode = tail;
		}
		else {
			prevNode = this.getNode(index-1);
			nextNode = this.getNode(index);
		}
		currNode = new LLNode<E>(element, prevNode, nextNode);
		size = this.size();
	}
	public LLNode<E> getNode(int index){
		if (index < 0 || this.size() == 0 || this.size()-1 < index) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> tempNode = head;
		int i = -1;
		while(i < this.size()) {
			if (i == index) {
				return tempNode;
			}
			i++;
			tempNode = tempNode.next;
		}
		throw new IndexOutOfBoundsException();
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		LLNode<E> currNode;
		int size = 0;
		for (currNode = head; currNode.next != tail; currNode = currNode.next) {
			size++;
		}
		
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index < 0 || this.size() < index || this.size() == 0) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> currNode;
		LLNode<E> prevNode;
		LLNode<E> nextNode;

		if (index == 0 && this.size() > 1) {
			prevNode = head;
			nextNode = this.getNode(index+1);
		}
		else if (index == 0 && this.size() == 1) {
			prevNode = head;
			nextNode = tail;
		}
		else if (index == this.size()-1) {
			prevNode = this.getNode(index-1);
			nextNode = tail;
		}
		else {
			prevNode = this.getNode(index-1);
			nextNode = this.getNode(index+1);
		}
		currNode = this.getNode(index);
		prevNode.next = currNode.next;
		nextNode.prev = currNode.prev;
		
		size = this.size();
		return currNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index < 0 || this.size()==0 || this.size() < index) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new NullPointerException();
		}
		LLNode<E> removingNode = this.getNode(index);
		LLNode<E> currNode;
		LLNode<E> prevNode;
		LLNode<E> nextNode;
		if (index == 0 && this.size() > 1) {
			prevNode = head;
			nextNode = this.getNode(index+1);
		}
		else if (index == 0 && this.size() == 1) {
			prevNode = head;
			nextNode = tail;
		}
		else if (index == this.size()-1) {
			prevNode = this.getNode(index-1);
			nextNode = tail;
		}
		else {
			prevNode = this.getNode(index-1);
			nextNode = this.getNode(index+1);
			
		}
		currNode = new LLNode<E>(element, prevNode, nextNode);
		removingNode.next = null;
		removingNode.prev = null;
		
		size = this.size();
		return removingNode.data;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	public LLNode(E e, LLNode<E> prevNode) {
		this(e);
		this.next = prevNode.next;
		prevNode.next = this;

	}
	
	public LLNode(E e, LLNode<E> prevNode, LLNode<E> nextNode) {
		this(e);
		this.next = prevNode.next;
		prevNode.next = this;
		this.prev = nextNode.prev;
		nextNode.prev = this;
	}
}



