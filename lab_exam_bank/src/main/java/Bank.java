import java.util.List;
import java.util.HashMap;

public class Bank {
    
    LoadCSV loadCSV = new LoadCSV();
    HashMap<AssetType,TraderAssetDeskSubject> desks = new HashMap<AssetType, TraderAssetDeskSubject>();
    private TraderFactory traderFactory = new ConcreteTraderFactory();
    int roomCounter = 0;


    protected void trade(){
        for (TraderAssetDeskSubject traderAssetDesk : desks.values()){
            traderAssetDesk.traderGroup.checkBalances();;
        }
    }

    public void allTrades(){
        for (int counter = 0; counter < 1; counter++){
            trade();
        }
    }

    public void setUpTraderAssetDesk(){
        for (AssetType assetType : AssetType.values()){
            addTraderAssetDeck(new TraderAssetDeskSubject(assetType));
        }
    }

    public void addTraderAssetDeck(TraderAssetDeskSubject traderAssetDesk){
        desks.put(traderAssetDesk.getAssetType(), traderAssetDesk);
    }

    public TraderAssetDeskSubject getTraderAssetDesk(AssetType assetType){
        return desks.get(assetType);
    }

    protected void setUpPeople(){
        List<String[]> csvPeople = loadCSV.getCSVRows("src/main/resource/people.csv");
        for (String[] row : csvPeople){
            TraderCompositeObserver trader = traderFactory.createTrader(row);

            TraderAssetDeskSubject desk = getTraderAssetDesk(trader.getAssetType());
            desk.addTrader(trader);
        }
    }

    public void setUp(){
        setUpTraderAssetDesk();
        setUpPeople();
    }
    
    public static void main(String[] args){
        Bank bank = new Bank();
        bank.setUp();
        bank.allTrades();
    }
}
