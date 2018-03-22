
import java.util.*;

public class Person {
	private List<Relation> partners;
	private List<Person> children;
	private String name;

	public Person (String name) {
		this.name = name;
		this.partners = new ArrayList<Relation>();
		this.children = new ArrayList<Person>();
	}

	public void addRelation(Person person){
		this.partners.add(new Relation(this, person));
	}

	public void addChild (Person person){
		this.children.add(person)
	}
} 