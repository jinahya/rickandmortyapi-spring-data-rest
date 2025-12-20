package io.github.jinahya.rickandmortyapi.data.respository;

import io.github.jinahya.rickandmortyapi.persistence.Episode;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface EpisodeRepository extends _BaseEntityRepository<Episode, Integer> {

}
