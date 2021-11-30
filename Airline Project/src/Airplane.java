
public class Airplane {
	
	private int id;
	private String destination;
	private String departure;
	private Seat[] seats;
	private static int capacity = Utilities.FLIGHT_CAPACITY;
	
	public Airplane(int id, String departure, String destination) {
		this.id = id;
		this.departure = departure;
		this.destination = destination;
		seats = new Seat[capacity];
		for(int i = 0; i<capacity; i++) {
			seats[i] = new Seat(i+1);
		}
	}
	
	public Airplane(int id, String departure, String destination, boolean[] occupied) {
		if (occupied.length!=capacity) throw new IllegalArgumentException();
		this.id = id;
		this.departure = departure;
		this.destination = destination;
		seats = new Seat[capacity];
		for(int i = 0; i<capacity; i++) {
			seats[i] = new Seat(occupied[i], i+1);		
		}
	}
	
	public String getDestination() {
		return destination;
	}
	
	public String getDeparture() {
		return departure;
	}
	
	public int getID() {
		return id;
	}
	
	
	public Seat[] getSeats() {
		return seats;
	}
	
	//returns a basic representation of Airplane
	public String toString() {
		return "#"+ id + ", " + departure + " to " + destination;
	}
	
	//returns a detailed representation Airplane (seats represented as a binary set)
	public String toStringExtended() {
		String s = "#"+ id + ", " + departure + " to " + destination + ", ";
		for(int i=0; i<seats.length; i++) {
			int temp;
			if(seats[i].getOccupied()==true) temp = 1;
			else temp = 0;
			
			s+=temp;
		}
		return s;
	}
}
