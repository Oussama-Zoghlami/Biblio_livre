package com.comeback.securityauthback.services.impl;

import com.comeback.securityauthback.entities.*;
import com.comeback.securityauthback.repository.*;
import com.comeback.securityauthback.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicesImpl implements Services {
    @Autowired
    EmpruntRepo empruntRepo;
    @Autowired
    LivreRepo livreRepo;
    @Autowired
    NotificationRepo notificationRepo;
    @Autowired
    ReservationRepo reservationRepo;
    @Autowired
    UserRepository userRepository;


    @Override
    public Livre addLivre(Livre livre) {
        return livreRepo.save(livre);
    }

    @Override
    public Emprunt addEmprunt(Emprunt emprunt) {
        return empruntRepo.save(emprunt);
    }

    @Override
    public Notification addNotification(Notification notification) {
        return notificationRepo.save(notification);
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    public Livre updateLivre(Livre livre) {
        return livreRepo.save(livre);
    }

    @Override
    public Livre affichLivre(Integer idLivre) {
        return livreRepo.findById(idLivre).orElse(null);
    }

    @Override
    public Emprunt affichEmprunt(Integer idEmprunt) {
        return empruntRepo.findById(idEmprunt).orElse(null);
    }

    @Override
    public Notification affichNotification(Integer idNotification) {
        return notificationRepo.findById(idNotification).orElse(null);
    }

    @Override
    public Reservation affichReservation(Integer idReservation) {
        return reservationRepo.findById(idReservation).orElse(null);
    }

    @Override
    public void deleteLivre(Integer idLivre) {
        livreRepo.deleteById(idLivre);

    }
    @Override
    public List<Livre> getLivreByCategorie(Categorie categorie) {
        List<Livre> allLivres = livreRepo.findAll(); // Assuming you have a method to get all Livre objects

        // Filter Livre objects by the specified category
        List<Livre> livresByCategorie = allLivres.stream()
                .filter(livre -> livre.getCategorie() == categorie)
                .collect(Collectors.toList());

        return livresByCategorie;
    }
    @Override
    public void affectUtilisateurEmprunt(Integer idUser, Integer idEmprunt) {
        User u = userRepository.findById(idUser).get();
        Emprunt e = empruntRepo.findById(idEmprunt).get();

        u.setEmprunt(e);
        userRepository.save(u);


    }

    @Override
    public void affectLivreEmprunt(Integer idLivre, Integer idEmprunt) {
        Livre l =livreRepo.findById(idLivre).get();
        Emprunt e = empruntRepo.findById(idEmprunt).get();

        l.setEmprunt(e);
        livreRepo.save(l);

    }

    @Override
    public void affectNotificationUser(Integer idNotification, Integer idUser) {
        Notification n= notificationRepo.findById(idNotification).get();
        User u =userRepository.findById(idUser).get();

        n.setUser(u);
        notificationRepo.save(n);
    }
    @Override
    public void addReservationWithParams(Long userId, Integer livreId, LocalDate dateDebut , LocalDate dateFin) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Livre livre = livreRepo.findById(livreId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setLivre(livre);
        reservation.setDateDebut(dateDebut);
        reservation.setDateFin(dateFin);

        reservationRepo.save(reservation);
    }
    public User getUserByEmpruntId(Integer idEmprunt) {
        return userRepository.findByEmprunt_IdEmprunt(idEmprunt).orElse(null);
    }


}
