package ca.cmput301w15t09.model.cache;

import java.util.ArrayList;

import model.UnreadMarker;

import ca.cmput301w14t09.model.comment.Comment;
import ca.cmput301w14t09.model.comment.Favorite;
import ca.cmput301w14t09.model.user.User;

public class ProfileCache {
	private User user;
	private ArrayList<Comment> comments;
	private ArrayList<Favorite> favorites;
	private ArrayList<UnreadMarker> unreadMarkers;
	
	/**
	 * Determines class of object and adds it to corresponding queue.
	 */
	void add(Object object)
	{
		if (object.getClass() == Comment.class) {
			comments.add((Comment)object);
		}
		else if (object.getClass() == Favorite.class) {
			favorites.add((Favorite)object);
		}
		else {
			unreadMarkers.add((UnreadMarker)object);
		}
	}
	
	/**
	 * Determines class of object and removes it from the corresponding queue.
	 */
	void remove(Object object)
	{
		if (object.getClass() == Comment.class) {
			comments.remove((Comment)object);
		}
		else if (object.getClass() == Favorite.class) {
			favorites.remove((Favorite)object);
		}
		else {
			unreadMarkers.remove((UnreadMarker)object);
		}
	}
	
	// ProfileCache responsibility.
//	void save(UserCache cache);
//	void load(UserCache cache);
//	void push(ICacheable next);
//	void pull(ICacheable next);
}
