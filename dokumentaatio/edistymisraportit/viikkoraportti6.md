## Viikkoraportti 6

Tuntimäärä: ~16 

Viikko täy MyMapin testauksella ja hiomisella, MyDeque-tietorakenteen toteutuksella ja testauksella sekä "survival moden" viimeistelyllä. Lisäksi aikaa kului toiseen koodikatselmointiin.

MyMap vaikutti testeissä toimivan kuten pitää, mutta jostain syystä itse ohjelmassa käytettäessä ```keySet()``` ja ```values()``` eivät toimineetkaan odotetusti. Sitä debuggaillessa hujahti enemmän kuin tunti tai pari, mutta lopulta vika onneksi löytyi ja toivo heräsi jälleen :D 
MyDequen toteutus ja käyttöönotto oli onneksi nopeampaa.
Tietorakenteet on suhteellisen kattavasti testattu, mutta kaikki toteuttamatta jätetyt toiminnot laskevat kattavuusprosentteja.

Survival mode laskee nyt pisimmät polut topologisen järjestyksen perusteella. Mietinnässä on vielä, kuinka näyttää tieto käyttöliittymässä. Siksi myös luokan testaus on vielä aika ontuvaa. 

Seuraavaksi täytyy vielä viimeistellä dokumentaatiota ja vielä hioa vähän kaikkea. Omista tietorakenteista puuttuu vielä javadocit.