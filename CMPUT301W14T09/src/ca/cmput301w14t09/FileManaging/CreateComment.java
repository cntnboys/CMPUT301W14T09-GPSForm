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

package ca.cmput301w14t09.FileManaging;

import android.graphics.Bitmap;
import ca.cmput301w14t09.Controller.LocationController;
import ca.cmput301w14t09.Controller.PictureController;
import ca.cmput301w14t09.Model.Comment;
import ca.cmput301w14t09.Model.GeoLocation;

import java.util.Date;

/**
 * 
 * @author Conner
 * CreateComment creates top comments and reply comments
 * when requested by methods. reply comments has not
 * been completed yet
 * 
 */

public class CreateComment {

	/**
	 * newComment creates a new top comment and fills out
	 * the required parameters for a top comments
	 * @param lc
	 * @param authorname
	 * @param commentText
	 * @param topComment
	 * @param attachment
	 * @param picture
	 * @return
	 */
	
	public static Comment newComment(LocationController lc, String authorname, String commentText, Boolean topComment, Bitmap picture) {
		Comment comment = new Comment();
		comment = instantiateComment(comment, lc, authorname, commentText, topComment, picture);
		comment.setThreadId((comment.getAuthorName() + " " + comment.getPostDate().toString().substring(0, 12)));
		return comment;
	}
	
	public static Comment newReplyComment(LocationController lc, String authorname, String commentText, Boolean topComment, Bitmap picture, String threadId) {
	                Comment comment = new Comment();
	                comment = instantiateComment(comment, lc, authorname, commentText, topComment, picture);
	                comment.setThreadId(threadId);
	                return comment;
	}
	
	private static Comment instantiateComment(Comment comment, LocationController lc, String authorname, String commentText, Boolean topComment, Bitmap picture) {
            comment.setAuthorName(authorname);
            comment.setCommentText(commentText);            
            
            comment.setPicture(picture);
            
            GeoLocation geo = lc.getGeoLocation();
            comment.setGeoLocation(geo);

            comment.setTopComment(topComment);
            comment.setPostDate(new Date());
            return comment;
	}
	
	
	

}
