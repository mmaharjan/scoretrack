package com.webservices.scoretrack.repo;

import com.webservices.scoretrack.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByClientId(String clientId);
}
