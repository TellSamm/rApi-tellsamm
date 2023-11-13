package studies;

public class MainGenerics {

    public static void main(String[] args) {

        ExampleGenerics<Automobile,String> exampleGenerics = new ExampleGenerics<>();

        String vString = " Конечно же";

        Automobile automobile1 = new Automobile("bmw",1998);
        Automobile automobile2 = new Automobile("mercedes", 1999);
        Automobile automobile3 = new Automobile("jeely",9999);

        exampleGenerics.addToString(automobile1,vString);

//        exampleGenerics.addToString(1);
//        exampleGenerics.addToString(2);
//        exampleGenerics.addToString(3);

        System.out.println(exampleGenerics.getString());

    }
}
