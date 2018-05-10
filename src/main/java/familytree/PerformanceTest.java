package familytree;

import graph.*;
import java.util.*;

/**
 * Apuluokka suorituskykytestausta varten.
 */
public class PerformanceTest {

  private void printResults(Map<String, List<Long>> data) {
    System.out.println("Tulokset: ");
    for (String key : data.keySet()) {
      System.out.println("Määrä: " + key);
      Long summa = 0l;
      for (Long value : data.get(key)) {
        System.out.println(value);
        summa += value;
      }
      System.out.println("Ka: " + (double) (summa / 10));
    }
  }

  public void runPerformanceTest() {
    Map<String, List<Long>> data = new HashMap();

    for (int i = 4; i <= 9000; i *= 2) {
      List<Long> values = new ArrayList();
      for (int j = 1; j <= 10; j++) {
        //Family testFamily = populateFamily(i);
        long duration = runTopoTest(i);
        //long duration = runDfsTest(testFamily);
        System.out.println(i + " - " + duration);
        values.add(duration);
      }
      data.put("Size" + i, values);
    }
    printResults(data);
  }

  private long runDfsTest(Family family) {
    RelationFinder finder = new RelationFinder(family);
    Person p1 = getRandomPerson(family);
    Person p2 = getRandomPerson(family);
    long start = System.nanoTime();
    finder.areRelated(p1, p2);
    long end = System.nanoTime();
    return (end-start);
  }

  private long runTopoTest(int n) {
    Family family = buildFamily(n);
    SurvivalMode survive = new SurvivalMode(family);
    long start = System.nanoTime();
    survive.topologicalSort();
    long end = System.nanoTime();
    return((end-start));
  }

  private Person getRandomPerson(Family family) {
    Map<String, Person> familyMap = family.getFamilyMap();
    int random = new Random().nextInt(familyMap.size());
    return familyMap.get("test" + random);
  }

  private Family populateFamily(int n) {
    Family testFamily = new Family();
    for (int i = 0; i < n; i++) {
      testFamily.addPerson(new Person("test" + i));
    }

    Map<String, Person> familyMap = testFamily.getFamilyMap();
    int size = familyMap.size();
    for (int i = 0; i < size; i++) {
      testFamily.addRelation(getRandomPerson(testFamily), getRandomPerson(testFamily));
      testFamily.addParentChild(getRandomPerson(testFamily), getRandomPerson(testFamily));
      testFamily.addParentChild(getRandomPerson(testFamily), getRandomPerson(testFamily));
    }
    return testFamily;
  }

  private Family buildFamily(int n){
    Family testFamily = new Family();
    Person p1 = new Person("test" + 1);
    testFamily.addPerson(p1);
    addLevel(n, 2, testFamily, p1);
    return testFamily;
  }

  private void addLevel(int n, int k, Family family, Person start){
    if(k+1 > n){
      return;
    }
    Person p2 = new Person("test" + k++);
    family.addPerson(p2);
    family.addRelation(start, p2);
    int random = new Random().nextInt(3);
    Person child = null;
    for (int i = 0; i < 2; i++) {
      if(k+1 > n){
        return;
      }
      child = new Person("test" + k++);
      family.addPerson(child);
      family.addParentChild(start, child);
      family.addParentChild(p2, child);
    }
    addLevel(n, k, family, child);
  }

}