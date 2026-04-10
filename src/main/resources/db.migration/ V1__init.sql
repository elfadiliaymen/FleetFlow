CREATE TABLE  IF NOT EXISTS Client(
    id BIGINT auto_increment primary,
    email varchar(255) UNIQUE ,
    nom varchar(255),
    telephone varchar(255),
    ville varchar(255)

)

CREATE TABLE IF NOT EXISTS Vehicule(
    id BIGINT auto_increment primary,
    capacite double ,
    matricule varchar(255) UNIQUE,
    statut varchar(255),
    type varchar(255)

)
CREATE TABLE IF NOT EXISTS  Chauffeur(
    id BIGINT auto_increment primary,
    diponible Boolean,
    nom   varchar(255),
    permis_type varchar(255),
    telephone varchar(255)


)
CREATE TABLE  IF NOT EXISTS Livraison(
    id BIGINT auto_increment primary key,
    adresse_depart varchar(255),
    adresse_destination varchar(255),
    date_livraison datetime,
    statut varchar(255),
    chauffeur_id BIGINT,
    client_id BIGINT,
    vehicule_id BIGINT




)