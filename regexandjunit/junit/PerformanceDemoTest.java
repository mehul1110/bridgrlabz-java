package regexandjunit.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Logic Class
 */
class PerformanceDemo {
    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000);
        return "Done";
    }
}

/**
 * JUnit Test Class
 */
public class PerformanceDemoTest {
    PerformanceDemo demo = new PerformanceDemo();

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void testWithinTimeout() throws InterruptedException {
        assertEquals("Done", demo.longRunningTask());
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testShouldFailTimeout() throws InterruptedException {
        demo.longRunningTask();
    }
}
