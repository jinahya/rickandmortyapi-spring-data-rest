package io.github.jinahya.rickandmortyapi.test.web.servlet.client;

import io.github.jinahya.rickandmortyapi.persistence.CharacterEpisode;
import io.github.jinahya.rickandmortyapi.persistence.CharacterEpisodeId;
import lombok.extern.slf4j.Slf4j;

@org.junit.jupiter.api.Disabled
@Slf4j
class CharacterEpisode_ResourceTest extends _BaseEntityResourceTest<CharacterEpisode, CharacterEpisodeId> {

    // -----------------------------------------------------------------------------------------------------------------
    CharacterEpisode_ResourceTest() {
        super(CharacterEpisode.class);
    }
}
