package ca.cmput301w14t09.model.comment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;

import android.app.Activity;
import android.content.Context;

import ca.cmput301w14t09.model.GeoLocation;
import ca.cmput301w14t09.model.Picture;


public class Comment implements ICacheable<Comment>, Comparable<Comment> {
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
	 * Write this object to cache using GSon.
	 * https://github.com/Mrbilec/CMPUT301W14T09-GPSForm/blob/saveBranch/CMPUT301W14T09/src/ca/cmput301w14t09/FileManaging/FileSaving.java
	 */
	public void serialize(String userName, Comment object, Activity main) {
		Gson gson = new Gson();
		String jsonIn = gson.toJson(object);           

		try {
			FileOutputStream fos = main.openFileOutput(userName + ".sav",
					Context.MODE_PRIVATE );
			fos.write(jsonIn.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	/**
	 * Loads this object, specified by name, from cache with userName.sav
	 */
	public Comment load(String userName, String name, Activity main) {
        Gson gson = new Gson();
        Comment comment = null;
        
        try{
            FileInputStream fis = main.openFileInput(userName + ".sav");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader buff = new BufferedReader(isr);
            String jsonOut = buff.readLine();
            comment = gson.fromJson(jsonOut, Comment.class);
            buff.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return comment;
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
