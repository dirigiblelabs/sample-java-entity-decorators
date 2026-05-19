# sample-java-entity-decorators

Showing how to use `@Entity`, `@Repository`, `@Controller` and related Java annotations in
[Eclipse Dirigible](https://www.dirigible.io/).

## Layout

```
sample-java-entity-decorators/   # Dirigible project (registry path)
└── demo/                          # Java package
    ├── Country.java               # @Entity — persisted via the data-store-java SessionFactory
    ├── CountryRepository.java     # @Repository extending JavaRepository<Country>
    ├── CountryController.java     # @Controller exposing CRUD over /services/java/…
    └── CountrySeeder.java         # @Controller that seeds three rows on POST
```

## Usage

Drop this project into the Dirigible IDE (clone via the Git perspective and publish, or copy it
to `/registry/public/sample-java-entity-decorators/`). The synchronizer compiles every `.java`
file, registers `@Entity` classes with Hibernate, instantiates each `@Repository`, and binds the
controller routes:

| Method | URL                                                                 |
| ------ | ------------------------------------------------------------------- |
| POST   | `/services/java/sample-java-entity-decorators/demo/CountrySeeder`   |
| GET    | `/services/java/sample-java-entity-decorators/demo/CountryController/list`    |
| GET    | `/services/java/sample-java-entity-decorators/demo/CountryController/{id}`    |
| POST   | `/services/java/sample-java-entity-decorators/demo/CountryController`         |
| DELETE | `/services/java/sample-java-entity-decorators/demo/CountryController/{id}`    |

The OpenAPI fragment for the controllers is published automatically at
`/services/openapi`.
