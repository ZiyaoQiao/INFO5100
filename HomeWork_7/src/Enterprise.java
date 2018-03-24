import java.util.ArrayList;

public class Enterprise {
    ArrayList<Enterprise> enterpriseList;
    PersonDirectory personDirectory;


    public Enterprise(){
        enterpriseList = new ArrayList<>();
        personDirectory = new PersonDirectory();
    }
}
