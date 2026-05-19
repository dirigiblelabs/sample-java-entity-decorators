package demo;

import org.eclipse.dirigible.components.data.store.java.repository.JavaRepository;
import org.eclipse.dirigible.engine.java.annotations.Documentation;
import org.eclipse.dirigible.engine.java.annotations.Repository;

/**
 * Repository for {@link Country}. Subclassing {@link JavaRepository} is the recommended way for
 * client code to talk to the entity store — controllers receive an injected instance via
 * {@code @Inject} without ever needing to know about {@code BeanProvider} or
 * {@code JavaEntityStore}.
 */
@Repository
@Documentation("CRUD repository for Country")
public class CountryRepository extends JavaRepository<Country> {

    public CountryRepository() {
        super(Country.class);
    }
}
