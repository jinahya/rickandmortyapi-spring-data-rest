package io.github.jinahya.rickandmortyapi;

import io.github.jinahya.rickandmortyapi.persistence._BaseEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@EntityScan(basePackageClasses = {
        _BaseEntity.class
})
@SpringBootApplication
class Application {

    static void main(final String... args) {
        SpringApplication.run(Application.class, args);
    }

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS
    private Application() {
        super();
    }
}
