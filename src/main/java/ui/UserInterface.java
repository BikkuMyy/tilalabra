package ui;

import graph.*;
import java.util.*;

/**
* Luokka vastaa käyttöliittymän toiminnasta.
*/

public class UserInterface {

	private Scanner scanner;
	private Family family;

	public UserInterface(Scanner scanner, Family family) {
		this.scanner = scanner;
		this.family = family;
	}

	/**
	*Metodi käynnistää käyttöliittymän.
	*/
	public void start(){
		System.out.print("Tervetuloa käyttämään sukulaisuusverkkoa!\n");
		System.out.print(family.toString());
	}

	public void printOptions(){

	}

	public Person findPerson(String name){
		return null;
	}

	public boolean addPerson(String name){
		return true;
	}

	public boolean findRelation(String p1, String p2) {
		return true;
	}
}