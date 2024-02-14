package jupiter;


import org.junit.jupiter.api.extension.ExtendWith;
import qaAutoTraining.PrintUnsuccessExtension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(PrintUnsuccessExtension.class)
public @interface PrintUnsuccessBody {
}
