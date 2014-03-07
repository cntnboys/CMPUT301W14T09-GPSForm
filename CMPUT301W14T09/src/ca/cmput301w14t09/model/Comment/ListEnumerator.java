package ca.cmput301w14t09.model.Comment;

// Taken from: http://staff.science.uva.nl/~heck/JAVAcourse/ch4/sss1_2_3.html
import java.util.Enumeration;
import java.util.NoSuchElementException;

final class ListEnumerator implements Enumeration {
	LinkedList list;
	ListIterator cursor;
	
	ListEnumerator(LinkedList list) {
		this.list = list;
		cursor = list.head();
		cursor.next();
	}
	
	public boolean hasMoreElements() {
		return cursor.getPosition() != list.head;
	}
	
	public Object nextElement() {
		synchronized (list) {
			if (cursor.getPosition() != list.head) {
				Object object = cursor.getPosition().getNode();
				cursor.next();
				return object;
			}
		}
		
		throw new NoSuchElementException("ListEnumerator");
	}
}
