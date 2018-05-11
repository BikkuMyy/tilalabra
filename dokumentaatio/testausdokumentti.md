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
8. Valitse "Survive" -> henkilöt topologisessa järjestyksessä sekä niiden etäsiyydet tulostuvat ruudulle.
9. Valitse "Tyhjennä" ja "Kyllä" -> kunn valitset "Kaikki", ei tulostu mitään.
10. Valitse "Lopeta".

### Suorituskykytestaus

Syvyyshaun suorituskykytestauksessa luotiin v henkilöä ja E = 2V tai E = 3V niiden välistä suhdetta sisältävä Family-olio. Suhteet lisättiin satunnaisten henkilöiden välille. Henkilöiden määrä kaksinkertaistui jokaisen 10 testikerran kierroksen jälkeen. Jokaiselta kierrokselta laskettiin 10 kerran keskiarvo huomioiden äärimmäiset poikkeavuudet. Tulokset koottuna alla olevaan kuvaajaan, jossa kolmen eri testiajon aikoijen keskiarvot.

![DFS](/dokumentaatio/dfs_performance.png)

Topologisen järjestämisen suorituskykytestaamista varten luotiin v henkilöä ja joko E = 3V tai vaihteleva määrä niiden välisiä suhteita. Kun E = 3V, 2/3 suhteista oli vanhempi-lapsi -suhteita ja kun määrä oli vaihteleva, luotiin 1..3 vanhempi-lapsi -suhdetta. Family-olio luotiin eri tavalla kuin syvyyshaun suorituskykytestauksessa , jotta se ei sisältäisi syklejä. Tämän, rekursiivisen luomistavan takia testattavan verkon koko jäi huomattavaksi pienemmäksi kuin syvyyshaussa. Henkilöiden määrä kaksinkertaistui jokaisen 10 testikerran kierroksen jälkeen. Jokaisella kierroksella laskettiin 10 kerran keskiarvo huomioiden äärimmäiset poikkeavuudet.Tulokset koottuna alla olevaan kuvaajaan, jossa kahden eri ajon aikojen keskiarvot.

![Topologinen järjestäminen](/dokumentaatio/topo_performance.png)