package io.github.jinahya.rickandmortyapi.data.rest.core;

import io.github.jinahya.rickandmortyapi.persistence.Location;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface LocationRepository extends _BaseEntityRepository<Location, Integer> {

}
