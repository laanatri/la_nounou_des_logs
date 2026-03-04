# La nounou des logs

**Nounou des logs** est un petit service de centralisation de logs pour surveiller l'activité d'applications comme ÉtudIA.  

---

## Statut du projet

 **Étape n°0 – Initialisation**

 - Définition du concept
 - Nom du projet : `nounou-des-logs`
 - Mise en place du repo et des prochaines étapes

 **Étape n°1 – Base backend Spring Boot**
  - Créer le projet Spring Boot (Web, Validation, MongoDB, PostgreSQL, Security)
  - Ajouter un endpoint `/api/health`

 **Étape n°2 – Setup BDD locales**
  - PostgreSQL via Docker Desktop
  - MongoDB via Docker Desktop
  - Configuration de application.properties pour connexion aux BDD
  - Ajout de Flyway pour les migrations

> **Étape n°3 – Modèle des applications monitorées**
> - Modèle `MonitoredApp` (entité JPA pour PostgreSQL)
> - Migration Flyway `V1__create_monitored_apps.sql`
> - Table `monitored_apps` créée dans PostgreSQL

---

## Objectif global

Construire un service de logs qui permet à des applications (ÉtudIA d'abord, puis d'autres) d'envoyer leurs logs vers un backend Spring Boot, stockés dans une base NoSQL, avec une interface web simple pour les consulter et une stack DevOps.

---

## Stack prévue

- **Backend** : Java 17 / Spring Boot 4
- **Base NoSQL** : MongoDB (stockage des logs)
- **Base SQL (plus tard)** : PostgreSQL (applications clientes, utilisateurs, clés API…)
- **Frontend** : Angular (UI simple pour consulter et filtrer les logs)
- **Infra / DevOps** :
  - Docker, docker-compose
  - GitHub Actions (CI/CD)
  - Déploiement cloud
  - Kubernetes (optionnel)
