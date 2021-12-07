package jUnitTest;

import static org.junit.Assert.*;

import java.awt.Color;

import javax.swing.JButton;

import org.junit.Test;

import AirlineTicketer.Seat;
import AirlineTicketer.SeatButton;

public class SeatButtonTest {
	
	@Test
	public void getSeat() {
		Seat seat = new Seat(0);
		//check seatbutton w preset seat
		SeatButton button = new SeatButton("", seat);
		assertSame("getSeat()", seat, button.getSeat());
		//seatbutton without a seat will have a null object
		SeatButton button2 = new SeatButton("");
		assertNull("getSeat(), null seat", button2.getSeat());
		
	}
	
	@Test
	public void setSeat() {
		Seat seat = new Seat(1);
		SeatButton button = new SeatButton("");
		button.setSeat(seat);
		assertSame("setSeat()", seat, button.getSeat());
	}
	
	@Test
	//checks color updating of seatbuttons
	public void checkStatus() {
		//2 seats, 1 occupied, 1 unoccupied
		Seat seat1 = new Seat(true, 0);
		Seat seat2 = new Seat(false, 1);
		//create seatbuttons out of test seats and check default bg color
		SeatButton button1 = new SeatButton("", seat1);
		SeatButton button2 = new SeatButton("", seat2);
		assertEquals(Color.DARK_GRAY, button1.getBackground());
		assertEquals((new JButton().getBackground()), button2.getBackground() );
		//switch occupation status, update seatbuttons, and recheck for correct bg color
		button1.getSeat().setOccupied(false);
		button2.getSeat().setOccupied(true);
		button1.checkStatus();
		button2.checkStatus();
		assertEquals((new JButton().getBackground()), button1.getBackground() );
		assertEquals(Color.DARK_GRAY, button2.getBackground());
	}
	

}
