ALTER TABLE livraison DROP FOREIGN KEY fk_client;
ALTER TABLE livraison DROP FOREIGN KEY fk_chauffeur;

ALTER TABLE client DROP COLUMN email;
ALTER TABLE client MODIFY COLUMN id BIGINT NOT NULL;
ALTER TABLE client
    ADD CONSTRAINT fk_user_client FOREIGN KEY (id) REFERENCES users (id);

ALTER TABLE chauffeur MODIFY COLUMN id BIGINT NOT NULL;
ALTER TABLE chauffeur
    ADD CONSTRAINT fk_user_chauffeur FOREIGN KEY (id) REFERENCES users (id);

ALTER TABLE livraison
    ADD CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES client (id);
ALTER TABLE livraison
    ADD CONSTRAINT fk_chauffeur FOREIGN KEY (chauffeur_id) REFERENCES chauffeur (id);
