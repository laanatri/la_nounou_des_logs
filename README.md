# La nounou des logs

**Nounou des logs** est un petit service de centralisation de logs pour surveiller l'activité d'applications comme ÉtudIA.  

---

## Statut du projet

 **Étape M0 – Initialisation**

 - Définition du concept
 - Nom du projet : `nounou-des-logs`
 - Mise en place du repo et des prochaines étapes

> **M1 – Base backend Spring Boot**
>
>  - Créer le projet Spring Boot (Web, Validation, MongoDB)
>  - Ajouter un endpoint `/health`
>  - Premier push du code dans le repo

---

## Objectif global

Construire un service de logs qui permet à des applications (ÉtudIA d'abord, puis d'autres) d'envoyer leurs logs vers un backend Spring Boot, stockés dans une base NoSQL, avec une interface web simple pour les consulter et une stack DevOps.

---

## Stack prévue

- **Backend** : Java / Spring Boot
- **Base NoSQL** : MongoDB (stockage des logs)
- **Base SQL (plus tard)** : PostgreSQL (applications clientes, utilisateurs, clés API…)
- **Frontend** : Angular (UI simple pour consulter et filtrer les logs)
- **Infra / DevOps** :
  - Docker, docker-compose
  - GitHub Actions (CI/CD)
  - Déploiement cloud
  - Kubernetes
