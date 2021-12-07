package AirlineTicketer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;

//Subject class that keeps track of selected items(plane/seat) and notifies observers of changes
public class TicketTracker implements TicketSubject, ActionListener{
	
	private ArrayList<TicketObserver> observers = new ArrayList<TicketObserver>();
	private Airplane plane = null;
	private Seat seat = null;
	
	//boolean[] representing changes made to aspects where...
	//modified[0]=selected plane changed
	//modified[1]=selected seat changed
	//modified[2]=selection(seat&plane) is confirmed
	private boolean[] modified = {false, false, false};
	
	//add observer object to this subject
	public void addObserver(TicketObserver o) {
		observers.add(o);
		notifyObservers();
	}
	
	//remove observer from this subject
	public void removeObserver(TicketObserver o) {
		observers.remove(o);
	}
	
	public ArrayList<TicketObserver> getObservers(){
		return observers;
	}
	
	//notifies all observer objects to current state and changes
	public void notifyObservers() {
		//observers recieve a copy of changes, so local version may be reset
		for(TicketObserver o : observers) {
			o.handleNotification(modified.clone(), this);
		}
		//reset notifications
		modified[0]=false;
		modified[1]=false;
		modified[2]=false;
	}
	
	//returns current plane selected
	public Airplane getPlane() {
		return plane;
	}
	
	//returns current seat selected
	public Seat getSeat() {
		return seat;
	}
	
	//sets selected seat to a new given seat, notifies observers
	public void setSeat(Seat seat) {
		this.seat = seat;
		modified[1] = true;
		notifyObservers();
	}
	
	//handles actions from selection objects and creates observer notifications
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		//flight is selected (seat selection is reset)
		if(source instanceof FlightSelection) {
			Airplane newPlane = ((Airplane)((JComboBox<Airplane>)source).getSelectedItem());
			if(newPlane!=null && !newPlane.equals(plane)) {
				plane = newPlane;
				seat = null;
				modified[0] = true;
				modified[1] = true;
			}
		}
		//seat is selected
		else if(source instanceof SeatButton) {
			Seat newSeat = ((SeatButton)source).getSeat();
			seat = newSeat;
			modified[1] = true;
		}
		//confirmation button is pressed
		else if(source instanceof JButton && ((JButton)source).getText().contains("Confirm")) {
			if(seat!=null) modified[2] = true;
		}
		//notify observers to changes
		notifyObservers();
	}
	
}
