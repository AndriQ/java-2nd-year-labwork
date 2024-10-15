public class Clipper extends Ship{

	public Clipper(TravelBehaviour travel, MaintenanceBehaviour maintain)
	{
		super(travel, maintain);
		this.maxSpeed = 30.0;
	}


	public void learnHomeMaintenance()
	{
		setMaintain(new HomeMaintenance());
	}

}
