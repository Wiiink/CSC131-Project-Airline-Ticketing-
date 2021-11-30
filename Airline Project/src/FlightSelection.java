import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.HashSet;

//dropbox object for flight selection
//NOTE: when selecting items, item may have to be selected "twice" to update listener
public class FlightSelection extends JComboBox<Airplane> {
	
	private ActionListener listener; //listener for when an Airplane is chosen
	
	//list of available flights from masterList
	private HashSet<Airplane> planes = Utilities.getFlightList();
	
	
	public FlightSelection(ActionListener listener) {
		super();
		this.listener = listener;
		setMaximumRowCount(10);
		setUp();
	}
	
	
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
		setSelectedIndex(-1);
	}
	
	//updates flight list if necessary
	public void setPlanes(HashSet<Airplane> planes) {
		this.planes = planes;
		setUp();
	}
	
	
}
