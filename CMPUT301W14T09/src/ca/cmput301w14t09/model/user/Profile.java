package ca.cmput301w14t09.model.user;

import java.util.ArrayList;

import ca.cmput301w14t09.model.comment.Favorite;
import ca.cmput301w14t09.model.comment.UnreadMarker;
import ca.cmput301w15t09.model.cache.ProfileCache;

public class Profile {
	private ArrayList<Favorite> favorites;
	private ArrayList<UnreadMarker> unreadNotifications;
	private ProfileCache cache;
	private String owner;
	
	public Profile(User user) {
		this.favorites = new ArrayList<Favorite>();
		this.unreadNotifications = new ArrayList<UnreadMarker>();
		this.cache = new ProfileCache(user);
		this.owner = user.getUserName();	
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the favorites
	 */
	public ArrayList<Favorite> getFavorites() {
		return favorites;
	}

	/**
	 * @return the unreadNotifications
	 */
	public ArrayList<UnreadMarker> getUnreadNotifications() {
		return unreadNotifications;
	}

	/**
	 * @return the cache
	 */
	public ProfileCache getCache() {
		return cache;
	}
	
	// ADD, REMOVE, SERIALIZE, LOAD
	
}
