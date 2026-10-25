# SocaPay API

**SocaPay API** est une API de paiement marchand **simulée**, construite avec Spring Boot pour apprendre à **observer un système en production** avec Actuator, Micrometer, Prometheus et Grafana.
## Objectifs

- Comprendre comment instrumenter une application Spring Boot avec Micrometer
- Exposer des métriques via Spring Boot Actuator au format Prometheus
- Les collecter avec Prometheus et les visualiser dans Grafana
- Répondre à des questions concrètes sur la santé du système :
    - Combien de transactions ont réussi ?
    - Combien ont échoué, et pour quel provider ?
    - Combien de temps prend une transaction ?

## Providers simulés

| Provider | Type | Valeur dans la requête |
|---|---|---|
| Orange Money | Mobile money | `orange money` |
| MTN MoMo | Mobile money | `mtn momo` |
| Visa | Carte bancaire | `visa` |

Chaque provider simule des résultats différents (succès, échec) et des temps de réponse variables, afin de comparer leurs performances dans Grafana.

## Stack technique

- Java / Spring Boot
- Spring Boot Actuator
- Micrometer (registry Prometheus)
- Prometheus
- Grafana
- Docker

## Métriques suivies

| Indicateur | Description |
|---|---|
| Transactions réussies | Nombre de transactions terminées avec succès |
| Transactions échouées | Nombre de transactions en échec |
| Durée d'une transaction | Temps de traitement d'une transaction (moyenne, p95, p99) |
| Répartition par provider | Les mêmes indicateurs ventilés par Orange Money, MTN MoMo, Visa |
| Taux d'échec | Échecs / total des transactions |

En plus des métriques métier, Actuator expose automatiquement les métriques techniques : requêtes HTTP, JVM (mémoire, GC, threads), CPU, etc.

## Démarrage rapide

### Prérequis

- Docker


### Lancer l'application

```bash
docker build -t socapay-api .
docker run -p 8080:8080 socapay-api
```

L'API est disponible sur `http://localhost:8080`.

## Utilisation

### Créer une transaction

`POST /api/transactions`

| Champ | Type | Obligatoire | Description |
|---|---|---|---|
| `amount` | nombre décimal | oui | Montant de la transaction |
| `currency` | texte | oui | Devise (ex. `XAF`) |
| `merchantId` | texte | non | Identifiant du marchand |
| `provider` | texte | oui | `orange money`, `mtn momo` ou `visa` |

Exemple :

```bash
curl -X POST http://localhost:8080/api/transactions \
  -H "Content-Type: application/json" \
  -d '{
    "amount": 5000,
    "currency": "XAF",
    "merchantId": "merchant-001",
    "provider": "mtn momo"
  }'
```

```

## Observabilité

### Endpoints Actuator

| Endpoint | Rôle |
|---|---|
| `/actuator/health` | État de santé de l'application |
| `/actuator/metrics` | Liste des métriques disponibles |
| `/actuator/prometheus` | Métriques au format Prometheus |



## Licence

Projet d'apprentissage, sans licence particulière.