package ca.cmput301w14t09.Model;

import android.graphics.Bitmap;

public class UserProfileModel {

	private String uniqueID;
	private String firstLastName;
	private String sex;
	private String phone;
	private String email;
	private String biography;
	private Bitmap picture;
	
	public UserProfileModel(String uniqueID, String fLName, String sex, String phone, String email, String biography, Bitmap pic) {
		this.uniqueID = uniqueID;
		this.firstLastName = fLName;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.biography = biography;
		this.picture = pic;
	}
	
	public String getUniqueID(){
		return this.uniqueID;
	}
	
	public String getFirstLastName(){
		return this.firstLastName;
	}
	
	public String getsex(){
		return this.sex;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getBiography(){
		return this.biography;
	}
	
	public String getPhone(){
		return this.phone;
	}
	
	public Bitmap getPicture(){
		return this.picture;
	}
	
	

}
