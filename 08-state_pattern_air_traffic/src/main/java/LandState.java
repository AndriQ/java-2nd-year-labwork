public class LandState extends PlaneState {

    private static LandState instance;

    private LandState(Plane plane) {
        this.plane = plane;
        this.planeStage = PlaneStage.LAND;
    }

    public static synchronized LandState getInstance(Plane plane) {
        if (instance == null) {
            instance = new LandState(plane);
        }    
        return instance;
    }

    @Override
    public void setState() {
        System.out.println("Finished");
    }
}
