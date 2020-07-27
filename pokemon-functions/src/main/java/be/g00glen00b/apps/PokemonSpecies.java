package be.g00glen00b.apps;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Introspected
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PokemonSpecies {
    @Nonnull
    private long id;
    @Nonnull
    @NotEmpty
    private String name;
    @JsonProperty("flavor_text_entries")
    private List<PokedexEntry> pokedexEntries;
}
