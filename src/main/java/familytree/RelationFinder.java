package familytree;

import java.util.*;
import graph.*;

public class RelationFinder {

    private Map<String, Boolean> visited;

    public RelationFinder(Family family) {
        this.visited = new HashMap();
        initializeMap(family);
    }

    public boolean areRelated(Person start, Person end) {
        return dfs(start, end);
    }

    public boolean dfs(Person start, Person end) {
        String endName = end.getName();
        ArrayDeque<Person> queue = new ArrayDeque();
        Person processed = start;
        queue.add(start);

        while (!queue.isEmpty()) {
            processed = queue.poll();

            if (dfsVisit(queue, processed.getChildren(), endName)) {
                return true;
            }
            if (dfsVisit(queue, processed.getParents(), endName)) {
                return true;
            }

        }
        return false;
    }

    public boolean dfsVisit(ArrayDeque<Person> queue, List<Person> processedList, String endName) {
        if (!processedList.isEmpty()) {
            for (Person next : processedList) {
                String nextName = next.getName();
                if (nextName.equals(endName)) {
                    return true;
                }
                if (!visited.get(nextName)) {
                    visited.put(nextName, true);
                    queue.add(next);
                }
            }
        }

        return false;
    }

    public void initializeMap(Family family) {
        for (String name : family.getNames()) {
            this.visited.put(name, false);
        }
    }
}
