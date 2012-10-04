package com.algorithms.week2;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * A solution to the "deck" problem of week 2.
 * Uses a linked list solution per the requirement:
 * "Your deque implementation should support each deque operation in constant worst-case time 
 * and use space proportional to the number of items currently in the deque"
 * 
 * @author David Nelson
 *
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {
	
	/** track the first node */
	private Node first = null;
	
	/** track the last node */
	private Node last = null;
	
	/** track the size */
	private int size = 0;
		
	/** construct an empty deque */
	public Deque() {
		// construct an empty deque
	}

	/**
	 * True if the {@link Deque} is empty
	 * @return true if the {@link Deque} is empty
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Returns the current number of {@link Items} in the list
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * Adds an {@link Item} to the front of the list
	 * @param item the {@link Item} to add
	 */
	public void addFirst(Item item) {
		if (item == null) throw new NullPointerException();
		
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		first.previous = null;
		
		// increment our tracking count
		size++;
	}

	/**
	 * Adds an {@link Item} to the end of the list
	 * @param item the {@link Item} to add
	 */
	public void addLast(Item item) {
		if (item == null) throw new NullPointerException();
		
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		first.previous = null;
		
		// increment our tracking count
		size++;
	}

	/**
	 * Removes the first {@link Item} from the list
	 * @return the first {@link Item} from the list
	 */
	public Item removeFirst() {
		if (first == null) throw new NoSuchElementException();
		
		Item item = first.item;
		first = first.next;
		first.previous = null;
		
		// decrement our tracking count
		size--;
		
		return item;
	}

	/**
	 * Removes the last {@link Item} from the list
	 * @return the last {@link Item} from the list
	 */
	public Item removeLast() {
		if (last == null) throw new NoSuchElementException();
		Item item = last.item;
		last = last.previous;
	    last.next = null;
	    
	    // decrement our tracking count
		size--;
		
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	/** a node on the list */
	private class Node {
		Item item;
		Node next;
		Node previous;
	}
	
	/**
	 * Internal Iterator
	 * @author David Nelson
	 *
	 */
	private class ListIterator implements Iterator<Item> {
		
		/** the current item, initialized to the first of the linked list */
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (current == null) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}	
	}

}
