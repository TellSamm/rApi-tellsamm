package studies;

import java.util.*;

public class CollectionsSai {


    public static void main(String[] args) {

        Collection<Integer> call = new ArrayList<>();

        Collection<String> str = new LinkedList<>();


        call.add(1);
        call.add(12);
        call.add(144);
        call.add(112);
        call.add(1124);
        call.add(11241);
        call.add(1124124);
        call.add(1124142);


            Iterator<Integer> iter1 = call.iterator();


            while (iter1.hasNext()) {
                Integer element = iter1.next();
                System.out.println("Элемент коллекции: " + element);
            }
        }


//        List<String> names = new ArrayList<>();
//        names.add("Alice");
//        names.add("Bob");
//        names.add("Charlie");
//
//        Iterator<String> iterator = names.iterator();
//        while (iterator.hasNext()) {
//            String name = iterator.next();
//            System.out.println(name);
//        }



    }

