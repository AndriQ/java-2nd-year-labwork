public class GoToRunwayState extends PlaneState {

    public GoToRunwayState(Plane plane) {
        this.plane = plane;
        this.planeStage = PlaneStage.GO_TO_RUNWAY;
    }

    @Override
    public void setState() {
        plane.setState(new GroundRollState(plane));
    }

}
