package datastructures;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;

public class MyListTest {

    List<Object> testList;

    @Before
    public void setUp() {
        this.testList = new MyList();
    }

    @Test
    public void returnsCorrectSize() {
        testList.add(new Object());
        assertEquals(testList.size(), 1);
    }

    @Test
    public void containsReturnsFalse() {
        Object test = new Object();
        assertFalse(testList.contains(test));
    }

    @Test
    public void containsAcceptsNull() {
        testList.add(null);
        assertTrue(testList.contains((null)));
    }

    @Test
    public void getReturnsCorrectResult() {
        Object test = new Object();
        testList.add(test);
        assertEquals(test, testList.get(0));
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void getFailsWithIndexOutOfBounds() {
        exception.expect(IndexOutOfBoundsException.class);
        testList.get(0);
    }

    @Test
    public void listIsResized() {
        for (int i = 0; i < 11; i++) {
            testList.add(new Object());
        }
        assertEquals(testList.size(), 11);
    }

}
