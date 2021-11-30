import java.util.TreeSet;
import java.util.HashSet;

//contains several resources to be used across classes as needed
public class Utilities {
	
	//locations to be used for departre/destinations
	public static final String[] LOCATIONS = {"New York", "Los Angeles", "Chicago", "Houston", "San Francisco", "Philidelphia"};
	//All Airplane objects created are stored in the masterList
	private static HashSet<Airplane> masterList = new HashSet<Airplane>();
	//Amount of seats to for each plane (recommended to be divisible by 6)
	public static final int FLIGHT_CAPACITY = 18;
	
	//add a new flight to the masterList
	public static void addFlight(Airplane plane) {
		if(plane!=null) {
			masterList.add(plane);
		}
	}
	
	//remove flight from masterList
	public static void removeFlight(Airplane plane) {
		masterList.remove(plane);
	}
	
	//returns a clone of the masterList (to avoid direct tampering)
	public static HashSet<Airplane> getFlightList() {
		return (HashSet<Airplane>)masterList.clone();
	}
	
	//checks if there are any flights existing
	public static boolean isEmpty() {
		return masterList.isEmpty();
	}
	
	
}
