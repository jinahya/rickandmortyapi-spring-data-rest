package io.github.jinahya.rickandmortyapi.data.rest.core;

import io.github.jinahya.rickandmortyapi.persistence._BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
@SuppressWarnings({
        "java:S114", // Interface names should comply with a naming convention
        "java:S119"  // Type parameter names should comply with a naming convention
})
interface _BaseEntityRepository<ENTITY extends _BaseEntity<ID>, ID> extends JpaRepository<ENTITY, ID> {

}
