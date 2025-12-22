package io.github.jinahya.rickandmortyapi.test.web.servlet.client;

import io.github.jinahya.rickandmortyapi.persistence.EpisodeCharacter;
import io.github.jinahya.rickandmortyapi.persistence.EpisodeCharacterId;
import lombok.extern.slf4j.Slf4j;

@org.junit.jupiter.api.Disabled
@Slf4j
class EpisodeCharacter_ResourceTest extends _BaseEntityResourceTest<EpisodeCharacter, EpisodeCharacterId> {

    // -----------------------------------------------------------------------------------------------------------------
    EpisodeCharacter_ResourceTest() {
        super(EpisodeCharacter.class);
    }
}
