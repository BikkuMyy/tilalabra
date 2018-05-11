package familytree;

import graph.*;
import org.junit.*;
import static org.junit.Assert.*;

public class RelationFinderTest {

    RelationFinder finder;
    Family family;

    @Before
    public void setUp() {
        FamilyTree ft = new FamilyTree();
        this.family = ft.initializeFamily();
        this.finder = new RelationFinder(family);
    }

    @Test
    public void validRelationReturnsTrue() {
        Person p1 = family.findPerson("Ales");
        Person p2 = family.findPerson("Joze");
        assertTrue(finder.areRelated(p1, p2));

        p2 = family.findPerson("Kristof");
        assertTrue(finder.areRelated(p1, p2));
    }

    @Test
    public void invalidReturnsFalse() {
        Person p1 = family.findPerson("Mari");
        Person p2 = family.findPerson("Joze");

        assertFalse(finder.areRelated(p1, p2));
    }

}
