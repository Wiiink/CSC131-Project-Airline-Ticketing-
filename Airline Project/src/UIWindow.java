import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


//Main GUI for booking process
public class UIWindow extends JFrame{
	
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
		
		//create and add components for JFrame
		//(SeatSelect, FlightSelect, confirm button, TicketHandler) are observers to TicketTracker
		//TicketTracker(subject) is an ActionListener to FlightSelect, SeatButton, and confirm button
		TicketTracker selection = new TicketTracker();
		TicketHandler feedback = new TicketHandler("");
		selection.addObserver(feedback);
		contentPane.add(feedback, BorderLayout.EAST);
		
		SeatSelect seats = new SeatSelect(selection);
		selection.addObserver(seats);
		contentPane.add(seats, BorderLayout.CENTER);
		
		FlightSelection flights = new FlightSelection();
		contentPane.add(flights, BorderLayout.NORTH);
		flights.addActionListener(selection);
		selection.addObserver(flights);
		
		contentPane.add(new JLabel("Select your seat"), BorderLayout.WEST);
		
		JButton confirm = new JButton("Confirm selection");
		confirm.addActionListener(selection);
		contentPane.add(confirm, BorderLayout.SOUTH);
	}
	
}
