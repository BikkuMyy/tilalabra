## Viikkoraportti 4

Tuntimäärä ~ 14 h

Viikko kului tietorakenteiden korvaamisessa, testikattavuuden parantelussa sekä dokumentaation kirjoittamisessa.

ArrayList on siis korvattu omalla toteutuksella, MyListillä ([lähde](http://hg.openjdk.java.net/jdk8/jdk8/jdk/file/tip/src/share/classes/java/util/ArrayList.java)). Tällä hetkellä MyList "tukee" vain niitä toimintoja, joita listan käyttö vaatii. Vaihto vaikutti sujuvan kivuttomasti, tosin listan käyttämät toiminnot ovat aika simppeleitä. MyListin oikeaa toimintaa pitää vielä testata paremmin. Viime viikon kommentin perusteella mietintään jäi myös lapsi- ja vanhempi-listojen korvaamisen linkityksillä ja sen toteutus käytännössä. Samalla tuli aloitettua myös HashMapin korvaaminen, joka vaikuttaa monimutkaisemmalta kuin ArrayListin tapaus.

Toiseksi koitin parannella testikattavuutta, kirjoitin testausdokumenttia ja loin lisää testidataa ohjelmaan. Vaaditun "muun testaamisen" laatu on ainakin tässä kohtaa vielä kysymysmerkki. Kuten myös testausdokumentin "Ohjelman toiminnan empiirisen testauksen tulosten esittäminen graafisessa muodossa". Tällä hetkellä yksikkötestien lisänä on vain käyttöliittymän manuaalinen testaus. Tässä ehkä tulee vastaan aiheenkin suppeus.. Syklittömyyden ts. sukusiittoisuuden tarkistuksen sijaan olisi ehkä järkevämpää toteuttaa jokin toisenlainen toiminnallisuus.

On sen verran monta avointa kysymystä, että täytynee vaivautua pajaan ens viikolla :D