# Optimisez votre Microservice !
Dans cette activité,  vous allez créer un Microservice pour gérer les expéditions des commandes. Ce Microservice permettra de créer l'expédition d’une commande, puis de faire évoluer l’état de celle-ci (en préparation, expédiée, livrée).

Vous allez réaliser cette activité en 2 parties. Dans un premier temps, vous allez créer un Microservice pour gérer les expéditions. Puis vous allez créer une page pour le suivi de la commande côté client.

Forkez puis clonez le projet du cours : https://github.com/OCCourses/McommerceActivites (branche master)  

Vous pousserez ensuite les modifications dans le dépôt issu du fork.

## Consignes pour la réalisation

### Partie 1 : création d'un nouveau Microservice
1- Créez un nouveau Microservice et nommez-le  microservice-expedition. Ce Microservice doit :

intégrer les starters web, Actuator, JPA et H2,
avoir un nom déclaré,
écouter le port 9006.
2- Créez une classe Expedition dans un package appelé model avec comme attributs :  id ,  idCommande  et  etat .
3- Créez une méthode qui répond aux requêtes de type POST et qui permet d’ajouter une nouvelle expédition à la base de données.

Par exemple, exécutez une requête POST avec le JSON suivant :

{
   "id": 1,
   "idCommande": 3,
   "etat": 1
 }

4- Créez une méthode qui permet de récupérer une expédition par son id.
5- Créez une méthode qui permet de mettre à jour une expédition.

### Partie 2 : interface de visualisation
Dans ClientUI, créez une page qui affiche l’état de la commande.

Les états possibles sont les suivants : 

0 : En préparation
1 : Expédiée
2 : Livrée

Pour cela :

1) Ajoutez Ribbon à microservice-expedition
2) Pour faire appel à microservice-expedition vous devez utiliser Feign

Le rôle de Feign est :

d'utiliser Ribbon pour aller chercher l’URL,
d'envoyer les requêtes en passant par l’API Gateway ZUUL.

3) Ajoutez Eureka à microservice-expedition.
4) Faites les modifications nécessaires afin que les requêtes générées par Feign via le proxy d’expédition passent par ZUUL.
 
### Livrables
Vous devez rendre un fichier ZIP avec l’ensemble du projet fonctionnel.

### Compétences évaluées
Cette activité permet de mettre en œuvre les compétences suivantes. Votre activité sera évaluée par vos pairs en fonction des critères associés à chaque compétence.

Mettre en œuvre Ribbon et Eureka et les utiliser en harmonie avec ZUUL
Critères d'évaluation
Pour valider cette compétence, l'ensemble des critères suivants doivent être validés :

Le starter Ribbon et Eureka sont ajoutés dans le pom.xml  de microservice-expedition.
L'annotation  @EnableDiscoveryClient  est ajoutée à MicroserviceExpeditionApplication.
L’appel de l’URL  http://localhost:8080/suivi/1  retourne le résultat attendu.

Faire communiquer les Microservices grâce à Feign et créer des classes proxy
Critères d'évaluation
Pour valider cette compétence, vous devez créer une classe proxy dans ClientUI. Celle-ci doit comporter :

Les annotations  @FeignClient  et  @RibbonClient  correctement paramétrées.
Une méthode  etatExpedition  utilisant la notation @PathVariable à l'endroit pertinent.
Une classe ExpeditionBean qui reprend la structure du modèle Expedition.
Une méthode dans ClientController qui fait appel à la classe proxy pour récupérer une expédition.
Créer des Microservices exposant une API REST pour les opérations CRUD et les configurer
Critères d'évaluation
Pour valider cette compétence, l'implémentation de l'exercice 1 doit répondre aux critères suivants :

Une classe DAO, un model et un contrôleur sont créés.
Les trois méthodes créées répondent à POST, GET et PUT.
Le nom du Microservice et le port sont définis dans application.properties.
Les opérations fonctionnent quand on teste avec Postman.
