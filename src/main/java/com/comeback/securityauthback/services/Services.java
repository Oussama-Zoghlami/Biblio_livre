package com.comeback.securityauthback.services;

import com.comeback.securityauthback.entities.*;

import java.time.LocalDate;
import java.util.List;

public interface Services {
    public Livre addLivre(Livre livre);
    public Emprunt addEmprunt(Emprunt emprunt);
    public Notification addNotification(Notification notification);
    public Reservation addReservation(Reservation reservation);

    public Livre updateLivre(Livre livre);
    public Livre affichLivre(Integer idLivre);
    public Emprunt affichEmprunt(Integer idEmprunt);
    public Notification affichNotification(Integer idNotification);
    public Reservation affichReservation(Integer idReservation);
    public void deleteLivre(Integer idLivre);
    public List<Livre> getLivreByCategorie(Categorie categorie);

    public void affectUtilisateurEmprunt(Integer idUser, Integer idEmprunt);
    public void affectLivreEmprunt(Integer idLivre, Integer idEmprunt);
    public void affectNotificationUser(Integer idNotification, Integer idUser);
    public void addReservationWithParams(Long userId, Integer livreId, LocalDate dateDebut , LocalDate dateFin);



}
