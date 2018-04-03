import graph.*;
import org.junit.*;
import static org.junit.Assert.*;

public class FamilyTest {

    Family family;

    @Before
    public void setUp() {
        family = new Family();
    }

    @Test
    public void constructorCreatesEmptyFamily() {
        assertEquals(this.family.getFamily().size(), 0);
    }

    @Test
    public void newPersonIsAdded() {
        family.addPerson(new Person("Tester"));
        assertEquals(this.family.getFamily().size(), 1);
    }

    @Test
    public void existingPersonIsNotAdded() {
        assertTrue(family.addPerson(new Person("Tester")));
        assertFalse(family.addPerson(new Person("Tester")));
    }
    
    @Test
    public void relationIsAdded() {
        Person partner = new Person("Partner");
        Person tester = new Person("Tester");
        family.addRelation(partner, tester);

        assertTrue(partner.getPartners().contains(tester));
        assertTrue(tester.getPartners().contains(partner));   
    }

    @Test
    public void childIsAdded() {
        Person parent = new Person("Parent");
        Person child = new Person("Child");
        family.addChild(parent, child);

        assertTrue(parent.getChildren().contains(child));
    }

    @Test
    public void parentIsAdded() {
        Person parent = new Person("Parent");
        Person child = new Person("Child");
        family.addParent(child, parent);

        assertTrue(child.getParents().contains(parent));
    }
} 