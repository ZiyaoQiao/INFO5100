import java.util.ArrayList;

public class CDCNetwork {
    private static CDCNetwork CDC;

    ArrayList<State> stateList;
    DiseaseList diseaseList;
    VaccineList vaccineList;

    private CDCNetwork(){
        stateList = new ArrayList<>();
        diseaseList = new DiseaseList();
        vaccineList = new VaccineList();
    }
    public static CDCNetwork getInstance(){
        if(CDC==null){
            CDC=new CDCNetwork();
        }
        return CDC;
    }
}
