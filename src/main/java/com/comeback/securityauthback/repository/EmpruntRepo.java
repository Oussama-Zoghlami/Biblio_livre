package com.comeback.securityauthback.repository;

import com.comeback.securityauthback.entities.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpruntRepo extends JpaRepository<Emprunt,Integer> {
}
