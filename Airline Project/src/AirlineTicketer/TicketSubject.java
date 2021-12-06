package AirlineTicketer;
public interface TicketSubject {
	
	public void addObserver(TicketObserver o);
	
	public void removeObserver(TicketObserver o);
	
	public void notifyObservers();
	
}