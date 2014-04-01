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

import java.util.Date;
import android.graphics.Bitmap;

/**
 * 
 * Picture is an object that holds the information for 
 * a picture of a comment
 *
 */

public class Picture {
	private Bitmap picture;
	private String text;
	private Date timestamp;

	protected Picture(Bitmap pic) {
		this.picture = pic;
	}

	public Bitmap getPicture() {
		return this.picture;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public String getText() {
		return this.text;
	}
}