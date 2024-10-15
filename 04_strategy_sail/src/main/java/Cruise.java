public class Cruise extends Ship{
	
	public Cruise(TravelBehaviour travel, MaintenanceBehaviour maintain) 
	{
		super(travel, maintain);
		this.maxSpeed = 35.0;
	}
	
	public void takeDamage()
	{
		setMaintain(new HardMaintenance());
	}
}
