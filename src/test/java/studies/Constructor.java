package studies;



public class Constructor {

    int speed;
    int age;
    String name;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static void main(String[] args) {


        Constructor myConst = new Constructor();

        new Constructor().setName("опана!");

        myConst.setAge(12);
        myConst.setName("РУС");
        myConst.setSpeed(12123);
    }
}
