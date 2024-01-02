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
@Table(name = "livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livre")
    private Integer idLivre;
    @Column(name = "titre_livre")
    private String titre;
    @Column(name = "autheur_livre")
    private String autheur;
    @Column(name = "dete_publication")
    private LocalDate datePub;
    @Column(name = "isbn")
    private Integer numISBN;

    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "livre")
    private Set<Reservation> reservations;
    @ManyToOne
    Emprunt emprunt;

}
