public class GroundRollState extends PlaneState {

    public GroundRollState(Plane plane) {
        this.plane = plane;
        this.planeStage = PlaneStage.GROUND_ROLL;
    }

    @Override
    public void setState() {
        plane.setState(new AirDistanceState(plane));
    }

}
