ALTER TABLE Livraison
ADD CONSTRAINT fk_chauffeur
FOREIGN KEY (chauffeur_id)
REFERENCES Chauffeur(chauffeur_id)

ALTER TABLE Livraison
ADD CONSTRAINT fk_client
FOREIGN KEY (client_id)
REFERENCES Client(client_id)

ALTER TABLE Livraison
ADD CONSTRAINT fk_vehicule
FOREIGN KEY (vehicule_id)
REFERENCES Vehicule(vehicule_id)

ALTER TABLE Livraison MODIFY COLUMN statut VARCHAR(255)  DEFAULT 'encours';
ALTER TABLE Chauffeur MODIFY COLUMN diponible Boolean   DEFAULT true;
ALTER TABLE Vehicule
ADD CONSTRAINT c_capacite CHECK (capacite>0);



