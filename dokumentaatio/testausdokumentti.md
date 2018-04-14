## Testausdokumentti

Ohjelman testaus on toteutettu JUnit-yksikkötesteillä sekä manuaalisella testauksessa käyttöliittymän kautta. [JUnit testit](/src/test/java/) kattavat tietorakenteet ja toimintalogiikan. Käyttöliittymän testaus on toteutettu manuaalisesti käymällä läpi sen tarjoamat toiminnot.

### Manuaalinen testaus

Ohjelman toimintojen testaaminen käyttöliittymän kautta:
1. Käynnistä ohjelma -> toiminnallisuudet tulostuvat ruudulle
2. Valitse "Lisää" ja lisää henkilö esim. nimellä "Testi"
3. Valitse "Etsi" ja etsi juuri lisättyä henkilöä
4. Valitse "Kaikki" -> kaikkien henkilöiden tulokset tulostuvat ruudulle
5. Valitse "Suhde" ja lisää kumppanuus lisätyn henkilön ja henkilön "Tiina" välille
6. Valitse "Sukulaisuus" ja etsi lisätyllä henkilöllä ja henkilöllä "Daniel" -> "Henkilöt eivät ole sukua."
7. Valitse "Sukulaisuus" ja etsi henkilöillä "Ales" ja "Kristof" -> "... ovat sukua".
8. Valitse "Lopeta".