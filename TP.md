# TP GOG.com - Architecture POM


## Contexte


Vous allez automatiser la navigation sur https://www.gog.com/fr/, une plateforme de jeux vidéo, en utilisant l'architecture Page Object Model.


###  Partie 1 : Préparation des bases de l'architecture POM


Commencez par créer un package `gog`, vous travaillerez uniquement dans ce package


#### Exercice 1.1 : Créer `BasePage.java`


- **Consigne** : Créer une classe `BasePage` dans le package `pages`
- **Rôle** : Classe parente qui contient les méthodes utilitaires réutilisables par toutes les pages

| Méthode                  | Rôle                                     | Retour     |
|--------------------------|------------------------------------------| ---------- |
| `BasePage(WebDriver driver)` | Constructeur qui reçoit le driver        | -          |
| `waitUntil(By locator)`  | Attend qu'un élément soit visible        | WebElement |
| `waitClick(By locator)`  | Clique sur un élément                    | void       |
| `type(By locator, String text)` | Tape du texte dans un champ              | void       |
| `getText(By locator)`     | Récupère le contenu textuel d'un élément | String     |

- Attributs de la classe :
  - `protected WebDriver driver`
  - `protected WebDriverWait wait`


#### Exercice 1.2 : Créer `BaseTest.java`


- **Consigne** : Créer une classe `BaseTest` dans le package `tests`
- **Rôle** : Classe parente pour les tests

| Méthode   | Annotation  | Rôle                                   |
|-----------| ----------- | -------------------------------------- |
| `setUp()` | @BeforeEach | Initialise le driver avant chaque test |
| `down()`  | @AfterEach  | Ferme le driver après chaque test      |


###  Partie 2 : Créer les Pages Objects


#### Exercice 2.1 : Créer `HomePage.java`


- **Consigne** : Créer une classe `HomePage` dans le package `pages`, elle va hériter de `BasePage`
- **Rôle** : Représente la page d'accueil de GOG.com

Elle possède l'attribut `private final By searchInput = `, vous devez définir le bon locator à utiliser


| Méthode                    | Paramètres       | Rôle                                                               | Retour            |
| -------------------------- | ---------------- | ------------------------------------------------------------------ | ----------------- |
| `HomePage(WebDriver driver)` | WebDriver driver | Constructeur qui appelle super(driver)                             | -                 |
| `open()`                     | -                | Ouvre https://www.gog.com/fr/                                      | `HomePage`          |
| `searchGame(String gameName)` | String gameName  | Tape le nom du jeu dans la barre de recherche et appuie sur ENTRÉE | `SearchResultsPage` |


> Détails importants :
> - `open()` doit retourner `this` pour permettre le chaînage
> - `searchGame()` doit retourner `new SearchResultsPage(driver)`
> - Il peut être intéressant d'appuyer sur ENTRÉE pour valider la recherche...


#### Exercice 2.2 : Créer `SearchResultsPage.java`


- **Consigne** : Créer une classe `SearchResultsPage` dans le package `pages`, elle va hériter de `BasePage`
- **Rôle** : Représente la page des résultats de recherche


| Méthode                              | Paramètres       | Rôle                                         | Retour  |
|--------------------------------------| ---------------- | -------------------------------------------- | ------- |
| `SearchResultsPage(WebDriver driver)` | WebDriver driver | Constructeur qui appelle super(driver)       | -       |
| `isDisplayed()`                       | -                | Vérifie qu'on est bien sur la page résultats | boolean |
| `getCurrentUrl()`                     | -                | Retourne l'URL actuelle de la page           | String  |


###  Partie 3 : Écrire les tests



