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
        family.addPerson(mari);
        family.addPerson(ales);
        family.addRelation(mari, ales);

        return family;
    }
}