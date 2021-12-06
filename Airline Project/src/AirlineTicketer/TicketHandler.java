package AirlineTicketer;
import java.awt.Color;
import javax.swing.JLabel;

//Feedback label that displays selections made during program
//Observer to TicketSubject
public class TicketHandler extends JLabel implements TicketObserver{
	
	public TicketHandler(String text) {
		super(text);
		setBackground(Color.CYAN);
	}
	
	//handles state changes to subject
	public void handleNotification(boolean[] state, TicketSubject subject) {
		//confirmation button pressed, display confirmation & reset seat selection
		if(state[2] && (subject instanceof TicketTracker)) {
			TicketTracker b = (TicketTracker)subject;
			if(b.getSeat()!=null) {
				b.getSeat().setOccupied(true);
				setText("Selection Confirmed");
				b.setSeat(null);
			}
		}
		//seat selected, display feedback
		else if(state[1] && ((TicketTracker)subject).getSeat()!=null) {
			setText("seat selected");
		}
		//no feedback to display
		else setText("");
	}
	
}
