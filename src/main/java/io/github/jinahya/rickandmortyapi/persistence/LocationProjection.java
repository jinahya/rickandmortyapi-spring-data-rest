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

    Location.@Nullable Type getType();

    Location.@Nullable Dimension getDimension();

//    java.net.URL getUrl();
}
