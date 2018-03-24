## Viikkoraportti 2

Tuntimäärä ~12 h

Toisella viikolla varsinainen projekti sai alkunsa ja puitteet pitäisi olla aika hyvissä kantimissa. Tietorakennekin sai jo toimivalta vaikuttavan muodon.

Päädyin käyttämään Gradle + Travis + Codecov yhdistelmää, koska se on tuttu parilta aiemmalta kurssilta ja tuntui siksi luontevalta. Ympäristön pystyttäminen oli siksi vaivatonta. Lisäsin myös checkStylen, mutta sen kaikkia tarpeellisia sääntöjä täytyy vielä tutkia lisää.

Myöskin tietorakenteen totetutus sujui suhteellisen kivuttomasti. Inspiraationa toimivasta [videosta](https://youtu.be/gQ3iqBh69fU?t=240) poiketen käytin henkilön kumppanuuksien ja lapsien säilömiseen listaa taulukon sijaan, koska niiden määrää ei voida etukäteen tietää ja lista vaikutti siksi helpommalta ratkaisulta. Family-olio, jota ei videolla tai aihemäärittelyssä mainita, pitää taasen sisällään listan sukulaisuusverkkoon lisätyistä henkilöistä. Testejä kirjoittaessa kävi tosin mielessä, että listan sijaan siihen voisi käyttää myös HashMapia, jotta voidaan nopeammin selvittä, onko tiettyä henkilöä lisätty vielä. Se toisaalta edellyttää, ettei suvussa ole täyskaimoja. 

Tällä hetkellä testikattavuus ei näytä kovin kauniilta, koska kaikki manuaalista testausta varten kirjoitettu koodi (Main, toStringit) sekä käyttöliittymäluokka, joka ei varsinaisesti vielä muuta virkaa toimita, on testaamatta. Tärkeimmät tietorakenteen osien, eli luokat Family, Person ja Relation ja niiden oleellisten metodien testikattavuus on kuitenkin riittävä.

Seuraavaksi tavoitteena on aloittaa varsinaisen toiminnallisuuden toteutus ja ottaa selvää valmiiden tietorakenteiden korvaamisesta. Lisäksi aiheen laajennusmahdollisuudet ovat varmasti vielä mietinnässä.
