package io.github.jinahya.rickandmortyapi.data.rest.webmvc.spi;

import io.github.jinahya.rickandmortyapi.persistence.LocationResident;
import io.github.jinahya.rickandmortyapi.persistence.LocationResidentId;
import org.springframework.stereotype.Component;

@Component
class LocationResidentIdConverter extends _BaseEntityIdConverter<LocationResident, LocationResidentId> {

    // -----------------------------------------------------------------------------------------------------------------
    LocationResidentIdConverter() {
        super(LocationResident.class, LocationResidentId.class);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    LocationResidentId fromRequestId(final String id) {
        final var values = idsFromString(id);
        assert values.length == 2;
        return LocationResidentId.of(values[0], values[1]);
    }

    @Override
    String toRequestId(final LocationResidentId id) {
        return idsToString(id.getLocationId(), id.getResidentId());
    }
}
