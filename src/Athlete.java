
public class Athlete {
	static int nextBibNumber;
	static String raceLocation = "New York";
	static String raceStartTime = "9.00am";

	String name;
	int speed;
	// int bibNumber;

	Athlete(String name, int speed) {
		this.name = name;
		this.speed = speed;

		nextBibNumber++;
	}

	public static void main(String[] args) {

		AthleteRunners athlete1 = new AthleteRunners("Joe", 10);
		AthleteRunners athlete2 = new AthleteRunners("Larry", 12);

		System.out.println(nextBibNumber);
		System.out.println(nextBibNumber);

		System.out.println(athlete1.name);
		System.out.println(athlete2.name);

		System.out.println(raceLocation);
		System.out.println(raceStartTime);

		// create two athletes //print their names, bibNumbers, and the location of
		// their race. }
	}
}
