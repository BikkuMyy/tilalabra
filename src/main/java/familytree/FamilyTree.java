package familytree;

import graph.*;

/**
 * Luo Family-olion ja syöttää esimerkkidsatan.
 */
public class FamilyTree {

    /**
     * Initialisoi family-olion.
     *
     * @return family
     */
    public Family initializeFamily() {
        Family family = new Family();
        addFamilyMembers(family);
        additionalFamilyMembers(family);
        return family;
    }

    public void addFamilyMembers(Family family) {

        Person mari = new Person("Mari");
        Person ales = new Person("Ales");
        Person marija = new Person("Marija");
        Person joze = new Person("Joze");
        Person katja = new Person("Katja");
        Person kristof = new Person("Kristof");

        family.addPerson(mari);
        family.addPerson(ales);
        family.addPerson(marija);
        family.addPerson(joze);
        family.addPerson(katja);
        family.addPerson(kristof);

        family.addRelation(mari, ales);
        family.addParentChild(marija, ales);
        family.addParentChild(marija, katja);
        family.addRelation(marija, joze);
        family.addParentChild(joze, ales);
        family.addParentChild(joze, katja);
        family.addParentChild(katja, kristof);
    }

    public void additionalFamilyMembers(Family family) {
        Person saara = new Person("Saara");
        Person jukka = new Person("Jukka");
        Person janne = new Person("Janne");
        Person tiina = new Person("Tiina");
        Person tuomas = new Person("Tuomas");
        Person laura = new Person("Laura");
        Person daniel = new Person("Daniel");
        Person mari = family.findPerson("Mari");

        family.addPerson(saara);
        family.addPerson(jukka);
        family.addPerson(janne);
        family.addPerson(tiina);
        family.addPerson(tuomas);
        family.addPerson(laura);
        family.addPerson(daniel);

        family.addRelation(saara, jukka);
        family.addParentChild(jukka, janne);
        family.addParentChild(jukka, tiina);
        family.addParentChild(jukka, mari);
        family.addParentChild(saara, janne);
        family.addParentChild(saara, tiina);
        family.addParentChild(saara, mari);
        family.addParentChild(janne, laura);
        family.addParentChild(janne, daniel);
        family.addParentChild(tiina, tuomas);
    }

}
