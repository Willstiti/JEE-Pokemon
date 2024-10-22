package fr.efrei.pokemon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.efrei.pokemon.models.Trainer;

@Repository
public interface  TrainerRepository extends JpaRepository<Trainer, String>{
}