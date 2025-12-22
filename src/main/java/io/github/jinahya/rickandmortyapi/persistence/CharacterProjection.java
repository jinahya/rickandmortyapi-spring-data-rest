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

    Character.Status getStatus();

    Character.Species getSpecies();

    Character.@Nullable Type getType();

    Character.Gender getGender();

//    String getImage();

//    java.net.URL getUrl();
}
