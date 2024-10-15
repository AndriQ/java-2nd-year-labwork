import java.util.List;
import java.util.ArrayList;

public class AirTrafficControl {

    private List<Plane> planes = new ArrayList<Plane>();

    public void add(Plane plane){
        planes.add(plane);
        plane.setState(new ParkedState(plane));
    }

    public static void main(String[] args){
        AirTrafficControl airTrafficControl = new AirTrafficControl();
        Plane planeHenry = new Plane("Henry", 50);
        Plane planeFran = new Plane("Fran", 100);
        airTrafficControl.add(planeHenry);
        airTrafficControl.add(planeFran);
    }
    
}
