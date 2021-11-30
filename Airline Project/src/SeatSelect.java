import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Panel object for seat selection (intended to be listener for flightSelection)
public class SeatSelect extends JPanel implements ActionListener{
	
	private ActionListener listener;//listener for when a seat is picked
	
	//Panel dimensions based on flight capacity
	private static final int rows = 6;
	private static final int col = Utilities.FLIGHT_CAPACITY/6;
	private static String[] buttonText = new String[col*rows];
	
	private Airplane plane = null;//Airplane chosen from previous step
	
	public SeatSelect() {
		super();
		createText();
		setUpLayout();
	}
	
	public SeatSelect(ActionListener listener) {
		super();
		this.listener = listener;
		createText();
		setUpLayout();
	}
	
	//once a flight is chosen, updates seat selection
	public void actionPerformed(final ActionEvent e) {
		JComboBox<Airplane> source = ((JComboBox<Airplane>)(e.getSource()));
		if (e.getActionCommand().isBlank()) plane = null;
		else {
			plane = ((Airplane)((JComboBox<Airplane>)(e.getSource())).getSelectedItem());
		}
		if(plane!=null) {
			setUpLayout(plane.getSeats());
		}
		else setUpLayout();
		
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
}
