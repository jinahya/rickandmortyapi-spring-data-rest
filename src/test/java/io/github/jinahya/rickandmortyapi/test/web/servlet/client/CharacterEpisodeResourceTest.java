package io.github.jinahya.rickandmortyapi.test.web.servlet.client;

import io.github.jinahya.rickandmortyapi.persistence.CharacterEpisode;
import io.github.jinahya.rickandmortyapi.persistence.CharacterEpisodeId;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class CharacterEpisodeResourceTest extends _BaseEntityResourceTest<CharacterEpisode, CharacterEpisodeId> {

    // -----------------------------------------------------------------------------------------------------------------
    CharacterEpisodeResourceTest() {
        super(CharacterEpisode.class);
    }
}