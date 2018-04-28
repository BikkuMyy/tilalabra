import datastructures.MyDeque;
import graph.Person;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MyDequeTest {

    Deque<Object> testDeque;

    @Before
    public void setUp() {
        this.testDeque = new MyDeque();
    }

    @Test
    public void isEmptyReturnsTrue(){
      assertTrue(testDeque.isEmpty());
    }

    @Test
    public void isEmptyRetursFalse(){
      testDeque.push(new Person("test"));
      assertFalse(testDeque.isEmpty());
    }

    @Test
    public void returnsCorrectSize(){
      testDeque.push(new Person("test"));
      testDeque.add(new Person("testAgain"));
      assertEquals(2, testDeque.size());
    }

    @Test
    public void addIsSuccessful(){
      assertTrue(testDeque.add(new Person("test")));
    }

    @Test
    public void popReturnsCorrectResult() {
      Person test = new Person("test");
      testDeque.push(test);
      testDeque.push(new Person("testAgain"));
      assertNotEquals(test, testDeque.pop());
      assertEquals(test, testDeque.pop());
    }

    @Test
    public void pollReturnsCorrectResult() {
      Person test = new Person("test");
      testDeque.add(test);
      testDeque.add(new Person("testAgain"));
      assertEquals(test, testDeque.poll());
    }

    @Test
    public void queueIsResizedwithPush(){
      for (int i = 0; i <= 16; i++) {
        testDeque.push(new Person("test"));
      }
      assertTrue(testDeque.size() > 16);
    }

    @Test
    public void queueIsResizedwithAdd(){
      for (int i = 0; i <= 16; i++) {
        testDeque.add(new Person("test"));
      }
      assertTrue(testDeque.size() > 16);
    }
  }