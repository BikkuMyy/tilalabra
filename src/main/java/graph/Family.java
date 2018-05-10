package graph;

import java.util.*;
import datastructures.MyMap;

/**
 * Vastaa kaikkien sukulaisuusverkkoon lisättyjen henkilöiden
 * säilyttämisestä ja hallinnasta.
 */
public class Family {

    private Map<String, Person> family;

    public Family() {
        this.family = new MyMap<>();
    }

    /**
     * Palauttaa Family-olion sisältämän HashMapin arvot 
     * eli sukulaisuusverkkoon lisätyt Person-oliot.
     * 
     * @return Collection<Person> perheenjäsenet
     */
    public Collection<Person> getFamily() {
        return this.family.values();
    }

    public Map<String, Person> getFamilyMap(){
        return this.family;
    }

    public Set<String> getNames() {
        return this.family.keySet();
    }

    /**
     * Lisää parametrina saamansa henkilön sukulaisuusverkkoon.
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

    /**
     * Etsii henkilön sukulaisuusverkosta nimen perusteella.
     * 
     * @param name
     * @return Person löydetty henkilö
     */
    public Person findPerson(String name) {
        if (this.family.containsKey(name)) {
            return this.family.get(name);
        }
        return null;
    }

    /**
     * Lisää kumppanuuden kahden parametrina saamansa henkilön välille.
     *
     * @param p1
     * @param p2
     */
    public void addRelation(Person p1, Person p2) {
        p1.addRelation(p2);
        p2.addRelation(p1);
    }

    /**
     * Lisää toisena parametrina saamansa henkilön ensimmäisenä saamansa
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
     * Palauttaa totuusarvon sen perusteella, löytyykö parametrina
     * annettua henkilöä verkosta.
     *
     * @param person
     * @return boolean
     */
    public boolean containsPerson(String person) {
        return this.family.containsKey(person);
    }

    /**
     * Populoi visited-mapin.
     * @return visited
     */
    public Map<String, Boolean> initializeVisitedMap() {
        Map<String, Boolean> visited = new MyMap();
        for (String name : getNames()) {
            visited.put(name, false);
        }
        return visited;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person person : this.family.values()) {       
            sb.append(person + "\n");
        }

        return sb.toString();
    }
}
