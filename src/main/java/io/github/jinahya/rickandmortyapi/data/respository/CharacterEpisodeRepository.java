package io.github.jinahya.rickandmortyapi.data.respository;

import io.github.jinahya.rickandmortyapi.persistence.CharacterEpisode;
import io.github.jinahya.rickandmortyapi.persistence.CharacterEpisodeId;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface CharacterEpisodeRepository extends _BaseEntityRepository<CharacterEpisode, CharacterEpisodeId> {

}
