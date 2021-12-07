package jUnitTest;

import static org.junit.Assert.*;

import java.awt.BorderLayout;

import org.junit.Test;

import AirlineTicketer.FlightSelection;
import AirlineTicketer.SeatSelect;
import AirlineTicketer.TicketHandler;
import AirlineTicketer.UIWindow;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JLabel;

public class UITest {

	@Test
	public void windowCreator() {
		//test singleton design for UIWindow
		UIWindow window1 = UIWindow.windowCreator();
		UIWindow window2 = UIWindow.windowCreator();
		assertSame("windowCreator()", window1, window2);
	}
	
	@Test
	//checks all components are added correctly within a JFrame
	public void componentTest() {
		UIWindow window = UIWindow.windowCreator(); //JFrame as created in AirlineProgram
		Container pane = window.getContentPane();
		int components = 5;
		//check correct number of components added
		assertTrue("getLayout()", pane.getLayout() instanceof BorderLayout);
		assertEquals("getComponentCount()", components, pane.getComponentCount());
		//check each component corresponds to specific object
		assertTrue("feedback Component", pane.getComponent(0) instanceof TicketHandler);
		assertTrue("Seat Select Component", pane.getComponent(1) instanceof SeatSelect);
		assertTrue("Flight Select Component", pane.getComponent(2) instanceof FlightSelection);
		assertTrue("label component", pane.getComponent(3) instanceof JLabel);
		assertTrue("confirm button component", pane.getComponent(4) instanceof JButton);
		//check each component is not null
		for(int i=0; i<components; i++) {
			assertNotNull(pane.getComponent(i));
		}
	}

}
