import static org.junit.Assert.*;

import org.junit.Test;

import ca.cmput301w14t09.Controller.LocationFactory;


public class LocationFactoryTest {

	public LocationFactoryTest() {
	}

	@Test
	public void test() {
		LocationFactory lf = new LocationFactory();
		lf.buildlocations();
	}

}
