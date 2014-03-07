package ca.cmput301w14t09.model.Comment;

import ca.cmput301w14t09.model.Profile;



public class Favorite {
	private String name;
	private Comment comment;

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
