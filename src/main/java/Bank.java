import java.util.List;
import java.util.HashMap;

public class Bank {
    
    LoadCSV loadCSV = new LoadCSV();

    HashMap<AssetType,TraderAssetDesk> desks = new HashMap<AssetType, TraderAssetDesk>();
    int roomCounter = 0;


    protected void trade(){
        for (TraderAssetDesk traderAssetDesk : desks.values()){
            traderAssetDesk.traderGroup.checkBalances(traderAssetDesk);;
        }
    }

    public void allTrades(){
        for (int counter = 0; counter < 1; counter++){
            trade();
        }
    }

    public void setUpTraderAssetDesk(){
        for (AssetType assetType : AssetType.values()){
            addTraderAssetDeck(new TraderAssetDesk(assetType));
        }
    }

    public void addTraderAssetDeck(TraderAssetDesk traderAssetDesk){
        desks.put(traderAssetDesk.getAssetType(), traderAssetDesk);
    }



    public TraderAssetDesk getTraderAssetDesk(AssetType assetType){
        return desks.get(assetType);
    }


    protected void setUpPeople(){
        List<String[]> csvPeople = loadCSV.getCSVRows("src/main/resource/people.csv");
        for (String[] row : csvPeople){
            TraderFactory.parseString(row, this);

        }
    }

    public void setUp(){
        setUpTraderAssetDesk();
        setUpPeople();
    }
    // REMOVE THIS BEFORE SUBMITTING
    public HashMap<AssetType, TraderAssetDesk> getDesks(){
        return desks;
    }
    
    public static void main(String[] args){
        Bank bank = new Bank();
        bank.setUp();
        bank.allTrades();

    }
}
