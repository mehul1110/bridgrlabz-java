package reflectionandannotation.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Demonstrates how to create a custom logging proxy using Reflection.
 */

// Define the Greeting interface
interface Greeting {
    void sayHello();

    void sayGoodbye(String name);
}

// Implement the Greeting interface
class WelcomeGreeting implements Greeting {
    public void sayHello() {
        System.out.println("Hello, welcome to the system!");
    }

    public void sayGoodbye(String name) {
        System.out.println("Goodbye, " + name + "!");
    }
}

// Intercept method calls through the InvocationHandler
class LoggingInvocationHandler implements InvocationHandler {
    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[LOG]: Preparing to execute method '" + method.getName() + "'");

        // Let the actual target handle the method dynamically
        Object result = method.invoke(target, args);

        System.out.println("[LOG]: Completed execution of method '" + method.getName() + "'\n");
        return result;
    }
}

public class CustomLoggingProxyDemo {
    public static void main(String[] args) {
        // Concrete target object
        Greeting original = new WelcomeGreeting();

        // Create a custom Proxy Instance
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                WelcomeGreeting.class.getClassLoader(),
                new Class[] { Greeting.class },
                new LoggingInvocationHandler(original));

        // Usage will trigger the invocation handler's intercept logic before/after
        // execution
        proxyInstance.sayHello();
        proxyInstance.sayGoodbye("Alex");
    }
}
