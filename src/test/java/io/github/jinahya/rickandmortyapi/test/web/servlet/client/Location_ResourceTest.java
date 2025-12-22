package io.github.jinahya.rickandmortyapi.test.web.servlet.client;

import io.github.jinahya.rickandmortyapi.persistence.Location;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class Location_ResourceTest extends _BaseEntityResourceTest<Location, Integer> {

    // -----------------------------------------------------------------------------------------------------------------
    Location_ResourceTest() {
        super(Location.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("read all items")
    @Test
    void readAllItemResources__ForAllIntegerIds() {
        super.readAllItemResources__ForAllIntegerIds();
    }
}
