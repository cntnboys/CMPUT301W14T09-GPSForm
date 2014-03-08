package ca.cmput301w14t09.model.comment;

import java.util.Date;

import ca.cmput301w14t09.model.GeoLocation;
import ca.cmput301w14t09.model.Picture;


public class Comment implements ICacheable, Comparable<Comment> {
	private Thread thread;
	private GeoLocation geoLocation;
	private Picture attachment;
	private String authorName;
	private String commentText;
	private int favoriteCount;
	
	private Date postDate;
	
	public Comment() {
		geoLocation = null;
		attachment = null;
		authorName = "";
		commentText = "";
		favoriteCount = 0;
	}
	
	/**
	 * Compares this Comment to another Comment.
	 */
	public int compareTo(Comment otherComment) {
		Date compareDate = ((Comment) otherComment).getPostDate();
		return this.postDate.compareTo(compareDate);
	}
	
	public Thread getThread() {
		return thread;
	}
	
	public void setThread(Thread newThread) {
		this.thread = newThread;
	}
	
	/**
	 * @return the geoLocation
	 */
	public GeoLocation getGeoLocation() {
		return geoLocation;
	}

	/**
	 * @param geoLocation the geoLocation to set
	 */
	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}

	/**
	 * @return the attachment
	 */
	public Picture getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(Picture attachment) {
		this.attachment = attachment;
	}

	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * @return the commentText
	 */
	public String getCommentText() {
		return commentText;
	}

	/**
	 * @param commentText the commentText to set
	 */
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	/**
	 * @return the favoriteCount
	 */
	public int getFavoriteCount() {
		return favoriteCount;
	}

	/**
	 * @param favoriteCount the favoriteCount to set
	 */
	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	
	/**
	 * @return the postDate
	 */
	public Date getPostDate() {
		return postDate;
	}
	
	/**
	 * Set the post date variable. 
	 * @param now
	 */
	public void setPostDate(Date now) {
		this.postDate = now;
	}
}
