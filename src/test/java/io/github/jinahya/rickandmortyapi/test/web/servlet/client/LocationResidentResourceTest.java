package io.github.jinahya.rickandmortyapi.test.web.servlet.client;

import io.github.jinahya.rickandmortyapi.persistence.LocationResident;
import io.github.jinahya.rickandmortyapi.persistence.LocationResidentId;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class LocationResidentResourceTest extends _BaseEntityResourceTest<LocationResident, LocationResidentId> {

    // -----------------------------------------------------------------------------------------------------------------
    LocationResidentResourceTest() {
        super(LocationResident.class);
    }
}