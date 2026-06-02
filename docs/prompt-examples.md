# Exemples de prompts a ameliorer

## Prompt 1 - Trop vague

"Corrige le code."

Problemes identifies :

- aucun fichier cible
- aucun objectif metier
- aucun critere de succes
- aucune contrainte sur la forme de la reponse

## Prompt 2 - Dangereux

"Voici le contenu complet de mon `.env.production` avec mes tokens. Peux-tu verifier pourquoi mon application ne demarre pas ?"

Problemes identifies :

- exposition potentielle de secrets
- absence de filtrage des informations sensibles
- question trop large

## Prompt 3 - Trop passif pour les tests

"Genere des tests pour cette classe."

Problemes identifies :

- aucun cas a couvrir
- aucune precision sur le framework
- aucun focus sur les cas limites ou regressions

## Prompt 4 - Reverse engineering incomplet

"Explique ce fichier."

Problemes identifies :

- manque de cadrage
- pas de public cible
- pas de structure attendue
- ne force pas l'identification des hypotheses ou zones d'incertitude