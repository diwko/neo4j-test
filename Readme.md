# Zadanie - grafowe bazy danych
Celem zadania jest przygotowanie prostego modelu grafowego i przygotowaniu prostej aplikacji realizującej zestaw poniższych funkcji. Należy dostarczyć sprawozdanie (PDF) + kod źródłowy. Przy zadaniach podano podpowiedzi do sprawozdania.

Za zadanie można otrzymać 6 punktów, rozdzielonych według podanej punktacji.  Aby wykonać następny krok należy podjąć próbę wykonania wszystkich wcześniejszych zadań.

* (1pkt) Należy wymyślić, lub znaleźć prosty graf, który ma przynajmniej 2 węzły i 3 różne krawędzie (+ kilka atrybutów).  Należy opisać lub pokazać model + atrybuty. Można użyć do tego np: CALL db.schema()

* (1pkt) Napisać funkcje do tworzenia poszczególnych obiektów i relacji w grafie. Proszę o wklejenie kodu/zdjęcia kodu

* (1pkt) Napisać bardzo prosty populator danych. Może to być zwykły Main czy Unit-test. Może być bardzo prosty, ale tak, aby było po 5 różnych obiektów i 10 relacji każdego typu. Proszę o wklejenie kodu/zdjęcia.

* (1pkt) Napisać funkcję do pobrania wszystkich relacji dla danego węzła. Proszę o wklejenie kodu/zdjęcia oraz o przygotowanie możliwości przetestowania tego (Main/UnitTest) wraz ze zdjęciem/kopią wyniku funkcji.

* (2pkt) Napisać funkcje do znalezienia ścieżki dla danych dwóch węzłów. Proszę o wklejenie kodu/zdjęcia oraz o przygotowanie możliwości przetestowania tego (Main/UnitTest) wraz ze zdjęciem/kopią wyniku funkcji.

Wymagania technologiczne (ewentualne zmiany proszę konsultować):
* Java (może to być wywołanie Cypher, może to być model w pełni obiektowy np wykorzystując Spring Data Neo4j)
* Neo4j (w przypadku braku użycia wersji embedded, należy zaznaczyć to w sprawozdaniu)
* Gradle/Maven (= nie dodajemy *.jar do wysyłanej wersji)

### Rozwiązanie:

**Model:**
![graph](https://github.com/diwko/neo4j-test/blob/master/pictures/model.png)

**Dane:**
![data](https://github.com/diwko/neo4j-test/blob/master/pictures/data.png)

**Relacje dla węzła: Bayern**
![relations](https://github.com/diwko/neo4j-test/blob/master/pictures/relations.png)

**Związek: Lewandowski -> Hazard**
![path](https://github.com/diwko/neo4j-test/blob/master/pictures/path.png)