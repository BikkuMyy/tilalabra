import java.util.*

public class Family{
	private List<Person> family;

	public Family (){
		this.family = new ArrayList<Person>();
	}

	public void addPerson(String name){
		this.family.add(new Person(name));
	}

	public void addRelation(Person p1, Person p2) {
		p1.addRelation(p2);
		p2.addRelation(p1);
	}

	public void addChild(Person person, Person child){
		person.addChild(child)
	}
}