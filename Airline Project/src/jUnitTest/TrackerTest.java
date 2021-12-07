package jUnitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import AirlineTicketer.TicketTracker;
import AirlineTicketer.Airplane;
import AirlineTicketer.Seat;
import AirlineTicketer.TicketHandler;
import AirlineTicketer.TicketObserver;

public class TrackerTest {
	
	@Test
	public void getandAddObservers() {
		//add same observers to a TicketTracker object & list
		TicketTracker subject = new TicketTracker();
		ArrayList<TicketObserver> observers = new ArrayList<TicketObserver>();
		for(int i=0; i<3; i++) {
			TicketHandler ob = new TicketHandler("");
			observers.add(ob);
			subject.addObserver(ob);
		}
		//check the returned observers list exists
		assertNotNull("getObservers()", subject.getObservers());
		
		ArrayList<TicketObserver> observers2 = subject.getObservers();
		//check the two obersver lists are of equal size (all observers added)
		assertEquals("addObservers(), size", observers.size(), observers2.size());
		//check each observer object exists in both lists
		for(TicketObserver handler : observers) {
			assertTrue("addObserver()", observers2.contains(handler));
		}
	}
	
	@Test
	public void removeObserver() {
		//initialize subject & observer. add/remove test observers
		TicketTracker subject = new TicketTracker();
		TicketHandler ob1 = new TicketHandler("");
		TicketHandler ob2 = new TicketHandler("");
		TicketHandler ob3 = new TicketHandler("");
		subject.addObserver(ob1);
		subject.addObserver(ob2);
		subject.removeObserver(ob2);
		
		ArrayList<TicketObserver> observers = subject.getObservers();
		assertFalse(observers.contains(ob2));//observer successfully removed
		assertTrue(observers.contains(ob1));//remaining observer still exists
	}
	
	@Test
	public void getPlane() {
		TicketTracker subject = new TicketTracker();
		assertNull("getPlane()", subject.getPlane());
	}
	
	@Test
	public void setandGetSeat() {
		TicketTracker subject = new TicketTracker();
		//check getter method immediately after initialization
		assertNull("getSeat()", subject.getSeat());
		//check getter method after setting seat object
		Seat seat = new Seat(0);
		subject.setSeat(seat);
		assertNotNull("getSeat()", subject.getSeat());
		assertSame("setSeat()", seat, subject.getSeat());
	}
	

}
