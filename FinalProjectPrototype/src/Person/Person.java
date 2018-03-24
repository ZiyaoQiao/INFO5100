package Person;

public class Person {
    private String name;
    //1 is male; -1 is female; 0 is nvzhuangdalao;
    int gender;
    //hash ID
    private int ID;
    private double income;
    private double foodSpend;
    private double EngelsCoefficient;

    public Person(){

    }
    public Person(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getFoodSpend() {
        return foodSpend;
    }

    public void setFoodSpend(double foodSpend) {
        this.foodSpend = foodSpend;
    }

    public double getEngelsCoefficient() {
        return EngelsCoefficient;
    }

    public void setEngelsCoefficient(double engelsCoefficient) {
        EngelsCoefficient = engelsCoefficient;
    }
}
