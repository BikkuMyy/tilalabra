package familytree;

import ui.*;
import graph.*;

public class Main {

    public static void main(String[] args) {
        FamilyTree ft = new FamilyTree();
        Family family = ft.initializeFamily();
        UserInterface UI = new UserInterface(new ConsoleIO(), family);
        UI.start();
        //new PerformanceTest().runPerformanceTest();
    }
}