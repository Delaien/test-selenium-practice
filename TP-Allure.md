# TP GOG.com - Intégration d'Allure Reports

## Contexte

Vous allez améliorer les tests automatisés en intégrant **Allure**
Vous devez ajouter des métadonnées aux tests (feature, story, severity, description) et de capturer automatiquement des screenshots en cas d'échec.

---

## Objectifs

- Configurer Allure dans le projet Maven
- Enrichir les tests avec des annotations Allure
- Implémenter la capture automatique de screenshots
- Générer un rapport HTML complet

---

## Partie 1 : Configuration d'Allure

### Exercice 1.1 : Ajouter les dépendances Maven

**Consigne** : Modifier le fichier `pom.xml` pour ajouter les dépendances Allure

Ajoutez les dépendances nécessaire dans le `pom.xml`

### Exercice 1.2 : Configurer le plugin Maven Surefire

**Consigne** : Ajouter la configuration AspectJ dans le plugin `maven-surefire-plugin`

Ajoutez ou modifiez la section `<build>` dans votre `pom.xml`

NB : pensez également à ajouter une dépendance dans la balise `<version>`...

### Exercice 1.3 : Vérifier l'installation

**Consigne** : Tester que Maven reconnaît Allure

Lancer vos tests avec Maven via un `mvn clean test`

Ou via l'interface graphique d'IntelliJ

---

## Partie 2 : Enrichir les tests avec les annotations Allure

### Exercice 2.1 : Annoter les tests de `HomeTest`

**Consigne** : Enrichir tous les tests de la classe `HomeTest` avec les annotations Allure

**Tous les tests** doivent avoir :

```java
@Feature("Home action") // Tests de la page d'accueil

@Story("...") // Vous devez écrire une user story pertinente pour chaque test

@Severity(SeverityLevel.NORMAL)

// SeverityLevel.CRITICAL pour testHomePageIsDisplayed()
// SeverityLevel.NORMAL pour tous les autres tests

@Description("...") // Une description claire de ce que fait le test
```

### Exercice 2.2 : Annoter les tests de `SearchTest`

**Consigne** : Enrichir tous les tests de la classe `SearchTest` avec les annotations Allure


**Tous les tests** doivent avoir :

```java
@Feature("Search action") // Tests de la page d'accueil

@Story("...") // Vous devez écrire une user story pertinente pour chaque test

@Severity(SeverityLevel.NORMAL) // SeverityLevel.NORMAL pour tous les tests

@Description("...") // Une description claire de ce que fait le test
```

---

## Partie 3 : Implémenter la capture automatique de screenshots

### Exercice 3.1 : Configurer la classe `BaseTest`

**Consigne** : Configurer la classe `BaseTest` pour qu'elle gère la prise de screenshot

### Exercice 3.2 : Lancer vos tests et générer un rapport HTML

**Consigne** : Lancer le rapport de tests et le consulter

### Exercice 3.3 : Forcer l'erreur dans un test

**Consigne** : Faites en sorte qu'un test échoue, et consulter le rapport généré avec le screenshot

---

## Partie 4 : Appliquer cette logique sur la partie 6 du TP précédent

**Consigne** : Tout est dans le titre !

---

## Partie 5 : Faire une CI pour exécuter les tests dans une tâche GitHub Action

**Consigne** : Tout est dans le titre !



















