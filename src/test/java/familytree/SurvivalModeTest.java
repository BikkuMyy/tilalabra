package familytree;

import java.util.*;
import graph.*;
import org.junit.*;
import static org.junit.Assert.*;

public class SurvivalModeTest {
    Family family;
    SurvivalMode survive;

    @Before
    public void setUp() {
        FamilyTree ft = new FamilyTree();
        this.family = ft.initializeFamily();
        this.survive = new SurvivalMode(family);
    }

    @Test
    public void correctLongestPath(){
        assertTrue(survive.findLongestPath() == 10);
    }

}