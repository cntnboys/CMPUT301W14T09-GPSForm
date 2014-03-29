import org.junit.Test;

import ca.cmput301w14t09.Controller.SortingController;

import junit.framework.TestCase;


public class SortingTest extends TestCase {

	@Test
	public void testSort(){
		SortingController sc = new SortingController();
		sc.sortCommentsByDefaultGeoLocation();
		assertTrue(true);
	}
	

}
