package com.comeback.securityauthback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bibliothecaire")
@RequiredArgsConstructor
public class BibliothecaireController {

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("hi bibliothecaire");
    }
}