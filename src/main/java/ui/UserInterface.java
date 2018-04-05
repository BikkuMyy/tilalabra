package ui;

import graph.*;
import java.util.*;

/**
* Luokka vastaa käyttöliittymän toiminnasta.
*/

public class UserInterface {

    private IO io;
    private Family family;
    private Map<String, Function> functions;

    public UserInterface(IO io, Family family) {
        this.io = io;
        this.family = family;
        this.functions = new HashMap();
        populateFunctions();
    }

    /**
    *Metodi käynnistää käyttöliittymän.
    */
    public void start(){
        this.io.println("Tervetuloa käyttämään sukulaisuusverkkoa!\n");
        printFunctions();
        run();
    }

    /**
    * Metodi tulostaa mahdolliset toiminnot.
    */
    public void printFunctions(){
        this.io.println("Toiminnot (?):");
        for(String key : this.functions.keySet()){
            this.io.print("    " + key + "\n");
        }
    }

    /**
    * Metodi vastaa käyttöliittymän suorittamisesta.
    */
    public void run(){
        this.io.print("?  ");
        String toiminto = this.io.nextLine();;
        while(!toiminto.equals("Lopeta")){
            if(this.functions.containsKey(toiminto)){
                functions.get(toiminto).implement();
            }
            this.io.print("\n?  ");
            toiminto = this.io.nextLine();
        }
        this.io.print("Kiitos hei!");
    }

    /**
    * Metodi toteuttaa henkilön etsinnän.
    */
    public void findPerson(){
        this.io.print("Etsi nimellä: ");
        String name = this.io.nextLine();
        Person person = this.family.findPerson(name);
        if (person == null) {
            this.io.println("Ei tuloksia.");
        } else {
            this.io.println("Löytyi:\n" + person.toString());
        }
    }

    /**
    * Metodi toteuttaa henkilön lisäämisen.
    */
    public void addPerson(){
        this.io.print("Lisää nimellä: ");
        String name = this.io.nextLine();
        while(!this.family.addPerson(new Person(name))){
            this.io.print("Nimi käytössä, tarkenna: ");
            name = this.io.nextLine();
        }
        this.io.println("Lisätty: " + name );
    }

    /**
    * Metodi lisää halutun tyyppisen suhteen henkilöiden välille.
    */
    public void addRelation(){
        this.io.print("Tyyppi: Kumppani, V(anhempi)-L(apsi)? (Peruuta)");
        String type = this.io.nextLine();
        switch(type){
            case("Kumppani"):
                addPartner();
                break;
            case("V-L"):
                addParentChild();
                break;
            case("Peruuta"):
                return;
            default:
                this.io.print("Väärä tyyppi.");
        }
    }

    public void addPartner(){
        this.io.print("Henkilö 1: ");
        Person p1 = askUntilValid();
        this.io.print("Henkilö 2: ");
        Person p2 = askUntilValid();
        
        if (p1 == null || p2 == null){
            this.io.println("Kumppanuutta ei lisätty");
            return;
        }

        this.family.addRelation(p1, p2);
        this.io.println("Lisätty kumppanuus: " + p1.getName() + " - " + p2.getName());
    }

    public void addParentChild() {
        this.io.print("Vanhempi: ");
        Person parent = askUntilValid();
        this.io.print("Lapsi: ");
        Person child = askUntilValid();

        if (parent == null || child == null){
            this.io.println("Vanhempi-Lapsi -suhdetta ei lisätty");
            return;
        }

        this.family.addParentChild(parent, child);
        this.io.print("Lisätty Vanhempi-Lapsi -suhde: " + parent.getName() + " - " + child.getName());

    }

    public Person askUntilValid(){
        this.io.print("?  ");
        String name = this.io.nextLine();
        Person person = this.family.findPerson(name);
        while(person == null){
            if(name.equals("Peruuta")){
                break;
            }
            this.io.print("Ei löytynyt..");
            this.io.print("\n?  ");
            name = this.io.nextLine();
        }
        return person;
    }

    public void findRelation() {

    }

    public void printAll(){
        this.io.println(family.toString());
    }

    /**
    * Lisää käytössä olevat toiminnot HashMapiin.
    */
    public void populateFunctions(){

        functions.put("Etsi", new Function(){
            public void implement(){
                findPerson();
            }
        });

        functions.put("Lisää", new Function(){
            public void implement(){
                addPerson();
            }
        });

        functions.put("Suhde", new Function(){
            public void implement(){
                addRelation();
            }
        });

        functions.put("Sukulaisuus", new Function(){
            public void implement(){
                findRelation();
            }
        });

        functions.put("Kaikki", new Function(){
            public void implement(){
                printAll();
            }
        });
    }

}