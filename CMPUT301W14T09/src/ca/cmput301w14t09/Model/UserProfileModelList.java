package ca.cmput301w14t09.Model;

/**
 * One of the two model for User profile, This one is the modelList.
 * Responsible for putting the user profile model into a list and sending this list 
 * to the elsaticSearchOperations.
 * @author ssowemim
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ca.cmput301w14t09.elasticSearch.ElasticSearchOperations;
import android.graphics.Bitmap;

public class UserProfileModelList {
	
	private List<UserProfileModel> list;
	
	public UserProfileModelList(){
		this.list = new ArrayList<UserProfileModel>();
	}

	/**
	 * Creates a model of the user profile information based on the UserProfileModel.
	 * Adds that UserProfileModel into a list
	 * Then also send that UserProfileModel to the server. 
	 * @param uniqueID
	 * @param fLName
	 * @param sex
	 * @param pic
	 * @param phone
	 * @param email
	 * @param bio
	 */
	public void addUserProfile(String uniqueID, String fLName, String sex, Bitmap pic, String phone, String email, String bio){
		UserProfileModel uPModel = new UserProfileModel(uniqueID, fLName, sex, phone, email, bio, pic);
		this.list.add(uPModel);
		
		ElasticSearchOperations.pushUserProfile(uPModel);
	}
	
	public void addUserProfileCollections(Collection<UserProfileModel> profiles){
		this.list.addAll(profiles);
	}
	
	public List<UserProfileModel> getList(){
		return Collections.unmodifiableList(this.list);
	}
}
