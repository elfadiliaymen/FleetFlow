CREATE TABLE IF NOT EXISTS client (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) UNIQUE,
    nom VARCHAR(255),
    telephone VARCHAR(255),
    ville VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS vehicule (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    capacite DOUBLE,
    matricule VARCHAR(255) UNIQUE,
    statut VARCHAR(255),
    type VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS chauffeur (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    disponible BOOLEAN,
    nom VARCHAR(255),
    permis_type VARCHAR(255),
    telephone VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS livraison (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    adresse_depart VARCHAR(255),
    adresse_destination VARCHAR(255),
    date_livraison DATETIME,
    statut VARCHAR(255),
    chauffeur_id BIGINT,
    client_id BIGINT,
    vehicule_id BIGINT
);
