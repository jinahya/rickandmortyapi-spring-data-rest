package io.github.jinahya.rickandmortyapi.context;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@NoArgsConstructor(access = AccessLevel.PACKAGE)
class DataRestConfiguration implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(final RepositoryRestConfiguration config,
                                                     final CorsRegistry cors) {
        config.getExposureConfiguration()
                .withCollectionExposure((m, hm) -> {
                    return hm.disable(
                            HttpMethod.DELETE,
                            HttpMethod.PATCH,
                            HttpMethod.POST,
                            HttpMethod.PUT
                    );
                })
                .withItemExposure((m, hm) -> {
                    return hm.disable(
                            HttpMethod.DELETE,
                            HttpMethod.PATCH,
                            HttpMethod.POST,
                            HttpMethod.PUT
                    );
                });
    }
}
