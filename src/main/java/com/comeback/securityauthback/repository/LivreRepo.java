package com.comeback.securityauthback.repository;

import com.comeback.securityauthback.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepo extends JpaRepository<Livre, Integer> {
}
