
public class Services {

	public String meal_type;
	public String disability_info;
	public String previous_flights;
	
	public void display_services()
	{
		System.out.println("Additional services available to our passengers are: \n");
		System.out.println("Types of Meals: Vegetarian/Non-Vegetarian \n");
		System.out.println("Special services for people with disability \n");
		System.out.println("More information related to previous flights \n");
	}
	
	public void check_prev_flights()
	{
		
	}
	
	public void display_disability_info()
	{
		
	}
	
	public void display_meal_options()
	{
		System.out.println("Meal options available on this flight: \n");
		System.out.println("Vegetarian Menu \n");
		System.out.println("Non-Vegetarian Menu \n");
		System.out.println("Other \n");
		
	}

}
