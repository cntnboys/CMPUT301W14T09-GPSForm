package ca.cmput301w14t09;

import java.util.ArrayList;
import java.util.List;

import ca.cmput301w14t09.Controller.UserProfileController;
import ca.cmput301w14t09.Model.Comment;
import ca.cmput301w14t09.Model.User;
import ca.cmput301w14t09.Model.UserProfileModel;
import ca.cmput301w14t09.Model.UserProfileModelList;
import ca.cmput301w14t09.elasticSearch.ElasticSearchOperations;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class UserProfileActivity extends Activity{

	public static final int OBTAIN_PIC_REQUEST_CODE = 117; 
			
	protected EditText firstLastNameText;
	protected EditText phoneText;
	protected EditText emailText;
	protected EditText biographyText;
	protected Button saveButton;
	protected ImageView userProfilePicture;
	protected TextView usernameText;
	protected Spinner maleOrFemale;
	protected Bitmap currentPicture;
	
	ArrayList<UserProfileModel> userProfile = null;
	
	User user;
	Intent intent;

	UserProfileModelList uPModelList;
	UserProfileController uPController;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_profile);
		
		this.firstLastNameText = (EditText)this.findViewById(R.id.editTextFirstLastName);
		this.phoneText = (EditText)this.findViewById(R.id.editTextPhone);
		this.emailText = (EditText)this.findViewById(R.id.editTextEmail);
		this.biographyText = (EditText)this.findViewById(R.id.editTextBiography);
		this.saveButton = (Button)this.findViewById(R.id.buttonSave);
		this.usernameText = (TextView)this.findViewById(R.id.textViewUsername);
		this.userProfilePicture = (ImageView)this.findViewById(R.id.imageViewUsername);
		this.maleOrFemale = (Spinner)this.findViewById(R.id.spinnerSex);
		
		this.uPModelList = new UserProfileModelList();
		this.uPController = new UserProfileController(this.uPModelList, this);
		maleFemaleSpinner();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_profile, menu);

		intent = getIntent();
		user = (User) intent.getSerializableExtra("CURRENT_USER");	
		
		
		
	//	Log.e("HERE!!!!", user.getProfile().getAuthorName().toString());
		usernameText.setText(user.getProfile().getUserName());
		userToProfile();
		return true;

	}
	

	/**
	 * Add user to appropriate user profile
	 */
	public void userToProfile(){
		try {
			userProfile = ElasticSearchOperations.pullUserProfile(user.getUniqueId());
		//	userProfile.get(0);
		//	Log.e("Here!!", userProfile.get(0).getFirstLastName());
			if(!userProfile.isEmpty()){
			this.firstLastNameText.setText(userProfile.get(0).getFirstLastName().toString());

			if (userProfile.get(0).getsex().equalsIgnoreCase("male"))
				this.maleOrFemale.setSelection(0);
			else 
				this.maleOrFemale.setSelection(1);
			this.currentPicture = userProfile.get(0).getPicture();
			this.phoneText.setText(userProfile.get(0).getPhone().toString());
			this.emailText.setText(userProfile.get(0).getEmail().toString());
			this.biographyText.setText(userProfile.get(0).getBiography().toString());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This simple method populates the male/female spinner.
	 */
	public void maleFemaleSpinner(){
		List<String> list = new ArrayList<String>();
		list.add("Male");
		list.add("Female");
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		this.maleOrFemale.setAdapter(adapter);
	}
	
	/**
	 * Lets you take picture when the imageView is pressed.
	 * @param v
	 */
	public void retrievePicture(View v){
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(intent, OBTAIN_PIC_REQUEST_CODE);
	}
	
	/**
	 * Puts the picture taken on the imageView.
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == OBTAIN_PIC_REQUEST_CODE && resultCode == RESULT_OK) {
			this.currentPicture = (Bitmap)data.getExtras().get("data");
			this.userProfilePicture.setImageBitmap(this.currentPicture);
		}
	}
	
	/**
	 * Sends all the userProfiles information to its controller, and prepares
	 * it for the userProfile model.
	 * @param v
	 */
	public void saveUserProfile(View v){
		String uniqueID = user.getProfile().getUniqueID();
		this.uPController.trimUserProfile(uniqueID,this.firstLastNameText.getText().toString(), this.maleOrFemale.getSelectedItem().toString(),
										this.currentPicture, this.phoneText.getText().toString(),
										this.emailText.getText().toString(), this.biographyText.getText().toString());
		
	/**	this.firstLastNameText.setText(null);
		this.maleOrFemale.setSelection(0);
		this.currentPicture = null;
		this.phoneText.setText(null);
		this.emailText.setText(null);
		this.biographyText.setText(null); **/
		finish();
	}
}
