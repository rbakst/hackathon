package Simulation.wr;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class WaitingRoom
{
	static final int NUM_LIMITS = 5;
	private static int ID=0;
	//supplied by user
	private double arrivalRate;
	private int[] servicePercent;
	private int lengthOfSimulation;
	private int busyTimeRemaining;
	// Calculated Outputs - result of simulation
	private int peopleTaken;
	private double totalWaitingTime;
	private Timer myTimer;
	private Random numGenerator;
	private LinkedList<Patient> peopleWaiting; //will be a queue of calls
	private ArrayList<Patient> peopleServiced; //will be a list of who was serviced
	private int[] times;
	private int peopleSeen;
	private Patient currentCall;
	private int numDoctors;
	
	public WaitingRoom()
	{
		//peopleTaken = 0;
		totalWaitingTime = 0;
		busyTimeRemaining = 0;
		servicePercent = new int[NUM_LIMITS];
		servicePercent[0] = 0; //because this array is parallel to times, and 0% of people take 0 minutes
		myTimer = new Timer();
		numGenerator = new Random();
		peopleWaiting = new LinkedList<Patient>();
		peopleServiced = new ArrayList<Patient>();

		times = new int[] { 0, 15, 30, 45, 60 };
		peopleSeen=0;
		currentCall= null;
		numDoctors = 1;
	}
	
	public void setValues(Scanner in)
	{
		{
			System.out.println("How many doctors are there?");
			numDoctors = in.nextInt();
			System.out.println("Enter arrival rate:  patients per hour ");
			int peoplePerHour = in.nextInt();
			arrivalRate = peoplePerHour / 60.0;
			System.out.println("Enter percent of patients serviced for: ");
			int perc, sum = 0;
			//int j = 0;
			for (int i = 1; i < times.length; i++) //start at 1 b/c servicePercent[0] is hard coded 
			{
				//j++;
				System.out.println(times[i] + " min ");
				perc = in.nextInt();
				sum += perc;
				servicePercent[i] = sum; 
			}
			servicePercent[NUM_LIMITS - 1] = 100;
			System.out.println("Enter # of hours in your workday: ");
			lengthOfSimulation = in.nextInt() * 60; //convert hours to minutes
			myTimer.setTimer(lengthOfSimulation);
		}
		
	}
	
	/*
	 * FOR GUI
	 */
	public void setValues(int numDocs, int pplperhr, int fifteen, int thirty, int fortyfive, int sixty, int simulationLength)
	{
		numDoctors = numDocs; 
		
		arrivalRate = pplperhr / 60.0;
		
		servicePercent[1] = fifteen;
		servicePercent[2] = fifteen + thirty;
		servicePercent[3] = fifteen + thirty + fortyfive;
		servicePercent[4] = 100;

		lengthOfSimulation = simulationLength * 60; //convert hours to minutes
		myTimer.setTimer(lengthOfSimulation);
	}
	
	public void setNumDoctors(int num)
	{
		numDoctors = num;
	}
	
	
	public void run()
	{
		// Begin the simulation
		busyTimeRemaining = 0;
		while (myTimer.timeRemaining() > 0)
		{
			for (int i = 0; i < numDoctors; i++)
			{	
				service(currentCall); 
			}
			checkForNewCall(); //once per minute, no matter how many doctors
			myTimer.tick();
			
		}
		System.out.println("Not accepting more patients.");
		System.out.println("People still on queue:");
		System.out.println(peopleWaiting);
		// Service any remaining calls in incomingCalls queue
	//	while (!peopleWaiting.isEmpty())
	//	{
		//	service();
		//	myTimer.tick();
	//	}
		
		// Output the results
		//display();
	}
	
	public void checkForNewCall()
	{
		int x;
		x = numGenerator.nextInt(100);
		if (x < 100 * arrivalRate) //if the probability of getting a new call has been satisfied
		{
			// a new call has arrived. generate a random service time for it
			int rand = numGenerator.nextInt(100); //represents the percentage of the interval it will fall into
			int minutesForThisVisit = 0;
			
			for (int i  = 0; i < servicePercent.length; i++)
			{
				if (rand < servicePercent[i])
				{
					minutesForThisVisit = times[i];
					break; //so that we end the loop and don't keep checking all subsequent values in servicePercent array
				}
				
			}
			
			
			//construct a new Call and add it to the queue of incoming calls
			Patient newCall = new Patient(ID++, myTimer, minutesForThisVisit);
			peopleWaiting.addLast(newCall); //add to back of list
			peopleTaken++;
			
		}
	}
	
	//--- Definition of service()
	public void service(Patient c)
	{
		if (busyTimeRemaining > 0)
		{ // servicing a call
			busyTimeRemaining--;
			System.out.println("seeing patient " + c.getID());
		} // service it for another minute
		else if (!peopleWaiting.isEmpty()) // calls are waiting -- get one
		{
			//currentCall = getNextPatient();
			Patient nextCall = peopleWaiting.getFirst();
			nextCall.setWaitTime(nextCall.getArrivalTime() - myTimer.timeRemaining()); //setting how long the pt waited!
			//totalWaitingTime += peopleWaiting.size(); //TODO
			peopleServiced.add(nextCall);
			peopleWaiting.removeFirst();
			peopleSeen++;
			busyTimeRemaining = nextCall.getServiceTime();
			System.out.println("service time current call: " + nextCall.getServiceTime() + " minutes");
			currentCall = nextCall;
			// Update total waiting time
			//totalWaitingTime += nextCall.getArrivalTime() - myTimer.timeRemaining(); //TODO
			System.out.println("Total wait so far:  " + totalWaitingTime);
		}
	}
	
	/***
	 * Output Output: total number of call and the average waiting time for calls
	 * ---------------------------------------------------------
	 */
	/*
	public void display()
	{
		System.out.println("Number of people processed: " + peopleSeen + "\nAverage waiting time per patient:  "+
				totalWaitingTime / peopleSeen 
				+ " minutes");
	}
	*/
	public String toString()
	{
		return ("Number of people processed: " + peopleSeen + "\nAverage waiting time per patient:  "+
				totalWaitingTime / peopleSeen 
				+ " minutes");
	}
	
	public int getPeopleSeen()
	{
		return peopleSeen;
	}
	
	public double getAverageWaitTime()
	{
		int sum = 0;
		for (Patient pt: peopleServiced)
			sum += pt.getWaitTime();
		return sum / peopleServiced.size();
		
		//return totalWaitingTime / peopleSeen;
	}

	public int getNumDoctors() {
		return numDoctors;
	}
} // end of class declaration
