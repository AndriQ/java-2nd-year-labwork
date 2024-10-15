public class ConcreteTraderFactory implements TraderFactory {

    @Override
    public TraderCompositeObserver createTrader(String[] data) {
        Role role = Role.getFromName(data[0]);
            String firstName = data[1];
            String lastName = data[2];
            AssetType assetType = AssetType.getFromName(data[3]);
            int balance = Integer.parseInt(data[4]);
            String[] trades = data[5].split(";");

            Person person = new Person(role, firstName, lastName);

            return new TraderCompositeObserver(person, assetType, balance, trades);
    }
}
