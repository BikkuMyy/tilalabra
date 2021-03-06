package ui;

import graph.*;

/**
* Vastaa käyttöliittymän toiminnasta.
*/
public class UserInterface {

    private IO io;
    private Functions functions;

    public UserInterface(IO io, Family family) {
        this.io = io;
        this.functions = new Functions(io, family);
    }

    /**
    * Käynnistää käyttöliittymän.
    */
    public void start(){
        this.io.println("Tervetuloa käyttämään sukulaisuusverkkoa!\n");
        this.io.print(functions.toString());
        run();
    }

    /**
    * Vastaa käyttöliittymän suorittamisesta.
    */
    public void run(){
        this.io.print("?  ");
        String function = this.io.nextLine();
        
        while(!function.equals("Lopeta")){
            if(!this.functions.implementFunction(function)){
                this.io.println("Virheellinen toiminto!");
            }
   
            this.io.print("\n?  ");
            function = this.io.nextLine();
        }
        this.io.print("Kiitos hei!");
    }

}