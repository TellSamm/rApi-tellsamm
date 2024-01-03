package qaAutoTraining;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MyExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MyTest {

    @Test
    @Order(2)
    void myTestMethod (){
        System.out.println("результат теста: " + 1 + 1 * 3);
    }

    @Test
    @Order(1)
    void myTestMethodCars (){
        Assumptions.abort("А давайте просто отменим этот тестовый метод =)");
        String bmw = "BMW";
        System.out.println("результат теста: " + bmw );
    }
    @Test
    @Order(3)
    void myTestMethodAnimal (){

        String dino = "Dino";
        System.out.println("результат теста: " + dino );
    }
}
