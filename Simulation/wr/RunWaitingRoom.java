package Simulation.wr;


import java.util.Scanner;

public class RunWaitingRoom
{	
	public static String message;
	
	public static void main(String[] args) {
		WaitingRoom theClinic = new WaitingRoom();
		
		runWaitingRoom(theClinic);
		runWithNumDoctorProjections(theClinic);
		runWithNumPercentageProjections(theClinic);
	}
		
		public static void runWaitingRoom(WaitingRoom theClinic) {
			Scanner input = new Scanner(System.in);
		theClinic.setValues(input);
		//run clinic.run() 100 times to mitigate randomness
				int sumPatients = 0;
				double sumWaitTime = 0;
				for (int i = 0; i < 100; i++)
				{
					theClinic.run();
					sumPatients += theClinic.getPeopleSeen();
					sumWaitTime += theClinic.getAverageWaitTime();
				}
				//calculate averages
				double avgPatients = sumPatients / 100;
				double avgWaitTime = sumWaitTime / 100;
						
				message = ("Average patients serviced: " + avgPatients);
				message = ("Average wait time patients waited: " + avgWaitTime);
	}
		
		public static void runWithNumDoctorProjections(WaitingRoom theClinic)
		{
			System.out.println("Adding one doctor:");
			theClinic.setNumDoctors(theClinic.getNumDoctors() + 1);
			
			int sumPatients = 0;
			double sumWaitTime = 0;
			for (int i = 0; i < 100; i++)
			{
				theClinic.run();
				sumPatients += theClinic.getPeopleSeen();
				sumWaitTime += theClinic.getAverageWaitTime();
			}
			//calculate averages
			double avgPatients = sumPatients / 100;
			double avgWaitTime = sumWaitTime / 100;
					
			System.out.println("Average patients serviced: " + avgPatients);
			System.out.println("Average wait time patients waited: " + avgWaitTime);
		}
		
		private static void runWithNumPercentageProjections(WaitingRoom theClinic) {
			//set all percentages -5%
			
		}
	
}
