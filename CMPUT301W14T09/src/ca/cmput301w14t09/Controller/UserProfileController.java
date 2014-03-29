package ca.cmput301w14t09.Controller;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import ca.cmput301w14t09.R;
import ca.cmput301w14t09.UserProfileActivity;
import ca.cmput301w14t09.Model.UserProfileModel;
import ca.cmput301w14t09.Model.UserProfileModelList;

public class UserProfileController {

	private UserProfileActivity activity;
	private UserProfileModelList model;
	
	public static final int MAX_BIO_LENGTH = 300;
	public static final int MAX_PHONE_LENGTH = 12;
	public static final int MAX_BITMAP_DIMENSIONS = 100;
	
	public UserProfileController( UserProfileModelList model, UserProfileActivity activity) {
		this.model = model;
		this.activity = activity;
	}
	
	public void trimUserProfile(String uniqueID, String fLName, String sex, Bitmap pic, String phone,String email, String bio){
		if(pic == null){
			pic = BitmapFactory.decodeResource(this.activity.getResources(), R.drawable.ic_default_image);
		}
		
		if(bio.length() > MAX_BIO_LENGTH)
			bio = bio.substring(0, MAX_BIO_LENGTH);
		
		
		if(phone.length() > MAX_PHONE_LENGTH)
			phone = phone.substring(0, MAX_PHONE_LENGTH);
		
		if (pic.getWidth() > MAX_BITMAP_DIMENSIONS || pic.getHeight() > MAX_BITMAP_DIMENSIONS) {
			double scalingFactor = pic.getWidth() * 1.0 / MAX_BITMAP_DIMENSIONS;
			if (pic.getHeight() > pic.getWidth())
				scalingFactor = pic.getHeight() * 1.0 / MAX_BITMAP_DIMENSIONS;
			
			int newWidth = (int)Math.round(pic.getWidth() / scalingFactor);
			int newHeight = (int)Math.round(pic.getHeight() / scalingFactor);
			
			pic = Bitmap.createScaledBitmap(pic, newWidth, newHeight, false);
		}
		this.model.addUserProfile(uniqueID, fLName, sex, pic, phone, email, bio);
	}

}
