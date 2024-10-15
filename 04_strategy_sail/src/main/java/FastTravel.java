public class FastTravel implements TravelBehaviour{

    public double travel(double hoursTravelled, Ship ship)
    {
        return hoursTravelled * ship.maxSpeed;
    }

}
