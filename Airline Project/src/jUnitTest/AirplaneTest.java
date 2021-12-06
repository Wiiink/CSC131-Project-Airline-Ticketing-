package jUnitTest;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import AirlineTicketer.Airplane;
import AirlineTicketer.Seat;

public class AirplaneTest {
	
	@Test
	public void getDestination() {
		int id = 135;
		String depart = "loc1";
		String dest = "loc2";
		Airplane plane = new Airplane(id, depart, dest);
		
		assertEquals("getDestination()", dest, plane.getDestination());
	}
	
	@Test
	public void getDeparture() {
		int id = 135;
		String depart = "loc1";
		String dest = "loc2";
		Airplane plane = new Airplane(id, depart, dest);
		
		assertEquals("getDeparture()", depart, plane.getDeparture());
	}
	
	@Test
	public void getID() {
		int id = 135;
		String depart = "loc1";
		String dest = "loc2";
		Airplane plane = new Airplane(id, depart, dest);
		
		assertEquals("getID()", id, plane.getID());
	}
	
	@Test
	public void getSeats() {
		int id = 135;
		String depart = "loc1";
		String dest = "loc2";
		boolean[] b1 = new boolean[18];
		boolean[] b2 = new boolean[18];
		Airplane plane = new Airplane(id, depart, dest, b1);
		int i=0;
		for(Seat s : plane.getSeats()) {
			b2[i] = s.getOccupied();
		}
		
		assertArrayEquals("getSeats()", b1, b2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getSeats_incorrectSeatSize() {
		boolean[] b = new boolean[100];
		new Airplane(1, "", "", b);
	}
	
	@Test
	public void testToString() {
		int id = 100;
		String depart = "loc1";
		String dest = "loc2";
		Airplane plane = new Airplane(id, depart, dest);
		
		assertEquals("toString()", ("#"+id+", "+depart+" to "+dest), plane.toString());
	}

}
