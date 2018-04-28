package graph;

import java.util.*;
import datastructures.MyMap;

/**
 * Luokka on vastuussa kaikkien sukulaisuusverkkoon lisättyjen henkilöiden
 * säilyttämisestä ja hallinnasta.
 */
public class Family {

    private Map<String, Person> family;

    public Family() {
        this.family = new MyMap<>();
    }

    public Collection<Person> getFamily() {
        return this.family.values();
    }

    public Set<String> getNames() {
        return this.family.keySet();
    }

    /**
     * Metodi lisää parametrina saamansa henkilön sukulaisuusverkkoon.
     *
     * @param person
     * @return boolean
     */
    public boolean addPerson(Person person) {
        String name = person.getName();
        if (!this.family.containsKey(name)) {
            this.family.put(name, person);
            return true;
        } else {
            return false;
        }
    }

    public Person findPerson(String name) {
        if (this.family.containsKey(name)) {
            return this.family.get(name);
        }
        return null;
    }

    /**
     * Metodi lisää kumppanuuden kahden parametrina saamansa henkilön välille.
     *
     * @param p1
     * @param p2
     */
    public void addRelation(Person p1, Person p2) {
        p1.addRelation(p2);
        p2.addRelation(p1);
    }

    /**
     * Metodi lisää toisena parametrina saamansa henkilön ensimmäisenä saamansa
     * parametrin lapseksi ja päinvastoin.
     *
     * @param parent
     * @param child
     */
    public void addParentChild(Person parent, Person child) {
        parent.addChild(child);
        child.addParent(parent);
    }

    /**
     * Metodi palauttaa totuusarvon sen perusteella, löytyykö parametrina
     * annettua henkilöä verkosta.
     *
     * @param person
     * @return boolean
     */
    public boolean containsPerson(String person) {
        return this.family.containsKey(person);
    }

    /**
     * Apumetodi, joka populoi visited-listan.
     * 
     */
    public Map<String, Boolean> initializeVisitedMap() {
        Map<String, Boolean> visited = new HashMap();
        for (String name : getNames()) {
            visited.put(name, false);
        }
        return visited;
    }

    /**
     * Metodi palauttaa kaikkien sukulaisuusverkon sisältämien henkilöiden
     * tiedot merkkijonona.
     *
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // for (String key : family.keySet()){
        //     sb.append(key + "\n");
        // }
        for (Person person : this.family.values()) {       
            sb.append(person.toString() + "\n");
        }

        return sb.toString();
    }
}
