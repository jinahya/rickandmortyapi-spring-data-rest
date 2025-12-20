package io.github.jinahya.rickandmortyapi.test.web.servlet.client;

import io.github.jinahya.rickandmortyapi.core.ResolvableTypeUtils;
import io.github.jinahya.rickandmortyapi.persistence._BaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.LinkRelationProvider;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.client.RestTestClient;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@AutoConfigureRestTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@SuppressWarnings({
        "java:S119" // Type parameter names should comply with a naming convention

})
abstract class _BaseEntityResourceTest<ENTITY extends _BaseEntity<ID>, ID extends Serializable> {

    // -----------------------------------------------------------------------------------------------------------------
    private static <T> ParameterizedTypeReference<PagedModel<T>> pagedModelTypeReference(final Class<T> entityClass) {
        final var type = ResolvableType.forClassWithGenerics(PagedModel.class, entityClass).getType();
        return ParameterizedTypeReference.forType(type);
    }

    private static <T> ParameterizedTypeReference<EntityModel<T>> entityModelTypeReference(final Class<T> entityClass) {
        final var type = ResolvableType.forClassWithGenerics(EntityModel.class, entityClass).getType();
        return ParameterizedTypeReference.forType(type);
    }

    // -----------------------------------------------------------------------------------------------------------------
    _BaseEntityResourceTest(final Class<ENTITY> entityClass, final Class<ID> idClass) {
        super();
        this.entityClass = Objects.requireNonNull(entityClass, "entityClass is null");
        this.idClass = Objects.requireNonNull(idClass, "idClass is null");
        pagedModelTypeReference = pagedModelTypeReference(entityClass);
        entityModelTypeReference = entityModelTypeReference(entityClass);
    }

    _BaseEntityResourceTest(final Class<ENTITY> entityClass) {
        this(entityClass, ResolvableTypeUtils.resolveIdType(entityClass));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("read all pages")
    @Test
    void readAllPagedResources__() {
        final var collectionPath = linkRelationProvider.getCollectionResourceRelFor(entityClass).value();
        for (var uri = '/' + collectionPath; uri != null; ) {
            log.debug("uri: {}", uri);
            final var body = restTestClient
                    .get().uri(uri)                                            // GET /{collection} HTTP/1.1
                    .exchange()
                    .expectStatus().isOk()                                     // HTTP/1.1 200 OK
                    .expectHeader().contentType(MediaTypes.VND_HAL_JSON)       // Content-Type: application/vnd.hal+json
                    .expectBody(pagedModelTypeReference)
                    .returnResult()
                    .getResponseBody();
            Optional.ofNullable(body)
                    .map(CollectionModel::getContent)
                    .ifPresent(c -> log.debug("collection: {}", c));
            uri = Optional.ofNullable(body)
                    .flatMap(b -> b.getLink(IanaLinkRelations.NEXT))
                    .map(Link::getHref)
                    .orElse(null);
        }
    }

    void readAllItemResources__ForAllIntegerIds() {
        final var collectionPath = linkRelationProvider.getCollectionResourceRelFor(entityClass).value();
        EntityModel<ENTITY> item;
        for (final var id = new AtomicInteger(1); ; ) {
            final var responseSpec = restTestClient
                    .get().uri(b -> b.pathSegment(collectionPath)                     // GET /{collection}/{id} HTTP/1.1
                            .pathSegment(String.valueOf(id.getAndIncrement()))
                            .build()
                    )
                    .exchange();
            try {
                item = responseSpec
                        .expectStatus().isOk()                                 // HTTP/1.1 200 OK
                        .expectHeader().contentType(MediaTypes.VND_HAL_JSON)   // Content-Type: application/vnd.hal+json
                        .expectBody(entityModelTypeReference)
                        .returnResult()
                        .getResponseBody();
            } catch (final AssertionError e) { // by <.expectStatus().isOk()>
                final var status = responseSpec.returnResult().getStatus();    // HTTP/1.1 404 Not Found
                assert status == HttpStatus.NOT_FOUND;
                break;
            }
            log.debug("item[{}]: {}", id.get(), item);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    final Class<ENTITY> entityClass;

    final Class<ID> idClass;

    @Autowired
    private RestTestClient restTestClient;

    @Autowired
    private LinkRelationProvider linkRelationProvider;

    // -----------------------------------------------------------------------------------------------------------------
    private final ParameterizedTypeReference<PagedModel<ENTITY>> pagedModelTypeReference;

    private final ParameterizedTypeReference<EntityModel<ENTITY>> entityModelTypeReference;
}
