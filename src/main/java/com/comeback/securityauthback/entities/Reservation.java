package com.comeback.securityauthback.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    private Integer idReservation;
    @Column(name = "datedebut")
    private LocalDate dateDebut;
    @Column(name = "datefin")
    private LocalDate dateFin;
    @ManyToOne
    User user;
    @ManyToOne
    Livre livre;

}
