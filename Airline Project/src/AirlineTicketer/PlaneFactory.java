package AirlineTicketer;
import java.util.HashSet;
import java.util.Random;

//This class is used to generate a set number of random flights for the program
//**Factory design pattern**
public class PlaneFactory {
	
	//flights to be created
	public static final int TOTAL_FLIGHTS = 10;
	private static Random rand = new Random();
	
	//list of unique ID's created for flights
	private static HashSet<Integer> flightIDList = new HashSet<Integer>();
	
	public static HashSet<Airplane> createFlights() {
		
		HashSet<Airplane> list = new HashSet<Airplane>();
		
		String[] locations = Utilities.LOCATIONS; 
		int capacity = Utilities.FLIGHT_CAPACITY;
		
		//create x amount of Airplanes
		for(int i=0; i<TOTAL_FLIGHTS; i++) {
			//generate random 6-digit id, check if unique
			int id = rand.nextInt(900000)+100000; 
			while(flightIDList.contains(id)) {
				id = rand.nextInt(900000)+100000;
			}
			
			//generate destination/departure
			int temp1 = rand.nextInt(locations.length);
			int temp2 = rand.nextInt(locations.length);
			while(temp2==temp1) {
				temp2 = rand.nextInt(locations.length);
			}
			String depart = locations[temp1];
			String dest = locations[temp2];
			
			//generate boolean[] that will represent available seats
			boolean[] occupiedSeats = new boolean[capacity];
			for(int j=0; j<capacity; j++) {
				occupiedSeats[j] = rand.nextBoolean();
			}
			//create Airplane and add it to the masterList
			//return list
			//Utilities.addFlight(new Airplane(id, depart, dest, occupiedSeats));
			list.add(new Airplane(id, depart, dest, occupiedSeats));
			flightIDList.add(id);
		}
		return list;
	}
	
}
