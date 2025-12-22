package io.github.jinahya.rickandmortyapi.data.rest.core;

import io.github.jinahya.rickandmortyapi.persistence.Character;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface CharacterRepository extends _BaseEntityRepository<Character, Integer> {

}
