package ca.cmput301w14t09.model.Comment;

//Taken from: http://staff.science.uva.nl/~heck/JAVAcourse/ch4/sss1_2_3.html

public class ListIterator {
	private LinkedList owner;			// Need a reference to access elements.
	private LinkNode position;			// Current referred element in LinkedList.
	
	public ListIterator(LinkedList owner, LinkNode position)
	{
		this.owner = owner;
		this.position = position;
	}
	
	/*
	 * returns current position of the iterator.
	 */
	public LinkNode getPosition() {
		return position;
	}
	
	/*
	 * Ensure we don't use this Iterator with the wrong list.
	 */
	public boolean belongsTo(Object owner) {
		return this.owner == owner;
	}
	
	/*
	 * To be used before attempting work on an element.
	 */
	public boolean isPositionValid() {
		return position != null;
	}
	
	/*
	 * Set position to head.
	 */
	public void head() {
		position = owner.head;
	}
	
	/*
	 * Move to next node in list.
	 */
	public void next() {
		position = position.getNext();
	}
	
	/*
	 * Move to prev. node in list.
	 */
	public void prev() {
		position = position.getPrev();
	}
}
