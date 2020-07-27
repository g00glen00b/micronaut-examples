package be.g00glen00b.apps;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PokedexEntry {
    @JsonProperty("flavor_text")
    private String text;
    private PokedexEntryLanguage language;
}
