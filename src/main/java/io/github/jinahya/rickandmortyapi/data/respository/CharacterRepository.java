package io.github.jinahya.rickandmortyapi.data.respository;

import io.github.jinahya.rickandmortyapi.persistence.Character;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface CharacterRepository extends _BaseEntityRepository<Character, Integer> {

//    Page<Character> findAll(Pageable pageable);

//    Optional<Character> findById(Integer integer);
}
