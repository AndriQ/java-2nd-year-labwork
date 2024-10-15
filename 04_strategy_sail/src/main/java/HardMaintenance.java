public class HardMaintenance implements MaintenanceBehaviour {

    public static double HARD_MAINTENANCE_MUTIPLIER = 0.2;

    @Override
    public void maintainShip(Ship ship) 
    {
        ship.setMaintenaceBill(ship.getDistanceSinceLastService() * HARD_MAINTENANCE_MUTIPLIER);
		ship.setDistanceSinceLastService(0.0);
    }
}


