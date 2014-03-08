package ca.cmput301w14t09.model.comment;

import java.util.Date;


public class UnreadMarker implements Comparable<UnreadMarker> {
	private boolean unread;
	private Comment comment;
	
	public UnreadMarker() {
		unread = true;
	}
	
	/**
	 * Compares this Favorite to another Favorite.
	 */
	public int compareTo(UnreadMarker otherMarker) {
		Date compareDate = ((UnreadMarker) otherMarker).comment.getPostDate();
		return this.comment.getPostDate().compareTo(compareDate);
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
