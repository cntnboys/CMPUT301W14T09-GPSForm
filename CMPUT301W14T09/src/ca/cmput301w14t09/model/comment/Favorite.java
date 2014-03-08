package ca.cmput301w14t09.model.comment;

import java.util.Date;

public class Favorite implements Comparable<Favorite> {
	private String name;
	private Comment comment;

	/**
	 * Compares this Favorite to another Favorite.
	 */
	public int compareTo(Favorite otherFavorite) {
		Date compareDate = ((Favorite) otherFavorite).comment.getPostDate();
		return this.comment.getPostDate().compareTo(compareDate);
	}
	
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
