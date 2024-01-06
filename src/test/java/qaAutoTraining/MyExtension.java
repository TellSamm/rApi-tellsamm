package qaAutoTraining;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class MyExtension implements BeforeTestExecutionCallback {

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        System.out.println("Выполняется тест " + context.getTestMethod().get().getName());
    }
}
