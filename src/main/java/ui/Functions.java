package ui;

import java.util.*;
import graph.*;
import familytree.*;
import datastructures.MyMap;

/**
 * Sisältää ohjelman tarjoamat toiminnot.
 */
public class Functions {

    private Map<String, Function> functions;
    private Family family;
    private IO io;

    public Functions(IO io, Family family) {
        this.functions = new MyMap();
        populateFunctions();
        this.io = io;
        this.family = family;
    }

    /**
     * Toteuttaa parametrina saamansa funktion.
     * @param   function    suoritettava toiminto
     * @return  boolean
     */
    public boolean implementFunction(String function) {
        if (this.functions.containsKey(function)) {
            functions.get(function).implement();
            return true;
        }
        return false;
    }

    /**
     * Etsii kysyttyä henkilöä verkosta.
     */
    public void findPerson() {
        String name = askUserFor("Etsi nimellä: ");
        Person person = this.family.findPerson(name);
        if (person == null) {
            this.io.println("Ei tuloksia.");
        } else {
            this.io.println("Löytyi:\n" + person.toString());
        }
    }

    /**
     * Toteuttaa henkilön lisäämisen.
     */
    public void addPerson() {
        String name = askUserFor("Lisää nimellä: ");
        while (!this.family.addPerson(new Person(name))) {
            name = askUserFor("Nimi käytössä, tarkenna: ");
        }
        this.io.println("Lisätty: " + name);
    }

    /**
     * Lisää halutun tyyppisen suhteen henkilöiden välille.
     */
    public void addRelation() {

        String type = askUserFor("Tyyppi: Kumppani, V(anhempi)-L(apsi)? (Peruuta)");
        switch (type) {
            case ("Kumppani"):
                addPartner();
                break;
            case ("V-L"):
                addParentChild();
                break;
            case ("Peruuta"):
                return;
            default:
                this.io.print("Väärä tyyppi.");
        }
    }

    /**
     * Lisää kumppanuuden henkilöiden välille.
     */
    public void addPartner() {
        Person p1 = askUntilValid("Henkilö 1: ");
        Person p2 = askUntilValid("Henkilö 2: ");

        if (p1 == null || p2 == null) {
            this.io.println("Kumppanuutta ei lisätty");
            return;
        }

        this.family.addRelation(p1, p2);
        this.io.println("Lisätty kumppanuus: " + p1.getName() + " - " + p2.getName());
    }

    /**
     * Lisää vanhempi-lapsi suhteen henkilöiden välille.
     */
    public void addParentChild() {
        Person parent = askUntilValid("Vanhempi: ");
        Person child = askUntilValid("Lapsi: ");

        if (parent == null || child == null) {
            this.io.println("Vanhempi-Lapsi -suhdetta ei lisätty");
            return;
        }

        this.family.addParentChild(parent, child);
        this.io.print("Lisätty Vanhempi-Lapsi -suhde: " + parent.getName() + " - " + child.getName());
    }

    /**
     * Apumetodi, joka kysyy henkilön nimeä, 
     * kunnes annetaan verkosta löytyvä nimi.
     *
     * @param text tulostettava merkkijono
     * @return Person löydetty henkilö
     */
    public Person askUntilValid(String text) {
        String name = askUserFor(text);
        Person person = this.family.findPerson(name);
        while (person == null) {
            if (name.equals("Peruuta")) {
                break;
            }
            this.io.print("Ei löytynyt..");
            this.io.print("\n?  ");
            name = this.io.nextLine();
        }
        return person;
    }

    /**
     * Tarkistaa, ovatko kysytyt henkilöt sukua toisilleen.
     */
    public void findRelation() {
        Person p1 = askUntilValid("Henkilö 1: ");
        Person p2 = askUntilValid("Henkilö 2: ");
        RelationFinder finder = new RelationFinder(this.family);
        if (finder.areRelated(p1, p2)) {
            this.io.print(p1.getName() + " ja " + p2.getName() + " ovat sukua.");
        } else {
            this.io.println("Henkilöt eivät ole sukua.");
        }
    }

    /**
     * Selvittää verkon kauimmaista sukua olevat eli pisimmän polun.
     */
    public void survivalMode(){
        SurvivalMode survive = new SurvivalMode(this.family);
        this.io.println("Henkilö - Etäisyys ensimmäisestä");
        this.io.println("_________________");
        survive.findLongestPath();
    }

    /**
     * Alustaa tyhjän Family-olion varmistuksen jälkeen.
     */
    public void emptyFamily(){
        if(askUserFor("Haluatko varmasti tyhjentää sukulaisuusverkon - Kyllä/Ei?").equals("Kyllä")){
            this.family = new Family();
        } else {
            this.io.print("Tyhjennys peruttu.");
        }
    }

    public void printAll() {
        this.io.println(family.toString());
    }

    /**
     * Apumetodi, joka palauttaa käyttäjältä kysytyn syötteen.
     *
     * @param   text   käyttäjän antama syöte   
     * @return nextLine
     */
    public String askUserFor(String text) {
        this.io.println(text);
        return this.io.nextLine();
    }

    /**
     * Lisää käytössä olevat toiminnot HashMapiin.
     */
    public void populateFunctions() {

        functions.put("Etsi", (Function) () -> {
            findPerson();
        });

        functions.put("Lisää", (Function) () -> {
            addPerson();
        });

        functions.put("Suhde", (Function) () -> {
            addRelation();
        });

        functions.put("Sukulaisuus", (Function) () -> {
            findRelation();
        });

        functions.put("Kaikki", (Function) () -> {
            printAll();
        });

        functions.put("Survive", (Function) () -> {
            survivalMode();
        });

        functions.put("Tyhjennä", (Function) () -> {
            emptyFamily();
        });
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Toiminnot (?):\n");
        for (String key : this.functions.keySet()) {
            sb.append("    " + key + "\n");
        }
        sb.append("    Lopeta\n");
        return sb.toString();
    }
}
