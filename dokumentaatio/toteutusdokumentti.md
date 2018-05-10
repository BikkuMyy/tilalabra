## Toteutusdokumentti

### Ohjelman yleisrakenne

Ohjelma koostuu Familytree-tietorakenteesta (graph) ja sitä käyttävistä toiminnoista(familytree) sekä tekstikäyttöliittymästä(UI). Luokat käyttävät itse toteutettuja tietorakenteita (datastructures). Rakennetta havainnollistaa oheinen luokkakaavio:

![Luokkakaavio](/dokumentaatio/tiralabra.png)

### Saavutetut aika- ja tilavaativuudet

Syvyyshaun ja topologisen järjestämisen toteutuneet aikavaativuudet todennettiin kokeellisesti erilaisilla verkoilla (ks. [Testausdokumentti](/dokumentaatio/testausdokumentti.md)). Kuten alla olevista kuvaajista nähdään, verkon koon kasvaessa lineaarisesti myös suoritusaika kasvaa lineaarisesti.

![DFS](/dokumentaatio/dfs_performance.png)

![Topologinen järjestäminen](/dokumentaatio/topo_performance.png)

### Puutteet ja parannusehdotukset
- Ohjelman käyttöä helpottaisi, jos sukulaisuusverkon sisältämät henkilöt voidaan lukea esim. JSON-tiedostosta, jossa kullekin henkilölle on valmiiksi määriteltynä suhteet, ja tallentaa edelleen samassa muodossa.
- Lasten ja vanhempien väliset suhteet voitaisiin hoitaa suoraan pointtereita käyttämällä kaksinkertaisten listojen sijaan.
- Henkilöiden yksilöinti muuten kuin vain nimen perusteella, jolloin täyskaimojen lisääminen on mahdollista, mutta samalla nimen perusteella tapahtuvien toiminnallisuuksien säilyttäminen
- Omien tietorakenteiden toteutusta voisi yksinkertaistaa ja optimoida.
- "Survival Mode" olettaa tällä hetkellä, että verkossa ei ole syklejä, mikä suuremmissa sukulaisuus verkoissa tuskin pitää paikkaansa.

### Lähteet
- [Tietorakenne](https://youtu.be/gQ3iqBh69fU?t=240)
- [ArrayListin](http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/tip/src/share/classes/java/util/ArrayList.java) korvaaminen
- [ArrayDequen](http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/tip/src/share/classes/java/util/ArrayDeque.java) korvaaminen
- HashMapin korvaaminen:
  - [JDK8](http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/tip/src/share/classes/java/util/HashMap.java)
  - [JDK7](http://hg.openjdk.java.net/jdk7/jdk7/jdk/file/tip/src/share/classes/java/util/HashMap.java)
- Topologinen järjestäminen ja pisin polku:
  - [Pisin polku DAGissa](https://www.geeksforgeeks.org/find-longest-path-directed-acyclic-graph/)
  - [Topologinen järjestäminen](https://www.geeksforgeeks.org/topological-sorting/)
  - [Wikipedia - Longest path problem](https://en.wikipedia.org/wiki/Longest_path_problem)
- Syvyyshaku: Tietorakenteet ja algoritmit S17 materiaali