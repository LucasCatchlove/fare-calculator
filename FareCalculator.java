// -------------------------------------------------------
// Assignment 2
// Written by: Lucas catchlove 27145640
// For COMP 248 Section (section U) – Winter 2020
// --------------------------------------------------------
/* This program estimates the cost of a taxi ride based on several factors. 
 * The user must specify the type of car they would like too ride in, 
 * the time of week, and the time of day given a few options
 *  for each of these factors. Based on the choices made by the user, the total
 *  cost is calculated and displayed for the user to see. 
 */

import java.util.Scanner;
public class FareCalculator {

	public static void main(String[] args) {
		//declaration of variables
		double LIMO_FARE, BASE_CAR_FARE, carFare, rideDistance,
		WEEKDAY_DAYTIME_RATIO, WEEKEND_RATIO,
		rushHourRatio; 

		int carType, WEEKDAY_OVERNIGHT_RATIO,
		WEEKEND_OVERNIGHT_RATIO, WEEKDAY_EVENING_RATIO, dayOfWeek, timeOfDay; 
		
		//initialization of variables
		LIMO_FARE = 1.55;
		BASE_CAR_FARE = 0.81; 
		WEEKDAY_DAYTIME_RATIO = 1.5; 
		WEEKDAY_EVENING_RATIO = 1;
		WEEKDAY_OVERNIGHT_RATIO = 2;
		WEEKEND_OVERNIGHT_RATIO  = 2;
		WEEKEND_RATIO = 1.3; 
		rushHourRatio = 0.0;
		carFare = 0.0;
		//welcome message
		System.out.println("*****************************************\n" +
				"           Taxi Fare Calculator           \n" + 
				"*****************************************\n"); 

		Scanner keyInput = new Scanner(System.in); 
		//receives users inputted car choice 
		System.out.println("Select a car type.\nEnter: \"1\" for a base car or \"2\" for a limo:");
		carType = keyInput.nextInt();

		if(carType == 1)
			carFare = BASE_CAR_FARE;
		else if(carType == 2)
			carFare = LIMO_FARE; 

		//receives users inputted choice of weekday
		System.out.println("Select a period of the week.\nEnter: \"1\" for a"
				+ " weekday or \"2\" for the weekend:");
		dayOfWeek = keyInput.nextInt(); 
		
		//receives users inputted choice of time of day depending on the weekday they chose
		if(dayOfWeek == 1)
		{
			System.out.println("Select a time of day.\n"
					+"Enter \"1\" for daytime (8am-10am and 4pm -5pm),\n \"2\" for overnight (12am-6am),"
					+ " or \"3\" for evening): ");

			timeOfDay = keyInput.nextInt();
			if(timeOfDay == 1)
				rushHourRatio = WEEKDAY_DAYTIME_RATIO; 
			else if(timeOfDay == 2)
				rushHourRatio = WEEKDAY_OVERNIGHT_RATIO; 
			else if(timeOfDay == 3)
				rushHourRatio = WEEKDAY_EVENING_RATIO; 

		}

		else if(dayOfWeek == 2)
		{ 
			System.out.println("Select a time of day.\n"
					+"Enter \"1\" for overnight (12am-6am) or "+
					"\"2\" for daytime or evening): ");

			timeOfDay = keyInput.nextInt();

			if(timeOfDay == 1)
				rushHourRatio = WEEKEND_OVERNIGHT_RATIO; 
			else if(timeOfDay == 2)
				rushHourRatio = WEEKEND_RATIO; 
		}

		//receives users inputted ride distance 
		System.out.println("Enter a distance (km): ");
		rideDistance = keyInput.nextInt();
		
		//displays the total cost for the taxi ride
		System.out.println("\nYour ride costs: $"+ rushHourRatio*rideDistance*carFare);
		
		//displays a goodbye message 
		System.out.print("\nthank you for using Taxi Fare Calculator!");
		
		//closes the scanner
		keyInput.close();

	}
	
	

}
