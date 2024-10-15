public class AirDistanceState extends PlaneState {

    public AirDistanceState(Plane plane) {
        this.plane = plane;
        this.planeStage = PlaneStage.AIR_DISTANCE;
    }

    @Override
    public void setState() {
        plane.setState(new ClimbOutState(plane));
    }
}
