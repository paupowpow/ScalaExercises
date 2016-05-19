# Aufgaben

## Aufgabe 1 (1. Abgabe)

Implementiere folgende Funktionen auf Listen in strikt funktionaler Weise (keine Variablen) und „zu Fuß“, d.h. Funktionen aus dem Scala-API sollen nach Möglichkeit nicht verwendet werden, insbesondere natürlich nicht solche, die genau die gefragte Funktionalität liefern.
- `def length (l: List[…]): Int` Länge der Liste
- `def take (l: List[…], n: Int): List[…]` und
  `def drop (l: List[…], n: Int): List[…]` erste n Elemente der Liste, Liste ohne erste n Elemente
- `def uniq (l: List[…]): List[…]` die Liste l ohne doppelte Elemente (mehrfach aufeinanderfolgende gleiche Elemente werden weggelassen)
- `def dupall (l: List[…]): List[…]` die Liste l, in der alle Elemente verdoppelt sind
- `def insertAt (l: List[…], i: Int, x: …): List[…]` und `def removeAt (l: List[…], i: Int): List[…]` Element an n-ter Stelle einfügen bzw. löschen



##Aufgabe 2 (1. Abgabe)

Erstelle eine Statistik-Funktion
`def zählZeichen (s: String): List[(Char, Int)] = …`
die eine Liste der Häufigkeiten von Buchstaben im String ermittelt.



## Aufgabe 3 (2. Abgabe)

Implementiere
- eine Funktion `def quicksort (l: List[Int]): List[Int] = …`
- eine Hilfsfunktion `def filter (l: List[Int], bleibtdrin: Int ⇒ Boolean): List[Int] = …` die aus einer Liste eine gefilterte Liste derjenigen Elemente erstellt, die das Prädikat bleibtdrin erfüllen
- und/oder eine Hilfsfunktion
`def split (l: List[Int], x: Int): (List[Int], List[Int]) = …` die eine Liste aufteilt in zwei Listen, deren Elemente kleiner oder kleinergleich bzw. größergleich oder größer als x sind
- und ggf. eine Hilfsfunktion
`def merge (l1: List[Int], l2: List[Int]): List[Int]) = …` die zwei sortierte Listen zu einer sortierten Liste mit allen Elementen beider Listen zusammenfügt


## Aufgabe 4 (2. Abgabe)

Erstelle eine „funktionale Funktion“ zur Bestimmung der Anzahl möglicher „Münzstückelungen“:
Zu einem Geldbetrag x und einer Reihe von „Münz-Denominationen“ (also verfügbarer Münzwerte) ist die Anzahl der Möglichkeiten gesucht, den Betrag aus den entsprechenden Münzen zusammenzustellen.

`def münzStückl (werte: List[Int], betrag: Int): Int = …`
S.a. Chicken Nugget Numbers.


## Aufgabe 5 (3. Abgabe)

Implementiere
`def balanced (s: String): Boolean:`
Bestimmung, ob String eine korrekte Klammerung enthält, z.B. „x(x(x))“ oder „(a)(b())“, nicht aber „a(“ oder „)x(“

Hinweis: praktischer ist `balanced (s: List[Char]): Boolean;` beim Aufruf kann ein String mit der Funktion toList in eine List[Char] umgewandelt werden: balanced (s.toList)
