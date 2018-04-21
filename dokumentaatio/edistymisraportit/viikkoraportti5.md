## Viikkoraportti 5

Tuntimäärä: ~ 12

Tällä viikolla ohjelma eteni HashMapin omalla toteutuksella, refaktoroimalla vanhempi-lapsi -suhteen käyttämään pointtereitä listojen sijaan ja toiminnallisuuden laajentamisen aloittamisella. Aikaa kului myös vertaisarviontiin.

HashMapin sielunelämän ymmärtäminen ja oma toteutus oli ajoittain aika puuduttavaa. Tämänhetkisen toteutuksen testaus ja käyttöönotto jää vielä ensi viikolle. Tietorakenteista on vielä sen jälkeen toteutettavana ArrayDeque.

Survival modessa aka paritustestissä etsitään pisin polku verkossa eli jos sattuisi pullonkaulailmiö, niin ketkä kaksi sukulaisuusverkon jäsentä kannattaisi valita jatkamaan sukua. Jotta ongelma voidaan ratkaista lineaarisessa ajassa, tulee verkon olla DAG eli siinä ei ennestään saa olla syklejä. Survival moden kanssa pääsin siihen pisteeseen, että topologinen järjestäminen vaikuttaa toimivan.

Seuraavaksi siis täytyy testata toimiiko MyMap ja ottaa se käyttöön, toteuttaa oma versio jono/pinorakenteesta, jatkaa survival modea pisimmän polun etsimiseen. Harkinnassa on vielä, toteutuuko aihemäärittelyssä alunperin ollut "mitä kautta sukua" -toiminnallisuus. 