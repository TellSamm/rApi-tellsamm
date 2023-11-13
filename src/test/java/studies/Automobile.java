package studies;

public class Automobile {

    private String model;
    private int year;

    public Automobile(String model, int year) {
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString() {
        return "My Car :"+" " + model + "\n" + "Year: " + year;
    }


}
