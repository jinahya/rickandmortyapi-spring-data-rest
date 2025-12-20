package io.github.jinahya.rickandmortyapi.core;

import io.github.jinahya.rickandmortyapi.persistence._BaseEntity;
import org.springframework.core.ResolvableType;

import java.util.Objects;

public final class ResolvableTypeUtils {

    public static <ENTITY extends _BaseEntity<ID>, ID> Class<ID> resolveIdType(final Class<ENTITY> entityClass) {
        Objects.requireNonNull(entityClass, "entityClass is null");
        return (Class<ID>) ResolvableType.forClass(entityClass).as(_BaseEntity.class).getGeneric(0).resolve();
    }

    private ResolvableTypeUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
