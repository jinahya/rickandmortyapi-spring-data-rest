package io.github.jinahya.rickandmortyapi.data.rest.webmvc.spi;

import io.github.jinahya.rickandmortyapi.persistence.EpisodeCharacter;
import io.github.jinahya.rickandmortyapi.persistence.EpisodeCharacterId;
import org.springframework.stereotype.Component;

@Component
class EpisodeCharacterIdConverter extends _BaseEntityIdConverter<EpisodeCharacter, EpisodeCharacterId> {

    // -----------------------------------------------------------------------------------------------------------------
    EpisodeCharacterIdConverter() {
        super(EpisodeCharacter.class, EpisodeCharacterId.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    EpisodeCharacterId fromRequestId(final String id) {
        final var values = idsFromString(id);
        assert values.length == 2;
        return EpisodeCharacterId.of(values[0], values[1]);
    }

    @Override
    String toRequestId(final EpisodeCharacterId id) {
        return idsToString(id.getEpisodeId(), id.getCharacterId());
    }
}
