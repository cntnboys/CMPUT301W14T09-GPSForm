package ca.cmput301w14t09.model.user;

import java.util.ArrayList;

import ca.cmput301w14t09.model.comment.Favorite;
import ca.cmput301w14t09.model.comment.UnreadMarker;

public class Profile {
	private ArrayList<Favorite> favorites;
	private ArrayList<UnreadMarker> unreadNotifications;
	private String owner;
	
	public Profile(String userName) {
		this.owner = userName;
	}
}
