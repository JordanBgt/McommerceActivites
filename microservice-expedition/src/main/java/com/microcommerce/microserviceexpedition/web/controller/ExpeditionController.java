package com.microcommerce.microserviceexpedition.web.controller;

import com.microcommerce.microserviceexpedition.dao.ExpeditionDao;
import com.microcommerce.microserviceexpedition.model.Expedition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ExpeditionController {

    @Autowired
    ExpeditionDao expeditionDao;

    @PostMapping(value="/expedition")
    public ResponseEntity<Expedition> ajouterExpedition(@RequestBody Expedition expedition){
        //TODO : erreur si expedition existe déjà

        Expedition nouvelleExpedition = expeditionDao.save(expedition);

        //TODO : erreur si la sauvegarde ne renvoie rien

        return new ResponseEntity<Expedition>(nouvelleExpedition, HttpStatus.CREATED);
    }

    @GetMapping(value="/expedition/{id}")
    public Optional<Expedition> recupererUneExpedition(@PathVariable int id){

        return expeditionDao.findById(id);
    }

    @PutMapping(value="/expedition")
    public void mettreAJourExpedition(@RequestBody Expedition expedition){
        expeditionDao.save(expedition);
    }
}
