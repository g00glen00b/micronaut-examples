package be.g00glen00b.apps;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.client.annotation.Client;

@Client("https://pokeapi.co/api/v2")
public interface PokeAPIClient {
    @Get("/pokemon-species/{name}")
    PokemonSpecies findSpeciesByName(@PathVariable String name);
}
