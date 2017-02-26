package Simulation.wr;

public class Patient {
	
	  /***** instance variables *****/
	  private  int myTimeOfArrival;
	  private  int myServiceTime;
	  private int myWaitTime;
	private int id;
	
	    /***** methods *****/
	   /***** Constructor *****/
	  
	  /*----------------------------------------------------------
	     Construct a Call object (default).

	     Precondition:  None
	     Postcondition: All data members are initialized to 0.
	       
	   -----------------------------------------------------------*/
	   public Patient(){ 
	    myTimeOfArrival = myServiceTime = myWaitTime = 0; 
	 }
	  
	   /*----------------------------------------------------------
	     Construct a Call object (explicit-value).

	     Precondition:  Countdown timer t is received
	     Postcondition: myTimeOfArrival has been set to time left
	         on Timer t and myServiceTime to serviceTime.
	       
	   -----------------------------------------------------------*/
	   public Patient( int id, Timer  t, int serviceTime)
	   { 
		   this.id = id;
		    // record call's time of arrival
		    myTimeOfArrival = t.timeRemaining();
		   
		    // set its service time
		    myServiceTime = serviceTime;
		 }
	  

	   public int getArrivalTime()  {
		    return myTimeOfArrival;
		 }
	   

	   public int getServiceTime() {
		    return myServiceTime;
		 }
	  

	   public void setWaitTime(int t)
	   {
		   myWaitTime = t;
	   }
	   
	   public int getWaitTime()
	   {
		   return myWaitTime;
	   }
	   void display() {
		   System.out.println( "Arrival Time:    " +  myTimeOfArrival +
	 	       "\nService Time:    " + myServiceTime );
	 }

	public int getID()
	{
		// TODO Auto-generated method stub
		return id;
	}

	   public String toString()
	   {
		   StringBuilder str = new StringBuilder();
		   
		   str.append("Call #" + id + " Arrival time: " + myTimeOfArrival + " Service time: " + myServiceTime + "\n");
		   
		   return str.toString();
		   
	   }
	 
	 } 
