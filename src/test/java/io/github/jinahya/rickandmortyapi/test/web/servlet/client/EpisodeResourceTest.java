package io.github.jinahya.rickandmortyapi.test.web.servlet.client;

import io.github.jinahya.rickandmortyapi.persistence.Episode;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class EpisodeResourceTest extends _BaseEntityResourceTest<Episode, Integer> {

    // -----------------------------------------------------------------------------------------------------------------
    EpisodeResourceTest() {
        super(Episode.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("read all items")
    @Test
    void readAllItemResources__ForAllIntegerIds() {
        super.readAllItemResources__ForAllIntegerIds();
    }
}
