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

package ca.cmput301w14t09.Model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import android.app.Activity;
import android.content.Context;
import com.google.gson.Gson;

/**
 * 
 * @author mcmorris
 * UnreadMarker is currently a mildly glorified boolean flag that sets whether a comment has been
 * read, and generates new markers for new comments with no related UnreadMarker.  This is done
 * on a per Profile basis.
 * 
 */

public class UnreadMarker implements Serializable, Comparable<UnreadMarker> {
	private boolean unread;
	private Comment comment;

	private static final long serialVersionUID = 13L;
	
	public UnreadMarker() {
		unread = true;
	}

	/**
	 * Constructor.
	 * @param unread - is this comment unread?  T/F
	 * @param comment - The comment this unread marker marks.
	 */

	public UnreadMarker(boolean unread, Comment comment) {
		this.unread = unread;
		this.comment = comment;
	}

	/**
	 * compareTo compares this UnreadMarker to another UnreadMarker.
	 * @param otherComment - other comment object to compare to.
	 * @return - this or otherComment, whichever has earlier date.
	 */

	public int compareTo(UnreadMarker otherMarker) {
		Date compareDate = ((UnreadMarker) otherMarker).comment.getPostDate();
		return this.comment.getPostDate().compareTo(compareDate);
	}

	public boolean isUnread() {
		return unread;
	}


	public void setUnread(boolean unread) {
		this.unread = unread;
	}

	public Comment getComment() {
		return comment;
	}


	public void setComment(Comment comment) {
		this.comment = comment;
	}


	/**
	 * generateNewMarkers goes through all comments, check a read flag exists for each one.
	 * TODO: I'm pretty sure this won't actually work - oldMarkers is made up of UnreadMarkers, so it is logical
	 * that it won't say it "contains" a Comment.
	 */

	public ArrayList<UnreadMarker> generateNewMarkers(ArrayList<UnreadMarker> oldMarkers, ArrayList<Comment> allComments) {
		ArrayList<UnreadMarker> markers = new ArrayList<UnreadMarker>();
		boolean isRead = false;

		// Compare each comment node, and mark if read only if it is already read in oldComments.
		for(int index = 0; index < allComments.size(); index++) {
			isRead = false;

			if (oldMarkers.contains(allComments.get(index)) == true)
				isRead = true;

			markers.add(new UnreadMarker(isRead, comment));
		}

		return markers;
	}

}