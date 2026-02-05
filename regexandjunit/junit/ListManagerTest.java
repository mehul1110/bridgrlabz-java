package regexandjunit.junit;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Logic Class
 */
class ListManager {
    public void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    public void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

    public int getSize(List<Integer> list) {
        return list.size();
    }
}

/**
 * JUnit Test Class
 */
public class ListManagerTest {
    ListManager manager = new ListManager();

    @Test
    void testListOperations() {
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 10);
        assertEquals(1, manager.getSize(list));
        manager.removeElement(list, 10);
        assertEquals(0, manager.getSize(list));
    }
}
