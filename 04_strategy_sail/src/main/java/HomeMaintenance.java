public class HomeMaintenance implements MaintenanceBehaviour {

    @Override
    public void maintainShip(Ship ship) {
        ship.setMaintenaceBill(0.0);
        ship.setDistanceSinceLastService(0.0);
        
    }
}
