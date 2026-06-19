# sample-java-entity-decorators

Showing how to use `@Entity`, `@Repository`, `@Controller` and related Java annotations in
[Eclipse Dirigible](https://www.dirigible.io/).

## Layout

```
sample-java-entity-decorators/   # Dirigible project (registry path)
└── demo/                          # Java package
    ├── Country.java               # @Entity — persisted via the data-store-java SessionFactory
    ├── CountryRepository.java     # @Repository extending JavaRepository<Country>
    └── CountryController.java     # @Controller exposing CRUD over /services/java/…
```

## Usage

Drop this project into the Dirigible IDE (clone via the Git perspective and publish, or copy it
to `/registry/public/sample-java-entity-decorators/`). The synchronizer compiles every `.java`
file, registers `@Entity` classes with Hibernate, instantiates each `@Repository`, and binds the
controller routes:

| Method | URL                                                                              |
| ------ | -------------------------------------------------------------------------------- |
| GET    | `/services/java/sample-java-entity-decorators/demo/CountryController`            |
| GET    | `/services/java/sample-java-entity-decorators/demo/CountryController/{id}`       |
| POST   | `/services/java/sample-java-entity-decorators/demo/CountryController`            |
| DELETE | `/services/java/sample-java-entity-decorators/demo/CountryController/{id}`       |

The OpenAPI fragment for the controller is published automatically at
`/services/openapi`.

## Dependency injection styles

- **Field injection** — `CountryController` uses `@Inject CountryRepository` (still supported).
- **Constructor injection (preferred)** — `GreetingController` receives a `@Component GreetingService` through its constructor; more testable.
- **Programmatic lookup** — `Beans.get(...)` for when an injection point isn't convenient.

See the [Develop guide](https://www.dirigible.io/help/develop/dependency-injection/) and the [Java SDK](https://www.dirigible.io/sdk/).
