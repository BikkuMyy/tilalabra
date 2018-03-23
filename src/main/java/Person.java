
import java.util.*;

public class Person {

    private List<Relation> relations;
    private List<Person> children;
    private String name;

    public Person (String name) {
        this.name = name;
        this.relations = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addRelation(Person person) {
        this.relations.add(new Relation(this, person));
    }

    public void addChild (Person person) {
        this.children.add(person);
    }

    public String getName() {
        return this.name;
    }

    public List<Person> getPartners() {
        List<Person> partners = new ArrayList<>();
        for (Relation relation : this.relations) {
            partners.add(relation.getPartner());
        }
        return partners;
    }

    public List<Person> getChildren() {
        return this.children;
    }
}