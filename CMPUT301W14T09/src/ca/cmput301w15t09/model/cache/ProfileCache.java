package ca.cmput301w15t09.model.cache;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;

import com.google.gson.Gson;

import ca.cmput301w14t09.model.comment.Comment;
import ca.cmput301w14t09.model.comment.ICacheable;
import ca.cmput301w14t09.model.user.User;

public class ProfileCache implements ICacheable<ProfileCache> {
	private String userName;
	private ArrayList<Comment> comments;
	
	public ProfileCache(User user) {
		userName = user.getUserName();
	}
	
	/**
	 * If true, this user owns this profile cache.  Should always check before using cache.
	 */
	public boolean isOwner(User user) {
		if (this.userName == user.getUserName())
			return true;
		return false;
	}
	
	
	/**
	 * Determines class of object and adds it to corresponding queue.
	 */
	public void add(Object object)
	{
		comments.add((Comment)object);
	}
	
	/**
	 * Determines class of object and removes it from the corresponding queue.
	 * Should only be used after push to server.
	 */
	private void remove(Object object)
	{
		comments.remove((Comment)object);
	}
	
	/**
	 * Write this object to cache using GSon.
	 * https://github.com/Mrbilec/CMPUT301W14T09-GPSForm/blob/saveBranch/CMPUT301W14T09/src/ca/cmput301w14t09/FileManaging/FileSaving.java
	 */
	public void serialize(String userName, ProfileCache object, Activity main) {
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
	public ProfileCache load(String userName, String name, Activity main) {
        Gson gson = new Gson();
        ProfileCache cache = null;
        
        try{
            FileInputStream fis = main.openFileInput(userName + ".sav");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader buff = new BufferedReader(isr);
            String jsonOut = buff.readLine();
            cache = gson.fromJson(jsonOut, ProfileCache.class);
            buff.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return cache;
	}
	
	
}
