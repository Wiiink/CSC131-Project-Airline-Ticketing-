package AirlineTicketer;
import javax.swing.JComboBox;
import java.util.HashSet;

//dropbox object for flight selection
//observer for ticketsubject class
public class FlightSelection extends JComboBox<Airplane> implements TicketObserver{
	
	//list of available flights from masterList
	private HashSet<Airplane> planes = Utilities.getFlightList();
	
	public FlightSelection() {
		super();
		setMaximumRowCount(10);
		setUp();
	}
	
	//adds Airplanes as items on the dropbox (by default no item selected)
	public void setUp() {
		removeAllItems();
		for(Airplane a : planes) {
			addItem(a);
		}
		setSelectedItem(null);
	}
	
	//updates flight list if necessary
	public void setPlanes(HashSet<Airplane> planes) {
		this.planes = planes;
		setUp();
	}
	
	//updates selected flight from subject object
	public void handleNotification(boolean[] state, TicketSubject t) {
		if(state[0]) setSelectedItem(((TicketTracker)t).getPlane());
	}
	
}
