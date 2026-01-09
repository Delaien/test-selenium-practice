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
| `setUp()` | `@BeforeEach` | Initialise le driver avant chaque test |
| `down()`  | `@AfterEach`  | Ferme le driver après chaque test      |


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


#### Exercice 2.2 : Créer `SearchResultsPage.java`


- **Consigne** : Créer une classe `SearchResultsPage` dans le package `pages`, elle va hériter de `BasePage`
- **Rôle** : Représente la page des résultats de recherche


| Méthode                              | Paramètres       | Rôle                                         | Retour  |
|--------------------------------------| ---------------- | -------------------------------------------- | ------- |
| `SearchResultsPage(WebDriver driver)` | WebDriver driver | Constructeur qui appelle super(driver)       | -       |
| `isDisplayed()`                       | -                | Vérifie qu'on est bien sur la page résultats | boolean |
| `getCurrentUrl()`                     | -                | Retourne l'URL actuelle de la page           | String  |


###  Partie 3 : Écrire les tests


#### Exercice 3.1 : Créer `HomeTest`


- **Consigne** : Créer une classe `HomeTest` dans le package `tests`, elle va hériter de `BaseTest`
- **Rôle** : Contient les tests nécessaires à l'affiche de la page d'acceuil


#### Exercice 3.2 : Test vérification page d'accueil


- **Consigne** : Créer un test `testHomePageIsDisplayed()` dans `HomeTest`

Ce que doit faire le test :
- Ouvrir la page d'accueil de GOG
- Vérifier que la page s'affiche correctement (`isDisplayed`)
- Vérifier l'existance d'un lien pour revenir à la page d'accueil


#### Exercice 3.3 : Créer `SearchTest.java`


- **Consigne** : Créer une classe `SearchTest` dans le package `tests`, elle va hériter de `BaseTest`
- **Rôle** : Contient les tests de recherche sur GOG.com


#### Exercice 3.4 : Test recherche "Cyberpunk"


- **Consigne** : Créer un test `testSearchCyberpunk` dans la classe `SearchTest`

Ce que doit faire le test :
- Créer une instance de `HomePage` en lui passant `driver`
- Appeler `open()` puis `searchGame("Cyberpunk")`
- Vérifier que l'URL contient "Cyberpunk"


#### Exercice 3.5 : Test recherche "Binding"


- **Consigne** : Créer un test `testSearchBindingOf` dans la classe `SearchTest`

Ce que doit faire le test :
- Rechercher "Binding of" sur GOG
- Appeler `open()` puis `searchGame("Binding of")`
- Vérifier que `isDisplayed()` retourne `true`


###  Partie 4 : Améliorer les Page Objects


#### Exercice 4.1 : Ajouter une méthode dans `SearchResultsPage`


- **Consigne** : Ajouter une méthode `getFirstGameTitle()` dans `SearchResultsPage`
- - **Rôle** : Retourne le titre du premier jeu dans les résultats

Il faut prévoir l'ajout de :
- Un attribut supplémentaire
- Une méthode supplémentaire


#### Exercice 4.2 : Test avec vérification du titre


- **Consigne** : Créer un test `testFirstResultContainsWitcher()`

Ce que doit faire le test :
- Rechercher "Witcher"
- Vérifier que le titre du premier résultat contient "Witcher"


#### Exercice 4.3 : Ajouter une méthode dans `HomePage`


- **Consigne** : Ajouter une méthode `changeLanguage(String locale)` dans `HomePage`

Ce que doit faire la méthode :
- Ouvrir https://www.gog.com/{locale}/
- Retourner `this`


###  Partie 5 : Améliorer la `HomeTest`


#### Exercice 5.1 : Tester le slider (carousel)


- **Consigne** : Créer un test `testSliderLeft()` dans `HomeTest`

Ce que doit faire le test :
- Chercher le bouton permettant de faire défiler le slider vers la gauche, cliquer dessus
- Vérifier ensuite le "swiper" (balise HTML) a bien changé son élément "actif" (classe `swiper-pagination-bullet-active`)

- Astuces :
  - il faudra ajouter des attributs / fonctions dans la classe `HomePage`


#### Exercice 5.2 : Aller sur la page d'un jeu


- **Consigne** : Créer un test `testGoToGamePage()` dans `HomeTest`

Ce que doit faire le test :
- Chercher le premier jeu du premier "swiper" (Nom : `a_plague_tale_requiem`) et cliquer dessus pour aller sur la page de détail de celui-ci

- Astuces :
  - il faudra créer une classe `GamePage`
  - il faudra ajouter des attributs / fonctions dans la classe `HomePage`


#### Exercice 5.3 : Améliorer la `SearchTest`


- **Consigne** : Créer un test `testFilterGoodOldGames`

Ce que doit faire le test :
- Chercher la checkbox de "GOOD OLD GAMES", cliquer dessus
- Vérifier l'affiche du filtre "Good old games"

- Astuces :
  - il faudra ajouter des attributs / fonctions dans la classe `SearchResultsPage`


#### Exercice 5.4 : Améliorer la `SearchResultsPage`


- **Consigne** : Créer un test `testRemoveFilter`

Ce que doit faire le test :
- Chercher le filtre "Supprimer les filtres" et cliquer dessus
- Vérifier que la page soit bien "réinitialisée" (à votre guise pour l'idée)

- Astuces :
  - il faudra ajouter des attributs / fonctions dans la classe `SearchResultsPage`


#### Exercice 5.5 : Améliorer la `HomePage`


- **Consigne** : Créer une fonction `goToGame`

Ce que doit faire la fonction :
- Elle prend en paramètre un `String` correspondant au nom du jeu à rechercher
- Elle doit faire le même comportement que la fonction `searchGame`, sauf qu'elle n'appuie pas sur `ENTER`
- Elle doit attendre que le dropdown de recherche apparaisse et clique sur le premier jeu du dropdown
- Elle renvoie un objet de type `GamePage`

- Astuces :
  - il faudra ajouter des attributs / fonctions dans la classe `HomePage`


#### Exercice 5.6 : Améliorer la `HomeTest`


- **Consigne** : Créer une fonction `testGoToGame`

Ce que doit faire la fonction :
- Tester le comportement de la fonction `goToGame` de la `HomePage`
- Vérifier que l'on arrive bien sur la page du jeu (via l'URL)
- Tester votre fonction avec le jeu "Theme Hospital"


#### Exercice 5.7 : Améliorer la `GamePage`


- **Consigne** : Créer une fonction `addGameToCart`

Ce que doit faire la fonction :
- Elle reprend le comportement de la fonction `goToGame` pour aller sur la page d'un jeu
- Elle clique sur le bouton "Ajouter au panier"


#### Exercice 5.8 : Créer la classe `GameTest`


- **Consigne** : Créer une fonction `testAddGameToCart`

Ce que doit faire la fonction :
- Elle reprend le comportement de la fonction `addGameToCart` de la `GamePage` pour ajouter un jeu au panier
- Elle doit vérifier que le jeu s'est correctement ajouté


###  Partie 6 : Nouvelle page


#### Exercice 6.1 : Créer la classe `WorkPage`


- **Consigne** : Créer une fonction `goToJobOfferInput`

Ce que doit faire la fonction :
- Aller sur la page des offres d'emplois, puis scroller jusqu'à la barre de recherche des offres d'emploi


#### Exercice 6.2 : Améliorer la classe `WorkPage`


- **Consigne** : Créer une fonction `searchForJobOffer`

Ce que doit faire la fonction :
- Avoir un paramètre de type String, de nom "job"
- Reprendre le comportement de la fonction `goToJobOfferInput`
- Ecrire le paramètre "job" dans la barre de recherche


#### Exercice 6.3 : Améliorer la classe `HomePage`


- **Consigne** : Créer une fonction `goToJobOfferPage`

Ce que doit faire la fonction :
- Cliquer sur le dropdown "À propos"
- Puis cliquer "Rejoindre notre équipe"
- La fonction doit retourner un objet de type `WorkPage`


#### Exercice 6.4 : Améliorer la classe `HomeTest`


- **Consigne** : Créer une fonction `testGoToJobOfferPage`

Ce que doit faire la fonction :
- Tester si l'on peut bien accéder à la base `WorkPage`


#### Exercice 6.5 : Créer la classe `WorkTest`


- **Consigne** : Créer une fonction `testSearchForJobOffer`

Ce que doit faire la fonction :
- Tester si l'on peut bien accéder à l'input de recherche d'offre d'emploi et saisir "backend" dedans
- Il faudra modifier `WorkPage` pour cet exercice










