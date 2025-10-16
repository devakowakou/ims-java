# Système de Gestion d'Inventaire

## Description
Ce projet est une application de gestion d'inventaire développée avec Spring Boot. Il permet de gérer les produits, catégories, fournisseurs, transactions et utilisateurs de manière sécurisée avec authentification JWT.

## Fonctionnalités Principales
- **Gestion des Produits** : Ajout, modification, suppression et recherche de produits avec upload d'images
- **Gestion des Catégories** : Organisation des produits par catégories
- **Gestion des Fournisseurs** : Suivi des fournisseurs et de leurs informations
- **Gestion des Transactions** : Enregistrement des mouvements de stock
- **Gestion des Utilisateurs** : Système d'authentification et d'autorisation
- **API REST** : Endpoints documentés avec OpenAPI/Swagger
- **Sécurité** : Authentification JWT et contrôle d'accès basé sur les rôles

## Technologies Utilisées
- **Framework** : Spring Boot 3.5.5
- **Langage** : Java 21
- **Base de Données** : MySQL 8
- **ORM** : Spring Data JPA avec Hibernate
- **Sécurité** : Spring Security avec JWT
- **Documentation** : SpringDoc OpenAPI
- **Outils** : Lombok, ModelMapper
- **Build** : Maven

## Prérequis
- Java 21 ou supérieur
- MySQL 8
- Maven 3.6+

## Installation et Configuration

### 1. Cloner le Projet
```bash
git clone <url-du-projet>
cd InventoryManagementSystem
```

### 2. Configuration de la Base de Données
Créez une base de données MySQL nommée `inventorydb` :
```sql
CREATE DATABASE inventorydb;
```

### 3. Configuration des Propriétés
Modifiez le fichier `src/main/resources/application.properties` selon vos besoins :
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inventorydb
spring.datasource.username=votre_utilisateur
spring.datasource.password=votre_mot_de_passe
server.port=5050
```

**⚠️ Note de Sécurité** : Changez la clé JWT par défaut (`secreteJwtString`) dans le fichier de propriétés.

### 4. Build et Démarrage
```bash
# Build du projet
./mvnw clean install

# Démarrage de l'application
./mvnw spring-boot:run
```

L'application sera accessible sur http://localhost:5050

## Structure du Projet
```
src/main/java/com/Sindev/InventoryManagementSystem/
├── controllers/          # Contrôleurs REST
│   ├── AuthController.java
│   ├── CategoryController.java
│   ├── ProductController.java
│   ├── SupplierController.java
│   ├── TransactionController.java
│   └── UserController.java
├── models/               # Entités JPA
│   ├── User.java
│   ├── Product.java
│   ├── Category.java
│   ├── Supplier.java
│   └── Transaction.java
├── services/             # Logique métier
├── repositories/         # Accès aux données
├── dtos/                 # Objets de transfert
├── security/             # Configuration sécurité
├── exceptions/           # Gestion des erreurs
├── enums/                # Énumérations
└── specification/        # Spécifications de requêtes
```

## Entités Principales

### Produit (Product)
- **id** : Identifiant unique
- **name** : Nom du produit
- **sku** : Code SKU unique
- **price** : Prix du produit
- **stockQuantity** : Quantité en stock
- **description** : Description optionnelle
- **expiryDate** : Date d'expiration
- **imageUrl** : URL de l'image du produit
- **category** : Catégorie associée

### Utilisateur (User)
- Gestion des utilisateurs avec rôles (ADMIN, USER)

### Catégorie (Category)
- Classification des produits

### Fournisseur (Supplier)
- Informations sur les fournisseurs

### Transaction (Transaction)
- Historique des mouvements de stock

## API Endpoints

### Authentification
- `POST /api/auth/login` - Connexion utilisateur
- `POST /api/auth/register` - Inscription utilisateur

### Produits
- `POST /api/products/add` - Ajouter un produit (ADMIN)
- `PUT /api/products/update` - Modifier un produit (ADMIN)
- `GET /api/products/all` - Lister tous les produits
- `GET /api/products/{id}` - Détails d'un produit

### Catégories
- `GET /api/categories/all` - Lister les catégories

### Autres Endpoints
Consultez la documentation interactive sur http://localhost:5050/swagger-ui.html après démarrage.

## Sécurité
- Authentification basée sur JWT
- Rôles : ADMIN, USER
- Endpoints protégés selon les permissions

## Tests
```bash
./mvnw test
```

## Déploiement
Pour déployer en production :
1. Configurez une base de données de production
2. Ajustez les propriétés de sécurité
3. Build avec `./mvnw clean package`
4. Déployez le JAR généré

## Captures d'Écran
Le dossier `ScreenShots/` contient des exemples d'interface utilisateur.

## Images de Produits
Le dossier `product-images/` contient les images uploadées pour les produits.

## Support
Pour toute question ou problème, consultez la documentation ou créez une issue dans le repository.

## Auteur
Développé par Sindev

## Licence
Ce projet est sous licence propriétaire.
