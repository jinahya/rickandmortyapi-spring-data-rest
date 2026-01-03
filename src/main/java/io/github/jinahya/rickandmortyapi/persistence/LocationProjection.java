package io.github.jinahya.rickandmortyapi.persistence;

import org.jspecify.annotations.Nullable;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "locationProjection",
            types = {
                    Location.class
            }
)
interface LocationProjection {

    String getName();

    @Nullable
    Location_Type getType();

    @Nullable
    Location_Dimension getDimension();
}
