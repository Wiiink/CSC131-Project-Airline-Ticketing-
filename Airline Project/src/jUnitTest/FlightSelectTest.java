package jUnitTest;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

import AirlineTicketer.Airplane;
import AirlineTicketer.FlightSelection;
import AirlineTicketer.PlaneFactory;
import AirlineTicketer.Utilities;

public class FlightSelectTest {

	@Test
	public void setPlanes() {
		FlightSelection select = new FlightSelection();
		assertEquals("setPlanes()", 10, select.getItemCount());
		//test setPlanes() with an empty list
		HashSet<Airplane> list = new HashSet<Airplane>();
		select.setPlanes(list);
		assertEquals("setPlanes()", 0, select.getItemCount());
		//check setPlanes() works with non-empty list
		list = PlaneFactory.createFlights();
		select.setPlanes(list);
		assertEquals("setPlanes()", 10, select.getItemCount());
	}

}
