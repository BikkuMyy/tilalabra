import datastructures.*;
import java.util.*;
import graph.Person;
import org.junit.*;
import static org.junit.Assert.*;

public class MyMapTest {

  Map<String, Person> testMap;

  @Before
  public void setUp() {
    this.testMap = new MyMap();
  }

  @Test
  public void returnsCorrectSize() {
    testMap.put("test", new Person("test"));
    assertEquals(1, testMap.size());
  }

  @Test
  public void isEmptyReturnsTrue(){
    assertTrue(testMap.isEmpty());
  }

  @Test
  public void isEmptyReturnsFalse(){
    testMap.put("test", new Person("test"));
    assertFalse(testMap.isEmpty());
  }

  @Test
  public void containsKeyReturnsFalse() {
    testMap.put("test", new Person("test"));
    assertFalse(testMap.containsKey("Test"));
  }

  @Test
  public void containsKeyReturnsTrue() {
    testMap.put("test", new Person("test"));
    assertTrue(testMap.containsKey("test"));
  }

  @Test
  public void getReturnsCorrectResultWithOneEntry() {
    Person value = new Person("test");
    String key = "test";
    testMap.put(key, value);
    assertEquals(value, testMap.get(key));
  }

  @Test
  public void getReturnsCorrectResultWithManyEntro() {
    Person value = new Person("test");
    String key = "test";
    testMap.put(key, value);
    for (int i = 0; i <= 5; i++) {
      testMap.put("test"+i, new Person("test"));
    }
    assertEquals(value, testMap.get(key));
  }

  @Test
  public void getReturnsNull() {
    Person value = new Person("test");
    String key = "test";
    testMap.put(key, value);
    assertEquals(null, testMap.get("Test")); 
  }

  @Test
  public void putReplacesOldValue(){
    Person firstValue = new Person("test");
    String key = "test";
    testMap.put(key, firstValue);
    Person secondValue = new Person("testAgain");
    testMap.put(key, secondValue);
    assertEquals(secondValue, testMap.get(key));
  }

  @Test
  public void mapIsResized(){
    for (int i = 0; i <= 16; i++) {
      testMap.put(""+i, new Person("test"));
    }
    assertTrue(testMap.size() > 16);
  }

  @Test
  public void keySetReturnedCorrectly(){
    for (int i = 0; i <= 5; i++) {
      testMap.put("test"+i, new Person("test"));
    }

    Set<String> keys = testMap.keySet();
    assertEquals(6, keys.size());
    for (int i = 0; i <= 5; i++) {
      assertTrue(keys.contains("test"+i));
    }
  }

  @Test
  public void valuesReturnedCorrectly(){
    List<String> expected = new MyList();
    for (int i = 0; i <= 5; i++) {
      String value = "test"+i;
      testMap.put(value, new Person(value));
      expected.add(value);
    }

    assertEquals(6, testMap.values().size());
  
    for(Person person : testMap.values()){
      assertFalse(person == null);
      assertTrue(expected.contains(person.getName()));
    }
  }
}