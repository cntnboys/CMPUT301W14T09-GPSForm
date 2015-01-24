/**

License GPLv3: GNU GPL Version 3
<http://gnu.org/licenses/gpl.html>.
This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package ca.cmput301w14t09;
#first page activity example
import android.app.Activity;
 * @author Conner
 * MainActivity of the app.
 * displays a list of current users on the device
 * and allows you to create a new user or sign
 * in as a guest
 * 
 */
public class MainActivity extends Activity {

	//initialize vars
	protected ListView UserList;
	protected EditText editText;
	protected User user;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	
	
	/**
	 * onStart populates the listview with clickable usernames
	 * that have already been created on the device
	 */
	public void onStart() {
	

	}

	/**
	 * newUser is called when continue button is pressed
	 * this method is run.
	 * It grabs the username entered in the text field and
	 * creates a new user with it. Then starts the next 
	 * activity with the newly created user
	 * @param v
	 */
	public void newUser(View v) {
	
		}else{
			Toast.makeText(getApplicationContext(),"No UserName specified", Toast.LENGTH_LONG).show();
		}
	}

	/**
	 * topComments takes in a username selected in the listview
	 * and starts the next activity with that user
	 * @param user
	 */
	public void topComments(User user) {
	
	}

	/**
	 * guestUser is called when the guest button is pressed
	 * Sets user to guest user and then calls
	 * topComments with the guest user
	 * @param v
	 */
	public void guestUser(View v) {
	
	}

	/**
	 * loadUser calls FileLoading.returnUser(text, this)
	 * which gets a user and then returns the user that
	 * FileLoading.returnUser(text, this) gets
	 * @param text
	 * @return
	 */
	public User loadUser(String text) {
		
	}

}
