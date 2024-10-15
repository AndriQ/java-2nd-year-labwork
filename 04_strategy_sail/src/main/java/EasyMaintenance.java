public class EasyMaintenance implements MaintenanceBehaviour{

	public static double EASY_MAINTENANCE_MUTIPLIER = 0.005;
	
	@Override
	public void maintainShip(Ship ship) 
	{	
		ship.setMaintenaceBill(ship.getDistanceSinceLastService() * EASY_MAINTENANCE_MUTIPLIER);
		ship.setDistanceSinceLastService(0.0);
	}

}
