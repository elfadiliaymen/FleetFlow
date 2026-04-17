ALTER TABLE fleetflow.Livraison
    ADD CONSTRAINT fk_chauffeur
        FOREIGN KEY (chauffeur_id)
            REFERENCES fleetflow.Chauffeur(id);

ALTER TABLE fleetflow.Livraison
    ADD CONSTRAINT fk_client
        FOREIGN KEY (client_id)
            REFERENCES fleetflow.Client(id);

ALTER TABLE fleetflow.Livraison
    ADD CONSTRAINT fk_vehicule
        FOREIGN KEY (vehicule_id)
            REFERENCES fleetflow.Vehicule(id);

ALTER TABLE fleetflow.Livraison MODIFY COLUMN statut VARCHAR(255)  DEFAULT 'encours';
ALTER TABLE fleetflow.Chauffeur MODIFY COLUMN diponible Boolean   DEFAULT true;
ALTER TABLE fleetflow.Vehicule
    ADD CONSTRAINT c_capacite CHECK (capacite>0);



