import java.util.*;

public class Main {

    public static void main(String[] args) {
        Family family = initializeFamily();
        UserInterface UI = new UserInterface(new Scanner(System.in), family);
        UI.start();
    }

    public static Family initializeFamily() {
        Family family = new Family();

        Person mari = new Person("Mari");
        Person ales = new Person("Ales");
        Person marija = new Person("Marija");

        family.addPerson(mari);
        family.addPerson(ales);
        family.addPerson(marija);
        family.addRelation(mari, ales);
        family.addChild(marija, ales);

        return family;
    }
}