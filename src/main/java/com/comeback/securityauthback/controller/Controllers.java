package com.comeback.securityauthback.controller;

import com.comeback.securityauthback.entities.*;
import com.comeback.securityauthback.services.Services;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1/auth/adminpage")
@RequiredArgsConstructor
public class Controllers {

    private final Services services;

    @PreAuthorize("permitAll()")
    @PostMapping("/addlivre")
    public Livre addLivre(@RequestBody Livre livre){
        Livre l = services.addLivre(livre);
        return l;
    }
    @PreAuthorize("permitAll()")
    @PostMapping("/addemprunt")
    public Emprunt addEmprunt(@RequestBody Emprunt emprunt){
        Emprunt e = services.addEmprunt(emprunt);
        return e;
    }
    @PreAuthorize("permitAll()")
    @PostMapping("/addnotification")
    public Notification addNotification(@RequestBody Notification notification){
        Notification n = services.addNotification(notification);
        return n;
    }
    @PreAuthorize("permitAll()")
    @PostMapping("/addreservation")
    public Reservation addReservation(@RequestBody Reservation reservation){
        Reservation r = services.addReservation(reservation);
        return r;
    }
    @PreAuthorize("permitAll()")
    @PostMapping("/updatelivre")
    public Livre updateLivre(@RequestBody Livre livre){
        Livre l = services.addLivre(livre);
        return l;
    }
    @PreAuthorize("permitAll()")
    @GetMapping("/affichLivre/{livre-id}")
    public Livre affichLivre(@PathVariable ("livre-id")Integer idLivre){
        Livre l=services.affichLivre(idLivre);
        return l;
    }
    @PreAuthorize("permitAll()")
    @DeleteMapping("/deleteLivre/{livre-id}")
    public void deleteLivre(@PathVariable ("livre-id")Integer idLivre){
        services.deleteLivre(idLivre);

    }
    @PreAuthorize("permitAll()")
    @GetMapping("/byCategorie/{categorie}")
    public List<Livre> getLivresByCategorie(@PathVariable("categorie") Categorie categorie) {
        return services.getLivreByCategorie(categorie);
    }
    @PreAuthorize("permitAll()")
    @GetMapping("/affichEmprunt/{emprunt-id}")
    public Emprunt affichEmprunt(@PathVariable ("emprunt-id")Integer idEmprunt){
        Emprunt e=services.affichEmprunt(idEmprunt);
        return e;
    }
    @PreAuthorize("permitAll()")
    @GetMapping("/affichNotification/{notification-id}")
    public Notification affichNotification(@PathVariable ("notification-id")Integer idNotification){
        Notification n=services.affichNotification(idNotification);
        return n;
    }
    @PreAuthorize("permitAll()")
    @GetMapping("/affichReservation/{reservation-id}")
    public Reservation affichReservation(@PathVariable ("reservation-id")Integer idReservation){
        Reservation r=services.affichReservation(idReservation);
        return r;
    }
    @PreAuthorize("permitAll()")
    @PutMapping("/affecterUtilisateurEmprunt/{idUser}/{idEmprunt}")
    public void affectUtilisateurEmprunt (@PathVariable Integer idUser,@PathVariable Integer idEmprunt){
        services.affectUtilisateurEmprunt(idUser,idEmprunt);
    }
    @PreAuthorize("permitAll()")
    @PutMapping("/affecterLivreEmprunt/{idLivre}/{idEmprunt}")
    public void affectLivreEmprunt (@PathVariable Integer idLivre,@PathVariable Integer idEmprunt){
        services.affectLivreEmprunt(idLivre,idEmprunt);
    }
    @PreAuthorize("permitAll()")
    @PutMapping("/affecterNotificationUser/{idNotification}/{idUser}")
    public void affectNotificationUser (@PathVariable Integer idNotification,@PathVariable Integer idUser){
        services.affectNotificationUser(idNotification,idUser);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addReservation(
            @RequestParam("userId") Long userId,
            @RequestParam("livreId") Integer livreId,
            @RequestParam("dateDebut") String dateDebut,
            @RequestParam("dateFin") String dateFin) {

        try {

            LocalDate parsedDateDebut = LocalDate.parse(dateDebut);
            LocalDate parsedDateFin = LocalDate.parse(dateFin);

            services.addReservationWithParams(userId, livreId, parsedDateDebut, parsedDateFin);

            return new ResponseEntity<>("Reservation added successfully", HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>("Error adding reservation: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PreAuthorize("permitAll()")
    @GetMapping("/byEmprunt/{idEmprunt}")
    public ResponseEntity<User> getUserByEmpruntId(@PathVariable Integer idEmprunt) {
        User user = services.getUserByEmpruntId(idEmprunt);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }






}
