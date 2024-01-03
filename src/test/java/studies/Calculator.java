package studies;

public class Calculator {

    private int result;

    public Calculator() {
        result = 0;
    }

    public void add(int num) {
        result += num;
    }

    public void subtract(int num) {
        result -= num;
    }

    public void multiply(int result) {
        this.result = result;
        result *= result;
    }

    public void getResult() {
        System.out.println("Результат: " + result);
    }

    public static void main(String[] args) {


        Calculator showMeYour = new Calculator();

        showMeYour.add(5);
        showMeYour.subtract(3);
        showMeYour.multiply(2);


        showMeYour.getResult();



    }

}
