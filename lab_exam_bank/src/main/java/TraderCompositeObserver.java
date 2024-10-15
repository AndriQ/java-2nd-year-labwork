public class TraderCompositeObserver implements GroupMembersComposite, Observer { 
    
    private AssetType assetType;
    public String[] trades;
    protected int balance = 0;
    private int tradeCounter = 0;   
    private Person person; 
    private TraderAssetDeskSubject traderAssetDesk;

    public TraderCompositeObserver(Person person, AssetType assetType, int balance, String[] trades){
        this.person = person;
        this.assetType = assetType;
        this.trades = trades;
        this.balance = balance;
    }

    public void checkBalanceAndNotify() {
        if (this.balance > traderAssetDesk.wia) {
            System.out.println("Warning! Balance: " + this.balance + ". The individual " + this.getName() + " is above the limit");
            traderAssetDesk.notifyObservers(this);
        } else if (this.balance < traderAssetDesk.wib) {
            System.out.println("Warning! Balance: " + this.balance + ". The individual " + this.getName() + " is below the limit");
            traderAssetDesk.notifyObservers(this);
        } else {
            System.out.println("Balance: " + this.balance + ". The individual " + this.getName() + " is within the limits");
        }
    }

    @Override
    public String getName(){
        return person.getName();
    }

    public AssetType getAssetType(){
        return assetType;
    }
    
    @Override
    public Role getRole(){
        return person.getRole();
    }

    public void trade(){
        balance += Integer.parseInt(trades[tradeCounter]);
        tradeCounter ++;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setTraderAssetDesk(TraderAssetDeskSubject traderAssetDesk) {
        this.traderAssetDesk = traderAssetDesk;
    }
    
    @Override
    public void balanceLimitExceeded(TraderCompositeObserver trader) {
        System.out.println("Warning to Team Leader: " + this.getName() + "! A trader in your team has a balance exceeding the limits: " + trader.getName());
    }
}