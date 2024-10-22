package fr.efrei.pokemon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.efrei.pokemon.models.Trainer;
import fr.efrei.pokemon.repositories.TrainerRepository;

@Service
public class TrainerService {
    private final TrainerRepository repository;

    @Autowired
    public TrainerService(TrainerRepository repository){
        this.repository=repository;
    }

    public List<Trainer> findall(){
        return repository.findAll();
    }

    public Trainer findById(String id){
        return repository.findById(id).orElse(null);
    }

    public void save(Trainer trainer){
        repository.save(trainer);
    }

}
