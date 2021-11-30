import java.awt.Color;

import javax.swing.*;

//The individual button used in the SeatSelect panel
public class SeatButton extends JButton{
	
	private Color defaultColor = Color.GRAY;
	private Seat seat;
	
	public SeatButton(String text) {
		super(text);
	}
	
	public SeatButton(String text, Seat seat){
		super(text);
		this.seat = seat;
		checkStatus();
	}
	
	public Seat getSeat() {
		return seat;
	}
	
	public void setSeat(Seat seat){
		this.seat = seat;
		checkStatus();
	}
	
	//refreshes the buttons color based on whether seat is occupied(gray) or not(blue)
	public void checkStatus() {
		if(seat.getOccupied()==false) defaultColor = (new JButton()).getBackground();
		else defaultColor = Color.DARK_GRAY;
		
		setBackground(defaultColor);
	}
	
}
