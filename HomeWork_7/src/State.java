import java.util.ArrayList;

public class State {
    ArrayList<Distributor> distributor;
    ArrayList<Manufacturer> manufacturer;
    ArrayList<Provider> providerList;

    public State(){
        distributor = new ArrayList<>();
        manufacturer = new ArrayList<>();
        providerList = new ArrayList<>();
    }
}
