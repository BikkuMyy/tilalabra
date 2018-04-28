package familytree;

import java.util.*;
import graph.*;
import datastructures.*;

/**
 * Toteuttaa "survival moden" eli pisimmän polut etsinnän verkossa.
 * WIP
 */
public class SurvivalMode {

    private Family family;
    private Deque<Person> stack;
    private int longest;

    public SurvivalMode(Family family) {
        this.family = family;
        this.stack = new MyDeque<>();
        this.longest = 0;
    }

    /**
     * Etsii pisimmän polun verkossa 
     * ja ilmoittaa, minkä kahden solmun välillä se on.
     */
    public void findBestMatch() {
        topologicalSort();
        System.out.print(longestPath());
        //return result
    }

    /**
     * Järjestää verkon topologiseen järjestykseen.
     */
    public void topologicalSort() {
        Map<String, Boolean> visited = family.initializeVisitedMap();

        for (Person processed : family.getFamily()) {
            if (!visited.get(processed.getName())) {
                sortUtil(processed, visited, stack);
            }
        }
    }

    /**
     * Apumetodi topologiseen järjestämiseen.
     */

    private void sortUtil(Person processed, Map<String, Boolean> visited, Deque<Person> stack) {
        visited.put(processed.getName(), true);

        processList(processed.getPartners(), visited, stack);
        processList(processed.getParents(), visited, stack);
        processList(processed.getChildren(), visited, stack);

        stack.push(processed);
    }

    /**
     * Apumetodi topologiseen järjestämiseen.
     */
    private void processList(List<Person> processedList, Map<String, Boolean> visited, Deque<Person> stack) {

        for (Person person : processedList) {
            if (!visited.get(person.getName())) {
                sortUtil(person, visited, stack);
            }
        }
    }

    private void processList(Person processed, List<Person> processedList, Map<Person, Integer> dist) {

        for (Person person : processedList) {
            int distance = dist.get(processed) + 1;
            this.longest = distance > longest ? distance : longest;
            if (dist.get(person) < distance) {
                dist.put(person, distance);
            }
        }
    }

    /**
     * Laskee pisimmän polun topologisesta järjestyksestä.
     */
    private String longestPath() {
        Map<Person, Integer> dist = initializedistMap();

        Person processed = stack.pop();
        dist.put(processed, 0);
        while (!stack.isEmpty()) {

            processList(processed, processed.getPartners(), dist);
            processList(processed, processed.getParents(), dist);
            processList(processed, processed.getChildren(), dist);

            System.out.println(processed.getName() + " " + dist.get(processed));
            processed = stack.pop();

        }
        return "Pisin polku " + this.longest;
    }

    /**
     * Initalisoi etäisyydet sisältävän mapin.
     */
    private Map<Person, Integer> initializedistMap() {
        Map<Person, Integer> dist = new MyMap();
        for (Person person : family.getFamily()) {
            dist.put(person, Integer.MIN_VALUE);
        }
        return dist;
    }

}