import java.util.List;
import java.util.ArrayList;

public class TraderGroup implements TraderComponent{

    protected String name;
    protected List<TraderComponent> components = new ArrayList<>();


    public TraderGroup(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void checkBalances(TraderAssetDesk traderAssetDesk){
        //Task Two
        System.out.println("\n" + traderAssetDesk + "\n");
        checkNestedGroups(traderAssetDesk.traderGroup, traderAssetDesk);
        

    }

    public void checkNestedGroups(TraderGroup traderGroup, TraderAssetDesk traderAssetDesk){
        for (TraderComponent component:traderGroup.components){
            if (component instanceof Trader){
                Trader componentTrader = (Trader) component;
                if(componentTrader.balance < traderAssetDesk.wib || componentTrader.balance > traderAssetDesk.wia){
                    componentTrader.getPerson().notifyTeamLead();
                }
            }
            else{
                TraderGroup newTraderGroup = (TraderGroup) component;
                checkNestedGroups(newTraderGroup, traderAssetDesk);
            }
        }
    }

    public void add(TraderComponent component){
        //Task One with the correct input parameter
        components.add(component);
        
    }


}
