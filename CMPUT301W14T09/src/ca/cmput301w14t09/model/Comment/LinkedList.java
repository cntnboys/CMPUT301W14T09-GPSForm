package ca.cmput301w14t09.model.Comment;

import java.util.Enumeration;
import java.util.NoSuchElementException;

//Taken from: http://staff.science.uva.nl/~heck/JAVAcourse/ch4/sss1_2_3.html

public class LinkedList {
	public LinkNode head;
	
	/**
	 * Creates an empty list.
	 */
	public LinkedList() {
		head = new LinkNode(null);
		head.setNext(head);
		head.setPrev(head);
	}
	
	/**
	 * Empty list of contents.
	 */
	public final synchronized void clear() {
		// remove each element.
	}
	
	/**
	 * Returns true if container is empty.
	 */
	public final boolean isEmpty() {
		return head.getNext() == head;
	}
	
	/**
	 * insert element after current position
	 */
	public final synchronized void insertAfter(Object node, ListIterator cursor) {
		LinkNode newItem = new LinkNode(cursor.getPosition(), node, cursor.getPosition().getNext());
		newItem.getNext().setPrev(newItem);
		cursor.getPosition().setNext(newItem);
	}
	
	/**
	 * insert element before current position
	 */
	public final synchronized void insertBefore(Object node, ListIterator cursor) {
		LinkNode newItem = new LinkNode(cursor.getPosition().getPrev(), node, cursor.getPosition());
		newItem.getPrev().setNext(newItem);
		cursor.getPosition().setPrev(newItem);
	}
	
	/**
	 * Remove the element at current position
	 */
	public final synchronized void remove(ListIterator cursor) {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException("cannot remove element from empty list");
		}
		if (cursor.getPosition() == head) {
			throw new NoSuchElementException("cannot remove head while elements still in list.");
		}
		
		cursor.getPosition().getPrev().setNext(cursor.getPosition().getNext());
		cursor.getPosition().getNext().setPrev(cursor.getPosition().getPrev());
	}
	
	/**
	 * Return an iterator positioned at the head.
	 */
	public final ListIterator head() {
		return new ListIterator(this, head);
	}
	
	/**
	 * Find the first occurrence of the object in a list.
	 */
	public final synchronized ListIterator find(Object node) {
		if(isEmpty()) {
			throw new IndexOutOfBoundsException("empty list.");
		}
		
		LinkNode pos = head;
		while (pos.getNext() != head) { 		// Elements still available for iteration.
			pos = pos.getNext();
			if (pos.getNode() == node) {
				return new ListIterator(this, pos);
			}
		}
		
		throw new NoSuchElementException("no such object found");
	}
	
	/**
	 * Find position of tail.
	 */
	public final synchronized ListIterator findTail() {
		if(isEmpty()) {
			throw new IndexOutOfBoundsException("empty list.");
		}
		
		LinkNode pos = head;
		while (pos.getNext() != head && pos.getNext() != null) {
			pos = pos.getNext();
		}
		
		// We are now at tail position.
		return new ListIterator(this, pos);
	}
	
	/**
	 * Returns an enumeration of the elements.  Use the Enumeration methods on the returned object to fetch the elements sequentially.
	 */
	public final synchronized Enumeration elements() {
		return new ListEnumerator(this);
	}
	
}
