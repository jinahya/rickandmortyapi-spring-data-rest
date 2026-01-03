package io.github.jinahya.rickandmortyapi.persistence;

import org.jspecify.annotations.Nullable;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "characterProjection",
            types = {
                    Character.class
            }
)
interface CharacterProjection {

    String getName();

    Character_Status getStatus();

    Character_Species getSpecies();

    @Nullable
    Character_Type getType();

    Character_Gender getGender();
}
