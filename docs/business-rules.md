# Regles metier

## Prix final d'un panier

- Le sous-total correspond a la somme de `unitPriceCents * quantity` pour chaque ligne.
- Un client VIP obtient 5 % de remise si le sous-total est superieur ou egal a `10_000` centimes.
- Le coupon `WELCOME10` donne 10 % de remise uniquement si le panier contient au moins 2 articles au total.
- Si le sous-total est superieur ou egal a `20_000` centimes, une remise fixe supplementaire de `500` centimes s'applique.
- La remise totale ne doit jamais depasser 25 % du sous-total.
- Le prix final ne peut jamais etre negatif.

## Analyse des categories

- Le classement des categories se fait par quantite totale achetee, pas par nombre de lignes.
- En cas d'egalite, la categorie est triee par ordre alphabetique croissant.
- La methode doit retourner au maximum `limit` categories.

## Export CSV

- Une valeur contenant une virgule, un guillemet ou un retour a la ligne doit etre entouree de guillemets.
- Un guillemet interne doit etre double.
- Une valeur `null` doit etre exportee comme chaine vide.