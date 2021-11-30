import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;


//Main GUI for booking process
public class UIWindow extends JFrame implements ActionListener{
	
	private Container contentPane = getContentPane();
	private static UIWindow window;
	private static boolean exists = false;
	
	private UIWindow() {
		super();
		setupLayout();
		//pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//Create and maintain only one instance of UIWindow at a time (Singleton)
	public static UIWindow windowCreator() {
		if(!exists) {
			window = new UIWindow();
			exists = true;
			return window;
		}
		else return window;
	}
	
	public void setupLayout() {
		setSize(1000,700);
		setResizable(false);
		
		contentPane.setLayout(new BorderLayout());
		
		//create seat and flight selection components (seatSelect listens to flightSelection)
		SeatSelect seats = new SeatSelect(this);
		contentPane.add(seats, BorderLayout.CENTER);
		
		FlightSelection flights = new FlightSelection();
		contentPane.add(flights, BorderLayout.NORTH);
		flights.addActionListener(seats);
		
		contentPane.add(new JLabel("Select your seat"), BorderLayout.WEST);
		
	}
	
	//responds to selection of available Seats once picked
	public void actionPerformed(ActionEvent e) {
		SeatButton source = (SeatButton)e.getSource();
		Seat selected = source.getSeat();
		if(selected!=null) {//Seat exists
			//occupy seat, and remove listener(avoid double booking)
			selected.setOccupied(true);
			System.out.println("Selection Confirmed"); //confirmation prompted on console insteaed of in frame
			source.removeActionListener(this);
			source.checkStatus();
		}
	}
	
}
