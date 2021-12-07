package jUnitTest;

import static org.junit.Assert.*;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;

import org.junit.Test;

import AirlineTicketer.TicketTracker;
import AirlineTicketer.TicketHandler;
import AirlineTicketer.SeatSelect;
import AirlineTicketer.FlightSelection;
import AirlineTicketer.SeatButton;

public class eventAndObserverTest {

	@Test
	public void eventTest() {
		//set up observers, subject, and listeners as they would be in Airline program
		TicketTracker subject = new TicketTracker();
		TicketHandler feedback = new TicketHandler("");
		SeatSelect seats = new SeatSelect(subject);
		FlightSelection flights = new FlightSelection();
		JButton confirm = new JButton("Confirm selection");
		JButton button = new JButton();
		flights.addActionListener(subject);
		confirm.addActionListener(subject);
		button.addActionListener(subject);
		subject.addObserver(seats);
		subject.addObserver(flights);
		subject.addObserver(feedback);
		
		//////////////////ActionEvent coverage Testing////////////////////////
		
		//click unrelated action button that results in nothing
		button.doClick(250);
		//click confirmation button before plane/seat are selected
		confirm.doClick(250);
		//set flight dropbox to empty item
		flights.setSelectedItem(null);
		
		ArrayList<SeatButton> activeButtons = getActiveButtons(getButtons(seats)); //interactable SeatButtons
		
		//select new flight
		flights.setSelectedIndex(5);
		//re-select the same flight
		flights.setSelectedIndex(5);
		
		activeButtons = getActiveButtons(getButtons(seats));
		
		//Select a random seat
		clickRandomButton(activeButtons);
		//confirm seat choice
		confirm.doClick(250);
		
	}
	
	//returns list of all SeatButtons within a SeatSelect object
	public ArrayList<SeatButton> getButtons(SeatSelect seats){
		ArrayList<SeatButton> list = new ArrayList<SeatButton>();
		Component[] c = seats.getComponents();
		for(Component comp : c) {
			if(comp instanceof SeatButton) list.add((SeatButton)comp);
		}
		return list;
	}
	
	//returns a list of buttons with an existing actionlistener, given a list of buttons
	public ArrayList<SeatButton> getActiveButtons(ArrayList<SeatButton> buttons){
		ArrayList<SeatButton> list = new ArrayList<SeatButton>();
		for(SeatButton button : buttons) {
			if(button.getActionListeners().length != 0) list.add(button);
		}
		return list;
	}
	
	//click a random button from list of interactable buttons
	public void clickRandomButton(ArrayList<SeatButton> buttons) {
		Random rand = new Random();
		buttons.get(rand.nextInt(buttons.size())).doClick(250);
	}
	
	

}
