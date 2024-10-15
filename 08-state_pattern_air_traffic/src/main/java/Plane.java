import java.util.List;
import java.util.ArrayList;

public class Plane {
    private PlaneState planeState;
    private String name;
    private List<PlaneState> states = new ArrayList<PlaneState>();
    protected int counter = 0;
    protected final static int MAX_STATES = 10;
    protected int distanceToTravel = 0;

    public Plane(String name, int distanceToTravel){
        this.name = name;
        this.distanceToTravel = distanceToTravel;
    }

    public PlaneState getPlaneState(){
        return planeState;
    }

    public int getDistanceToTravel(){
        return distanceToTravel;
    }

    public int getCounter(){
        return counter;
    }

    public List<PlaneState> getStates(){
        return states;
    }

    protected void sleep(int decaseconds){
        try {
            Thread.sleep(decaseconds * 100);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void decrementDistanceToTravel(int distance) {
        distanceToTravel -= distance;
    }

    public void setState(PlaneState planeState){
        this.planeState = planeState;
        states.add(planeState);
        System.out.println(name + " " + planeState.getPlaneStage());
        sleep(3);
        if (counter < MAX_STATES){
            this.planeState.setState();
        }
        counter ++;
    }
}
