package AirlineTicketer;
import java.util.HashSet;

//contains several resources to be used across classes as needed
public final class Utilities {
	
	//locations to be used for departre/destinations
	public static final String[] LOCATIONS = {"New York", "Los Angeles", "Chicago", "Houston", "San Francisco", "Philidelphia"};
	
	//All Airplane objects created are stored in the masterList
	private static final HashSet<Airplane> masterList = PlaneFactory.createFlights();
	
	//Amount of seats to for each plane (recommended to be divisible by 6)
	public static final int FLIGHT_CAPACITY = 18;
	
	//returns a clone of the masterList (to avoid direct tampering)
	public static HashSet<Airplane> getFlightList() {
		return (HashSet<Airplane>)masterList.clone();
	}
}
