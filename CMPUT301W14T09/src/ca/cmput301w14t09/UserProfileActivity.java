package ca.cmput301w14t09;

import java.util.ArrayList;
import java.util.List;

import ca.cmput301w14t09.Model.User;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class UserProfileActivity extends Activity{

	protected EditText firstLastNameText;
	protected EditText phoneText;
	protected EditText emailText;
	protected EditText biographyText;
	protected Button saveButton;
	protected ImageView userProfilePicture;
	protected TextView usernameText;
	protected Spinner maleOrFemale;
	User user;
	Intent intent;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_profile);
		
		firstLastNameText = (EditText) findViewById(R.id.editTextFirstLastName);
		phoneText = (EditText) findViewById(R.id.editTextPhone);
		emailText = (EditText) findViewById(R.id.editTextEmail);
		biographyText = (EditText) findViewById(R.id.editTextBiography);
		saveButton = (Button) findViewById(R.id.buttonSave);
		usernameText = (TextView) findViewById(R.id.textViewUsername);
		userProfilePicture = (ImageView) findViewById(R.id.imageViewUsername);
		maleOrFemale = (Spinner) findViewById(R.id.spinnerSex);
		
		maleFemaleSpinner();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_profile, menu);

		intent = getIntent();
		user = (User) intent.getSerializableExtra("CURRENT_USER");	
		
	//	Log.e("HERE!!!!", user.getProfile().getAuthorName().toString());
		usernameText.setText(user.getProfile().getAuthorName());
		return true;

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
		maleOrFemale.setAdapter(adapter);
	}
	

}
