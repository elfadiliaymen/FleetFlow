package org.example.fleetflow.repository;

import org.example.fleetflow.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
