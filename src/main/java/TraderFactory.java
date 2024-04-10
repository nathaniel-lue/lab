public class TraderFactory {
    public static void parseString(String[] row, Bank bank){
        Person person = createPerson(row[0],row[1],row[2]);
        Trader trader;
        TraderGroup traderGroup;
  
        if (person.getRole() == Role.TRADER){
            trader = createTrader(person, row[3],row[4],row[5]);
            addTraderToAssetDesk(trader, bank);
            traderGroup = addTraderToTraderGroup(trader, bank);
            
        }
        else {
            trader = createTrader(person, row[3],row[4],row[5]);
            addTraderToAssetDesk(trader, bank);
            traderGroup = createGroup(row[3]);
            addTraderGroupToTraderGroup(traderGroup, trader, bank);
            addTraderToTraderGroup(trader, bank);

        }
        addTeamTraderToTrader(traderGroup, trader);

    }

    public static Person createPerson(String roleString, String firstName, String lastName){
        Person person = new Person(Role.getFromName(roleString), firstName, lastName);
        return person;
    }

    public static Trader createTrader(Person person, String assetType, String balance, String trades){
        Trader trader = new Trader(person, AssetType.getFromName(assetType), Integer.parseInt(balance), trades.split(";"));
        return trader;
    }

    public static void addTraderToAssetDesk(Trader trader, Bank bank){
        bank.getTraderAssetDesk(trader.getAssetType()).addTrader(trader);
    }

    public static TraderGroup addTraderToTraderGroup(Trader trader, Bank bank){
        bank.getTraderAssetDesk(trader.getAssetType()).traderGroup.add(trader);
        return bank.getTraderAssetDesk(trader.getAssetType()).traderGroup;
    }

    public static TraderGroup createGroup(String assetType){
        TraderGroup traderGroup = new TraderGroup(assetType);
        return traderGroup;
    }

    public static void addTraderGroupToTraderGroup(TraderGroup traderGroup, Trader trader, Bank bank){
        bank.getTraderAssetDesk(trader.getAssetType()).traderGroup.add(traderGroup);
    }

    public static void addTeamTraderToTrader(TraderGroup traderGroup, Trader trader){
        for (TraderComponent traderComponent : traderGroup.components){
            if (traderComponent instanceof Trader){
                Trader newTrader = (Trader) traderComponent;
                if (newTrader.getRole() == Role.TEAM_LEAD){
                    trader.addTeamLead(newTrader);
                }
            }
        }
    }

}
