package io.github.jinahya.rickandmortyapi.test.web.servlet.client;

import io.github.jinahya.rickandmortyapi.persistence.EpisodeCharacter;
import io.github.jinahya.rickandmortyapi.persistence.EpisodeCharacterId;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class EpisodeCharacterResourceTest extends _BaseEntityResourceTest<EpisodeCharacter, EpisodeCharacterId> {

    // -----------------------------------------------------------------------------------------------------------------
    EpisodeCharacterResourceTest() {
        super(EpisodeCharacter.class);
    }
}