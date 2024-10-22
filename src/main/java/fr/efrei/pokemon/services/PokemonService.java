package fr.efrei.pokemon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.efrei.pokemon.models.Pokemon;
import fr.efrei.pokemon.repositories.PokemonRepository;

@Service
public class PokemonService {

	private final PokemonRepository pokemonRepository;

	@Autowired
	public PokemonService(PokemonRepository pokemonRepository) {
		this.pokemonRepository = pokemonRepository;
	}

	// Trajet de la donnée
	// Base de données -> Entité -> Repository -> Service -> Controller
	public List<Pokemon> findAll() {
		// SELECT * FROM pokemon;
		return pokemonRepository.findAll();
	}

	public Pokemon findById(String id) {
		// Optional : soit l'objet soit null
		// SELECT * FROM pokemon WHERE id = :id
		return pokemonRepository.findById(id).orElse(null);
	}

	// Trajet de la donnée
	// Controller -> Service -> Repository -> Entité -> BDD
	public void save(Pokemon pokemon) {
		// INSERT INTO pokemon VALUES (:name, :level, :type);
		pokemonRepository.save(pokemon);
	}

    public void delete(String id){
        pokemonRepository.deleteById(id);
    }

    public void update(String id, Pokemon pokemon){
        Pokemon pokemonAmodifier = findById(id);
        pokemonAmodifier.setType(pokemon.getType());
        pokemonAmodifier.setName(pokemon.getName());
        pokemonAmodifier.setLevel(pokemon.getLevel());
        pokemonRepository.save(pokemonAmodifier);
    }
}