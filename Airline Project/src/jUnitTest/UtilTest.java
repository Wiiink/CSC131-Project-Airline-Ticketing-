package jUnitTest;

import static org.junit.Assert.*;
import java.util.HashSet;
import org.junit.Test;

import AirlineTicketer.PlaneFactory;
import AirlineTicketer.Airplane;
import AirlineTicketer.Utilities;

public class UtilTest {

	@Test
	public void getFlightList() {
		PlaneFactory factory = new PlaneFactory();
		Utilities UTIL = new Utilities();
		HashSet<Airplane> planes = new HashSet<Airplane>();
		planes = UTIL.getFlightList();
		
		assertTrue(planes.size()==PlaneFactory.TOTAL_FLIGHTS);
		for(Airplane plane : planes) {
			assertNotNull(plane);
		}
	}

}
