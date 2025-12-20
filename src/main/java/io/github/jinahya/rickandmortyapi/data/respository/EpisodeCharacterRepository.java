package io.github.jinahya.rickandmortyapi.data.respository;

import io.github.jinahya.rickandmortyapi.persistence.EpisodeCharacter;
import io.github.jinahya.rickandmortyapi.persistence.EpisodeCharacterId;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface EpisodeCharacterRepository extends _BaseEntityRepository<EpisodeCharacter, EpisodeCharacterId> {

}
