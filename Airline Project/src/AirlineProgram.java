//Main class that runs the Airline Ticket program
public class AirlineProgram {
	
	
	public static void main(String[] arg) {
		//create flights for program
		PlaneFactory.createFlights();
		//setup JFrame
		UIWindow window = UIWindow.windowCreator();
		window.setTitle("Airline Demo");        
        window.setVisible(true);
        
	}
	
	
	
	
}
