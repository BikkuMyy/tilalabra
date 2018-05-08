## Aihemäärittely

Sukulaisuusverkko -tietorakenne ja eri algoritmien soveltaminen verkon ominaisuuksien selvittämiseen.

### Tietorakenne
Sukulaisuusverkon solmut ovat "Henkilö"-olioita, joihin liittyy kenttä "Nimi" ja kaaria edustavat "Kumppanit"-, "Lapset"- ja "Vanhemmat"-listat. Samalla nimellä voi esiintyä vain yksi henkilö, eli täyskaimojen lisääminen ei ole mahdollista. Listat sisältävät viitteet kaikkiin "Suhde"-oliohin, joihin henkilö liityy tai "Henkilö"-olioihin, joihin kyseisellä henkilöllä on suhde. "Suhde"-olio sisältää taulukon, jossa on viite suhteen kumpaankin osapuoleen. Verkko on suunnattu ja se voi sisältää syklejä.

### Toiminnot
Ohjelmaa voidaan käyttää yksinkertaisen tekstikäyttöliittymän avulla. Mahdolliset toiminnot:
- Etsi: etsi verkosta henkilöä nimen perusteella (nimen täytyy olla tarkka)
- Kaikki: tulosta kaikki verkon henkilöt ja niiden tiedot
- Lisää: lisää henkilö verkkoon
- Sukulaisuus: määritä ovatko kaksi henkilöä sukua toisilleen
- Survive: määritä verkon henkilöiden väliset etäisyydet ja siten verkon pisin polku 
- Suhde: lisää Kumppanuus tai Vanhempi-Lapsi -suhde kahden henkilön välille
- Lopeta

### Tavoitellut aikavaativuudet
Koska kyseessä on suunnattu verkko, polunetsintään kahden solmun välillä käytetään syvyyssuuntaista hakua. Pisimmän polun määrittämiseen käytetään topologista järjestämistä, jonka perusteella etäisyydet määritetään.
Sekä syvyyshaun että topologisen järjestämisen aikavaativuus on O(V+E) ja tilavaativuus O(V), joissa V on solmujen ja E kaarien määrä.

