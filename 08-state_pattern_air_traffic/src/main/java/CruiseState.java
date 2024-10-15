public class CruiseState extends PlaneState {

    private static final int LAND_VARIABLE = 50;

    public CruiseState(Plane plane) {
        this.plane = plane;
        this.planeStage = PlaneStage.CRUISE;
    }

    @Override
    public void setState() {
        if (plane.distanceToTravel > LAND_VARIABLE) {
            plane.decrementDistanceToTravel(LAND_VARIABLE);
            plane.setState(new CruiseState(plane));
        } else {
            LandState landStateInstance = LandState.getInstance(plane);
            plane.setState(landStateInstance);
        }
    }
}
