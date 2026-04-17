 Dockerisation de l'application

Création du Dockerfile:Ce fichier permet de créer l’image de l’application Spring Boot :


FROM eclipse-temurin:21-jdk-alpine
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

 Explication :

* `eclipse-temurin:21-jdk-alpine` : image Java légère
* `COPY target/*.jar app.jar` : copie le fichier `.jar` généré
* `ENTRYPOINT` : lance l’application Spring Boot



Création docker-compose.yml

Ce fichier permet de lancer l’application + la base de données MySQL:

yaml
version: "3.7"

services:
  app:
    build: .
    container_name: spring_boot_app
    depends_on:
      - db
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://db:3306/db?createDatabaseIfNotExist=true
      SPRING_DATASOURCE_USERNAME: user_name
      SPRING_DATASOURCE_PASSWORD: pass
    networks:
      - app_network

  db:
    image: mysql:8.0
    container_name: mysql_db
    restart: always
    ports:
      - "3307:3306"
    networks:
      - app_network
    environment:
      MYSQL_DATABASE: db
      MYSQL_ROOT_PASSWORD: 2005085
    volumes:
      - db_data:/var/lib/mysql

networks:
  app_network:

volumes:
  db_data:


 Explication :

app : service Spring Boot
db : base de données MySQL
depends_on : démarre la DB avant l’app
ports :

  * 8080 → API
  * 3307 → MySQL
  * volumes` : persistance des données

---

# Lancer l'application

docker compose up --build

 Vérification via Swagger

Une fois l’application lancée :Ouvrir dans le navigateur :

👉 http://localhost:8080/swagger-ui/index.html



 Si Swagger s’affiche :

* L’application fonctionne 
* La connexion à la base de données est OK 


 Prérequis

* Docker installé
* Maven utilisé pour générer le `.jar` :

mvn clean package


 Remarques importantes

* Le fichier `.jar` doit être présent dans `target/`
* Le port `8080` doit être libre
* Les identifiants MySQL sont définis dans `docker-compose.yml`
