package com.comeback.securityauthback.repository;

import com.comeback.securityauthback.entities.Categorie;
import com.comeback.securityauthback.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreRepo extends JpaRepository<Livre, Integer> {
    List<Livre> findByCategorie(Categorie categorie);
}
