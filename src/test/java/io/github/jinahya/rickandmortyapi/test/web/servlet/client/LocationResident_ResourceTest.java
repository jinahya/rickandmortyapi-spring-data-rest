package io.github.jinahya.rickandmortyapi.test.web.servlet.client;

import io.github.jinahya.rickandmortyapi.persistence.LocationResident;
import io.github.jinahya.rickandmortyapi.persistence.LocationResidentId;
import lombok.extern.slf4j.Slf4j;

@org.junit.jupiter.api.Disabled
@Slf4j
class LocationResident_ResourceTest extends _BaseEntityResourceTest<LocationResident, LocationResidentId> {

    // -----------------------------------------------------------------------------------------------------------------
    LocationResident_ResourceTest() {
        super(LocationResident.class);
    }
}
