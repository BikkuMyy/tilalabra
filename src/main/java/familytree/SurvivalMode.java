package familytree;

import java.util.*;
import graph.*;

public class SurvivalMode {

    public Relation findBestMatch(Family family) {
        topologicalSort(family);
        return null;
    }

    private void topologicalSort(Family family) {
        ArrayDeque<Person> stack = new ArrayDeque<>();
        Map<String, Boolean> visited = family.initializeVisitedMap();

    }

    private void sortUtil() {

    }

    //https://www.geeksforgeeks.org/find-longest-path-directed-acyclic-graph/
    //https://www.geeksforgeeks.org/topological-sorting/
    //https://en.wikipedia.org/wiki/Longest_path_problem
}