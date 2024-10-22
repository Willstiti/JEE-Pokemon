package fr.efrei.pokemon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.efrei.pokemon.models.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, String> { }