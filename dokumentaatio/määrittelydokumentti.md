## Aihemäärittely

Sukulaisuusverkko -tietorakenne ja eri algoritmien soveltaminen verkon ominaisuuksien selvittämiseen.

Sukulaisuusverkon solmut ovat "Henkilö"-olioita, joihin liittyy kenttä Nimi ja kaaria sisältävät taulukot "Kumppanit" ja "Lapset". Taulukot sisältävät viitteet kaikkiin "Kumppani"- tai "Henkilö"-olioihin, joihin kyseisellä henkilöllä on suhde. Kumppani-olio sisältää niin ikään taulukon, jossa on viite suhteen kumpaankin osapuoleen. Verkko on suunnattu ja se voi sisältää syklejä.

Kun syötteeksi annetaan kaksi henkilöä, voidaan selvittää, ovatko he sukua toisilleen, ja kuinka läheisesti. Lisäksi voidaan selvittää, ovatko saman suvun eri haarojen kaksi jälkeläistä kumppaneita ja kuinka kaukainen heidän lähin yhteinen sukulaisensa on. 

Koska kyseessä on suunnattu verkko, polunetsintään kahden solmun välillä (ensimmäinen käyttötapaus) voidaan käyttää leveys- tai syvyyssuuntaista hakua ja syklittömyyden tarkistukseen (toinen käyttötapaus) syvyyssuuntaista hakua. Sekä leveys- että syvyyssuuntaisen haun aikavaativuus on O(V+E) ja tilavaativuus O(V), joissa V on solmujen ja E kaarien määrä.

Lähteet:
[Tietorakenne](https://youtu.be/gQ3iqBh69fU?t=240)


