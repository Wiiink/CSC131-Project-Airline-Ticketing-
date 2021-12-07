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
		Utilities UTIL = new Utilities();
		HashSet<Airplane> planes = new HashSet<Airplane>();
		planes = UTIL.getFlightList();
		//check all flights (10 out of 10) were successfuly created
		assertEquals(planes.size(),PlaneFactory.TOTAL_FLIGHTS);
		//check each Airplane object is initialized
		for(Airplane plane : planes) {
			assertNotNull(plane);
		}
	}

}
