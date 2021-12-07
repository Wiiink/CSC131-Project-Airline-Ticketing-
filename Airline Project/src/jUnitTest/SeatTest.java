package jUnitTest;

import static org.junit.Assert.*;
import org.junit.Test;

import AirlineTicketer.Seat;

public class SeatTest {

	@Test
	public void getSeatNum() {
		int num = 10;
		Seat seat1 = new Seat();
		Seat seat2 = new Seat(num);
		assertEquals("getSeatNum()", -1, seat1.getSeatNum());
		assertEquals("getSeatNum(int num)", num, seat2.getSeatNum());
	}
	
	@Test
	public void getOccupied() {
		int num = 3;
		boolean occupied = true;
		Seat seat = new Seat(occupied, num);
		assertEquals("getOccupied()", false, (new Seat()).getOccupied());
		assertEquals("getOccupied()", occupied, seat.getOccupied());
	}
	
	@Test
	public void setOccupied() {
		boolean occupied = true;
		Seat seat = new Seat();
		seat.setOccupied(occupied);
		assertEquals("getOccupied()", occupied, seat.getOccupied());
	}
	
	@Test
	public void testToString() {
		int num = 6;
		boolean occ = true;
		Seat seat = new Seat(occ, num);
		assertEquals("toString()", ("Seat number: "+num+", occupied: "+occ), seat.toString());
	}

}
