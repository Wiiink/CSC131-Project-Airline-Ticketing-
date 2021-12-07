package AirlineTicketer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Panel object for seat selection
//Observer for TicketSubject
public class SeatSelect extends JPanel implements TicketObserver{
	
	private ActionListener listener;//listener for when a seat is picked
	
	//Panel dimensions based on flight capacity
	private static final int rows = 6;
	private static final int col = Utilities.FLIGHT_CAPACITY/6;
	private static String[] buttonText = new String[col*rows];
	//selected plane
	private Airplane plane;
	
	public SeatSelect(ActionListener listener) {
		super();
		this.listener = listener;
		createText();
		setUpLayout();
	}
	
	//Generates text for seats
	//length of text created is based on panel dimensions
	public void createText() {
		char curRow = 64; 
		for(int i=0; i<col; i++) {
			curRow++;
			for(int j=0; j<rows; j++) {
				buttonText[6*i+j] = curRow+String.valueOf(j+1);
			}
		}
	}
	

	//creates noninteractable set of empty "seats"
	public void setUpLayout() {
		removeAll();
		setLayout(new GridLayout(col,rows));
		for(int i=0; i<col*rows; i++) {
			JButton b = new JButton();
			b.setBackground(Color.DARK_GRAY);
			add(b);
		}
	}
	
	//creates interactable set of "seats" from list of Seat objects
	//occupied seats do not have listeners attached
	public void setUpLayout(Seat[] seats) {
		removeAll();
		int i=0;
		setLayout(new GridLayout(col,rows));
		for(String s : buttonText) {
			SeatButton button = new SeatButton(s, seats[i]);
			if(!seats[i].getOccupied())button.addActionListener(listener);
			add(button);
			i++;
		}
		
	}
	
	//handles notifications from subject that indicate change of plane and seats to be displayed
	public void handleNotification(boolean[] state, TicketSubject t) {
		if(state[0] || state[1]) {
			plane = ((TicketTracker)t).getPlane();
			setUpLayout(plane.getSeats());
		}
	}
	
}
