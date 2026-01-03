package io.github.jinahya.rickandmortyapi.persistence;

import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

@Projection(name = "episodeProjection",
            types = {
                    Episode.class
            }
)
interface EpisodeProjection {

    String getName();

    String getEpisode();

    Integer getSeasonNumber();

    Integer getEpisodeNumber();

    LocalDate getAirDateIso_();
}
