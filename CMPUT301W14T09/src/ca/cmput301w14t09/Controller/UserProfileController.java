package ca.cmput301w14t09.Controller;

/**
 * The controller for the userProfile
 * Simply adjusts the users input so it fits all the requirements and can be easily sent
 * up to the server.
 * @author ssowemim
 */
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import ca.cmput301w14t09.R;
import ca.cmput301w14t09.UserProfileActivity;
import ca.cmput301w14t09.Model.UserProfileModelList;

public class UserProfileController {

	private UserProfileActivity activity;
	private UserProfileModelList model;
	
	/**
	 * MAX_BIO_LENGTH = Max length for a user bios description
	 * MAX_PHONE_LENGTH = Max length for a users phone number
	 * MAX_BITMAP_DIMENSIONS = Max length on how big a users picture can be.
	 */
	public static final int MAX_BIO_LENGTH = 300;
	public static final int MAX_PHONE_LENGTH = 12;
	public static final int MAX_BITMAP_DIMENSIONS = 100;
	
	/**
	 * Makes the constructor class for this class.
	 * binds model to the modelList & activity to the usersActivity.
	 * @param model
	 * @param activity
	 */
	public UserProfileController( UserProfileModelList model, UserProfileActivity activity) {
		this.model = model;
		this.activity = activity;
	}
	
	/**
	 * This method makes the necessary changes to get the userProfile ready to be sent to the server.
	 * Like change dimensions of piture if too big, shorten phone number if too long etc.
	 * Then sends all this changes to the userProfileModelList
	 * @param uniqueID
	 * @param fLName
	 * @param sex
	 * @param pic
	 * @param phone
	 * @param email
	 * @param bio
	 */
	public void trimUserProfile(String uniqueID, String fLName, String sex, Bitmap pic, String phone,String email, String bio){
		// Sets default picture if none is set
		if(pic == null){
			pic = BitmapFactory.decodeResource(this.activity.getResources(), R.drawable.ic_userprofile);
		} 
		
		//Shortens bio length
		if(bio.length() > MAX_BIO_LENGTH)
			bio = bio.substring(0, MAX_BIO_LENGTH);
		
		//shortens phone number length
		if(phone.length() > MAX_PHONE_LENGTH)
			phone = phone.substring(0, MAX_PHONE_LENGTH);
		
		//shortens picture size if too big
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
