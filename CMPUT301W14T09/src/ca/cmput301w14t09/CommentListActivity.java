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

import android.app.Activity;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.mapquest.android.maps.MyLocationOverlay;

/**
 * 
 * @author Conner, Cameron, Chunhan, Micheal
 * 
 * This activity shows the top comment that was selected in a 
 * previous activity and displays all the replies to that comment
 * This activity shows the top comment that was selected in a 
 * previous activity and displays all the replies to that comment
 *
 * Need to send the user back as a Activity result so the favorite
 * saves to the user profile are sent back as well and favorites
 * are shown immediately
 */
public class CommentListActivity extends ListActivity {





	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
			
		});
	
	/**
	 * This function inflates the menu and adds items to the action bar if it is present.
	 * It also intialized Handler polling and populates the listview with reply comments
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.comment_list, menu);
		intent = getIntent();
		user = (User) intent.getSerializableExtra("CURRENT_USER");
		firstComment = (String) getIntent().getSerializableExtra("THREAD_ID");
	
		updateHandler = new Handler();
		updateFunction = new Runnable() {
			@Override
			public void run() {
				populateListView();
			}
		};

		return true;
	}


	/**
	 * 
	 * @author Chunhan
	 * Allows for selection of sorting on the action bar
	 * https://developer.android.com/training/basics/actionbar/adding-buttons.html
	 * 
	 */


	/**
	 * Sorts the list by location.
	 */
	private void sortByLocation() {
		SortingController sorting = new SortingController();
		filter = Filter.LOCATION;

		currentLocation = myLocationOverlay.getMyLocation();
		lc1.setGeodefault(currentLocation.getLatitude(), currentLocation.getLongitude());
		ArrayList<Comment> sortedList = sorting.sortTopComments(lc1, null, user.profile.cache.getSubComments(firstComment));
		adapter = new CommentAdapter(this,R.layout.comment_view, sortedList);
		favList.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
	
	/**
	 * Sorts the list by post-date.
	 */
	private void sortByDate() {
		filter = Filter.DATE;
		ArrayList<Comment> newList = user.profile.cache.getSubComments(firstComment);
		Collections.reverse(newList);
		adapter = new CommentAdapter(this,R.layout.comment_view, newList);
		favList.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
	
	/**
	 * Sorts the list by picture.
	 */
	private void sortByPicture() {
		SortingController sorting1 = new SortingController();
		filter = Filter.PICTURE;

		ArrayList<Comment> commentList = null;
		commentList = user.profile.cache.getSubComments(firstComment);
		commentList = sorting1.sortPicTopComments(commentList);
		adapter = new CommentAdapter(this,R.layout.comment_view, commentList);
		favList.setAdapter(adapter);
		adapter.notifyDataSetChanged();	
	}
	
	/**
	 * re-applies filter to results brought back from poll.
	 */
	private void reapplyFilter() {
		switch (filter) {
		case LOCATION:     
			sortByLocation();
			break;
		case DATE:
			sortByDate();
			break;
		case PICTURE:
			sortByPicture();
			break;
		default:
			filter = Filter.NONE;
			break;
		}
	}


	/**
	 * this function calls the popup reply to be generated when the reply button is pressed
	 * @param v
	 * @throws InterruptedException
	 */
	public void popUp(View v) throws InterruptedException {
		popUpReply.popUp(this, fileUri, lc1, selectedgeo, user, firstComment, "Comment Reply");
	}


	/**
	 * onStart populates the listview with results from the elasticSearch
	 *  query found in ElasticSearchOperations.pullOneThread(firstComment)
	 */
	@Override
	protected void onStart() {
		super.onStart();

	}

	/**
	 * This function is responsible for pulling the thread of comments and getting the comment replies
	 * It then populates the listview to display the replies, it reapplies the default filter to sort comments
	 * which by default is date, The filter changes if user has selected to sort by a different way.
	 */
	public void populateListView() {
		ArrayList<Comment> commentThread = null;
		if(user != null) {
			if(Server.getInstance().isServerReachable(this)) {
				try {
					commentThread = ElasticSearchOperations.pullOneThread(firstComment);
					user.profile.cache.add(commentThread);
					FileSaving.saveUserFile(user, this);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			adapter = new CommentAdapter(this,
					R.layout.comment_view,
					user.profile.cache.getSubComments(firstComment));
			
			favList.setAdapter(adapter);
			reapplyFilter();
			adapter.notifyDataSetChanged();
		}
	}

	/**
	 * onActivityResult will Receive the activity result method and will be called after closing 
	 * the camera and after the ChooseLocationActivity is closed to get geolocation, or the commentList. 
	 * //http://stackoverflow.com/questions/17242713/how-to-pass-parcelable-object-from-child-to-parent-activity
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		if (requestCode == 122 && resultCode == Activity.RESULT_OK){
			selectedgeo = (GeoLocation) data.getExtras().get("SomeUniqueKey");
		}

		if (requestCode == 123 && resultCode == Activity.RESULT_OK){
			selectedgeosort = (GeoLocation) data.getExtras().get("SomeUniqueKey");
		}

		// if the result is capturing Image
		if (requestCode == OBTAIN_PIC_REQUEST_CODE) {
			if (resultCode == RESULT_OK) {
					popUpReply.pictureResult(fileUri);
			} else if (resultCode == RESULT_CANCELED) {
				// user cancelled Image capture
				Toast.makeText(this.getApplicationContext(),
						"User cancelled image capture", Toast.LENGTH_SHORT)
						.show();
			}
		} else {
			// failed to capture image
			Toast.makeText(this.getApplicationContext(),
					"Sorry! Failed to capture image", Toast.LENGTH_SHORT)
					.show();
		}
	}

	/**
	 * onSaveInstanceState stores the file url as
	 * it will be null after returning from camera app
	 */
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		// save file url in bundle as it will be null on screen orientation changes
		outState.putParcelable("file_uri",fileUri);
	}


	/**
	 * This function restores the saved instance state using a file_uri
	 */
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		fileUri = savedInstanceState.getParcelable("file_uri");
	}


	/**
	 * On back pressed pack up the geolocation that was selected and send back to parent activity to be processed
	 * http://stackoverflow.com/questions/17242713/how-to-pass-parcelable-object-from-child-to-parent-activity
	 */
	public void onBackPressed() {
		Intent intent = getIntent();
		intent.putExtra("CURRENT_USER", user);
		setResult(Activity.RESULT_OK, intent);
		super.onBackPressed();
		finish();
	}

	/**
	 * Bring up the dialog box and input thread.
	 * @param thread
	 */
	public void optionsDialog(Comment thread) {
		popUpSelect.popUpSelect(this, fileUri, lc1, selectedgeo, user, firstComment, "Comment Reply", thread);

	}
	
	/**
	 * Return the selectedgeo object
	 * @author Cameron Alexander
	 * @return
	 */
	public GeoLocation getSelectedGeolocation(){
		return selectedgeo;
	}

	/**
	 * Reset selected geolocation object
	 * @author Cameron Alexander
	 */
	public void resetSelectedLocation(){
		double latitude = 0.0;
		double longitude = 0.0;
		selectedgeo.setLatitude(latitude);
		selectedgeo.setLongitude(longitude);
	}

	/**
	 * set location overlay
	 * @param myLocationOverlay
	 */
	public void setMyLocationOverlay(MyLocationOverlay myLocationOverlay){

		this.myLocationOverlay = myLocationOverlay;
	}

	/**
	 * set the current location is now fully working
	 * @param currentLocation
	 */
	public void setCurrentLocation(GeoPoint currentLocation){

		this.currentLocation = currentLocation;
	}

	public MyLocationOverlay getMyLocationOverlay(){

		return myLocationOverlay;
	}

	public GeoPoint getCurrentLocation(){

		return currentLocation;
	}
}
