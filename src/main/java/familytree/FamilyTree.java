package familytree;

import graph.*;

public class FamilyTree {

    public Family initializeFamily() {
        Family family = new Family();
        String[] names = {"Mari", "Ales", "Marija", "Joze", "Katja", "Kristof"};

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

        return family;
    }
}
