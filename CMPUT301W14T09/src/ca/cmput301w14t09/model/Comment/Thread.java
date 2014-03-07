package ca.cmput301w14t09.model.Comment;

public class Thread {
	private LinkedList comments;
	private DateTime lastUpdated;
	private String name;

	public Thread() {
		comments = new LinkedList();
		name = "";
	}
	
	public void addToThread(Comment comment) {
		// Set comment thread.
		this.lastUpdated = comment.getPostDate();
		comment.setThread(this);
		
		// Iterate through and append to tail.
		ListIterator cursor = comments.findTail();
		comments.insertAfter(comment, cursor);
	}
	
	public LinkedList getComments() { return comments; }
	public String getName() { return name; }
}
