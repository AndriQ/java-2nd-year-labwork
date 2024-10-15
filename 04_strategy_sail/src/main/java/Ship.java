public abstract class Ship {
	
	protected TravelBehaviour travelBehaviour;
	protected MaintenanceBehaviour maintainBehaviour;
	private double maintenanceBill;
	private double distanceSinceLastService;
	protected double maxSpeed;
	
	public Ship(TravelBehaviour travel, MaintenanceBehaviour maintain)
	{
		this.travelBehaviour = travel;
		this.maintainBehaviour = maintain;
		this.maintenanceBill = 0.0;
		this.distanceSinceLastService = 0.0;
	}
	
	public double travel(double timeTravelled) {
		double distance = travelBehaviour.travel(timeTravelled, this);
		distanceSinceLastService += distance;
		return distance;
	}

	public void maintain()
	{
		maintainBehaviour.maintainShip(this);
	}
	
	public double getVehicleSpeed() {
		return maxSpeed;
	}

	public void setVehicleSpeed(double speed) {
		this.maxSpeed = speed;
	}

	public TravelBehaviour getTravel() {
		return travelBehaviour;
	}

	public void setTravel(TravelBehaviour travel) {
		this.travelBehaviour = travel;
	}

	public MaintenanceBehaviour getMaintain() {
		return maintainBehaviour;
	}

	public void setMaintain(MaintenanceBehaviour maintain) {
		this.maintainBehaviour = maintain;
	}

	public double getMaintenanceBill() {
		return maintenanceBill;
	}

	public void setMaintenaceBill(double maintenaceBill) {
		this.maintenanceBill = maintenaceBill;
	}



	public double getDistanceSinceLastService() {
		return distanceSinceLastService;
	}

	public void setDistanceSinceLastService(double distanceSinceLastService) {

		this.distanceSinceLastService = distanceSinceLastService;
	}

	

	
}
