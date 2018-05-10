package graph;

/**
* Edustaa kahden henkilön välisiä kumppanuuksia.
*/
public class Relation {

    private Person[] partners;

    public Relation(Person p1, Person p2) {
        this.partners = new Person[2];
        this.partners[0] = p1;
        this.partners[1] = p2;
    }

    /**
    * Palauttaa kumppanuuden toisen osapuolen.
    */
    public Person getPartner() {
        return this.partners[1];
    }
}