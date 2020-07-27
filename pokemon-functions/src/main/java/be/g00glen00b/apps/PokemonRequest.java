package be.g00glen00b.apps;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotEmpty;

@Introspected
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PokemonRequest {
    @Nonnull
    @NotEmpty
    private String name;
}
