# rickandmortyapi-spring-data-rest

[![Java CI with Gradle](https://github.com/jinahya/rickandmortyapi-spring-data-rest/actions/workflows/gradle.yml/badge.svg)](https://github.com/jinahya/rickandmortyapi-spring-data-rest/actions/workflows/gradle.yml)

A Spring Data REST application for exposing [rickandmortyapi-db](https://github.com/jinahya/rickandmortyapi-db).

See

* [rickandmortyapi-db](https://github.com/jinahya/rickandmortyapi-db)
* [rickandmortyapi-persistence](https://github.com/jinahya/rickandmortyapi-persistence)

## How to

Run the application.

```shell
$ ./gradlew bootRun
```

Open the hal explorer at [/explorer/index.html#httpOptions=true&uri=/](http://localhost:8080/explorer/index.html#httpOptions=true&uri=/).

And/or open the swagger ui at [/swagger-ui.html](http://localhost:8080/swagger-ui.html).

## Endpoints

### `/characters(/{id})`

* [/characters?size=1](http://localhost:8080/characters?size=1)
* [/characters?size=1&projection=characterProjection](http://localhost:8080/characters?size=1&projection=characterProjection)
* [/characters/1](http://localhost:8080/characters/1)
* [/characters/1?&projection=characterProjection](http://localhost:8080/characters/1?&projection=characterProjection)

### `/episodes(/{id})`

* [/episodes?size=1](http://localhost:8080/episodes?size=1)
* [/episodes?size=1&projection=episodeProjection](http://localhost:8080/episodes?size=1&projection=episodeProjection)
* [/episodes/1](http://localhost:8080/episodes/1)
* [/episodes/1?&projection=episodeProjection](http://localhost:8080/episodes/1?&projection=episodeProjection)

### `/locations(/{id})`

* [/locations?size=1](http://localhost:8080/locations?size=1)
* [/locations?size=1&projection=locationProjection](http://localhost:8080/locations?size=1&projection=locationProjection)
* [/locations/1](http://localhost:8080/locations/1)
* [/locations/1?&projection=locationProjection](http://localhost:8080/locations/1?&projection=locationProjection)
