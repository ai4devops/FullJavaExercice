# BigLabs - Mini examen GitHub Copilot (niveau intermédiaire)

Ce repository contient un lab de 30 a 40 minutes destine a valider les acquis d'une formation GitHub Copilot pour developpeurs.

## Objectif

Vous reprenez un mini projet Java de type utilitaire metier. Le code compile en theorie dans un projet Maven standard, mais l'objectif principal n'est pas l'execution : il s'agit surtout d'utiliser GitHub Copilot de maniere pertinente pour comprendre, corriger, tester et cadrer le travail.

## Competences evaluees

- Utiliser les modes `ask`, `edit`, `agent` et `plan`
- Utiliser les raccourcis Copilot dans le chat : `#`, `@`, `/`
- Generer du code a partir d'un besoin metier
- Faire du reverse engineering sur du code existant
- Corriger et optimiser du code
- Generer des tests pertinents
- Rediger de meilleurs prompts
- Identifier les risques de securite lies aux prompts
- Personnaliser GitHub Copilot avec des fichiers `.instructions.md`, `copilot-instructions.md` et un agent custom

## Temps conseille

- 5 min : prise en main et plan d'action
- 10 min : reverse engineering et comprehension du code
- 10 min : correction et optimisation
- 5 min : generation de tests
- 5 a 10 min : prompt engineering, securite et personnalisation

## Structure du depot

- `docs/business-rules.md` : regles fonctionnelles de reference
- `docs/prompt-examples.md` : prompts a analyser et ameliorer
- `src/main/java/com/biglabs/copilot/...` : code du mini projet
- `src/test/java/com/biglabs/copilot/...` : squelettes de tests
- `.github/copilot-instructions.md` : instructions globales du repo
- `.github/instructions/java-quality.instructions.md` : instructions ciblees pour le code Java
- `.github/agents/lab-coach.agent.md` : agent custom a renforcer
- `.github/prompts/secure-debug.prompt.md` : prompt reutilisable

## Contexte metier

L'equipe maintient un module interne qui :

- calcule le prix final d'un panier
- construit des indicateurs simples par categorie
- exporte des lignes au format CSV

Le code est lisible mais imparfait : certaines regles metier ne sont pas respectees, une methode est sous-documentee, et la personnalisation Copilot n'est pas assez precise pour etre vraiment utile.

## Travail demande

### 1. Preparer l'approche avec Copilot

Construisez un plan de travail avec le mode `plan` en vous appuyant sur :

- `README.md`
- `docs/business-rules.md`
- `docs/prompt-examples.md`

Attendu : un plan simple et ordonne avant de modifier le code.

Pistes d'usage Copilot :

- utilisez `#file` pour cibler des fichiers
- utilisez `#codebase` pour demander une synthese du projet
- utilisez `/explain` ou `/fix` si vous les utilisez dans votre environnement

### 2. Faire du reverse engineering

Analysez la methode `buildMonthlySummary` dans `CustomerInsights` puis creez le fichier `docs/reverse-engineering.md` avec :

- le role de la methode
- ses entrees et sorties
- le format produit
- ses limites actuelles
- les hypotheses metier que vous avez deduites

Attendu : une documentation courte, exploitable par un autre developpeur.

### 3. Corriger le calcul de prix

La classe `LegacyPricingService` ne respecte pas toutes les regles de `docs/business-rules.md`.

Attendu :

- correction du calcul du prix final
- conservation de l'API publique existante
- code plus clair que la version initiale

### 4. Optimiser et fiabiliser l'analyse des categories

La methode `topCategories` dans `CustomerInsights` est a la fois peu performante et incorrecte.

Attendu :

- corriger le comportement
- reduire la complexite inutile
- garder une implementation simple a maintenir

### 5. Generer des tests

Completez les squelettes de tests pour couvrir les cas importants de :

- `LegacyPricingService`
- `CsvExporter`

Attendu :

- cas nominaux
- cas limites
- cas d'echappement CSV

### 6. Ameliorer les prompts

Dans `docs/prompt-examples.md`, plusieurs prompts sont vagues ou risquent d'exposer des informations sensibles.

Creez `docs/prompt-rewrites.md` avec des versions ameliorees qui montrent :

- du role prompting
- du contexte utile
- des contraintes explicites
- une meilleure demande de sortie
- une version securisee quand le prompt initial est dangereux

Important : ne demandez jamais a Copilot d'exposer ou de reutiliser un vrai secret, un token, un mot de passe, ou un contenu confidentiel.

### 7. Personnaliser Copilot pour ce repo

Ameliorez les fichiers suivants :

- `.github/copilot-instructions.md`
- `.github/instructions/java-quality.instructions.md`
- `.github/agents/lab-coach.agent.md`

Attendu :

- des consignes plus precises
- des attentes claires sur le style, les tests et la securite
- un agent custom qui aide sans faire le travail a la place du participant

## Livrables attendus

En fin d'exercice, le repo doit contenir au minimum :

- les corrections de code dans `src/main/java`
- des tests completes dans `src/test/java`
- `docs/reverse-engineering.md`
- `docs/prompt-rewrites.md`
- des fichiers de personnalisation Copilot ameliores

## Criteres d'evaluation

- pertinence des prompts utilises
- capacite a exploiter le contexte du repo
- qualite des corrections proposees
- qualite et couverture des tests generes
- capacite a identifier les risques de securite
- qualite des fichiers de personnalisation Copilot

## Indices facultatifs

- Commencez par comprendre avant de corriger.
- Quand une regle metier est explicite dans la documentation, privilegiez cette source.
- Si vous demandez a Copilot d'ecrire des tests, imposez les cas a couvrir au lieu de demander des tests generiques.
- Pour la personnalisation, cherchez a guider Copilot sans le sur-contraindre.

## Prerequis techniques

- VS Code avec GitHub Copilot et GitHub Copilot Chat
- JDK 17 si vous souhaitez lancer les tests localement
- Maven uniquement si vous voulez executer `mvn test`

L'exercice reste realisable meme sans execution locale.