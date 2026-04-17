ALTER TABLE livraison
ADD CONSTRAINT fk_chauffeur
FOREIGN KEY (chauffeur_id)
REFERENCES chauffeur(id);

ALTER TABLE livraison
ADD CONSTRAINT fk_client
FOREIGN KEY (client_id)
REFERENCES client(id);

ALTER TABLE livraison
ADD CONSTRAINT fk_vehicule
FOREIGN KEY (vehicule_id)
REFERENCES vehicule(id);

ALTER TABLE livraison MODIFY COLUMN statut VARCHAR(255) DEFAULT 'encours';
ALTER TABLE chauffeur MODIFY COLUMN disponible BOOLEAN DEFAULT true;
ALTER TABLE vehicule
ADD CONSTRAINT c_capacite CHECK (capacite > 0);
