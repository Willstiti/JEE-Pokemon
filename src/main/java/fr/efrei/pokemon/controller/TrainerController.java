package fr.efrei.pokemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.efrei.pokemon.models.Trainer;
import fr.efrei.pokemon.services.TrainerService;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
    
    private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }

    @GetMapping
    public ResponseEntity<List<Trainer>> findAll(){
        return new ResponseEntity<>(trainerService.findall(), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Trainer> findById(@PathVariable String id){
        Trainer trainer = trainerService.findById(id);
        if(trainer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(trainer, HttpStatus.OK);
    }

    @PostMapping("{/id}")
    public ResponseEntity<?> save(@RequestBody Trainer trainer){
        trainerService.save(trainer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
