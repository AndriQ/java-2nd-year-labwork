public class ClimbOutState extends PlaneState {

    public ClimbOutState(Plane plane) {
        this.plane = plane;
        this.planeStage = PlaneStage.CLIMB_OUT;
    }
    
    @Override
    public void setState() {
        plane.setState(new CruiseState(plane));
    }
}
