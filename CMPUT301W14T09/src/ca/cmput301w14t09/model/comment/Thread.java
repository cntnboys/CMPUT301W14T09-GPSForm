package ca.cmput301w14t09.model.comment;

import java.util.Date;
import java.util.LinkedList;

public class Thread implements Comparable<Thread> {
	private LinkedList<LinkNode> comments;
	private Date lastUpdated;
	private String name;
	private int length;

	public Thread() {
		comments = new LinkedList<LinkNode>();
		name = "";
	}
	
	public void addToThread(Comment comment) {
		// Set comment thread.
		this.lastUpdated = comment.getPostDate();
		comment.setThread(this);
		comment.setPostDate(new Date());
		
		LinkNode newNode = new LinkNode(comment);
		comments.addLast(newNode);
	}
	
	/**
	 * Compares this Comment to another Comment.
	 */
	public int compareTo(Thread otherThread) {
		Date compareDate = ((Thread) otherThread).getLastUpdated();
		return this.getLastUpdated().compareTo(compareDate);
	}
	
	
	public LinkedList<LinkNode> getComments() { return comments; }
	public String getName() { return name; }
	public int getLength() { return length; }
	public Date getLastUpdated() { return lastUpdated; }
}
