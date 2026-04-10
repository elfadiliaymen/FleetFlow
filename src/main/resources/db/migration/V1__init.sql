CREATE TABLE client (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    ville VARCHAR(255),
    telephone VARCHAR(50)
);

CREATE TABLE vehicule (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    matricule VARCHAR(50) NOT NULL UNIQUE,
    type VARCHAR(50),
    capacite DOUBLE,
    statut VARCHAR(50)
);

CREATE TABLE chauffeur (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    telephone VARCHAR(50),
    permis_type VARCHAR(50),
    disponible BOOLEAN DEFAULT TRUE
);

CREATE TABLE livraison (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_livraison DATETIME,
    adresse_depart VARCHAR(255),
    adresse_destination VARCHAR(255),
    statut VARCHAR(50),
    chauffeur_id BIGINT,
    client_id BIGINT,
    vehicule_id BIGINT,
    CONSTRAINT fk_livraison_chauffeur FOREIGN KEY (chauffeur_id) REFERENCES chauffeur(id),
    CONSTRAINT fk_livraison_client FOREIGN KEY (client_id) REFERENCES client(id),
    CONSTRAINT fk_livraison_vehicule FOREIGN KEY (vehicule_id) REFERENCES vehicule(id)
);
