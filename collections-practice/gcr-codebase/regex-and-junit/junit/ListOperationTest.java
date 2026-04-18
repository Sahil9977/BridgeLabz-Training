package junit;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListOperationTest {

	ListOperations ls = new ListOperations();
    List<Integer> list = new ArrayList<>();

    @Test
    void testAddElement() {
        ls.addElement(list, 10);
        ls.addElement(list, 20);
        assertEquals(2, list.size());
        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
    }

    @Test
    void testRemoveElement() {
        list.add(5);
        list.add(15);
        list.add(25);

        ls.removeElement(list, 15);
        assertEquals(2, list.size());
        assertFalse(list.contains(15));
        assertTrue(list.contains(5));
        assertTrue(list.contains(25));
    }

    @Test
    void testGetSize() {
        assertEquals(0, ls.getSize(list));
        list.add(1);
        list.add(2);
        assertEquals(2, ls.getSize(list));
    }
}
