import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class TraderAssetDeskSubject implements Subject {

    protected int wib = -30000;
    protected int wia = 30000;

    protected TraderGroupComposite traderGroup;
    private AssetType assetType;
    private int groupCounter = 0;
    private List<Observer> observers;

    private Map<TraderCompositeObserver, TraderGroupComposite> teamLeadGroupMap;
    private TraderCompositeObserver lead;

    public TraderAssetDeskSubject(AssetType assetType){
        this.assetType = assetType;
        traderGroup = new TraderGroupComposite(assetType.name());
        observers = new ArrayList<Observer>();
        teamLeadGroupMap = new HashMap<TraderCompositeObserver, TraderGroupComposite>();
    }

    public void addTrader(TraderCompositeObserver trader){
        trader.setTraderAssetDesk(this);
        if (trader.getRole() == Role.TEAM_LEAD) {
            TraderGroupComposite newGroup = new TraderGroupComposite(trader.getAssetType().name());
            newGroup.add(trader);
            this.traderGroup.add(newGroup);
            this.groupCounter++;

            this.lead = trader;
            teamLeadGroupMap.put(lead, newGroup);
            registerObserver(trader);
        } else {
            if (this.lead != null) {
                TraderGroupComposite teamLeadGroup = teamLeadGroupMap.get(this.lead);
                if (teamLeadGroup != null) {
                    teamLeadGroup.add(trader); 
                }
            }
            this.traderGroup.add(trader);
        }
    }

    public String getName(){
        return assetType.name();
    }

    public AssetType getAssetType(){
        return assetType;
    }

    public int getGroupCount() {
        return this.groupCounter;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Ensures that the team lead is notified rather than all the team leads in the same AssetType
    @Override
    public void notifyObservers(TraderCompositeObserver trader) {
        for (Observer observer : observers) {
            if (observer instanceof TraderCompositeObserver) {
                TraderCompositeObserver teamLead = (TraderCompositeObserver) observer;
                TraderGroupComposite teamLeadGroup = teamLeadGroupMap.get(teamLead);
                if (teamLeadGroup != null && teamLeadGroup.getMembers().contains(trader)) {
                    observer.balanceLimitExceeded(trader);
                }
            }
        }
    }
}
