package ca.cmput301w14t09.model.Comment;

import java.util.Date;

import ca.cmput301w14t09.model.GeoLocation;
import ca.cmput301w14t09.model.Picture;


public class Comment implements ICacheable {
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
}
