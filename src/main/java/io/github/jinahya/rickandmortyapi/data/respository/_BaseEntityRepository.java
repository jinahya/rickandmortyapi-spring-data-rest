package io.github.jinahya.rickandmortyapi.data.respository;

import io.github.jinahya.rickandmortyapi.persistence._BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
interface _BaseEntityRepository<ENTITY extends _BaseEntity<ID>, ID> extends JpaRepository<ENTITY, ID> {

}
