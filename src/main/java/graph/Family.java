package graph;

import java.util.*;

/**
* Luokka on vastuussa kaikkien sukulaisuusverkkoon
* lisättyjen henkilöiden säilyttämisestä ja hallinnasta.
*/
public class Family {

    private Map<String, Person> family;

    public Family() {
        this.family = new HashMap<>();
    }

    public Collection<Person> getFamily(){
        return this.family.values();
    }

    /**
    * Metodi lisää parametrina saamansa henkilön sukulaisuusverkkoon.
    *
    * @param person
    * @return boolean
    */
    public boolean addPerson(Person person) {
        String name = person.getName();
        if(!this.family.containsKey(name)){
            this.family.put(name, person);
            return true;
        } else {
            return false;
        }
    }

    /**
    * Metodi lisää kumppanuuden kahden parametrina saamansa
    * henkilön välille.
    *
    * @param p1
    * @param p2
    */
    public void addRelation(Person p1, Person p2) {
        p1.addRelation(p2);
        p2.addRelation(p1);
    }

    /**
    * Metodi lisää toisena parametrina saamansa henkilön
    * ensimmäisenä saamansa parametrin lapseksi.
    *
    * @param parent
    * @param child
    */
    public void addChild(Person parent, Person child) {
        parent.addChild(child);
        child.addParent(parent);
    }

    /**
    * Metodi lisää toisena parametrina saamansa henkilön
    * ensimmäisenä saamansa parametrin vanhemmaksi.
    *
    * @param child
    * @param parent
    */
    public void addParent(Person child, Person parent) {
        child.addParent(parent);
        parent.addChild(child);
    }

    /**
    * Metodi palauttaa totuusarvon sen perusteella,
    * löytyykö parametrina annettua henkilöä verkosta.
    *
    * @param person
    * @return boolean
    */
    public boolean containsPerson(String person){
        return this.family.containsKey(person);
    }

    /**
    * Metodi palauttaa kaikkien sukulaisuusverkon sisältämien
    * henkilöiden tiedot merkkijonona.
    *
    * @return String
    */
    public String toString() { 
        StringBuilder sb = new StringBuilder();
        for (Person person : this.family.values()){
            sb.append(person.toString()+"\n");
        }

        return sb.toString();
    }

}