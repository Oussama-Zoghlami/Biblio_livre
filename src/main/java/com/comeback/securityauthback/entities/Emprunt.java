package com.comeback.securityauthback.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "emprunt")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idemprunt")
    private Integer idEmprunt;
    @Column(name = "datedebut")
    private LocalDate dateDebut;
    @Column(name = "datefin")
    private LocalDate dateFin;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "emprunt")
    private Set<User> users;

}
