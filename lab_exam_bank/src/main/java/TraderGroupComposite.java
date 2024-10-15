import java.util.List;
import java.util.ArrayList;

public class TraderGroupComposite implements GroupMembersComposite {

    protected String name;
    private List<GroupMembersComposite> groupMembers;

    public TraderGroupComposite(String name){
        this.name = name;
        this.groupMembers = new ArrayList<GroupMembersComposite>();
    }

    public void checkBalances(){
        for (GroupMembersComposite entry : groupMembers) {
            
            if (entry instanceof TraderCompositeObserver) {
                TraderCompositeObserver trader = (TraderCompositeObserver) entry;
                System.out.println("Balance of trader " + trader.getName() + " is " + trader.getBalance());
            } else if (entry instanceof TraderGroupComposite) {
                TraderGroupComposite group = (TraderGroupComposite) entry;
                System.out.println("Balances for group: " + group.getName() + ":");
                group.checkBalances();
            }
        }
    }
    
    public void add(GroupMembersComposite component) {
        groupMembers.add(component);
    }

    @Override
    public Role getRole() {
        return null;
    }

    @Override
    public String getName(){
        return name;
    }

    public List<GroupMembersComposite> getMembers() {
        return groupMembers;
    }
}
