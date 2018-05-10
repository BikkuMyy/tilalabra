import java.util.*;
import familytree.*;
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

    // @Test
    // public void correctTopologicalSort(){
    //     List<String> expected = Arrays.asList("Kristof", "Katja", "Marija", "Joze", "Ales", "Mari", "Jukka", "Saara", "Tiina", "Tuomas", "Janne", "Daniel", "Laura");
    //     List<String> topoSort = survive.topologicalSort();
    //     for (int i = 0; i < expected.size(); i++) {
    //         assertEquals(expected.get(i), topoSort.get(i));
    //     }
        
    // }
}