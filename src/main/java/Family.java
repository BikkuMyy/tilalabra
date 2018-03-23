import java.util.*;

public class Family {
    private List<Person> family;

    public Family() {
        this.family = new ArrayList<Person>();
    }

    public void addPerson(Person person) {
        this.family.add(person);
    }

    public void addRelation(Person p1, Person p2) {
        p1.addRelation(p2);
        p2.addRelation(p1);
    }

    public void addChild(Person person, Person child) {
        person.addChild(child);
    }

    public String toString() { 
        StringBuilder sb = new StringBuilder();
        for (Person person : this.family){
            sb.append(person.getName()).append("\n");
            //suhteiden tulostus
            //lapsien tulostus
        }

        return sb.toString();
    }
}