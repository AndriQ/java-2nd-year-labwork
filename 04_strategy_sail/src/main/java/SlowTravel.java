public class SlowTravel implements TravelBehaviour{

	public double travel(double hoursTravelled, Ship ship) 
	{	
		return 0.3 * hoursTravelled * ship.maxSpeed;
	}
}
