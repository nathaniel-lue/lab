public class Trader implements TraderComponent, Observer{
    
    private AssetType assetType;
    private String[] trades;
    protected int balance = 0;
    private int tradeCounter = 0;   
    private Person person; 

    public Trader(Person person, AssetType assetType, int balance, String[] trades){
        this.person = person;
        this.assetType = assetType;
        this.trades = trades;
        this.balance = balance;
    }

    public String getName(){
        return person.getName();
    }

    public AssetType getAssetType(){
        return assetType;
    }

    public Role getRole(){
        return person.getRole();
    }

    public Person getPerson(){
        return person;
    }

    public void trade(){
        balance += Integer.parseInt(trades[tradeCounter]);
        tradeCounter ++;
    }

    public void checkBalance(TraderAssetDesk traderAssetDesk){
        if (balance < traderAssetDesk.wib || balance > traderAssetDesk.wia){
            person.notifyTeamLead();
        }
    }

    public void update(){
        System.out.println("WARNING MEMBER OF TEAM OVER OR UNDER BUDGET");
    }

    public void addTeamLead(Trader teamLead){
        person.addTeamLead(teamLead);
    }
}