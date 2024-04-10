import java.util.ArrayList;
import java.util.List;

public class Person implements Subject{

    protected String firstName;
    protected String lastName;
    protected Role role;
    protected static boolean printOn = true;
    protected List<Trader> warningPeople = new ArrayList<Trader>();
    protected List<TraderAssetDesk> warningDesks = new ArrayList<TraderAssetDesk>();

    public Person(Role role, String firstName, String lastName){
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setPrintOn(boolean status){
        printOn = status;
    }

    public Role getRole(){
        return role;
    }

    public String getName(){
        return firstName + " " + lastName;
    }

    protected void print(String message){
        System.out.println(message);
    }    

    @Override
    public void notifyTeamLead(){
        for (Trader teamLead: warningPeople){
            teamLead.update();
        }
    }

    @Override
    public void addTeamLead(Observer observer) {
        Trader trader = (Trader) observer;
        warningPeople.add(trader);
    }

    @Override
    public void removeTeamLead(Observer observer) {
        Trader trader = (Trader) observer;
        warningPeople.remove(trader);
    }
    
}
