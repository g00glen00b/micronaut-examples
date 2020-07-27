package be.g00glen00b.apps;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;

import javax.inject.Inject;
import java.util.UUID;

@Introspected
public class PokemonSpeciesRequestHandler extends MicronautRequestHandler<PokemonRequest, PokemonSpecies> {
    @Inject
    private PokeAPIClient client;

    @Override
    public PokemonSpecies execute(PokemonRequest input) {
        return client.findSpeciesByName(input.getName());
    }
}
