## Viikkoraportti 3

Tuntimäärä ~12.5
Viikko kului tietorakennetta paranteluun, käyttöliittymän laajennukseen ja leveyshaun toteutukseen. Edellisen viikon suunnitelman mukaan etsin myös lähteitä/esimerkkejä listan toteuttamisesta itse ja refaktoroin koodia hieman.

Edellisen viikon palautuksen jälkeen huomasin, että tietorakenne kaipaa vielä hiomista. Nykyisellään siitä voitaisiin ainoastaan selvittää sukulaisuussuhteita ylhäältä alaspäin eli vanhemmista lapsiin, mutta ei toiseen suuntaan. Alla olevissa kuvissa tilanne nyt ja toisessa "parannuksen" jälkeen.

![Nykyinen verkko](/graph1.png)

Sen lisäksi, että kukin "Henkilö" -olio sisältää tiedon lapsistaan, tulisi sen myös tuntea vanhempansa, jotta on mahdollista selvittää, ovatko esimerkiksi AT ja KrM sukua toisilleen. 

![Parannettu verkko](/graph2.png)

Tässä kohtaa hämmennyin hieman, mutta hetken pohdinnan jälkeen tulin siihen tulokseen, että verkon täytyy edelleen olla suunnattu, koska ei ole yhdentekevää, kumpi henkilö on vanhempi ja kumpi lapsi.

Lisäksi huomasin, kahden henkilön sukulaisuuden selvittämisessä tulee käyttää ainoastaan vanhempi-lapsi- tai lapsi-vanhempi-suhteita, ei kahden henkilön välisiä kumppanuuksia. Tässä vaiheessa toteutin sukulaisuuden määrityksen syvyyshaulla ja se toimii ainakin yksinkertaisissa tapauksissa. Tällä hetkellä avioparin kuitenkin lasketaan olevan sukua toisilleen, jos molemmilla on suhde lapseen. Nyt oletetaan, ettei verkko sisällä täyskaimoja, mikä toisaalta myös tarkistetaan käyttöliittymässä uusia henkilöitä lisättäessä.

Testikattavuutta rumentaa edelleen käyttöliittymä. Seuraavaksi suunnitelmissa on listan toteuttaminen itse ja HashMapin toteutuksen tutkiminen. Myös verkon tallentaminen jossain muodossa olisi hyödyllistä.
