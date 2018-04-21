package familytree;

import java.util.*;
import graph.*;
import datastructures.MyList;

/**
 * Toteuttaa "survival moden" eli pisimmän polut etsinnän verkossa.
 * WIP
 */
public class SurvivalMode {

    private Family family;

    public SurvivalMode(Family family) {
        this.family = family;
    }

    /**
     * Etsii pisimmän polun verkossa 
     * ja ilmoittaa, minkä kahden solmun välillä se on.
     */
    public void findBestMatch() {
        //ArrayDeque<Person> topologicalOrder = topologicalSort(family);
        //longestPath(family, topologicalOrder);

    }

    /**
     * Järjestää verkon topologiseen järjestykseen.
     * @return verkon henkilöt listattuna topologisessa järjestyksessä
     */
    public List<String> topologicalSort() {
        ArrayDeque<Person> stack = new ArrayDeque<>();
        Map<String, Boolean> visited = family.initializeVisitedMap();

        for (Person processed : family.getFamily()) {
            if (!visited.get(processed.getName())) {
                sortUtil(processed, visited, stack);
            }
        }

        List<String> topo = new MyList();
        while (!stack.isEmpty()) {
            topo.add(stack.pop().getName());
        }
        return topo;

    }
    /**
     * Apumetodi topologiseen järjestämiseen.
     */

    private void sortUtil(Person processed, Map<String, Boolean> visited, ArrayDeque<Person> stack) {
        visited.put(processed.getName(), true);

        processList(processed.getPartners(), visited, stack);
        processList(processed.getParents(), visited, stack);
        processList(processed.getChildren(), visited, stack);

        stack.push(processed);
    }

    /**
     * Apumetodi topologiseen järjestämiseen.
     */
    private void processList(List<Person> processedList, Map<String, Boolean> visited, ArrayDeque<Person> stack) {

        for (Person person : processedList) {
            if (!visited.get(person.getName())) {
                sortUtil(person, visited, stack);
            }
        }
    }

    /**
     * Laskee pisimmän polun topologisesta järjestyksestä.
     */
    private void longestPath(Family family, ArrayDeque<Person> topologicalOrder) {
        //Map<String, Integer> distance = initializeDistanceMap(family);

    }

    /**
     * Initalisoi etäisyydet sisältävän mapin.
     */
    private Map<String, Integer> initializeDistanceMap() {
        Map<String, Integer> distance = new HashMap();
        for (String name : family.getNames()) {
            distance.put(name, Integer.MIN_VALUE);
        }
        return distance;
    }

}