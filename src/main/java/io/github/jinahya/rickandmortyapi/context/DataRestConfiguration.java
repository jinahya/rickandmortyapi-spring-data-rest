package io.github.jinahya.rickandmortyapi.context;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.List;

@Configuration
@NoArgsConstructor(access = AccessLevel.PACKAGE)
class DataRestConfiguration implements RepositoryRestConfigurer {

    private static final List<HttpMethod> METHODS_TO_DISABLE = List.of(
            HttpMethod.DELETE,
            HttpMethod.PATCH,
            HttpMethod.POST,
            HttpMethod.PUT
    );

    @Override
    public void configureRepositoryRestConfiguration(final RepositoryRestConfiguration config,
                                                     final CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors); // empty
        config.getExposureConfiguration()
                .withCollectionExposure((m, hm) -> {
                    return hm.disable(
                            METHODS_TO_DISABLE.toArray(new HttpMethod[0])
                    );
                })
                .withItemExposure((m, hm) -> {
                    return hm.disable(
                            METHODS_TO_DISABLE.toArray(new HttpMethod[0])
                    );
                })
        ;
    }

    @Override
    public void configureConversionService(final ConfigurableConversionService conversionService) {
        RepositoryRestConfigurer.super.configureConversionService(conversionService); // empty
    }
}
