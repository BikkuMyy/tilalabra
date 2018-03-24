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
    public void personCanBeAdded() {
        family.addPerson(new Person("Tester"));
        assertEquals(this.family.getFamily().size(), 1);
    }
    
    @Test
    public void relationCanBeAdded() {
        Person partner = new Person("Partner");
        Person tester = new Person("Tester");
        family.addRelation(partner, tester);

        assertTrue(partner.getPartners().contains(tester));
        assertTrue(tester.getPartners().contains(partner));   
    }

    @Test
    public void childCanBeAdded() {
        Person parent = new Person("Parent");
        Person child = new Person("Child");
        family.addChild(parent, child);

        assertTrue(parent.getChildren().contains(child));
    }
}