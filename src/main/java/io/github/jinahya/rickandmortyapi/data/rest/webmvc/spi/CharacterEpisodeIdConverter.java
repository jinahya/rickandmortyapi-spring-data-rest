package io.github.jinahya.rickandmortyapi.data.rest.webmvc.spi;

import io.github.jinahya.rickandmortyapi.persistence.CharacterEpisode;
import io.github.jinahya.rickandmortyapi.persistence.CharacterEpisodeId;
import org.springframework.stereotype.Component;

@Component
class CharacterEpisodeIdConverter extends _BaseEntityIdConverter<CharacterEpisode, CharacterEpisodeId> {

    // -----------------------------------------------------------------------------------------------------------------
    CharacterEpisodeIdConverter() {
        super(CharacterEpisode.class, CharacterEpisodeId.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    CharacterEpisodeId fromRequestId(final String id) {
        final var values = idsFromString(id);
        assert values.length == 2;
        return CharacterEpisodeId.of(values[0], values[1]);
    }

    @Override
    String toRequestId(final CharacterEpisodeId id) {
        return idsToString(id.getCharacterId(), id.getEpisodeId());
    }
}
