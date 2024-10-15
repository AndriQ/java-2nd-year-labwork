public abstract class PlaneState {
    
    protected PlaneStage planeStage;
    protected Plane plane;

    public void setPlane(Plane plane){
        this.plane = plane;
    }
    
    public abstract void setState();

    public PlaneStage getPlaneStage(){
        return planeStage;
    }
}
