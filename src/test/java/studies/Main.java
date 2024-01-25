package studies;

public class Main {

    public static void main(String[] args) {
        Music ms = Music.CLASSIC;


        for(Music element : Music.values()){
            System.out.println(element);
        }

    }
}
