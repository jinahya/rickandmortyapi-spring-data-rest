package io.github.jinahya.rickandmortyapi.data.respository;

import io.github.jinahya.rickandmortyapi.persistence.LocationResident;
import io.github.jinahya.rickandmortyapi.persistence.LocationResidentId;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface LocationResidentRepository extends _BaseEntityRepository<LocationResident, LocationResidentId> {

}
