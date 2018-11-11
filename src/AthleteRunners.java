

public class AthleteRunners {
	 static int nextBibNumber=0;
     static String raceLocation = "New Jersey";
     static String raceStartTime = "9.00am";

     String name;
     int speed;
     int bibNumber;
     
     AthleteRunners (String name, int speed){
     this.name = name;
     this.speed = speed;
     bibNumber =  ++nextBibNumber;
     
     }

     public static void main(String[] args) {
    	 	AthleteRunners a1 = new AthleteRunners("Joe", 5);
    	 	AthleteRunners a2 = new AthleteRunners("Ron", 7);
    	 	
    	 	System.out.println(a1.name);
    	 	System.out.println(a2.name);
    	 	
    	 	System.out.println();
    	 	
    	 	System.out.println(a1.bibNumber);
    	 	System.out.println(a2.bibNumber);
    	 	
    	 	System.out.println();
    	 	
    	 	System.out.println(raceLocation);
    	 	System.out.println(raceStartTime);
     //create two athletes      //print their names, bibNumbers, and the location of their race. }
     }
}
