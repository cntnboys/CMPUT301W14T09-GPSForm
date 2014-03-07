package ca.cmput301w14t09.model.Comment;

import java.util.Collection;

import ca.cmput301w14t09.model.Profile;


public class UnreadMarker {
	private boolean unread;
	private Comment comment;
	
	public UnreadMarker() {
		unread = true;
	}
	
	public boolean isUnread() {
		return unread;
	}


	public void setUnread(boolean unread) {
		this.unread = unread;
	}


	public Comment getComment() {
		return comment;
	}


	public void setComment(Comment comment) {
		this.comment = comment;
	}


	/**
	*/
	public void generateNewMarkers() {
		
	}

}
