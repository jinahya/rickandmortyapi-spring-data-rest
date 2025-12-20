package io.github.jinahya.rickandmortyapi.data.rest.webmvc.spi;

import io.github.jinahya.rickandmortyapi.core.ResolvableTypeUtils;
import io.github.jinahya.rickandmortyapi.persistence._BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.spi.BackendIdConverter;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@SuppressWarnings({
        "java:S101", // Class names should comply with a naming convention
        "java:S119"  // Type parameter names should comply with a naming convention
})
abstract class _BaseEntityIdConverter<ENTITY extends _BaseEntity<ID>, ID extends Serializable>
        implements BackendIdConverter {

    private static final String DELIMITER = "_";

    static String idsToString(final int... ids) {
        if (Objects.requireNonNull(ids, "ids is null").length == 0) {
            throw new IllegalArgumentException("ids.length is zero");
        }
        return IntStream.of(ids)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(DELIMITER));
    }

    static int[] idsFromString(final String string) {
        if (Objects.requireNonNull(string, "string is null").isBlank()) {
            throw new IllegalArgumentException("string is blank");
        }
        return Arrays.stream(string.split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS
    _BaseEntityIdConverter(final Class<ENTITY> entityClass, final Class<ID> idClass) {
        super();
        this.entityClass = Objects.requireNonNull(entityClass, "entityClass is null");
        this.idClass = Objects.requireNonNull(idClass, "idClass is null");
    }

    _BaseEntityIdConverter(final Class<ENTITY> entityClass) {
        this(entityClass, ResolvableTypeUtils.resolveIdType(entityClass));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public final Serializable fromRequestId(final String id, final Class<?> entityType) {
        return fromRequestId(id);
    }

    abstract ID fromRequestId(final String id);

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public final String toRequestId(final Serializable id, final Class<?> entityType) {
        return toRequestId(idClass.cast(id));
    }

    abstract String toRequestId(final ID id);

    // -----------------------------------------------------------------------------------------------------------------
    @Override
    public final boolean supports(final Class<?> delimiter) {
        return delimiter == entityClass;
    }

    // -----------------------------------------------------------------------------------------------------------------
    final Class<ENTITY> entityClass;

    final Class<ID> idClass;
}
