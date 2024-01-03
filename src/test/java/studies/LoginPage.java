package studies;

public class LoginPage {

    public void AgeGamer(int age) {
        int ages = age + 1;
        System.out.println(ages);
    }

    public void nameGamer(String name) {
        System.out.println("имя игрока: " + name);
    }

    public MainPage clickLogin(int one) {
        if (one == 1) {
            System.out.println("Данные введены");
        } else {
            System.out.println("Данные не верны");
        }
        return new MainPage();
    }
}
