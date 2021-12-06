package AirlineTicketer;

public class Seat {
	
	private boolean occupied;
	private int seatNumber;
	
	public Seat() {
		occupied = false;
		seatNumber = -1;
	}
	
	public Seat(int seatNumber) {
		occupied = false;
		this.seatNumber = seatNumber;
	}
	
	public Seat(boolean occupied, int seatNumber) {
		this.occupied = occupied;
		this.seatNumber = seatNumber;
	}
	
	public int getSeatNum() {
		return seatNumber;
	}
	
	public boolean getOccupied() {
		return occupied;
	}
	
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
	public String toString() {
		return "Seat number: " + seatNumber +", occupied: " + occupied;
	}

}
